package br.com.blz.testjava.service

import br.com.blz.testjava.model.Product
import br.com.blz.testjava.repository.IProductRepository
import br.com.blz.testjava.exception.ConflictRequestException
import br.com.blz.testjava.exception.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service



@Service
class ProductService: IProductService {

  @Autowired
  lateinit var productRepository: IProductRepository

  override fun create(product: Product): Product {
    if(hasProductBySku(product.sku)) {
      throw ConflictRequestException("Product alredy exists")
    }

    return productRepository.save(product)

  }

  private fun hasProductBySku (sku: Long): Boolean {
    return productRepository.countBySku(sku) > 0
  }

  override fun findBySku(sku: Long): Product {
    return productRepository.findBySku(sku) ?: throw NotFoundException()
  }

  override fun updateBySku(sku: Long, product: Product) {
    if(product.sku != sku) {
      throw ConflictRequestException("header and body Sku are not the same")
    }

    if(!hasProductBySku(sku)) {
      throw NotFoundException("Product not found")
    }
    productRepository.update(sku, product)
  }
}
