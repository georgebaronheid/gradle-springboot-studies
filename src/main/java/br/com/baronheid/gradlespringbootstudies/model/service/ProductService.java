package br.com.baronheid.gradlespringbootstudies.model.service;

import br.com.baronheid.gradlespringbootstudies.model.entity.Product;
import br.com.baronheid.gradlespringbootstudies.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(@Autowired final ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(int id) {
        return productRepository.findById(id).get();
    }

    public Product registerProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product product, int id) {
        product.setId(id);
        return productRepository.save(product);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    public List<Product> searchProduct(String name, boolean isItNew) {
        return name != null ? productRepository.findByNameAndNewProduct(name, isItNew) :
                productRepository.findByNewProduct(isItNew);
    }
}
