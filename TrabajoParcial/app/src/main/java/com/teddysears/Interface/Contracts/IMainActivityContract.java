package com.teddysears.Interface.Contracts;

import android.content.Context;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * Contract of the Main Activity of the project
 */
public interface IMainActivityContract {

    /**
     * Method sign for getting the recycler view
     * @return The recycler view of the menu
     */
    RecyclerView GetRecyclerView();

    /**
     * Method for getting the current (application) context
     * @return The application context
     */
    Context GetCurrentContext();

    /**
     * Method for getting the floating button
     * @return The floatting button
     */
    FloatingActionButton GetFloatingButton();

    /**
     * Method for getting the main toolbar
     * @return The main toolbar of the app
     */
    Toolbar GetMainToolbar();
}
