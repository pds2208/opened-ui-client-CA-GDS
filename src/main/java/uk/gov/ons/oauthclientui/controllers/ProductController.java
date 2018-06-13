package uk.gov.ons.oauthclientui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uk.gov.ons.oauthclientui.service.ProductService;

import java.util.Map;

@Controller
public class ProductController {

    private final ProductService products;

    @Autowired
    public ProductController(ProductService products) {
        this.products = products;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String products(Map<String, Object> model) {
        model.put("products", products.getProducts());
        return "products";
    }

}
