package com.teddysears.Interface.Contracts;

import android.content.Context;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * Contract of the Main Activity of the project
 */
public interface IMainActivityContract {

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

    /**
     * Method for getting the view Pager where well place the RecyclerView
     * @return the ViewPager component
     */
    ViewPager GetViewPager();

    /**
     * Method for getting the fragment manager
     * @return The Fragment Manager
     */
    FragmentManager GetSupportFragmentManager();
}
