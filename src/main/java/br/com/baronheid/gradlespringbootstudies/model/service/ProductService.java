package br.com.baronheid.gradlespringbootstudies.model.service;

import br.com.baronheid.gradlespringbootstudies.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductService {

    public ProductService(@Autowired final ProductRepository productRepository){}
}
