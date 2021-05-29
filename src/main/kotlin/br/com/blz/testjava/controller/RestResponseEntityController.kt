package br.com.blz.testjava.controller

import br.com.blz.testjava.exception.RestErrorException
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice
@Component
class RestResponseEntityController : ResponseEntityExceptionHandler() {


    @ExceptionHandler(RestErrorException::class)
    fun handleException(e: RestErrorException): ResponseEntity<Any> {
        return getStringResponseEntity(e, HttpStatus.valueOf(e.status.value))
    }

    private fun getStringResponseEntity(e: Exception, status: HttpStatus): ResponseEntity<Any> {
        return ResponseEntity.status(status).contentType(MediaType.APPLICATION_JSON)
          .body(hashMapOf("mensagem" to e.message))
    }
}
