package com.teddysears.Interface.Contracts;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * Contract of the Main Activity of the project
 */
public interface IMainActivityContract {

    //Method sings for this activity
    RecyclerView GetRecyclerView();
    Context GetCurrentContext();
    FloatingActionButton GetFloatingButton();
}
