package by.snb.casino.api.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController {

    @GetMapping("/hello")
    fun greetings(): String = "Hello world"
}