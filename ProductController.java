package lesson_3;

import online_store.Product;
import online_store.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public String allProducts(Model model) {
        model.addAttribute("products", productRepository.getProduct());
        return "products";
    }

    @GetMapping("/form")
    public String formProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product_form";
    }

    @RequestMapping("/id")
    public String productById(@RequestParam("id") int id, Model model) {
        Product product = productRepository.getProductById(id);
        if (product != null) {
            model.addAttribute("product", product);
            return "product";
        }
        return allProducts(model);
    }

    @PostMapping("/form")
    public String newProduct(Product product) {
        productRepository.addProduct(product);
        return "redirect:/products";
    }
}
