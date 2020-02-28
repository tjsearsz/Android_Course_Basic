package com.teddysears.Interface.Contracts;

import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

/**
 * Contract of the task_creation view
 */
public interface ITaskCreationContract {

    /**
     * The current intent we are
     * @return The current intent we are manipulationg
     */
    Intent GetCurrentIntent();

    /**
     * Get the Create Button
     * @return Create button of the activity
     */
    Button GetCreateButton();

    /**
     * Get the Application context
     * @return The application context
     */
    Context GetApplicationContext();

    /**
     * Get the TextView of the title
     * @return Title's TextView
     */
    TextView GetTextTitle();

    /**
     * Get the Completed CheckBox for the creation task button
     * @return Completed CheckBox
     */
    CheckBox GetCompletedCheckBox();
}
