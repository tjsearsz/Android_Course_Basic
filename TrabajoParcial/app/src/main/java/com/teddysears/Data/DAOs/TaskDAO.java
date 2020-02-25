package com.teddysears.Data.DAOs;

import com.teddysears.Data.IDao.IGeneralDao;
import com.teddysears.Data.Utils;
import com.teddysears.Domain.DomainFactory;
import com.teddysears.Domain.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO class to manage all the logic related to tasks
 */
public class TaskDAO implements IGeneralDao {

    /**
     * Empty Constructor of the DAO
     */
    public TaskDAO()
    {

    }
    /**
     * Implementing the method for getting all the tasks
     * @return All the tasks
     */
    @Override
    public List<Entity> GetList() {
        List<Entity> list = new ArrayList<Entity>();

        list.add(DomainFactory.GetTask("Go to the beach",
                "relaxing task", Utils.GetNewDateBasedOnString("26/02/2020")));

        return list;
    }
}
