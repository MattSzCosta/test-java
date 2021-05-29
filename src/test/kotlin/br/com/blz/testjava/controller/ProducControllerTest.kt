package br.com.blz.testjava.controller

import br.com.blz.testjava.model.Inventory
import br.com.blz.testjava.model.Product
import br.com.blz.testjava.model.Warehouse
import br.com.blz.testjava.service.IProductService
import br.com.blz.testjava.util.JsonUtils
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.http.MediaType


import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.hamcrest.Matchers.`is`
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*


@AutoConfigureMockMvc
@SpringBootTest
@RunWith(SpringRunner::class)
class ProducControllerTest {

  @MockBean
  lateinit var productService: IProductService

  @Autowired
  lateinit var mvc: MockMvc


  private val warehouse = Warehouse("SP", 12, "ECOMEMRCE")
  private val inventory = Inventory(warehouses = listOf(warehouse))
  private val product = Product(sku = 43264, name = "L'Oréal", inventory = inventory)

  @Test
  fun testPostProduct() {
    `when`(productService.create(product)).thenReturn(product)
    mvc.perform(
      post("/product/").contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .content(JsonUtils.asJsonString(product))
    )
      .andExpect(status().isCreated)
      .andExpect(jsonPath("$.message", `is`("/product/${product.sku}")))
  }
}
