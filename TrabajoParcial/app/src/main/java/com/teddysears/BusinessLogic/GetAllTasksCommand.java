package com.teddysears.BusinessLogic;

import com.teddysears.Domain.Entity;

import java.util.List;

public class GetAllTasksCommand implements ICommand<Entity, List<Entity>> {


    @Override
    public List<Entity> execute(Entity parameter) {
        return null;
    }
}
