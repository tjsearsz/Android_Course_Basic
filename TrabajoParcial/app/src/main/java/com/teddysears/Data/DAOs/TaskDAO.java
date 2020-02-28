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
                "Take sun and enjoy the calm ocean along with my friends!",
                DateUtils.StringToDate("2019/02/26 21:40"), true));
        list.add(DomainFactory.GetTask("Go to the church",
                "Moment to be near God and pray for every need I have",
                DateUtils.StringToDate("2019/05/01 22:10"), false));
        list.add(DomainFactory.GetTask("Go to the NASA",
                "I really wanted to visit NASA headquarters since I was a kid"
                , DateUtils.StringToDate("2019/10/30 09:12"), true));

        //Same Years / same months / different days / different time
        list.add(DomainFactory.GetTask("Go to singing class",
                "I really need to improve this or I will keep singing horribly",
                DateUtils.StringToDate("2020/11/11 21:40"), true));
        list.add(DomainFactory.GetTask("Eat with my wife",
                "If I don't go with her, she will kill me",
                DateUtils.StringToDate("2020/11/23 22:10"), false));

        //Same Years / same months / same days / different time
        list.add(DomainFactory.GetTask("Study for my Android class",
                "I have an important homework this date, and I cannot get a bad score",
                DateUtils.StringToDate("2021/07/23 08:37"), true));
        list.add(DomainFactory.GetTask("Go to a Job meeting",
                "We will be having an important discussion with our CEOs",
                DateUtils.StringToDate("2021/07/23 10:20"), false));
        list.add(DomainFactory.GetTask("Go to the supermarket",
                "My refrigerator is almost empty, I need to fill it again",
                DateUtils.StringToDate("2021/07/23 14:57"), true));
        list.add(DomainFactory.GetTask("Go to the concert",
                "Finally Hoobastank will be playing in my city, I cannot wait!",
                DateUtils.StringToDate("2021/07/23 20:27"), false));

        return list;
    }
}
