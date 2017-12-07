/*
 *  You are free to do what you want with this code 
 *  as long as you offer me a drink ;)
 */
package com.skydream.neolynk.javatechnicaltest.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.jar.Attributes;

/**
 * 
 * @author SkyDream
 */
public abstract class Entity {
    
    protected int id = -1;
    protected Map<String,Object> attributes;
    
    protected Entity () {
        this.id = -1;
        attributes = new HashMap<>();
    }
    
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public <T> T getAttribute(EntityAN<T> attributeName) {
        return (T)this.attributes.get(attributeName.toString());
    }
    public <T> void setAttribute(EntityAN<T> attributeName, T value) {
        this.attributes.put(attributeName.toString(), value);
    }
    
    @Override
    public boolean equals (Object object) {
        Entity entity;
        // If the object is an entity
        if (object instanceof Entity) {
            entity = (Entity)object;
        } else {
            return false;
        }
        // If both entity attributes have the same size
        if (this.attributes.size() != entity.attributes.size()) {
            return false;
        }
        // And both entity attributes have matching entry
        for (Map.Entry entry : this.attributes.entrySet()) {
            if (entity.attributes.containsKey(entry.getKey()) &&
                    entity.attributes.get(entry.getKey()).equals(entry.getValue()))
                continue;
            return false;
        }
        // Then both entity are equals
        return true;
    }
    
    public static class EntityAN<T> extends Attributes.Name {
        public EntityAN(String name) {
            super(name);
        }
    }
}
