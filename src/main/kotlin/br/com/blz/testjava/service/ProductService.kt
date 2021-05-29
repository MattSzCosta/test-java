package br.com.blz.testjava.service

import br.com.blz.testjava.model.Product
import br.com.blz.testjava.repository.IProductRepository
import br.com.blz.testjava.exception.ConflictRequestException
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
}
