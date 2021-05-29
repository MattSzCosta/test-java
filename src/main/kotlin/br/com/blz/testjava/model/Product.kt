package br.com.blz.testjava.model

data class Product (
  var sku: Long,
  val name: String,
  val inventory: Inventory,
  var isMarketable: Boolean? = null
)
