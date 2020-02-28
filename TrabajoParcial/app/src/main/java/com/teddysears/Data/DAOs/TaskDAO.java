package com.teddysears.Data.DAOs;

import com.teddysears.Data.IDao.IGeneralDao;
import com.teddysears.Domain.DomainFactory;
import com.teddysears.Domain.Entity;
import com.teddysears.Utility.DateUtils;

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
                "relaxing task", DateUtils.StringToDate("26/02/2020 21:40"), true));

        list.add(DomainFactory.GetTask("go to the church",
                "relaxing task", DateUtils.StringToDate("26/02/2020 22:10"), false));

        list.add(DomainFactory.GetTask("Go to the nasa",
                "relaxing task", DateUtils.StringToDate("26/02/2020 09:12"), true));

        return list;
    }
}
