package com.teddysears.homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setViewAndChildrenEnabled(findViewById(R.id.cardid1),false);
        //setViewAndChildrenEnabled(findViewById(R.id.cardid2),false);

        FloatingActionButton floatingButton = findViewById(R.id.floating1);
        floatingButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Snackbar Working!", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    /**
     * Method to enable or disable an element and all its children
     * @param view The view we will disable and seek
     * @param enabled Flag to indicate whether the elements will be enabled/disable
     */
    private static void setViewAndChildrenEnabled(View view, boolean enabled) {
        view.setEnabled(enabled);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View child = viewGroup.getChildAt(i);
                setViewAndChildrenEnabled(child, enabled);
            }
        }
    }
}
