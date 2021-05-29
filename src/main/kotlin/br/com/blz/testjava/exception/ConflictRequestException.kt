package br.com.blz.testjava.exception

class ConflictRequestException(message: String?) : RestErrorException(message, HttpStatusExceptionRest.CONFLICT) {
}
