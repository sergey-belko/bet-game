package by.snb.casino.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.converter.DefaultContentTypeResolver
import org.springframework.messaging.converter.MappingJackson2MessageConverter
import org.springframework.messaging.converter.MessageConverter
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.util.MimeTypeUtils
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer

@Configuration
@EnableWebSocketMessageBroker
open class WebSocketConfig(val objectMapper: ObjectMapper) : WebSocketMessageBrokerConfigurer {

    companion object {
        const val WEB_SOCKET_SUBSCRIBE_ENDPOINT = "/subscribe"
        const val WEB_SOCKET_NOTIFY_PREFIX_ENDPOINT = "/notify"
        const val WEB_SOCKET_COMMAND_PREFIX_ENDPOINT = "/app"
    }

    override fun configureMessageBroker(config: MessageBrokerRegistry) {
        config.enableSimpleBroker(WEB_SOCKET_NOTIFY_PREFIX_ENDPOINT)
        config.setApplicationDestinationPrefixes(WEB_SOCKET_COMMAND_PREFIX_ENDPOINT)
    }

    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        registry
            .addEndpoint(WEB_SOCKET_SUBSCRIBE_ENDPOINT)
            .setAllowedOriginPatterns("*")
            .withSockJS()
    }

    override fun configureMessageConverters(messageConverters: MutableList<MessageConverter>): Boolean {
        val converter = MappingJackson2MessageConverter().apply {
            this.objectMapper = objectMapper
            contentTypeResolver = DefaultContentTypeResolver().apply {
                defaultMimeType = MimeTypeUtils.APPLICATION_JSON
            }
        }

        messageConverters.add(converter)
        return false
    }
}
