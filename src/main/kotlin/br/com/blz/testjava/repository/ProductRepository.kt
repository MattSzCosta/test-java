package br.com.blz.testjava.repository

import br.com.blz.testjava.model.Product
import org.springframework.stereotype.Repository

@Repository
class ProductRepository: IProductRepository {

  val listProduct: MutableList<Product> = mutableListOf()

  override fun countBySku(sku: Long): Int {
    return listProduct.count{ it.sku == sku}
  }

  override fun save(product: Product): Product {
    listProduct.add(product)
    return product
  }

  override fun findBySku(sku: Long): Product? {
    return listProduct.find { it.sku == sku }
  }
}
