package com.teddysears.Interface.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.teddysears.Interface.Contracts.ITaskCreationContract;
import com.teddysears.Interface.Presenters.TaskCreationPresenter;
import com.teddysears.Interface.R;

/**
 * Class that represents the view of the creation task activity
 */
public class task_creation extends AppCompatActivity implements ITaskCreationContract {

    //Attributes of the class
    private FrameLayout taskLayout;
    private FragmentManager transaction;

    /**
     * Method that gets created every time the activity is being displayed
     * @param savedInstanceState Saved state of the instance
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_creation);

        //Setting the values
        this.taskLayout = findViewById(R.id.CreationFrame);
        this.transaction = getSupportFragmentManager();

        //Creating presenter
        TaskCreationPresenter presenter = new TaskCreationPresenter(this);

        //Validating if we have received parameters (we are reading a task)
        presenter.ValidateParametersReceived();

    }

    @Override
    public Intent GetCurrentIntent() {
        return getIntent();
    }

    @Override
    public Context GetApplicationContext() {
        return this.GetApplicationContext();
    }

    @Override
    public FrameLayout GetTaskLayout() {
        return this.taskLayout;
    }

    @Override
    public FragmentManager GetTransaction() {
        return this.transaction;
    }
}

