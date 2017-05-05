package com.amaysim.cart;

import com.amaysim.cart.interfaces.Cart;
import com.amaysim.cart.pricing.PricingRules;
import com.amaysim.cart.product.Product;
import com.amaysim.cart.product.ProductCode;
import com.amaysim.cart.utils.ProductFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static junit.framework.Assert.assertEquals;

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
        double expectedTotal = 94.7;
        double actualTotal = cart.total();
        assertEquals(expectedTotal, actualTotal);

        int expectedTotalULTSmall = 3;
        int actualTotalULTSmall = getNoOfItems(ProductCode._ULT_SMALL, cart.items());
        assertEquals(expectedTotalULTSmall, actualTotalULTSmall);

        int expectedTotalULTLarge = 1;
        int actualTotalULTLarge = getNoOfItems(ProductCode._ULT_LARGE, cart.items());
        assertEquals(expectedTotalULTLarge, actualTotalULTLarge);
        System.out.println("Scenario1\t::" + displayItems(cart) + "|\t" + cart.total() + "\t|" + displayItems(cart));
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
        double expectedTotal = 209.4;
        double actualTotal = cart.total();
        assertEquals(expectedTotal, actualTotal);

        int expectedTotalULTSmall =2;
        int actualTotalULTSmall = getNoOfItems(ProductCode._ULT_SMALL,cart.items());
        assertEquals(expectedTotalULTSmall,actualTotalULTSmall);

        int expectedTotalULTLarge = 4;
        int actualTotalULTLarge = getNoOfItems(ProductCode._ULT_LARGE,cart.items());
        assertEquals(expectedTotalULTLarge,actualTotalULTLarge);

        System.out.println("Scenario2\t::" + displayItems(cart) + "|\t" + cart.total() + "\t|" + displayItems(cart));
    }

    @Test
    public void SCENARIO3() {
        Cart cart = new ShoppingCart(pricingRules);
        cart.add(ProductFactory.getProduct(ProductCode._ULT_SMALL));
        cart.add(ProductFactory.getProduct(ProductCode._ULT_MEDIUM));
        cart.add(ProductFactory.getProduct(ProductCode._ULT_MEDIUM));
        double expectedTotal = 84.7;
        double actualTotal = cart.total();
        assertEquals(expectedTotal, actualTotal);

        int expectedTotalULTSmall =1;
        int actualTotalULTSmall = getNoOfItems(ProductCode._ULT_SMALL,cart.items());
        assertEquals(expectedTotalULTSmall,actualTotalULTSmall);

        int expectedTotalULTMedium = 2;
        int actualTotalULTMedium = getNoOfItems(ProductCode._ULT_MEDIUM,cart.items());
        assertEquals(expectedTotalULTMedium,actualTotalULTMedium);

        int expectedTotal1GB = expectedTotalULTMedium;
        int actualTotal1GB = getNoOfItems(ProductCode._1GB,cart.items());
        assertEquals(expectedTotal1GB,actualTotal1GB);

        System.out.println("Scenario3\t::" + displayItems(cart) + "|\t" + cart.total() + "\t|" + displayItems(cart));
    }

    @Test
    public void SCENARIO4() {
        Cart cart = new ShoppingCart(pricingRules);
        cart.add(ProductFactory.getProduct(ProductCode._ULT_SMALL));
        cart.add(ProductFactory.getProduct(ProductCode._1GB), "I<3AMAYSIM");
        double expectedTotal = 31.32;
        double actualTotal = cart.total();
        assertEquals(expectedTotal, actualTotal);

        int expectedTotalULTSmall = 1;
        int actualTotalULTSmall = getNoOfItems(ProductCode._ULT_SMALL,cart.items());
        assertEquals(expectedTotalULTSmall,actualTotalULTSmall);

        int expexctedTotal1GB = 1;
        int actualTotal1GB = getNoOfItems(ProductCode._1GB,cart.items());
        assertEquals(expexctedTotal1GB,actualTotal1GB);
        System.out.println("Scenario4\t::" + displayItems(cart) + "|\t" + cart.total() + "\t|" + displayItems(cart));
    }

    private StringBuilder displayItems(Cart cart) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Product, Integer> item : cart.items().entrySet()) {
            stringBuilder.append(item.getValue() + "X " + item.getKey().getName() + " ");

        }
        return stringBuilder;
    }

    private int getNoOfItems(ProductCode productCode, Map<Product, Integer> products) {
        int noOfItems = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getCode().equalsIgnoreCase(productCode.toString())) {
                noOfItems = entry.getValue();
                break;
            }
        }
        return noOfItems;
    }
}