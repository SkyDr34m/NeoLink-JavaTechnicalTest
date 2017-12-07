/*
 *  You are free to do what you want with this code 
 *  as long as you offer me a drink ;)
 */
package com.skydream.neolynk.javatechnicaltest.managers;

import com.skydream.neolynk.javatechnicaltest.entities.Entity;
import java.util.HashMap;
import java.util.Map;

/**
 * Generic data access abstration layer
 * Application should use a Manager class to load and save Entities
 * @author SkyDream
 * @param <T>
 */
public abstract class EntityManager<T extends Entity> {
    
    private int nextId;
    
    private Map<Integer, T> entities;
    
    protected EntityManager () {
        this.nextId = 1;
        entities = new HashMap<>();
    }
    
    /**
     * Generate a new Entity ID (value > 0)
     * @return 
     */
    private int getNewId() {
        return nextId++;
    }
    
    /**
     * Register an entity giving it a new valid id
     * @param entity
     * @return the new id
     */
    public int register(T entity) {
        int newId = getNewId();
        entity.setId(newId);
        entities.put(newId, entity);
        return newId;
    }
    
    /**
     * Retrieve and return an entity with the entity id
     * @param entityId
     * @return 
     */
    public T get(int entityId) {
        return entities.get(Integer.valueOf(entityId));
    }
    
    /**
     * Update an entity
     * @param entity 
     */
    public T update(T entity) {
        if (entities.containsKey(entity.getId())) {
            entities.put(entity.getId(), entity);
            return entity;
        }
        return null;
    }
    
    /**
     * Delete an entity
     * @param entity 
     */
    public T delete(T entity) {
        boolean success = entities.remove(entity.getId(), entity);
        if (success)
            return entity;
        return null;
    }
    
}
