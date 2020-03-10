package com.teddysears.Data.DAOs;

import com.teddysears.Data.IDao.IGeneralDao;
import com.teddysears.Domain.DomainFactory;
import com.teddysears.Domain.Entity;
import com.teddysears.Domain.Task;
import com.teddysears.Utility.DateUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * DAO class to manage all the logic related to favorite tasks
 */
public class FavoriteDAO implements IGeneralDao {

    /**
     * Empty Constructor of the DAO
     */
    public FavoriteDAO()
    {

    }

    /**
     * Implementing the method for getting the favorite tasks
     * @return All the favorite tasks
     */
    @Override
    public Map<String, Map<String, List<Entity>>> GetList() {

        List<Task> list = new ArrayList<Task>();

        /**
         * HERE WE ASSUME GETTING THE INFORMATION FROM THE DATABASE
         */

        list.add(DomainFactory.GetTask("Go to the church",
                "Moment to be near God and pray for every need I have",
                DateUtils.StringToDate("2019/05/01 22:10"), false));

        //Same Years / same months / different days / different time
        list.add(DomainFactory.GetTask("Eat with my wife",
                "If I don't go with her, she will kill me",
                DateUtils.StringToDate("2020/11/23 22:10"), false));

        //Same Years / same months / same days / different time
        list.add(DomainFactory.GetTask("Study for my Android class",
                "I have an important homework this date, and I cannot get a bad score",
                DateUtils.StringToDate("2021/07/23 08:37"), true));
        list.add(DomainFactory.GetTask("Go to the concert",
                "Finally Hoobastank will be playing in my city, I cannot wait!",
                DateUtils.StringToDate("2021/07/23 20:27"), false));

        //Preparing information in a tree set
        Map<String, Map<String, List<Entity>>> response = new TreeMap<>();

        //Iterating through every element obtained in "database"
        for (Task aux : list)
        {
            //We need to look that exists task within that year
            Map<String, List<Entity>> value = response.get(DateUtils.YearDateToString(aux.getDate()));

            List listaux;

            //If value is null it means it doesn't exist a task for this year yet
            if(value == null){
                value = new TreeMap<>();
                listaux = new ArrayList<Entity>();


            }
            else
            {
                listaux = value.get(DateUtils.MonthDayDateToString(aux.getDate()));

                if(listaux == null)
                    listaux = new ArrayList<Entity>();

            }

            listaux.add(aux);

            value.put(DateUtils.MonthDayDateToString(aux.getDate()), listaux);

            //Updating the response
            response.put((DateUtils.YearDateToString(aux.getDate())), value);
        }

        return response;
    }
}
