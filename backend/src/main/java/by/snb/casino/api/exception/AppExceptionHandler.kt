package by.snb.casino.api.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class AppExceptionHandler {

    @ResponseBody
    @ExceptionHandler(RuntimeException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun employeeNotFoundHandler(ex: RuntimeException): String {
        return ex.localizedMessage
    }
}