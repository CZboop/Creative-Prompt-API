import './App.css';
import Header from './components/Header';
import Form from './components/Form';
import Prompt from './components/Prompt';
import {useState} from 'react';

function App() {
  const [prompt, setPrompt] = useState("");

  const faviconRandomiser = () => {
    const options = ["🖊️", "🖌️", "🎨", "💻", "🖱️", "📸" ];
    let fav = document.querySelector("link[rel~='icon']");
    let randEmoji = options[Math.floor(Math.random()*options.length)]; 
    fav.href = `data:image/svg+xml,<svg xmlns=%22http://www.w3.org/2000/svg%22 viewBox=%220 0 100 100%22><text y=%22.9em%22 font-size=%2290%22>${randEmoji}</text></svg>`
    return randEmoji;
  }


  const getRandomPrompt = () => {
    faviconRandomiser();
    fetch("http://localhost:8080/api/random")
    .then(data => data.json())
    .then(data=>setPrompt(JSON.stringify(data)))

  }

  const getFilteredPrompt = (promptRequest) => {
    fetch(`http://localhost:8080/api/filtered/${promptRequest.minsToComplete}/${promptRequest.discipline}/${promptRequest.difficulty}`
    )
    .then(data => data.json())
    .then(data => {if (data.status===500){
      alert("No matching prompt found, maybe try increasing the maximum time or difficulty")}
    else{
      setPrompt(JSON.stringify(data));
    }})
  }

  return (
    <div className="App">
      <Header emoji={faviconRandomiser()}/>
      <Form getRandomPrompt={getRandomPrompt} getFilteredPrompt={getFilteredPrompt} faviconRandomiser={faviconRandomiser}/>
      <Prompt prompt={prompt}/>
    </div>
  );
}

export default App;
