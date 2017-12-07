/*
 * You are free to do what you want with this code
 * as long as you offer me a drink ;)
 */
package com.skydream.neolynk.javatechnicaltest.entities;

/**
 *
 * @author SkyDream
 */
public class Account extends Entity {
    
    public static final AccountAN<String> DateOfCreation = new AccountAN<String>("date_of_creation");
    public static final AccountAN<Float> Balance = new AccountAN<Float>("balance");
    
    public Account () {
        super();
    }
    
    public static class AccountAN<T> extends EntityAN<T> {
        public AccountAN(String name) {
            super(name);
        }
    }
}
