package com.amaysim.cart.pricing;

import com.amaysim.cart.interfaces.IPricingRules;
import com.amaysim.cart.product.Product;
import com.amaysim.cart.product.ProductCode;
import com.amaysim.cart.utils.ProductFactory;

import java.util.Map;

/**
 * Created by FaustineP on 04/05/2017.
 */
public class PricingRules implements IPricingRules {

    private boolean hasBundledItems = false;
    private int noOfBundledItems = 0;

    public Double apply(Map<Product, Integer> items, String promoCode) {
        double total = 0;
        for (Object o : items.entrySet()) {
            Map.Entry<Product, Integer> pair = (Map.Entry) o;
            if (pair.getKey().getCode().equalsIgnoreCase(ProductCode._ULT_SMALL.toString()) && pair.getValue() >= 3) {
                total += ((pair.getValue() / 3) * 2) * pair.getKey().getPrice();
                total += (pair.getValue() % 3) * pair.getKey().getPrice();
            } else if (pair.getKey().getCode().equalsIgnoreCase(ProductCode._ULT_LARGE.toString()) && pair.getValue() > 3) {
                total += 39.90 * pair.getValue();
            } else if (pair.getKey().getCode().equalsIgnoreCase(ProductCode._ULT_MEDIUM.toString())) {
                hasBundledItems = true;
                noOfBundledItems = pair.getValue();
                total += pair.getKey().getPrice() * pair.getValue();
            } else {
                total += pair.getKey().getPrice() * pair.getValue();
            }
        }
        if (promoCode != null && promoCode.equalsIgnoreCase("I<3AMAYSIM")) {
            total = (total - (total * 0.10));
        }
        if (hasBundledItems) {
            items.put(ProductFactory.getProduct(ProductCode._1GB), noOfBundledItems);
        }
        return Math.round(total * 100.0) / 100.0;
    }
}
