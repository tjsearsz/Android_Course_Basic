package com.teddysears.Interface.Presenters;

import android.view.View;
import com.teddysears.Interface.Contracts.ITaskCreationContract;
import com.teddysears.Interface.R;
import com.teddysears.Utility.DateUtils;
import java.util.Date;

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
        //If this variable exists, it means that we need the information of a specific task
        if (this.TaskCreation.GetCurrentIntent().getStringExtra("Name") != null) {

            //Getting all the values of the task
            String name = this.TaskCreation.GetCurrentIntent().getStringExtra("Name");
            String description = this.TaskCreation.GetCurrentIntent()
                                                            .getStringExtra("Description");
            Date date = (Date)this.TaskCreation.GetCurrentIntent()
                                                            .getSerializableExtra("Date");
            boolean isFinished = this.TaskCreation.GetCurrentIntent()
                                            .getBooleanExtra("Finished", false);

            //Filling the information obtained
            this.TaskCreation.GetTextTitle().setText(R.string.TASK_SUMMARY);
            this.TaskCreation.GetTaskName().setText(name);
            this.TaskCreation.GetTaskName().setKeyListener(null);
            this.TaskCreation.GetTaskDescription().setText(description);
            this.TaskCreation.GetTaskDescription().setKeyListener(null);
            this.TaskCreation.GetTaskDate().setText(DateUtils.DateToString(date));
            this.TaskCreation.GetTaskDate().setKeyListener(null);
            this.TaskCreation.GetCompletedCheckBox().setChecked(isFinished);
            this.TaskCreation.GetCompletedCheckBox().setKeyListener(null);

            //Hiding the create button since we are not creating a new one
            this.TaskCreation.GetCreateButton().setVisibility(View.GONE);

            //Removing the values obtained
            this.TaskCreation.GetCurrentIntent().removeExtra("Name");
            this.TaskCreation.GetCurrentIntent().removeExtra("Description");
            this.TaskCreation.GetCurrentIntent().removeExtra("Date");
            this.TaskCreation.GetCurrentIntent().removeExtra("Finished");
        }
    }
}
