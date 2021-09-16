package ts.demo;


import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private String name;
    private Integer barcode;
    private BigDecimal price;

    public Product(String name, Integer barcode, BigDecimal price) {
        this.name = name;
        this.barcode = barcode;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBarcode() {
        return barcode;
    }

    public void setBarcode(Integer barcode) {
        this.barcode = barcode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return barcode.equals(product.barcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(barcode);
    }
}
