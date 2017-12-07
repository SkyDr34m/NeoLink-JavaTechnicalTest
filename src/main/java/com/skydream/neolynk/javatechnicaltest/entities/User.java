/*
 * You are free to do what you want with this code
 * as long as you offer me a drink ;)
 */
package com.skydream.neolynk.javatechnicaltest.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author SkyDream
 */
public class User extends Entity {
    
    private Map<String, Account> accounts;
    
    public static final UserAN<String> FirstName = new UserAN<String>("first_name");
    public static final UserAN<String> LastName = new UserAN<String>("last_name");
    public static final UserAN<String> Age = new UserAN<String>("age");
    public static final UserAN<String> Address = new UserAN<String>("address");
    public static final UserAN<String> Phone = new UserAN<String>("phone");
    
    public User () {
        super();
        accounts = new HashMap<String, Account>();
    }
    
    public void addAccount(Account account) {
        this.accounts.put(String.valueOf(account.getId()), account);
    }
    public void removeAccount(Account account) {
        this.accounts.remove(String.valueOf(account.getId()));
    }
    public List<Account> getAccounts() {
        return this.accounts.values().stream().collect(Collectors.toList());
    }
    
    public static class UserAN<T> extends EntityAN<T> {
        public UserAN(String name) {
            super(name);
        }
    }
}
