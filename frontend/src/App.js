import React, { useEffect, useState } from "react";
import './App.css';
import logo from './logo.svg';
import { connect, sendMessage } from './websocket';


function App() {
  const [greeting, setGreeting] = useState();

  useEffect(() => {
    connect(onMessageReceived)
  }, []);

  const onMessageReceived = (msg) => {
    const notification = JSON.parse(msg.body);

    console.log("Received a new message: ", { notification });
    setGreeting(notification)
  };

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        {greeting ? (
          <p>Hello from {greeting}</p>
        ) : (
            <p>Loading...</p>
          )}
        <p>
          Edit <code>src/App.tsx</code> and save to reload.
        </p>

        <button
          onClick={() => {
            sendMessage("AAAAAAAAAAAAAAAAA")
            setGreeting(false)
          }}
        >
        Send message
        </button>
      </header>
    </div>
  );
}

export default App;
