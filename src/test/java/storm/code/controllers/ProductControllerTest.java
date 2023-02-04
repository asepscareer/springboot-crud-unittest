package storm.code.controllers;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import storm.code.entities.Product;
import storm.code.services.ProductService;

@ContextConfiguration(classes = {ProductController.class})
@ExtendWith(SpringExtension.class)
class ProductControllerTest {
    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;

    /**
     * Method under test: {@link ProductController#edit(Integer, Model)}
     */
    @Test
    void testEdit2() throws Exception {
        // Arrange
        Product product = new Product();
        product.setId(1);
        product.setName("Name");
        product.setPrice(BigDecimal.valueOf(42L));
        product.setProductId("42");
        product.setVersion(1);
        when(productService.getProductById((Integer) any())).thenReturn(product);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/edit/{id}", 1);
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(productController).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("productform"));
    }

    /**
     * Method under test: {@link ProductController#list(Model)}
     */
    @Test
    void testList3() throws Exception {
        // Arrange
        when(productService.listAllProducts()).thenReturn((Iterable<Product>) mock(Iterable.class));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(productController).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("products"));
    }

    /**
     * Method under test: {@link ProductController#list(Model)}
     */
    @Test
    void testList4() throws Exception {
        // Arrange
        when(productService.listAllProducts()).thenReturn((Iterable<Product>) mock(Iterable.class));
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/");
        getResult.characterEncoding("Encoding");
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(productController).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(getResult);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("products"));
    }

    /**
     * Method under test: {@link ProductController#newProduct(Model)}
     */
    @Test
    void testNewProduct3() throws Exception {
        // Arrange
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/product/new");
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(productController).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("productform"));
    }

    /**
     * Method under test: {@link ProductController#newProduct(Model)}
     */
    @Test
    void testNewProduct4() throws Exception {
        // Arrange
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/product/new");
        getResult.characterEncoding("Encoding");
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(productController).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(getResult);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("productform"));
    }

    /**
     * Method under test: {@link ProductController#saveProduct(Product)}
     */
    @Test
    void testSaveProduct() throws Exception {
        // Arrange
        Product product = new Product();
        product.setId(1);
        product.setName("Name");
        product.setPrice(BigDecimal.valueOf(42L));
        product.setProductId("42");
        product.setVersion(1);
        when(productService.saveProduct((Product) any())).thenReturn(product);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/product");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("redirect:/product/null"));
    }

    /**
     * Method under test: {@link ProductController#saveProduct(Product)}
     */
    @Test
    void testSaveProduct2() throws Exception {
        // Arrange
        Product product = new Product();
        product.setId(1);
        product.setName("Name");
        product.setPrice(BigDecimal.valueOf(42L));
        product.setProductId("42");
        product.setVersion(1);
        when(productService.saveProduct((Product) any())).thenReturn(product);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/product");
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(productController).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("redirect:/product/null"));
    }

    /**
     * Method under test: {@link ProductController#delete(Integer)}
     */
    @Test
    void testDelete() throws Exception {
        // Arrange
        doNothing().when(productService).deleteProduct((Integer) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/{id}", 1);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("redirect:/products"));
    }

    /**
     * Method under test: {@link ProductController#delete(Integer)}
     */
    @Test
    void testDelete2() throws Exception {
        // Arrange
        doNothing().when(productService).deleteProduct((Integer) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/{id}", 1);
        deleteResult.characterEncoding("Encoding");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("redirect:/products"));
    }

    /**
     * Method under test: {@link ProductController#delete(Integer)}
     */
    @Test
    void testDelete3() throws Exception {
        // Arrange
        doNothing().when(productService).deleteProduct((Integer) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/{id}", 1);
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(productController).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("redirect:/products"));
    }

    /**
     * Method under test: {@link ProductController#delete(Integer)}
     */
    @Test
    void testDelete4() throws Exception {
        // Arrange
        doNothing().when(productService).deleteProduct((Integer) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/{id}", 1);
        deleteResult.characterEncoding("Encoding");
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(productController).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(deleteResult);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("redirect:/products"));
    }

    /**
     * Method under test: {@link ProductController#edit(Integer, Model)}
     */
    @Test
    void testEdit() throws Exception {
        // Arrange
        Product product = new Product();
        product.setId(1);
        product.setName("Name");
        product.setPrice(BigDecimal.valueOf(42L));
        product.setProductId("42");
        product.setVersion(1);
        when(productService.getProductById((Integer) any())).thenReturn(product);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/edit/{id}", 1);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("productform"));
    }

    /**
     * Method under test: {@link ProductController#list(Model)}
     */
    @Test
    void testList() throws Exception {
        // Arrange
        when(productService.listAllProducts()).thenReturn((Iterable<Product>) mock(Iterable.class));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("products"));
    }

    /**
     * Method under test: {@link ProductController#list(Model)}
     */
    @Test
    void testList2() throws Exception {
        // Arrange
        when(productService.listAllProducts()).thenReturn((Iterable<Product>) mock(Iterable.class));
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/");
        getResult.characterEncoding("Encoding");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("products"));
    }

    /**
     * Method under test: {@link ProductController#newProduct(Model)}
     */
    @Test
    void testNewProduct() throws Exception {
        // Arrange
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/product/new");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("productform"));
    }

    /**
     * Method under test: {@link ProductController#newProduct(Model)}
     */
    @Test
    void testNewProduct2() throws Exception {
        // Arrange
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/product/new");
        getResult.characterEncoding("Encoding");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("productform"));
    }

    /**
     * Method under test: {@link ProductController#showProduct(Integer, Model)}
     */
    @Test
    void testShowProduct() throws Exception {
        // Arrange
        Product product = new Product();
        product.setId(1);
        product.setName("Name");
        product.setPrice(BigDecimal.valueOf(42L));
        product.setProductId("42");
        product.setVersion(1);
        when(productService.getProductById((Integer) any())).thenReturn(product);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/{id}", 1);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(productController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("productshow"));
    }

    /**
     * Method under test: {@link ProductController#showProduct(Integer, Model)}
     */
    @Test
    void testShowProduct2() throws Exception {
        // Arrange
        Product product = new Product();
        product.setId(1);
        product.setName("Name");
        product.setPrice(BigDecimal.valueOf(42L));
        product.setProductId("42");
        product.setVersion(1);
        when(productService.getProductById((Integer) any())).thenReturn(product);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/{id}", 1);
        MockMvc buildResult = MockMvcBuilders.standaloneSetup(productController).build();

        // Act
        ResultActions actualPerformResult = buildResult.perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("productshow"));
    }
}

