package com.teddysears.Interface.Views.Activities.Fragments;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teddysears.BusinessLogic.CommandFactory;
import com.teddysears.BusinessLogic.ICommand;
import com.teddysears.Domain.Entity;
import com.teddysears.Interface.Adapters.MainActivityAdapter;
import com.teddysears.Interface.R;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    //Attributes of the class
    private RecyclerView taskslist;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_list, container, false);
        this.taskslist = root.findViewById(R.id.rv_main);

        //If this variable is not empty, it means we will list only the favorites
        if(getArguments()== null)
            ListAllTasks();
        else
        {
            ListFavoriteTasks();
            getArguments().clear();
        }

        return root;
    }

    private void ListFavoriteTasks() {

        //Performing the action
        ICommand<Entity, List<Object>> command = CommandFactory.CreateNewGetFavoriteTasksCommand();
        List<Object> tasks = command.execute(null);

        //Creating an adapter for the ReyclerView
        MainActivityAdapter adapter = new MainActivityAdapter(tasks);

        this.taskslist.setHasFixedSize(true);

        //Setting the adapter
        this.taskslist.setAdapter(adapter);

        //Creating a new Linear Layout for the list
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        this.taskslist.setLayoutManager(manager);
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

        this.taskslist.setHasFixedSize(true);

        //Setting the adapter
        this.taskslist.setAdapter(adapter);

        //Creating a new Linear Layout for the list
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        this.taskslist.setLayoutManager(manager);
    }

}
