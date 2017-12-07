/*
 *  You are free to do what you want with this code 
 *  as long as you offer me a drink ;)
 */
package com.skydream.neolynk.javatechnicaltest.managers;

import com.skydream.neolynk.javatechnicaltest.entities.Entity;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SkyDream
 */
public class EntityManagerTest {
    
    public EntityManagerTest() {
    }

    /**
     * Test of register method, of class EntityManager.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        EntityManager entityManager = new EntityManagerImpl();
        Entity entity = new EntityImpl();
        entity.setId(0);
        int id = entityManager.register(entity);
        assertFalse(id == 0);
    }

    /**
     * Test of get method, of class EntityManager.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        EntityManager entityManager = new EntityManagerImpl();
        Entity entity = new EntityImpl();
        entityManager.register(entity);
        
        int entityId = entity.getId();
        int expResult = entityId;
        int result = entityManager.get(entityId).getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class EntityManager.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        EntityManager entityManager = new EntityManagerImpl();
        Entity entity = new EntityImpl();
        Entity.EntityAN<String> testAttr1 = new Entity.EntityAN("test1");
        
        int id = entityManager.register(entity);
        entity.setAttribute(testAttr1, "value");
        entityManager.update(entity);
        Entity entity2 = entityManager.get(id);
        assertTrue(entity2.getAttribute(testAttr1).equals("value"));
    }

    /**
     * Test of delete method, of class EntityManager.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        EntityManager entityManager = new EntityManagerImpl();
        Entity entity = new EntityImpl();
        int id = entityManager.register(entity);
        assertTrue(entityManager.get(id) != null);
        entityManager.delete(entity);
        assertTrue(entityManager.get(id) == null);
    }

    public class EntityManagerImpl extends EntityManager {
    }
    public class EntityImpl extends Entity {
    }
    
}
