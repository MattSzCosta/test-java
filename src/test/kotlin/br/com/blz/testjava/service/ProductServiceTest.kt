package br.com.blz.testjava.service


import br.com.blz.testjava.exception.ConflictRequestException
import br.com.blz.testjava.model.Inventory
import br.com.blz.testjava.model.Product
import br.com.blz.testjava.model.Warehouse
import br.com.blz.testjava.repository.IProductRepository
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.junit.runner.RunWith
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.test.context.junit4.SpringRunner
import org.junit.Assert.assertThrows
import org.mockito.Mockito.*
import kotlin.test.assertNotNull

@AutoConfigureMockMvc
@SpringBootTest
@RunWith(SpringRunner::class)
class ProductServiceTest {

  @MockBean
   lateinit var respository: IProductRepository

   @Autowired
   lateinit var productService: IProductService


  private val warehouse = Warehouse("SP", 12, "ECOMEMRCE")
  private val inventory = Inventory(warehouses = listOf(warehouse))
  private val product = Product(sku = 43264, name = "L'Oréal", inventory = inventory)

   @Test
   fun testCreateProductSucess() {
     `when`(respository.countBySku(anyLong())).thenReturn(0)
     `when`(respository.save(product)).thenReturn(product)
     val data = productService.create(product)
     assertNotNull(data)
     verify(respository, times(1)).save(product)
   }

  @Test
  fun testCreateProductError() {
    `when`(respository.countBySku(anyLong())).thenReturn(1)
    `when`(respository.save(product)).thenReturn(product)
    assertThrows(ConflictRequestException::class.java) {
      productService.create(product)
    }
  }
}
