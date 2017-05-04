package com.amaysim.cart.interfaces;

import com.amaysim.cart.product.Product;

import java.util.Map;

/**
 * Created by FaustineP on 04/05/2017.
 */
public interface IPricingRules {

    Double apply(Map<Product, Integer> items, String promoCode);

}
