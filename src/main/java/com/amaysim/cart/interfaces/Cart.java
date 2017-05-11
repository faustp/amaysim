package com.amaysim.cart.interfaces;

import com.amaysim.cart.product.Product;

import java.util.Map;

/**
 * Created by FaustineP on 04/05/2017.
 */
public interface Cart {
    Map<Product, Integer> items();

    void add(Product product);

    void add(Product product, String promo);

    Double total();

    String getPromoCode();
}
