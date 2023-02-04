package storm.code.repositories;

import storm.code.entities.Product;
import org.springframework.data.jpa.repository.*;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
