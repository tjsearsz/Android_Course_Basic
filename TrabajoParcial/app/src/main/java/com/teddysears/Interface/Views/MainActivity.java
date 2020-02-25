package com.teddysears.Interface.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.teddysears.Interface.Contracts.IMainActivityContract;
import com.teddysears.Interface.Presenters.MainActivityPresenter;
import com.teddysears.Interface.R;

/**
 * Class that represents the View of the MainActivity
 */
public class MainActivity extends AppCompatActivity implements IMainActivityContract {

    /**
     * Method to be performed when the view is being created
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Passing this view to the presenter
        MainActivityPresenter presenter = new MainActivityPresenter(this);
    }
}