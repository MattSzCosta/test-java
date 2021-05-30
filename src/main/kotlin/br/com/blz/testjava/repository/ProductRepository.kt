package br.com.blz.testjava.repository

import br.com.blz.testjava.model.Product
import org.springframework.stereotype.Repository

@Repository
class ProductRepository: IProductRepository {

 private val listProduct: MutableList<Product> = mutableListOf()

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

  override fun update(sku: Long, product: Product) {
    listProduct.replaceAll {  if(it.sku == sku) product else it  }
  }

  override fun deleteBySku(sku: Long): Boolean {
    return listProduct.removeIf { it.sku == sku }
  }

}
