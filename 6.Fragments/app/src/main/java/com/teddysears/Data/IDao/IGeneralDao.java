package com.teddysears.Data.IDao;

import com.teddysears.Domain.Entity;

import java.util.List;
import java.util.Map;

/**
 * Interface that contains all the contracts for the DAO implementations
 */
public interface IGeneralDao {

    /**
     * Method sign that gets all the tasks available
     * @return List of tasks
     */
    Map<String, Map<String,List<Entity>>> GetList();
}
