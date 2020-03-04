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
     * @param alreadyFinished flag to determinate whether this task has been finished or not
     * @return A new Task
     */
    public static Task GetTask(String title, String description, Date date, boolean alreadyFinished)
    {
        return new Task(title, description, date, alreadyFinished);
    }
}
