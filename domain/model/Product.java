package domain.model;

public class Product implements Comparable<Product> {
    private String code;
    private String name;
    private double price;
    private double discountPrice;

    public Product(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.discountPrice = price;
    }

    // Gettery i settery

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    public double getDiscountPrice() {
        return discountPrice;
    }

    public void applyDiscount(double discountAmount) {
        this.discountPrice = price - discountAmount;
    }

    public void resetDiscount() {
        this.discountPrice = price;
    }

    @Override
    public int compareTo(Product other) {
        int priceCompare = Double.compare(other.price, this.price); // malejąco
        return priceCompare != 0 ? priceCompare : this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name + " - " + discountPrice + " zł";
    }
}

