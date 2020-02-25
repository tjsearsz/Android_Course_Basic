package com.teddysears.Domain;

import java.util.Date;

/**
 * Factory class for all the classes in the domain layer
 */
public class DomainFactory {

    /**
     * Static method for getting a new task
     * @param title The title of the task
     * @param description The description of the class
     * @param date The date of this task
     * @return A new Task
     */
    public static Task GetTask(String title, String description, Date date)
    {
        return new Task(title, description, date);
    }
}
