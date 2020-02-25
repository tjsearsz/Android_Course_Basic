package com.teddysears.Domain;

/**
 * Mother class that represents the entity for all the classes in the project
 */
public class Entity {

    //Attribute of the class
    private int id;

    /**
     * Empty constructor of the class
     */
    public Entity()
    {

    }

    /**
     * Constructor that receives the ID of the entity
     * @param id The id of the entitty
     */
    public Entity(int id)
    {
        this.id = id;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
