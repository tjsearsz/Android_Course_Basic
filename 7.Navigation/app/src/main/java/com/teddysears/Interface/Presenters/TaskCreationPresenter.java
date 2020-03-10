package com.teddysears.Interface.Presenters;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.teddysears.Interface.Contracts.ITaskCreationContract;
import com.teddysears.Interface.R;
import com.teddysears.Interface.Views.Activities.Fragments.FragmentCreationTask;
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

        //We create the fragment
        Fragment taskFragment = new FragmentCreationTask();

        //If this variable exists, it means that we need the information of a specific task
        if (this.TaskCreation.GetCurrentIntent().getStringExtra("Name") != null) {

            Bundle parameters = new Bundle();

            //Getting all the values of the task
            String name = this.TaskCreation.GetCurrentIntent().getStringExtra("Name");
            String description = this.TaskCreation.GetCurrentIntent()
                                                            .getStringExtra("Description");
            Date date = (Date)this.TaskCreation.GetCurrentIntent()
                                                            .getSerializableExtra("Date");
            boolean isFinished = this.TaskCreation.GetCurrentIntent()
                                            .getBooleanExtra("Finished", false);

            parameters.putString("Name", name);
            parameters.putString("Description", description);
            parameters.putSerializable("Date", date);
            parameters.putBoolean("Finished", isFinished);

            taskFragment.setArguments(parameters);

            //Removing the values obtained
            this.TaskCreation.GetCurrentIntent().removeExtra("Name");
            this.TaskCreation.GetCurrentIntent().removeExtra("Description");
            this.TaskCreation.GetCurrentIntent().removeExtra("Date");
            this.TaskCreation.GetCurrentIntent().removeExtra("Finished");
        }

        //Transaction used to change fragments
        FragmentTransaction transaction = TaskCreation.GetTransaction().beginTransaction();
        transaction.add(R.id.CreationFrame, taskFragment);

        //Changing the fragment
        transaction.commit();
    }
}
