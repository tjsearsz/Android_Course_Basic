package com.teddysears.Interface.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.teddysears.Interface.Contracts.IMainActivityContract;
import com.teddysears.Interface.Presenters.MainActivityPresenter;
import com.teddysears.Interface.R;

/**
 * Class that represents the View of the MainActivity
 */
public class MainActivity extends AppCompatActivity implements IMainActivityContract {

    //Attributes of the class
    private FloatingActionButton floatingButton;
    private Toolbar mainToolbar;
    private ViewPager viewPager;
    private FragmentManager fragmentManager;

    /**
     * Method to be performed when the view is being created
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asigning the values of the Views
        this.floatingButton = findViewById(R.id.TaskCreationButton);
        this.mainToolbar = findViewById(R.id.main_toolbar);
        this.viewPager = findViewById(R.id.vp_main);
        this.fragmentManager = getSupportFragmentManager();

        //Adding toolbar in the activity
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle(R.string.ToolbarTitle);

        //Passing this view to the presenter
        MainActivityPresenter presenter = new MainActivityPresenter(this);
    }

    @Override
    public Context GetCurrentContext() {
        return this.getApplicationContext();
    }

    @Override
    public FloatingActionButton GetFloatingButton() {
        return this.floatingButton;
    }

    @Override
    public Toolbar GetMainToolbar() {
        return this.mainToolbar;
    }

    @Override
    public ViewPager GetViewPager() {
        return this.viewPager;
    }

    @Override
    public FragmentManager GetSupportFragmentManager() {
        return this.fragmentManager;
    }


}
