package com.teddysears.BusinessLogic;

import com.teddysears.Data.DAOFactory;
import com.teddysears.Data.IDao.IGeneralDao;
import com.teddysears.Domain.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Command action for listing all the favorite tasks
 */
public class GetFavoriteTasksCommand implements ICommand<Entity, List<Object>> {

    /**
     * Empty constructor
     */
    public GetFavoriteTasksCommand()
    {

    }

    /**
     * Method that executes the command
     * @param entity the parameter we need to use to execute the action
     * @return List of all the favorite tasks also with year and month
     */
    @Override
    public List<Object> execute(Entity entity) {

        IGeneralDao DAOTasks = DAOFactory.CreateFavoriteDAOTasks();

        //Getting all tasks with their dates
        Map<String, Map<String,List<Entity>>> tasks = DAOTasks.GetList();

        //variable with the response
        List<Object> response = new ArrayList<>();

        /**
         * Here we will parse the map object into a list, so we can show it in the
         * recycler view
         * We need to change this so it can be optimized, but for now we will do it as this
         */
        //Iterating through every date to transform the answer
        for (String aux : tasks.keySet()) {

            //Adding the year
            response.add(Integer.parseInt(aux));

            //Now we add the monthdate and task
            for (String aux2: tasks.get(aux).keySet())
            {
                response.add(aux2);

                for(Entity aux3 : tasks.get(aux).get(aux2))
                {
                    response.add(aux3);
                }
            }
        }

        return response;
    }
}
