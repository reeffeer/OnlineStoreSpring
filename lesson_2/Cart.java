package lesson_2;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Component
@Scope("prototype")
public class Cart {

    private ProductRepository productRepository;
    private List<Product> productList;

    public void addById(int id) {
        productList.add(productRepository.getProductById(id));
    }

    private boolean removeById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                productList.remove(product.getId());
            } else {
                throw new NoSuchElementException("Product with ID = " + id + " is not found.");
            }
        }
      return true;
    }

    public void clear() {
        productList.clear();
        System.out.println("Your cart is empty.");
    }

    @PostConstruct
    public void init() {
        productList = new LinkedList<>();
    }

    @Override
    public String toString() {
        if (productList.size() == 0) {
            return "[Empty cart.]";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Product product : productList) {
            stringBuilder.append(product).append("\n");
        }
        return stringBuilder.toString();
    }
}
