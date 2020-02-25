package com.teddysears.Data;

import com.teddysears.Data.DAOs.TaskDAO;
import com.teddysears.Data.IDao.IGeneralDao;

/**
 * Factory class for all DAO Objects
 */
public class DAOFactory {

    public static IGeneralDao CreateDAOTasks(){

        return new TaskDAO();
    }
}
