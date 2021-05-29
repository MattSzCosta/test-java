package br.com.blz.testjava.controller.dto.request

import br.com.blz.testjava.model.Warehouse

class WarehouseCreateRequest (
  val locality: String,
  val quantity: Long,
  val type: String
) {
  fun toWarehouse() = Warehouse (
    locality = locality,
    quantity = quantity,
    type = type
    )
}
