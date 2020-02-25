package com.teddysears.Domain;

import java.util.Date;

/**
 * POJO class of a task
 */
public class Task extends Entity {

    //Attributes of the class
    private String title;
    private String description;
    private Date date;

    /**
     * Constructor of the class that receives all the information of a task
     * @param title The title of the task
     * @param description The description of the class
     * @param date Date when this task needs to be done
     */
    public Task(String title, String description, Date date)
    {
        super();
        this.title = title;
        this.description = description;
        this.date = date;
    }
}
