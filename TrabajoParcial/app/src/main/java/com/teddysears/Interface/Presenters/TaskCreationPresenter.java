package com.teddysears.Interface.Presenters;

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
     * Method that validates if there are parameters being received
     * if this is true, we need to hide the creation and back button
     */
    public void ValidateParametersReceived()
    {

    }
}
