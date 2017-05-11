package com.amaysim.cart;

import com.amaysim.cart.interfaces.Cart;
import com.amaysim.cart.pricing.PricingRules;
import com.amaysim.cart.product.Product;
import com.amaysim.cart.product.ProductCode;
import com.amaysim.cart.utils.ProductFactory;

import java.util.Map;

import static junit.framework.Assert.assertEquals;
/**
 * Created by FaustineP on 11/05/2017.
 */
public class Application{

    public static void main(String args[]) {
        scenario1();
        scenario2();
        scenario3();
        scenario4();
    }


    protected static void scenario1() {
        PricingRules pricingRules = new PricingRules();
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
        System.out.println("   1\t | " + displayItems(cart) + "\t\t|\t" + cart.total() + "\t|  " + displayItems(cart));
    }

    protected static void scenario2() {
        PricingRules pricingRules = new PricingRules();
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

        System.out.println("   2\t | " + displayItems(cart) + "\t\t|\t" + cart.total() + "\t|  " + displayItems(cart));
    }

    protected static void scenario3() {
        PricingRules pricingRules = new PricingRules();
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

        System.out.println("   3\t | " + displayItems(cart) + "\t\t|\t" + cart.total() + "\t|  " + displayItems(cart));

    }

    protected static void scenario4() {
        PricingRules pricingRules = new PricingRules();
        Cart cart = new ShoppingCart(pricingRules);
        cart.add(ProductFactory.getProduct(ProductCode._ULT_SMALL));
        cart.add(ProductFactory.getProduct(ProductCode._1GB), "I<3AMAYSIM");
        double expectedTotal = 31.32;
        double actualTotal = cart.total();
        assertEquals(expectedTotal, actualTotal);

        int expectedTotalULTSmall = 1;
        int actualTotalULTSmall = getNoOfItems(ProductCode._ULT_SMALL,cart.items());
        assertEquals(expectedTotalULTSmall,actualTotalULTSmall);

        int expectedTotal1GB = 1;
        int actualTotal1GB = getNoOfItems(ProductCode._1GB,cart.items());
        assertEquals(expectedTotal1GB,actualTotal1GB);
        System.out.println("   4\t | " + displayItems(cart) + "\t\t|\t" + cart.total() + "\t|  " + displayItems(cart));
    }

    protected static StringBuilder displayItems(Cart cart) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Product, Integer> item : cart.items().entrySet()) {
            stringBuilder.append(item.getValue()).append("x ").append(item.getKey().getName()).append(", ");

        }
        if(cart.getPromoCode()!=null){
            stringBuilder.append(cart.getPromoCode());
        }
        return stringBuilder.deleteCharAt(stringBuilder.length()-2);
    }


    protected static int getNoOfItems(ProductCode productCode, Map<Product, Integer> products) {
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
