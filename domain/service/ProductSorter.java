package domain.service;

import domain.model.Product;

import java.util.Arrays;
import java.util.Comparator;

public class ProductSorter {

    private Comparator<Product> currentComparator;

    public ProductSorter() {
        this.currentComparator = Comparator.naturalOrder(); // cena malejąco, potem alfabetycznie
    }

    public void setComparator(Comparator<Product> comparator) {
        this.currentComparator = comparator;
    }

    public Product[] sort(Product[] products) {
        return Arrays.stream(products)
                .sorted(currentComparator)
                .toArray(Product[]::new);
    }
}
