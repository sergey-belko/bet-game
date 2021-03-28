package by.snb.casino.api.exception

import org.springframework.http.HttpStatus
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class AppExceptionHandler {

    @ResponseBody
    @ExceptionHandler(RuntimeException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun employeeNotFoundHandler(ex: RuntimeException): String = ex.localizedMessage

    @ResponseBody
    @ExceptionHandler(ValidationException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun badRequest(ex: RuntimeException): String = ex.localizedMessage
}

data class ValidationException(val fieldError: FieldError) : RuntimeException(fieldError.defaultMessage)