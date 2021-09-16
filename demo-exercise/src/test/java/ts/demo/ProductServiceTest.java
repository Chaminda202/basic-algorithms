package ts.demo;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;

public class ProductServiceTest {
    @Mock
    ProductRepository productRepository;

    ProductService productService;

    @Test
    void addProductTest() {
        Mockito.when(productRepository.addProduct(any())).thenReturn(createProduct());
    }

    private Product createProduct() {
       return new Product("Test", 2, new BigDecimal(23.45));
    }
}
