package by.snb.casino.api.controller

import by.snb.casino.config.WebSocketConfig
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController {

    companion object {
        const val COMMAND_URL = "/hello-1"
        const val NOTIFY_CHANNEL = "${WebSocketConfig.WEB_SOCKET_NOTIFY_PREFIX_ENDPOINT}/greetings"
    }

    @MessageMapping(COMMAND_URL)
    @SendTo(NOTIFY_CHANNEL)
    fun greeting(@Payload message: String): String {
        return "Hello $message"
    }

    @RequestMapping("/hello")
    fun greetings(): List<String> {
        return listOf("Hello world")
    }
}