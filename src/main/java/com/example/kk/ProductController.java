package com.example.kk;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")  // Base path for all endpoints in this controller
public class ProductController {

    private final List<Product> products = new ArrayList<>();

    @GetMapping
    public List<Product> getAllProducts() {
        return products;
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        int nextId = 0;
        product.setId((long) nextId++); // Assign auto-increment ID
        products.add(product);
        return product;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                updatedProduct.setId(id); // Ensure the ID remains the same
                products.set(i, updatedProduct);
                return updatedProduct;
            }
        }
        return null; // Consider throwing an exception or returning ResponseEntity.notFound() if product not found
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }
}

