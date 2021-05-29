package br.com.blz.testjava.controller.dto.response

import br.com.blz.testjava.model.Inventory

class InventoryGetRequest (
  val warehouses: List<WarehouseGetRequest>,
  val quantity: Long
) {

  constructor(inventory: Inventory): this (
    warehouses = inventory.warehouses.map { WarehouseGetRequest(it) },
    quantity = inventory.warehouses.sumOf { it.quantity }
    )
}

