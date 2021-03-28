package by.snb.casino

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class App {
    companion object {
        @JvmStatic
        fun main(vararg args: String) {
            SpringApplication.run(App::class.java, *args)
        }
    }
}

