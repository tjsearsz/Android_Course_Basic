package com.teddysears.Data;

import com.teddysears.Data.DAOs.FavoriteDAO;
import com.teddysears.Data.DAOs.TaskDAO;
import com.teddysears.Data.IDao.IGeneralDao;

/**
 * Factory class for all DAO Objects
 */
public class DAOFactory {

    /**
     * Static method for instantiating a DAO responsible of getting all the tasks
     * @return DAO of tasks
     */
    public static IGeneralDao CreateDAOTasks(){

        return new TaskDAO();
    }

    /**
     * Static method for instantiating a DAO responsible for getting all the favorite tasks
     * @return
     */
    public static IGeneralDao CreateFavoriteDAOTasks()
    {
        return new FavoriteDAO();
    }
}
