package com.teddysears.Interface.Presenters;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.teddysears.BusinessLogic.CommandFactory;
import com.teddysears.BusinessLogic.ICommand;
import com.teddysears.Domain.Entity;
import com.teddysears.Interface.Adapters.MainActivityAdapter;
import com.teddysears.Interface.Contracts.IMainActivityContract;

import java.util.List;

/**
 * Presenter of the Main Activity View
 */
public class MainActivityPresenter {

    //Attributes of the class
    private IMainActivityContract activity;

    /**
     * Constructor that receives the activity in charge of controlling
     * @param activity The main activity class
     */
    public MainActivityPresenter(IMainActivityContract activity)
    {
        this.activity = activity;
    }

    /**
     * Method that gets all the available tasks
     */
    public void ListAllTasks()
    {
        //Performing the action
        ICommand<Entity, List<Entity>> command = CommandFactory.CreateNewGetAllTasksCommand();
        List<Entity> tasks = command.execute(null);

        MainActivityAdapter adapter = new MainActivityAdapter(tasks);

        activity.GetRecyclerView().setAdapter(adapter);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(activity.GetCurrentContext());

        activity.GetRecyclerView().setLayoutManager(manager);
    }
}
