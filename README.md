# ShoppingCart

# Usage
  PricingRules pricingRules = new PricingRules();<br>
  Cart cart = new ShoppingCart(pricingRules);
  
  cart.add(ProductFactory.getProduct(ProductCode._ULT_SMALL));<br>
  cart.add(ProductFactory.getProduct(ProductCode._1GB), "I<3AMAYSIM");
  
  cart.total();<br>
  cart.items();

# Test
  run the ShoppingCartTest to execute the test scenarios

# Sample Test Result
         Scenario |                   Items Added                       |   Total   |         Expected Cart Items
         3        | 2X Unlimited 2GB 1X Unlimited 1GB 2X 1 GB Data-pack |	104.5	|2X Unlimited 2GB 1X Unlimited 1GB 2X 1 GB Data-package
         4	      |       1X Unlimited 1GB 1X 1 GB Data-pack            |	31.32	|1X Unlimited 1GB 1X 1 GB Data-package
         1	      |       1X Unlimited 5GB 3X Unlimited 1GB             |	94.7	|1X Unlimited 5GB 3X Unlimited 1GB
         2	      |      4X Unlimited 5GB 2X Unlimited 1GB              |	209.4	|4X Unlimited 5GB 2X Unlimited 1GB 

# Update
 Added Application.class (entry point) for the purpose to see the result.
  
   
