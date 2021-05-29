package br.com.blz.testjava.exception

enum class HttpStatusExceptionRest(var value: Int) {
    NOT_FOUND(404),
    CONFLICT(409)
}
