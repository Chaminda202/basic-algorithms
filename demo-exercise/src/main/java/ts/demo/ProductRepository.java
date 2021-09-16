package ts.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {
    private static final List<Product> productList = new ArrayList<>();

    public Product addProduct(Product product) {
        productList.add(product);
        return product;
    }

    public void remove(Integer barCode) {
        Optional<Product> optionalProduct = productList.stream()
                .filter(i -> i.getBarcode() == barCode)
                .findFirst();

        if (optionalProduct.isPresent())
            productList.remove(optionalProduct.get());
        else
            throw new ProductException("Product does not exist in the card");
    }

    public List<Product> getProductList() {
        return productList;
    }
}
