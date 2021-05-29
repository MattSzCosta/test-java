package br.com.blz.testjava.model

data class Inventory (
  var quantity: Long? = null,
  var warehouses: List<Warehouse>
  )
