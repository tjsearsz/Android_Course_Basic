package com.teddysears.BusinessLogic;

import com.teddysears.Domain.Entity;

import java.util.List;

/**
 * Command action for listing all the available tasks
 */
public class GetAllTasksCommand implements ICommand<Entity, List<Entity>> {

    /**
     * Empty constructor of the class
     */
    public GetAllTasksCommand(){}

    /**
     * Method that executes the command
     * @param parameter the parameter we need to use to execute the action
     * @return
     */
    @Override
    public List<Entity> execute(Entity parameter) {
        return null;
    }
}
