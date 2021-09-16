package ts.demo;

import java.util.List;

public interface ProductService {
    List<ShoppingCard> addProduct(Product product);
    List<ShoppingCard> deleteProduct(Integer barcode);
}
