/*
 *  You are free to do what you want with this code 
 *  as long as you offer me a drink ;)
 */
package com.skydream.neolynk.javatechnicaltest.entities;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SkyDream
 */
public class UserTest {
    
    public UserTest() {
    }

    /**
     * Test of addAccount method, of class User.
     */
    @Test
    public void testAddAccount() {
        System.out.println("addAccount");
        
        Account account = new Account();
        int accountId = account.getId();
        
        User instance = new User();
        instance.addAccount(account);
        instance.addAccount(account);
        
        // The new account exist and is unique (by id) in our User
        assertTrue(
            instance.getAccounts()
                    .stream()
                    .filter(eachAccount -> eachAccount.getId() == accountId)
                    .count() == 1);
    }

    /**
     * Test of removeAccount method, of class User.
     */
    @Test
    public void testRemoveAccount() {
        System.out.println("removeAccount");
        
        Account account = new Account();
        int accountId = account.getId();
        
        User instance = new User();
        instance.addAccount(account);
        instance.removeAccount(account);
        
        // The new account does not exist anymore in our User
        assertTrue(
            instance.getAccounts()
                    .stream()
                    .noneMatch(eachAccount -> eachAccount.getId() == accountId));
    }

    /**
     * Test of getAccounts method, of class User.
     */
    @Test
    public void testGetAccounts() {
        System.out.println("getAccounts");
        
        User instance = new User();
        for (int i=1; i<6; i++) {
            Account account = new Account();
            account.setId(i);
            instance.addAccount(account);
        }
        
        assertTrue(
            instance.getAccounts()
                    .stream()
                    .count() == 5);
    }
    
}
