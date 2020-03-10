package com.teddysears.Interface.Presenters;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.teddysears.Interface.Adapters.ViewPagerAdapter;
import com.teddysears.Interface.Contracts.IMainActivityContract;
import com.teddysears.Interface.Views.Activities.Fragments.ListFragment;
import com.teddysears.Interface.Views.Activities.task_creation;

/**
 * Presenter of the Main Activity View
 */
public class MainActivityPresenter {

    //Attributes of the class
    private IMainActivityContract activity;

    /**
     * Constructor that receives the activity in charge of controlling
     * @param activity The main activity class
     */
    public MainActivityPresenter(IMainActivityContract activity)
    {
        this.activity = activity;

        //Preparing floating button with the intent action
        PrepareTaskCreationButton();

        //Preparing Fragments
        PrepareViewPager();
    }

    /**
     * Method to initialize the view pager with fragments
     */
    private void PrepareViewPager() {

        //Creating the adapter for the viewPager
        ViewPagerAdapter adapter = new ViewPagerAdapter(this.activity.GetSupportFragmentManager());

        //Creating the fragment that will have the favorite list
        ListFragment list = new ListFragment();

        Bundle bundle = new Bundle();

        bundle.putBoolean("FAVORITE", true);

        list.setArguments(bundle);

        //Adding elements in the list
        adapter.addFragment(new ListFragment(), "Task List");
        adapter.addFragment(list, "Favorites");

        //Setting the adapter
        this.activity.GetViewPager().setAdapter(adapter);
    }

    /**
     * Method to call the creation activity
     */
    private void PrepareTaskCreationButton()
    {
        this.activity.GetFloatingButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity.GetCurrentContext(), task_creation.class);
                activity.GetCurrentContext().startActivity(intent);
            }
        });
    }
}
