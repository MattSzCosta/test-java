package br.com.blz.testjava.exception


open class RestErrorException : RuntimeException {
    var status: HttpStatusExceptionRest
        private set

    constructor(status: HttpStatusExceptionRest) {
        this.status = status
    }

    constructor(message: String?, status: HttpStatusExceptionRest) : super(message) {
        this.status = status
    }
}
