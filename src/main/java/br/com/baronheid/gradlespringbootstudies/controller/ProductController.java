package br.com.baronheid.gradlespringbootstudies.controller;

import br.com.baronheid.gradlespringbootstudies.model.entity.Product;
import br.com.baronheid.gradlespringbootstudies.model.service.ProductService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// RestController allows the controller to be RESTful
@RestController
// Route to all subroutes below
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(@Autowired final ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> listProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable int id) {
        return productService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product registerProduct(@RequestBody @NonNull Product product) {
        return productService.registerProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable int id) {
        return productService.updateProduct(product, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/search")
    public List<Product> searchProduct(@RequestParam(required = false) String name,
                                       @RequestParam(defaultValue = "false") boolean isItNew) {
        return productService.searchProduct(name, isItNew);
    }

}
