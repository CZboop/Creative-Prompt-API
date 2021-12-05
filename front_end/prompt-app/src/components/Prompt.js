import './Prompt.css';

const Prompt = ({prompt}) => {
    // this just to handle cross origin error
    let prompt2 = "";
    if (prompt!==""){
        prompt2 = JSON.parse(prompt)
    } 
    let star = String.fromCodePoint("0x2B50");
    return (
        prompt2.id ?
        <div className='promptContainer'>
            <h3>{prompt2.title}</h3>
            <p>{prompt2.info}</p>
            <hr></hr>
            <p>Approx. time to complete: {prompt2.minsToComplete} minutes</p>
            <p>{`Estimated difficulty: ${star.repeat(prompt2.difficulty)}`}</p>
        </div>
        :
        <p>...</p>
    )
}

export default Prompt;