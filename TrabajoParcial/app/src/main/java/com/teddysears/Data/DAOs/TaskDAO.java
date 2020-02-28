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

        //Same years / different months / different days / different time
        list.add(DomainFactory.GetTask("Go to the beach",
                "relaxing task", DateUtils.StringToDate("2019/02/26 21:40"), true));
        list.add(DomainFactory.GetTask("go to the church",
                "relaxing task", DateUtils.StringToDate("2019/05/01 22:10"), false));
        list.add(DomainFactory.GetTask("Go to the nasa",
                "relaxing task", DateUtils.StringToDate("2019/10/30 09:12"), true));

        //Same Years / same months / different days / different time
        list.add(DomainFactory.GetTask("Sing",
                "relaxing task", DateUtils.StringToDate("2020/11/11 21:40"), true));
        list.add(DomainFactory.GetTask("go to the church",
                "relaxing task", DateUtils.StringToDate("2020/11/23 22:10"), false));

        //Same Years / same months / same days / different time
        list.add(DomainFactory.GetTask("Sing",
                "relaxing task", DateUtils.StringToDate("2021/07/23 08:37"), true));
        list.add(DomainFactory.GetTask("go to the church",
                "relaxing task", DateUtils.StringToDate("2021/07/23 10:20"), false));
        list.add(DomainFactory.GetTask("Sing",
                "relaxing task", DateUtils.StringToDate("2021/07/23 14:57"), true));
        list.add(DomainFactory.GetTask("go to the church",
                "relaxing task", DateUtils.StringToDate("2021/07/23 20:27"), false));

        return list;
    }
}
