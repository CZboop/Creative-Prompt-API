import './Header.css';

const Header = ({emoji}) => {
    const getSynonyms = ["fetches", "gets", "finds", "serves", "gives", "provides", "delivers", "dispenses"];
    const inspirationSynonyms = ["ideas", "inspiration", "concepts", "notions"];

    return (
        <div className='header-container'>
            <div className="header-text">{emoji} <h1>Creative Prompt API</h1> {emoji}</div>
            <h3>An API that {getSynonyms[Math.floor(Math.random()*getSynonyms.length)]} you creative {inspirationSynonyms[Math.floor(Math.random()*inspirationSynonyms.length)]} </h3>

        </div>
    )
}

export default Header;