package br.com.blz.testjava.util

import com.fasterxml.jackson.databind.ObjectMapper

object JsonUtils {
  fun asJsonString(obj: Any?): String {
    return try {
      ObjectMapper().writeValueAsString(obj)
    } catch (e: Exception) {
      throw RuntimeException(e)
    }
  }
}
