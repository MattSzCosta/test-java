package br.com.blz.testjava.controller.dto.request

import br.com.blz.testjava.model.Inventory

class InventoryUpdateRequest (
  val warehouses: List<WarehouseUpdateRequest>
) {
  fun toInventory()= Inventory(
    warehouses = warehouses.map { it.toWarehouse() },
  )
}

