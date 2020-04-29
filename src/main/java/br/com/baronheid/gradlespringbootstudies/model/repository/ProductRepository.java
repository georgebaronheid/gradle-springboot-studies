package br.com.baronheid.gradlespringbootstudies.model.repository;

import br.com.baronheid.gradlespringbootstudies.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByName(String name);
    List<Product> findByNewProduct(boolean novo);
    List<Product> findByNameAndNewProduct(String name, boolean newProduct);
    List<Product> findByPriceGreaterThan(double price);

}
