package br.com.blz.testjava.controller.dto.request

import br.com.blz.testjava.model.Product

class ProductUpdateRequest (
  val sku: Long,
  val name: String,
  val inventory: InventoryUpdateRequest,
) {
  fun toProduct() = Product (
    sku = sku,
    name = name,
    inventory = inventory.toInventory()
    )
}
