package com.amaysim.cart.utils;

import com.amaysim.cart.product.Product;
import com.amaysim.cart.product.ProductCode;

import static com.amaysim.cart.product.ProductCode.*;

/**
 * Created by FaustineP on 04/05/2017.
 */
public class ProductFactory {

    public static Product getProduct(ProductCode productCode) {
        switch (productCode) {
            case _ULT_SMALL:
                return new Product(_ULT_SMALL.toString(), "Unlimited 1GB", 24.90);
            case _ULT_MEDIUM:
                return new Product(_ULT_MEDIUM.toString(), "Unlimited 2GB", 29.90);
            case _ULT_LARGE:
                return new Product(_ULT_LARGE.toString(), "Unlimited 5GB", 44.90);
            case _1GB:
                return new Product(_1GB.toString(), "1 GB Data-pack", 9.90);
            default:
                return null;
        }
    }
}
