package com.teddysears.Interface.Presenters;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.teddysears.Interface.Contracts.ITaskCreationContract;
import com.teddysears.Interface.R;
import com.teddysears.Interface.Views.MainActivity;

/**
 * Presenter class of the Task Creation View
 */
public class TaskCreationPresenter {

    //Attributes of the presenter
    ITaskCreationContract TaskCreation;

    /**
     * Constructor that receives the view of this presenter
     * @param taskCreation Task creation view
     */
    public TaskCreationPresenter(ITaskCreationContract taskCreation)
    {
        this.TaskCreation = taskCreation;
    }

    /**
     * Method that validates if there are any parameters being received
     * if this is true, we need to hide the creation button and display that information
     */
    public void ValidateParametersReceived()
    {
        if (this.TaskCreation.GetCurrentIntent().getStringExtra("Title") != null) {
            String title = this.TaskCreation.GetCurrentIntent().getStringExtra("Title");

            this.TaskCreation.GetTextTitle().setText(title);
        }

        this.TaskCreation.GetCurrentIntent().removeExtra("Title");

        Button backButton = TaskCreation.GetBackButton();
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TaskCreation.GetApplicationContext(), MainActivity.class);
                TaskCreation.GetApplicationContext().startActivity(intent);
            }
        });
    }
}
