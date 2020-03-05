package com.teddysears.Interface.Contracts;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public interface IFragmentCreationContract {

    /**
     * Get the TextView of the title
     * @return Title's TextView
     */
    TextView GetTextTitle();

    /**
     * Get the4 Name of the task
     * @return EditText with the name of the task
     */
    EditText GetTaskName();

    /**
     * Get the description of the task
     * @return EditText with the description of the task
     */
    EditText GetTaskDescription();

    /**
     * Get the Date of the task
     * @return EditText with the date of the task
     */
    EditText GetTaskDate();

    /**
     * Get the Completed CheckBox for the creation task button
     * @return Completed CheckBox
     */
    CheckBox GetCompletedCheckBox();

    /**
     * Get the Create Button
     * @return Create button of the activity
     */
    Button GetCreateButton();
}
