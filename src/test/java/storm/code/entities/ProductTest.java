package storm.code.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class ProductTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Product}
     *   <li>{@link Product#setId(Integer)}
     *   <li>{@link Product#setName(String)}
     *   <li>{@link Product#setPrice(BigDecimal)}
     *   <li>{@link Product#setProductId(String)}
     *   <li>{@link Product#setVersion(Integer)}
     *   <li>{@link Product#getId()}
     *   <li>{@link Product#getName()}
     *   <li>{@link Product#getPrice()}
     *   <li>{@link Product#getProductId()}
     *   <li>{@link Product#getVersion()}
     * </ul>
     */
    @Test
    void testConstructor() {
        // Arrange and Act
        Product actualProduct = new Product();
        actualProduct.setId(1);
        actualProduct.setName("Name");
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        actualProduct.setPrice(valueOfResult);
        actualProduct.setProductId("42");
        actualProduct.setVersion(1);

        // Assert
        assertEquals(1, actualProduct.getId().intValue());
        assertEquals("Name", actualProduct.getName());
        assertSame(valueOfResult, actualProduct.getPrice());
        assertEquals("42", actualProduct.getProductId());
        assertEquals(1, actualProduct.getVersion().intValue());
    }
}

