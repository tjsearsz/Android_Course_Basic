package com.teddysears.Data.IDao;

import com.teddysears.Domain.Entity;

import java.util.List;

/**
 * Interface that contains all the contracts for the DAO implementations
 */
public interface IGeneralDao {

    //Method sign that brings all the tasks
    List<Entity> GetList();
}
