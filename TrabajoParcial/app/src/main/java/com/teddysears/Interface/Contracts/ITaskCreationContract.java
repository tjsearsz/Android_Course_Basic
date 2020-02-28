package com.teddysears.Interface.Contracts;

import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

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
     * Get the Back button
     * @return Back button of the activity
     */
    Button GetBackButton();

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
}
