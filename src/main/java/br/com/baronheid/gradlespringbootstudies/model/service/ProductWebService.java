package br.com.baronheid.gradlespringbootstudies.model.service;

import br.com.baronheid.gradlespringbootstudies.model.entity.Product;
import br.com.baronheid.gradlespringbootstudies.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductWebService {

    private final ProductRepository productRepository;

    public ProductWebService(@Autowired final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(int idCode) {
        return productRepository.findById(idCode).get();
    }

    public void deleteById(int id) {
        productRepository.deleteById(id);
    }
}
