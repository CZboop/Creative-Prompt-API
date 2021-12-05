import './Form.css';
import {useState} from 'react';

const Form = ({getRandomPrompt, getFilteredPrompt, faviconRandomiser}) => {
    const [discipline, setDiscipline] = useState("");
    const [maxTime, setMaxTime] = useState(60);
    const [difficulty, setDifficulty] = useState(5);

    const handleDisciplineChange = (event) => {
        setDiscipline(event.target.value);
    }

    const handleMaxTimeChange = (event) => {
        setMaxTime(event.target.value);
    }

    const handleDifficultyChange = (event) => {
        setDifficulty(event.target.value);
    }

    const handleFormSubmission = (event) => {
        event.preventDefault();
        const promptRequest = {
            discipline: discipline,
            minsToComplete: maxTime,
            difficulty: difficulty
        }
        if (discipline===""){
            alert("Please choose a discipline, or click the random button to get a prompt from any discipline 👇")
        }
        else{
            getFilteredPrompt(promptRequest);
            // reset all the states, keep discipline the same as user likely to want several of the same discipline
            setMaxTime(60);
            setDifficulty(5);
            faviconRandomiser();
        }
    }

    return (
        <>
        <div className='form-container'>
            <h2>Options</h2>
            <form onSubmit={handleFormSubmission} className="form-class">
                <div className="form-element">
                    <label className="form-label">Discipline:</label>
                        <select name="discipline" id="discipline" onChange={handleDisciplineChange} value={discipline}>
                                    <option value="">-Select an option-</option>
                                    <option value="writing">Writing</option>
                                    <option value="programming">Programming</option>
                                    <option value="art">Art & Design</option>
                        </select>
                </div>
                <div className="form-element">
                    <label className="form-label">Time (mins):</label>
                    <input type="number" id="max-time" value={maxTime} onChange={handleMaxTimeChange} min="1"/>
                    
                </div>
                <div className="form-element">
                    <label className="form-label">Difficulty (out of 5):</label>
                    <input type="number" id="difficulty" value={difficulty} onChange={handleDifficultyChange} min="1" max="5"/>
                    
                </div>
                <div className="form-element">
                    <input type="submit" value="Give Prompt"></input>
                </div>
            </form>
            <h3>Or get a completely random prompt: </h3>
            <div className="randomButton">
            <button onClick={getRandomPrompt}>Random!</button>
        </div>  
        </div>       
        </>
    )
}

export default Form;