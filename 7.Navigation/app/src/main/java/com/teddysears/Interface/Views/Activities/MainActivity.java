package com.teddysears.Interface.Views.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.teddysears.Interface.Contracts.IMainActivityContract;
import com.teddysears.Interface.Presenters.MainActivityPresenter;
import com.teddysears.Interface.R;

/**
 * Class that represents the View of the MainActivity
 */
public class MainActivity extends AppCompatActivity implements IMainActivityContract, BottomNavigationView.OnNavigationItemSelectedListener {

    //Attributes of the class
    private FloatingActionButton floatingButton;
    private Toolbar mainToolbar;
    private ViewPager viewPager;
    private FragmentManager fragmentManager;
    private BottomNavigationView navigationView;

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

        //Finding the navigation view
        this.navigationView = findViewById(R.id.bn_main);

        //Method to switch between fragments
        this.navigationView.setOnNavigationItemSelectedListener(this);

        this.navigationView.getMenu().add(Menu.NONE, 1,
                Menu.NONE , "Tareas").setIcon(R.drawable.ic_list_white_24dp);

        this.navigationView.getMenu().add(Menu.NONE, 2,
                Menu.NONE , "Favoritos").setIcon(R.drawable.ic_star_white_24dp);


        //This methods triggers when the view Pager changes (fragment moves)
        this.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                //Here we change the icon
                switch (position)
                {
                    case 0:
                        navigationView.getMenu().findItem(1).setChecked(true);
                        break;

                    case 1:
                        navigationView.getMenu().findItem(2).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

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

    @Override
    public BottomNavigationView GetNavigationView() {
        return this.navigationView;
    }


    /**
     * Method to switch between fragments when we select an option in the bottom navigation
     * @param menuItem the menu item we are selection
     * @return true if the method succeeded
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        /**
         * depending in the id of the element we will switch between items
         */
        switch (menuItem.getItemId())
        {
            //First ID means first item and so on
            case 1:

                //Switching to the first element
                this.viewPager.setCurrentItem(0);
                break;

            case 2:

                //Switching to the first element
                this.viewPager.setCurrentItem(1);
                break;
        }

        return true;
    }
}
