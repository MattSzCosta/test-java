package br.com.blz.testjava.repository

import br.com.blz.testjava.model.Product

interface IProductRepository {
  fun countBySku(sku: Long): Int
  fun save(product: Product): Product
  fun findBySku(sku: Long): Product?
  fun update(sku:Long, product: Product)
}
