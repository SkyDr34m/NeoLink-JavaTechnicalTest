/*
 *  You are free to do what you want with this code 
 *  as long as you offer me a drink ;)
 */
package com.skydream.neolynk.javatechnicaltest;

import com.skydream.neolynk.javatechnicaltest.entities.Account;
import com.skydream.neolynk.javatechnicaltest.entities.User;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SkyDream
 */
public class AppTest {
    
    public AppTest() {
    }

    /**
     * Test of createUser method, of class App.
     */
    @Test
    public void testCreateUser() {
        System.out.println("createUser");
        String firstName = "Alexandre";
        String lastName = "Mothe";
        String age = "42";
        String address = "42 rue du test";
        String phone = "+33642424242";
        App app = new App();
        
        User createUser = app.createUser(firstName, lastName, age, address, phone);
        
        assertTrue(firstName.equals(createUser.getAttribute(User.FirstName)));
        assertTrue(lastName.equals(createUser.getAttribute(User.LastName)));
        assertTrue(age.equals(createUser.getAttribute(User.Age)));
        assertTrue(address.equals(createUser.getAttribute(User.Address)));
        assertTrue(phone.equals(createUser.getAttribute(User.Phone)));
    }

    /**
     * Test of readUser method, of class App.
     */
    @Test
    public void testReadUser() {
        System.out.println("readUser");
        String firstName = "Alexandre";
        String lastName = "Mothe";
        String age = "42";
        String address = "42 rue du test";
        String phone = "+33642424242";
        App app = new App();
        
        User user = new User();
        user.setAttribute(User.FirstName, firstName);
        user.setAttribute(User.LastName, lastName);
        user.setAttribute(User.Age, age);
        user.setAttribute(User.Address, address);
        user.setAttribute(User.Phone, phone);
        
        User createUser = app.createUser(firstName, lastName, age, address, phone);
        
        User readUser = app.readUser(createUser.getId());
        
        assertTrue(user.equals(readUser));
    }

    /**
     * Test of updateUser method, of class App.
     */
    @Test
    public void testUpdateUser() {
        System.out.println("updateUser");
        String firstName = "Alexandre";
        String lastName = "Mothe";
        String age = "42";
        String address = "42 rue du test";
        String phone = "+33642424242";
        App app = new App();
        
        // Expected User Result
        User user = new User();
        user.setAttribute(User.FirstName, firstName);
        user.setAttribute(User.LastName, lastName);
        user.setAttribute(User.Age, age);
        user.setAttribute(User.Address, address);
        user.setAttribute(User.Phone, phone);
        
        // Create a user with unexpected values
        User user2 = app.createUser("Michel", "Rambau", "24", "1 rue pileco", "12");
        
        // Set the id of our 'expected' user and replace our unexpected values
        user.setId(user2.getId());
        User updateUser = app.updateUser(user);
        
        // The updated user should be the same as the user used for the update
        assertTrue(user.equals(updateUser));
        
        // The updated user should be different from his inital data
        assertFalse(user2.equals(updateUser));
    }

    /**
     * Test of deleteUser method, of class App.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        App app = new App();
        User user = app.createUser("Michel", "Rambau", "24", "1 rue pileco", "12");
        User deletedUser = app.deleteUser(user);
        User readUser = app.readUser(deletedUser.getId());
        
        // The user returned should match the inital user
        assertTrue(user.equals(deletedUser));
        
        // The readUser is null
        assertEquals(null, readUser);
    }

    /**
     * Test of createAccount method, of class App.
     */
    @Test
    public void testCreateAccount() {
        System.out.println("createAccount");
        String dateOfCreation = "01-01-2001";
        float balance = 100;
        App app = new App();
        
        Account account = app.createAccount(dateOfCreation, balance);
        assertTrue(dateOfCreation.equals(account.getAttribute(Account.DateOfCreation)));
        assertTrue(account.getAttribute(Account.Balance).equals(balance));
    }

    /**
     * Test of readAccount method, of class App.
     */
    @Test
    public void testReadAccount() {
        System.out.println("readAccount");
        String dateOfCreation = "01-01-2001";
        float balance = 100;
        App app = new App();
        
        Account account = app.createAccount(dateOfCreation, balance);
        Account accountRead = app.readAccount(account.getId());
        
        assertTrue(account.equals(accountRead));
    }

    /**
     * Test of updateAccount method, of class App.
     */
    @Test
    public void testUpdateAccount() {
        System.out.println("updateAccount");
        String dateOfCreation = "01-01-2001";
        float balance = 100;
        App app = new App();
        
        Account account = new Account();
        account.setAttribute(Account.DateOfCreation, dateOfCreation);
        account.setAttribute(Account.Balance, balance);
        
        Account account2 = app.createAccount("12-12-2012", 999);
        account.setId(account2.getId());
        
        Account accountUpdate = app.updateAccount(account);
        
        assertTrue(account.equals(accountUpdate));
        
        assertFalse(account2.equals(accountUpdate));
    }

    /**
     * Test of deleteAccount method, of class App.
     */
    @Test
    public void testDeleteAccount() {
        System.out.println("deleteAccount");
        App app = new App();
        Account account = app.createAccount("12-12-2012", 999);
        Account deletedAccount = app.deleteAccount(account);
        Account readAccount = app.readAccount(deletedAccount.getId());
        
        // deleted account is the same as previously created account
        assertTrue(account.equals(deletedAccount));
        
        // readAccount is null because deleted
        assertEquals(null, readAccount);
    }

    /**
     * Test of withdraw method, of class App.
     */
    @Test
    public void testWithdraw() {
        System.out.println("withdraw");
        float amount = 200;
        App app = new App();
        Account account = app.createAccount("12-12-2012", 1000);
        float balance = account.getAttribute(Account.Balance);
        float withdrawn = app.withdraw(amount, account);
        
        assertTrue(amount == withdrawn);
        assertTrue(account.getAttribute(Account.Balance) == (balance - withdrawn));
    }

    /**
     * Test of deposit method, of class App.
     */
    @Test
    public void testDeposit() {
        System.out.println("deposit");
        float amount = 200;
        App app = new App();
        Account account = app.createAccount("12-12-2012", 1000);
        float balance = account.getAttribute(Account.Balance);
        float deposited = app.deposit(amount, account);
        
        assertTrue(amount == deposited);
        assertTrue(account.getAttribute(Account.Balance) == (balance + deposited));
    }

    /**
     * Test of linkAccount method, of class App.
     */
    @Test
    public void testLinkAccount() {
        System.out.println("linkAccount");
        App app = new App();
        Account account = app.createAccount("12-12-2012", 1000);
        User user = app.createUser("Michel", "Rambau", "24", "1 rue pileco", "12");
        
        assertFalse(user.getAccounts().contains(account));
        
        app.linkAccount(account, user);
        
        assertTrue(user.getAccounts().contains(account));
    }

    /**
     * Test of userAccounts method, of class App.
     */
    @Test
    public void testUserAccounts() {
        System.out.println("userAccounts");
        App app = new App();
        User user = app.createUser("Michel", "Rambau", "24", "1 rue pileco", "12");
        Account account1 = app.createAccount("12-12-2012", 1000);
        Account account2 = app.createAccount("12-12-2012", 1000);
        Account account3 = app.createAccount("12-12-2012", 1000);
        
        app.linkAccount(account1, user);
        app.linkAccount(account2, user);
        app.linkAccount(account3, user);
        
        Collection<Account> accounts = app.userAccounts(user);
        
        assertTrue(accounts.size() == 3);
        assertTrue(accounts.contains(account1));
        assertTrue(accounts.contains(account2));
        assertTrue(accounts.contains(account3));
    }

    /**
     * Test of userBalance method, of class App.
     */
    @Test
    public void testUserBalance() {
        System.out.println("userBalance");
        float balance1 = 200;
        float balance2 = -100;
        float balance3 = 1000;
        float delta = 0.0001F;
        App app = new App();
        User user = app.createUser("Michel", "Rambau", "24", "1 rue pileco", "12");
        Account account1 = app.createAccount("12-12-2012", balance1);
        Account account2 = app.createAccount("12-12-2012", balance2);
        Account account3 = app.createAccount("12-12-2012", balance3);
        
        app.linkAccount(account1, user);
        app.linkAccount(account2, user);
        app.linkAccount(account3, user);
        
        float balance = app.userBalance(user);
        float expected = balance1 + balance2 + balance3;
        
        assertEquals(balance, expected, delta);
    }
    
}
