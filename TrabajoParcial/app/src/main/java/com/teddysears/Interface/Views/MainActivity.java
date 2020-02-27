package com.teddysears.Interface.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.teddysears.Interface.Contracts.IMainActivityContract;
import com.teddysears.Interface.Presenters.MainActivityPresenter;
import com.teddysears.Interface.R;

/**
 * Class that represents the View of the MainActivity
 */
public class MainActivity extends AppCompatActivity implements IMainActivityContract {

    //Attributes of the class
    private RecyclerView taskslist;
    private FloatingActionButton floatingButton;

    /**
     * Method to be performed when the view is being created
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asigning the values of the Views
        this.taskslist = findViewById(R.id.rv_main);
        this.floatingButton = findViewById(R.id.TaskCreationButton);

        PrepareTaskCreationButton();

        //Passing this view to the presenter
        MainActivityPresenter presenter = new MainActivityPresenter(this);

        //Getting all the tasks
        presenter.ListAllTasks();
    }

    @Override
    public RecyclerView GetRecyclerView() {
        return taskslist;
    }

    @Override
    public Context GetCurrentContext() {
        return this.getApplicationContext();
    }

    @Override
    public FloatingActionButton GetFloatingButton() {
        return this.floatingButton;
    }

    /**
     * Method to call the other activity
     */
    private void PrepareTaskCreationButton()
    {
        this.floatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), task_creation.class);
                getApplicationContext().startActivity(intent);
            }
        });
    }
}
