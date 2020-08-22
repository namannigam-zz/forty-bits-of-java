package edu.forty.bits.features.lvti;

public class Q50567172 {
    public static void main(String[] args) {
        var products = java.util.List.of(
                new Product(10, 3, "Apple"),
                new Product(5, 2, "Banana"),
                new Product(17, 5, "Pear"));
        var productInfos = products
                .stream()
                .map(product -> new Object() {
                    String name = product.getName();
                    int total = product.getQuantity() * product.getPrice();
                })
                .collect(java.util.stream.Collectors.toList());
        productInfos.forEach(prod ->
                System.out.println("name = " + prod.name + ", total = " +
                        prod.total));
    }

    public static class Product {
        Integer price;
        Integer quantity;
        String name;

        public Product(Integer price, Integer quantity, String name) {
            this.price = price;
            this.quantity = quantity;
            this.name = name;
        }

        public Integer getPrice() {
            return price;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public String getName() {
            return name;
        }
    }
}

/**
 * Execute as following :-
 * java -p "/Users/naman.nigam/GitHub/Naman/jdk10-updates/out/production/jdk10-updates" -m jdk.comparison/com.stackoverflow.nullpointer.AnonymousClass
 */