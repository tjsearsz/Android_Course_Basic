package com.teddysears.BusinessLogic;

import com.teddysears.Domain.Entity;
import java.util.List;

/**
 * CommandFactory  method for the commands
 */
public class CommandFactory {

    /**
     * Method to instantiate the GetAllTasksCommand
     * @return The command formerly mentioned
     */
    public static ICommand<Entity, List<Object>> CreateNewGetAllTasksCommand()
    {
        return new GetAllTasksCommand();
    }
}
