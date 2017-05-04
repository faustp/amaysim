package com.amaysim.cart;

import com.amaysim.cart.interfaces.Cart;
import com.amaysim.cart.pricing.PricingRules;
import com.amaysim.cart.product.Product;
import com.amaysim.cart.product.ProductCode;
import com.amaysim.cart.utils.ProductFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * Created by FaustineP on 04/05/2017.
 */
public class ShoppingCartTest {

    static PricingRules pricingRules;

    @Before
    public void setup() {
        pricingRules = new PricingRules();
    }

    @Test
    public void SCENARIO1() {
        Cart cart = new ShoppingCart(pricingRules);
        cart.add(ProductFactory.getProduct(ProductCode._ULT_SMALL));
        cart.add(ProductFactory.getProduct(ProductCode._ULT_SMALL));
        cart.add(ProductFactory.getProduct(ProductCode._ULT_SMALL));
        cart.add(ProductFactory.getProduct(ProductCode._ULT_LARGE));
        System.out.println("Scenario1\t|" + displayItems(cart) + "|\t" + cart.total() + "\t|" + displayItems(cart));
    }


    @Test
    public void SCENARIO2() {
        Cart cart = new ShoppingCart(pricingRules);
        cart.add(ProductFactory.getProduct(ProductCode._ULT_SMALL));
        cart.add(ProductFactory.getProduct(ProductCode._ULT_SMALL));
        cart.add(ProductFactory.getProduct(ProductCode._ULT_LARGE));
        cart.add(ProductFactory.getProduct(ProductCode._ULT_LARGE));
        cart.add(ProductFactory.getProduct(ProductCode._ULT_LARGE));
        cart.add(ProductFactory.getProduct(ProductCode._ULT_LARGE));
        System.out.println("Scenario2\t|" + displayItems(cart) + "|\t" + cart.total() + "\t|" + displayItems(cart));
    }

    @Test
    public void SCENARIO3() {
        Cart cart = new ShoppingCart(pricingRules);
        cart.add(ProductFactory.getProduct(ProductCode._ULT_SMALL));
        cart.add(ProductFactory.getProduct(ProductCode._ULT_MEDIUM));
        cart.add(ProductFactory.getProduct(ProductCode._ULT_MEDIUM));
        System.out.println("Scenario3\t|" + displayItems(cart) + "|\t" + cart.total() + "\t|" + displayItems(cart));
    }

    @Test
    public void SCENARIO4() {
        Cart cart = new ShoppingCart(pricingRules);
        cart.add(ProductFactory.getProduct(ProductCode._ULT_SMALL));
        cart.add(ProductFactory.getProduct(ProductCode._1GB), "I<3AMAYSIM");
        System.out.println("Scenario4\t|" + displayItems(cart) + "|\t" + cart.total() + "\t|" + displayItems(cart));
    }

    private StringBuilder displayItems(Cart cart) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Product, Integer> item : cart.items().entrySet()) {
            stringBuilder.append(item.getValue() + "X " + item.getKey().getName() + " ");

        }
        return stringBuilder;
    }
}