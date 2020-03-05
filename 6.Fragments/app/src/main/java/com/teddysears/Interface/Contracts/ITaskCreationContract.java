package com.teddysears.Interface.Contracts;

import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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
     * Get the Application context
     * @return The application context
     */
    Context GetApplicationContext();

    /**
     * Get the Frame layout where the task information will be
     */
    FrameLayout GetTaskLayout();

    /**
     * Getter for the manager used to change fragments
     * @return the transaction used to change fragments
     */
    FragmentManager GetTransaction();

}
