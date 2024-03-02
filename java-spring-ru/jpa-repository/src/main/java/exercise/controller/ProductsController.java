package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort;

import java.util.List;

import exercise.model.Product;
import exercise.repository.ProductRepository;
import exercise.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    // BEGIN

    private final Integer VALUE = Integer.MAX_VALUE;
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> index(@RequestParam(defaultValue = "0") int min, @RequestParam(defaultValue = Integer.MAX_VALUE + "") int max) {
        var sort = Sort.by(Sort.Order.asc("price"));
        return productRepository.findByPriceBetween(min, max, sort);
    }
    // END

    @GetMapping(path = "/{id}")
    public Product show(@PathVariable long id) {

        var product =  productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));

        return product;
    }
}
