package com.teddysears.Interface.Presenters;

import android.view.View;

import com.teddysears.Interface.Contracts.ITaskCreationContract;

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

            this.TaskCreation.GetCreateButton().setVisibility(View.GONE);

            this.TaskCreation.GetCurrentIntent().removeExtra("Title");

        }
    }
}
