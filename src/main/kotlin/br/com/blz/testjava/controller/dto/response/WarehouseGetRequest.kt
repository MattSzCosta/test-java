package br.com.blz.testjava.controller.dto.response

import br.com.blz.testjava.model.Warehouse

class WarehouseGetRequest (
  val locality: String,
  val quantity: Long,
  val type: String
) {
  constructor(warehouse: Warehouse): this (
    locality = warehouse.locality,
    quantity = warehouse.quantity,
    type = warehouse.type
    )
}
