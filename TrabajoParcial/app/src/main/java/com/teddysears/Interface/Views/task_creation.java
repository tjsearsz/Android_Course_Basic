package com.teddysears.Interface.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.teddysears.Interface.Contracts.ITaskCreationContract;
import com.teddysears.Interface.Presenters.TaskCreationPresenter;
import com.teddysears.Interface.R;

/**
 * Class that represents the view of the creation task activity
 */
public class task_creation extends AppCompatActivity implements ITaskCreationContract {

    /**
     * Method that gets created everytime the activity is being displayed
     * @param savedInstanceState Saved state of the instance
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_creation);

        PrepareTaskCreationButton();

        //Creating presenter
        TaskCreationPresenter presenter = new TaskCreationPresenter(this);

        //Validating if we have received parameters (we are reading a task)
        presenter.ValidateParametersReceived();

    }

    /**
     * Method to call the other activity
     */
    private void PrepareTaskCreationButton()
    {
        Button backButton = findViewById(R.id.BackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                getApplicationContext().startActivity(intent);
            }
        });
    }
}

