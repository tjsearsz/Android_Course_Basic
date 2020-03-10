package com.teddysears.Interface.Presenters;

import android.content.Intent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.teddysears.BusinessLogic.CommandFactory;
import com.teddysears.BusinessLogic.ICommand;
import com.teddysears.Domain.Entity;
import com.teddysears.Interface.Adapters.MainActivityAdapter;
import com.teddysears.Interface.Contracts.IMainActivityContract;
import com.teddysears.Interface.Views.Activities.task_creation;
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

        //Preparing floating button with the intent action
        PrepareTaskCreationButton();


    }



    /**
     * Method that gets all the available tasks
     */
    public void ListAllTasks()
    {
        //Performing the action
        ICommand<Entity, List<Object>> command = CommandFactory.CreateNewGetAllTasksCommand();

        List<Object> tasks = command.execute(null);

        //Creating an adapter for the ReyclerView
        MainActivityAdapter adapter = new MainActivityAdapter(tasks);

        activity.GetRecyclerView().setHasFixedSize(true);

        //Setting the adapter
        activity.GetRecyclerView().setAdapter(adapter);

        //Creating a new Linear Layout for the list
        RecyclerView.LayoutManager manager = new LinearLayoutManager(activity.GetCurrentContext());
        activity.GetRecyclerView().setLayoutManager(manager);
    }

    /**
     * Method to call the creation activity
     */
    private void PrepareTaskCreationButton()
    {
        this.activity.GetFloatingButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity.GetCurrentContext(), task_creation.class);
                activity.GetCurrentContext().startActivity(intent);
            }
        });
    }
}
