package com.amaysim.cart;

import com.amaysim.cart.interfaces.Cart;
import com.amaysim.cart.interfaces.IPricingRules;
import com.amaysim.cart.product.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by FaustineP on 04/05/2017.
 */
public class ShoppingCart implements Cart {

    private HashMap<Product, Integer> items = new HashMap<>();

    private String promoCode;
    private IPricingRules pricingRules;

    public ShoppingCart(IPricingRules pricingRules) {
        this.pricingRules = pricingRules;
    }

    public Map<Product, Integer> items() {
        return items;
    }

    public void add(Product product) {
        items.put(product, items.get(product) == null ? 1 : items.get(product) + 1);
    }

    public void add(Product product, String promoCode) {
        add(product);
        this.promoCode = promoCode;
    }

    public Double total() {
        return pricingRules.apply(items, this.promoCode);
    }

    public String getPromoCode() {
        return promoCode;
    }

    public IPricingRules getPricingRules() {
        return pricingRules;
    }
}
