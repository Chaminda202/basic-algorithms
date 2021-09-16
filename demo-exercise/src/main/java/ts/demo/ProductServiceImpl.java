package ts.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ShoppingCard> addProduct(Product product) {
       this.productRepository.addProduct(product);
       List<Product> productList = this.productRepository.getProductList();
        List<ShoppingCard> shoppingCards = new ArrayList<>();
       Map<Product, Integer> map = new HashMap<>();
        for (int i = 0; i < productList.size(); i++) {
            if (map.containsKey(productList.get(i))) {
                map.put(productList.get(i), map.get(productList.get(i)) + 1);
            }else
                map.put(productList.get(i),  1);
        }

        for (Map.Entry<Product, Integer> entry : map.entrySet()) {
            shoppingCards.add(new ShoppingCard(entry.getKey(), entry.getValue()));
        }

       /* Map<Integer, List<Product>> collect = this.productRepository.getProductList()
                .stream()
                .collect(Collectors.groupingBy(Product::getBarcode));*/

        return shoppingCards;
    }

    @Override
    public List<ShoppingCard> deleteProduct(Integer barcode) {
        this.productRepository.remove(barcode);
        return null;
    }
}
