package com.teddysears.Interface.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.teddysears.Interface.Contracts.ITaskCreationContract;
import com.teddysears.Interface.Presenters.TaskCreationPresenter;
import com.teddysears.Interface.R;

/**
 * Class that represents the view of the creation task activity
 */
public class task_creation extends AppCompatActivity implements ITaskCreationContract {

    //Attributes of the class
    private Intent intent;
    private Button CreateButton;
    private Button BackButton;
    private TextView TextTitle;

    /**
     * Method that gets created everytime the activity is being displayed
     * @param savedInstanceState Saved state of the instance
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_creation);

        //Setting the values
        this.intent = getIntent();
        this.BackButton = findViewById(R.id.BackButton);
        this.CreateButton = findViewById(R.id.CreateButton);
        this.TextTitle = findViewById(R.id.textView);

        //Creating presenter
        TaskCreationPresenter presenter = new TaskCreationPresenter(this);

        //Validating if we have received parameters (we are reading a task)
        presenter.ValidateParametersReceived();

    }

    @Override
    public Intent GetCurrentIntent() {
        return this.intent;
    }

    @Override
    public Button GetBackButton() {
        return this.BackButton;
    }

    @Override
    public Button GetCreateButton() {
        return this.CreateButton;
    }

    @Override
    public Context GetApplicationContext() {
        return this.GetApplicationContext();
    }

    @Override
    public TextView GetTextTitle() {
        return this.TextTitle;
    }
}

