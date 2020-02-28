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
    private boolean alreadyFinished;

    /**
     * Constructor of the class that receives all the information of a task
     * @param title The title of the task
     * @param description The description of the class
     * @param date Date when this task needs to be done
     * @param alreadyFinished Flag to indicate whether this task has been finished
     */
    public Task(String title, String description, Date date, boolean alreadyFinished)
    {
        super();
        this.title = title;
        this.description = description;
        this.date = date;
        this.alreadyFinished = alreadyFinished;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isAlreadyFinished() {
        return alreadyFinished;
    }

    public void setAlreadyFinished(boolean alreadyFinished) {
        this.alreadyFinished = alreadyFinished;
    }
}
