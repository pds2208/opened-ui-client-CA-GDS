package uk.gov.ons.oauthclientui.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductService {
    public List<Product> getProducts() {

        ArrayList<Product> product = new ArrayList<>();

        product.add(new Product("Samsung 4k TV", 1500));
        product.add(new Product("Apple Macbook Pro 13\"/512GB/16GB", 1750));
        product.add(new Product("Samsung Galaxy S9", 799));
        product.add(new Product("iPhone X", 899));
        product.add(new Product("Synology NAS", 800));
        product.add(new Product("Jaguar F-Type, V8", 89000));
        product.add(new Product("Iiyama 4k Monitor", 450));
        product.add(new Product("Pair of Jeans", 49));
        product.add(new Product("Thinkpad P52", 1500));
        product.add(new Product("Water Bottle", 2));
        
        return product;
    }
}