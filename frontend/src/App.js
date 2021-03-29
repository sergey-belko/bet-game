import React, { useEffect, useState } from "react";
import './App.css';
import logo from './logo.svg';
import { connect, sendMessage, disconnect } from './websocket';


function App() {
  const [greeting, setGreeting] = useState();

  const [bet, setBet] = useState(0);
  const [guess, setGuess] = useState(0);

  useEffect(() => {
    connect(onMessageReceived)
    fetch("http://localhost:8080/score/list", {
      method: 'GET',

    })
      .then(res => res.json())
      .then(setGreeting)
      .catch(console.error)

    return disconnect
  }, []);

  const onMessageReceived = (notification) => {
    console.log("Received a new message: ", { notification });
    setGreeting(notification)
  };

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p> Let's play, Neo. Try to guess number </p>
        <p>Place your bet and guess the number between 1 and 10</p>
        <form>
          <input
            placeholder='Your bet here'
            value={bet}
            onChange={e => {
              setBet(e.target.value)
              e.preventDefault()
            }}
          />
          <input
            placeholder='Your guess here'
            onChange={e => {
              setGuess(e.target.value)
              e.preventDefault()
            }}
          />

          {greeting ? (
            <p>Hello from {greeting}</p>
          ) : (
              <p>Loading...</p>
            )}

          <button
            onClick={(e) => {
              console.log({ bet, guess })
              sendMessage({ bet, guess })
              setGreeting(false)
              e.preventDefault()
            }}
          >
            SUBMIT
        </button>
        </form>
      </header>
    </div>
  );
}

export default App;
