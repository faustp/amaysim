package com.amaysim.cart.interfaces;

import java.io.Serializable;

/**
 * Created by FaustineP on 04/05/2017.
 */
public interface Nameable extends Serializable {

    void setName(String name);

    String getName();
}
