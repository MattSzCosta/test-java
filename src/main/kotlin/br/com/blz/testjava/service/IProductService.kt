package br.com.blz.testjava.service

import br.com.blz.testjava.model.Product

interface IProductService {
  fun create(product: Product): Product
  fun findBySku(sku: Long): Product
  fun updateBySku(sku: Long, product: Product)
  fun delete(sku: Long)
}
