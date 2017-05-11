package com.amaysim.cart;

import com.amaysim.cart.pricing.PricingRules;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by FaustineP on 04/05/2017.
 */
public class ShoppingCartTest extends Application{

    static PricingRules pricingRules;

    @Before
    public void setup() {
        pricingRules = new PricingRules();
    }

    @Test
    public void SCENARIO1() {
        scenario1();
    }


    @Test
    public void SCENARIO2() {
      scenario2();
    }

    @Test
    public void SCENARIO3() {
     scenario3();
    }

    @Test
    public void SCENARIO4() {
      scenario4();
    }


}