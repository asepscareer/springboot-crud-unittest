package storm.code.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import storm.code.entities.Product;
import storm.code.repositories.ProductRepository;

@ContextConfiguration(classes = {ProductServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ProductServiceImplTest {
    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductServiceImpl productServiceImpl;

    /**
     * Method under test: {@link ProductServiceImpl#listAllProducts()}
     */
    @Test
    void testListAllProducts() {
        // Arrange
        ArrayList<Product> productList = new ArrayList<>();
        when(productRepository.findAll()).thenReturn(productList);

        // Act
        Iterable<Product> actualListAllProductsResult = productServiceImpl.listAllProducts();

        // Assert
        assertSame(productList, actualListAllProductsResult);
        assertTrue(((Collection<Product>) actualListAllProductsResult).isEmpty());
        verify(productRepository).findAll();
    }

    /**
     * Method under test: {@link ProductServiceImpl#getProductById(Integer)}
     */
    @Test
    void testGetProductById() {
        // Arrange
        Product product = new Product();
        product.setId(1);
        product.setName("Name");
        product.setPrice(BigDecimal.valueOf(42L));
        product.setProductId("42");
        product.setVersion(1);
        Optional<Product> ofResult = Optional.of(product);
        when(productRepository.findById((Integer) any())).thenReturn(ofResult);

        // Act
        Product actualProductById = productServiceImpl.getProductById(1);

        // Assert
        assertSame(product, actualProductById);
        assertEquals("42", actualProductById.getPrice().toString());
        verify(productRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link ProductServiceImpl#getProductById(Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetProductById2() {
        // TODO: Complete this test.
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:148)
        //       at storm.code.services.ProductServiceImpl.getProductById(ProductServiceImpl.java:25)

        // Arrange
        when(productRepository.findById((Integer) any())).thenReturn(Optional.empty());

        // Act
        productServiceImpl.getProductById(1);
    }

    /**
     * Method under test: {@link ProductServiceImpl#saveProduct(Product)}
     */
    @Test
    void testSaveProduct() {
        // Arrange
        Product product = new Product();
        product.setId(1);
        product.setName("Name");
        product.setPrice(BigDecimal.valueOf(42L));
        product.setProductId("42");
        product.setVersion(1);
        when(productRepository.save((Product) any())).thenReturn(product);

        Product product1 = new Product();
        product1.setId(1);
        product1.setName("Name");
        product1.setPrice(BigDecimal.valueOf(42L));
        product1.setProductId("42");
        product1.setVersion(1);

        // Act
        Product actualSaveProductResult = productServiceImpl.saveProduct(product1);

        // Assert
        assertSame(product, actualSaveProductResult);
        assertEquals("42", actualSaveProductResult.getPrice().toString());
        verify(productRepository).save((Product) any());
    }

    /**
     * Method under test: {@link ProductServiceImpl#deleteProduct(Integer)}
     */
    @Test
    void testDeleteProduct() {
        // Arrange
        doNothing().when(productRepository).deleteById((Integer) any());

        // Act
        productServiceImpl.deleteProduct(1);

        // Assert that nothing has changed
        verify(productRepository).deleteById((Integer) any());
    }
}

