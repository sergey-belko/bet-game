import Stomp from "stompjs"
import SockJS from "sockjs-client"

const HOST = "http://localhost:8080"
const CONNECT_API = HOST + '/subscribe'
const NOTIFY_API = '/topic/greetings'
const COMMAND_API = "/app/hello"

let stompClient = null;

export const connect = (onMessageReceived) => {
    stompClient = Stomp.over(new SockJS(CONNECT_API));
    stompClient.connect({}, (response) => {
        console.log('Connected: ' + response)
        stompClient.subscribe(NOTIFY_API, onMessageReceived)
    }, onError)
}

export const disconnect = () => {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    console.log("Disconnected");
}

export const sendMessage = (name) => {
    if (stompClient !== null) {
        stompClient.send(COMMAND_API, JSON.stringify(name))
    }
}

const onError = (err) => {
    console.log(err);
};