import Stomp from "stompjs"
import SockJS from "sockjs-client"

const HOST = "http://localhost:8080"
const API_URL = HOST + '/subscribe'
const NOTIFY_API_CHANNEL = '/notify/vote'
const SEND_API_CHANNEL = "/casino/vote/submit"

let stompClient = null;

export const connect = (onMessageReceived) => {
    stompClient = Stomp.over(new SockJS(API_URL));
    stompClient.connect({}, (response) => {
        console.log('Connected: ' + response)
        stompClient.subscribe(NOTIFY_API_CHANNEL, (event) => {
            onMessageReceived(event.body)
        })
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
        stompClient.send(SEND_API_CHANNEL, {}, JSON.stringify(name))
    }
}

const onError = (err) => {
    console.log(err);
};