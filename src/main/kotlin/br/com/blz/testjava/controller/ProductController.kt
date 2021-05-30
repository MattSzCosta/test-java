package br.com.blz.testjava.controller

import br.com.blz.testjava.controller.dto.response.CreateResponse
import br.com.blz.testjava.controller.dto.request.ProductCreateRequest
import br.com.blz.testjava.controller.dto.request.ProductUpdateRequest
import br.com.blz.testjava.controller.dto.response.ProductGetResponse
import br.com.blz.testjava.service.IProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/product")
class ProductController {

  @Autowired
  lateinit var productService: IProductService

  @PostMapping("/")
  @ResponseStatus(HttpStatus.CREATED)
  fun createProduct(@RequestBody product: ProductCreateRequest): CreateResponse {
    val newProduct = productService.create(product = product.toProduct())
    return CreateResponse("/product/${newProduct.sku}")
  }

  @GetMapping("/{sku}")
  @ResponseStatus(HttpStatus.OK)
  fun getProduct(@PathVariable("sku") sku: Long): ProductGetResponse {
    return ProductGetResponse(productService.findBySku(sku))
  }

  @PutMapping("/{sku}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  fun updateProduct(@PathVariable("sku") sku: Long,@RequestBody product: ProductUpdateRequest) {
    productService.updateBySku(sku, product.toProduct())
  }


  @DeleteMapping("/{sku}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  fun deleteProduct(@PathVariable("sku") sku: Long) {
    productService.delete(sku)
  }
}
