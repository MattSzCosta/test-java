package br.com.blz.testjava.exception

class NotFoundException : RestErrorException {
    constructor() : super(HttpStatusExceptionRest.NOT_FOUND) {}
    constructor(message: String?) : super(message, HttpStatusExceptionRest.NOT_FOUND) {}
}
