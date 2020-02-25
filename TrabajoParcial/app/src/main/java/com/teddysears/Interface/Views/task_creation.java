package com.teddysears.Interface.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.teddysears.Interface.R;

public class task_creation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_creation);

        PrepareTaskCreationButton();
    }

    /**
     * Method to call the other activity
     */
    private void PrepareTaskCreationButton()
    {
        Button backButton = findViewById(R.id.BackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                getApplicationContext().startActivity(intent);
            }
        });
    }
}

