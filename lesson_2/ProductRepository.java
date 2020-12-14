package lesson_2;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
@Primary
public class ProductRepository {

    private List<Product> products;

    public void addProduct(Product product) {
        products.add(product);
    }

    public void deleteProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProduct() {
        return Collections.unmodifiableList(products);
    }

    public void getProductById(int id) {
        if (products.size() != 0) {
            for (Product product : products) {
                if (id == product.getId()) {
                    System.out.println(product);
                } else {
                    throw new NoSuchElementException("Can't find the product with ID " + id + ".");
                }
            }
        }
    }

    @PostConstruct
    public void init() {
        List<Product> products = new LinkedList<>();
        int id = 0;
        addProduct (new Product(id++, "boots", 2000));
        addProduct(new Product(id++, "sheet", 150));
        addProduct(new Product(id++, "book", 790));
        addProduct(new Product(id++, "knife", 3450));
    }
}
