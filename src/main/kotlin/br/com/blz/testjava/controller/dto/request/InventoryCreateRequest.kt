package br.com.blz.testjava.controller.dto.request

import br.com.blz.testjava.model.Inventory

class InventoryCreateRequest (
  val warehouses: List<WarehouseCreateRequest>
) {
  fun toInventory()= Inventory(
    warehouses = warehouses.map { it.toWarehouse() },
  )
}

