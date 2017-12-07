/*
 * You are free to do what you want with this code
 * as long as you offer me a drink ;)
 */
package com.skydream.neolynk.javatechnicaltest;

import com.skydream.neolynk.javatechnicaltest.entities.Account;
import com.skydream.neolynk.javatechnicaltest.entities.User;
import com.skydream.neolynk.javatechnicaltest.managers.AccountManager;
import com.skydream.neolynk.javatechnicaltest.managers.UserManager;
import java.util.Collection;

/**
 *
 * @author SkyDream
 */
public class App {
    
    private final UserManager userManager;
    private final AccountManager accountManager;
    
    public App() {
        userManager = new UserManager();
        accountManager = new AccountManager();
    }
    
    // CRUD : User
    /**
     * Create a new User
     * @param firstName
     * @param lastName
     * @param age
     * @param address
     * @param phone
     * @return the User created with a new ID
     */
    public User createUser(String firstName, String lastName, String age, String address, String phone) {
        User user = new User();
        user.setAttribute(User.FirstName, firstName);
        user.setAttribute(User.LastName, lastName);
        user.setAttribute(User.Age, age);
        user.setAttribute(User.Address, address);
        user.setAttribute(User.Phone, phone);
        userManager.register(user);
        // Return created User
        return user;
    }
    /**
     * You'll have to uderstand what this does by yourself ... no seriously.
     * @param userId
     * @return read User
     */
    public User readUser(int userId) {
        return userManager.get(userId);
    }
    /**
     * Update the user if it already exist
     * @param user
     * @return updated User
     */
    public User updateUser(User user) {
        return  userManager.update(user);
    }
    /**
     * Delete the user if it already exist with the same values
     * @param user
     * @return deleted User
     */
    public User deleteUser(User user) {
        return userManager.delete(user);
    }
    
    // CRUD : Account
    /**
     * Create a new account and set a valid account id
     * @param dateOfCreation
     * @param balance 
     * @return created account
     */
    public Account createAccount(String dateOfCreation, float balance) {
        Account account = new Account();
        account.setAttribute(Account.DateOfCreation, dateOfCreation);
        account.setAttribute(Account.Balance, balance);
        accountManager.register(account);
        return account;
    }
    /**
     * Return an existing account matching the accound id
     * @param accountId
     * @return 
     */
    public Account readAccount(int accountId) {
        return accountManager.get(accountId);
    }
    /**
     * Update an existing account matching the account id
     * @param account
     * @return 
     */
    public Account updateAccount(Account account) {
        return accountManager.update(account);
    }
    /**
     * Delete an existing account matching both id and content
     * @param account
     * @return 
     */
    public Account deleteAccount(Account account) {
        return accountManager.delete(account);
    }
    
    // Money op
    /**
     * Withdraw amount from the account reducing it's amount
     * @param amount
     * @param account
     * @return 
     */
    public float withdraw(float amount, Account account) {
        // It was not specified but you might want to check (amount > 0)
        // Funny story, it was an existing bug in an Easter European Country few years ago
        float balance = account.getAttribute(Account.Balance);
        account.setAttribute(Account.Balance, balance - amount);
        accountManager.update(account);
        return amount;
    }
    /**
     * Deposit amount on the account
     * @param amount
     * @param account
     * @return 
     */
    public float deposit(float amount, Account account) {
        // Same as above, might want to check (amount > 0)
        float balance = account.getAttribute(Account.Balance);
        account.setAttribute(Account.Balance, balance + amount);
        accountManager.update(account);
        return amount;
    }
    
    // Link accounts
    /**
     * Link an account to a user
     * Note that if the account is already linked to another user this operation does not destroy any previous link.
     * @param account
     * @param user 
     */
    public void linkAccount(Account account, User user) {
        user.addAccount(account);
        userManager.update(user);
        // It was not specified if an account should be linked to only one user
    }
    
    // Find User Accounts
    /**
     * Return the accounts of a user
     * @param user
     * @return a Collection of Account
     */
    public Collection<Account> userAccounts(User user) {
        return user.getAccounts();
    }
    
    // User Accounts Balance
    /**
     * Return the total balance of a user's accounts
     * @param user
     * @return 
     */
    public float userBalance(User user) {
        return user.getAccounts()
                .stream()
                .map(account -> account.getAttribute(Account.Balance))
                .reduce((t, u) -> t + u).get();
    }
}
