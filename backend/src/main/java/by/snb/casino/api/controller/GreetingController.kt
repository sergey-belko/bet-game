package by.snb.casino.api.controller

import by.snb.casino.api.Bet
import by.snb.casino.config.WebSocketConfig
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@Validated
@RestController
class GreetingController {

    companion object {
        const val RECEIVE_CHANNEL_ID = "/vote/submit"
        const val NOTIFY_CHANNEL_ID = "${WebSocketConfig.WEB_SOCKET_NOTIFY_PREFIX_ENDPOINT}/vote"
    }

    @MessageMapping(RECEIVE_CHANNEL_ID)
    @SendTo(NOTIFY_CHANNEL_ID)
    fun vote(@Valid @RequestBody message: Bet): String {
        return "Hello $message"
    }

    @RequestMapping("/score/list")
    fun greetings(): List<String> {
        return listOf("Hello world")
    }
}