package br.com.blz.testjava.controller.dto.response

import br.com.blz.testjava.model.Product

class ProductGetResponse(
  var sku: Long,
  var name: String,
  var inventory: InventoryGetRequest,
){
  val isMarketable: Boolean
    get() {
    return this.inventory.quantity > 0
  }
  constructor(product: Product): this (
    sku = product.sku,
    name = product.name,
    inventory = InventoryGetRequest(product.inventory),
  )
}
