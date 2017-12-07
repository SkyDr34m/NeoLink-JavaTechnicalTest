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
public class EntityTest {
    
    public EntityTest() {
    }

    /**
     * Test of getId method, of class Entity.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Entity instance = new EntityImpl();
        instance.setId(0);
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Entity.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Entity instance = new EntityImpl();
        instance.setId(10);
        int expResult = 10;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAttribute method, of class Entity.
     */
    @Test
    public void testGetAttribute() {
        System.out.println("getAttribute");
        String attributeName = "TestName";
        Entity.EntityAN<String> testAttr = new Entity.EntityAN(attributeName);
        String attributeValue = "TestValue";
        Entity instance = new EntityImpl();
        
        instance.setAttribute(testAttr, attributeValue);
        String expResult = "TestValue";
        String result = instance.getAttribute(testAttr);
        assertEquals(expResult, result);
    }

    /**
     * Test of setAttribute method, of class Entity.
     */
    @Test
    public void testSetAttribute() {
        System.out.println("setAttribute");
        String attributeName = "TestName";
        Entity.EntityAN<String> testAttr = new Entity.EntityAN(attributeName);
        String attributeValue = "TestValue";
        String attributeValue2 = "TestValue2";
        Entity instance = new EntityImpl();
        instance.setAttribute(testAttr, attributeValue);
        instance.setAttribute(testAttr, attributeValue2);
        String expResult = "TestValue2";
        String result = instance.getAttribute(testAttr);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Entity.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        
        Entity entity = new EntityImpl();
        Entity.EntityAN<String> testAttr1 = new Entity.EntityAN("test1");
        Entity.EntityAN<String> testAttr2 = new Entity.EntityAN("test2");
        Entity.EntityAN<String> testAttr3 = new Entity.EntityAN("test3");
        
        entity.setAttribute(testAttr1, "42");
        entity.setAttribute(testAttr2, "43");
        entity.setAttribute(testAttr3, "44");
        
        Entity entity2 = new EntityImpl();
        entity2.setAttribute(testAttr1, "42");
        entity2.setAttribute(testAttr2, "43");
        entity2.setAttribute(testAttr3, "44");
        
        boolean expResult = true;
        boolean result = entity.equals(entity2);
        assertEquals(expResult, result);
        
        Entity entity3 = new EntityImpl();
        entity3.setAttribute(testAttr1, "42");
        entity3.setAttribute(testAttr2, "43");
        
        boolean expResult2 = false;
        boolean result2 = entity.equals(entity3);
        assertEquals(expResult2, result2);
    }

    public class EntityImpl extends Entity {
    }
    
}
