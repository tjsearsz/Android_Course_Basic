package com.teddysears.Interface.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.teddysears.Interface.Contracts.ITaskCreationContract;
import com.teddysears.Interface.Presenters.TaskCreationPresenter;
import com.teddysears.Interface.R;

/**
 * Class that represents the view of the creation task activity
 */
public class task_creation extends AppCompatActivity implements ITaskCreationContract {

    //Attributes of the class
    private TextView TextTitle;
    private EditText TaskName;
    private EditText TaskDescription;
    private EditText TaskDate;
    private Button CreateButton;
    private CheckBox CompletedCheckBox;

    /**
     * Method that gets created every time the activity is being displayed
     * @param savedInstanceState Saved state of the instance
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_creation);

        //Setting the values
        this.TextTitle = findViewById(R.id.TaskTitle);
        this.TaskName = findViewById(R.id.TaskName);
        this.TaskDescription = findViewById(R.id.TaskDescription);
        this.TaskDate = findViewById(R.id.TaskDate);
        this.CreateButton = findViewById(R.id.CreateButton);
        this.CompletedCheckBox = findViewById(R.id.CompletedCheckBox);

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
    public TextView GetTextTitle() {
        return this.TextTitle;
    }

    @Override
    public EditText GetTaskName() {
        return this.TaskName;
    }

    @Override
    public EditText GetTaskDescription() {
        return this.TaskDescription;
    }

    @Override
    public EditText GetTaskDate() {
        return this.TaskDate;
    }

    @Override
    public CheckBox GetCompletedCheckBox() {
        return this.CompletedCheckBox;
    }

    @Override
    public Button GetCreateButton() {
        return this.CreateButton;
    }
}

