package com.teddysears.Interface.Views.Activities.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.teddysears.Interface.Contracts.IFragmentCreationContract;
import com.teddysears.Interface.R;
import com.teddysears.Utility.DateUtils;

import java.util.Date;


public class FragmentCreationTask extends Fragment implements IFragmentCreationContract {

    private TextView TextTitle;
    private EditText TextName;
    private EditText TextDescription;
    private EditText TaskDate;
    private CheckBox CompletedCheckBox;
    private Button CreateButton;

    public FragmentCreationTask() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_creation_task, container, false);

        this.TextTitle = view.findViewById(R.id.TaskTitle);
        this.TextName = view.findViewById(R.id.TaskName);
        this.TextDescription = view.findViewById(R.id.TaskDescription);
        this.TaskDate = view.findViewById(R.id.TaskDate);
        this.CompletedCheckBox = view.findViewById(R.id.CompletedCheckBox);
        this.CreateButton = view.findViewById(R.id.CreateButton);

        Bundle args = getArguments();

        if(args != null)
        {
            //Filling the information obtained
            this.TextTitle.setText(R.string.TASK_SUMMARY);
            this.TextName.setText(args.getString("Name"));
            this.TextName.setKeyListener(null);
            this.TextDescription.setText(args.getString("Description"));
            this.TextDescription.setKeyListener(null);
            this.TaskDate.setText(DateUtils.DateToString((Date) args.getSerializable("Date")));
            this.TaskDate.setKeyListener(null);
            this.CompletedCheckBox.setChecked(args.getBoolean("Finished"));
            this.CompletedCheckBox.setKeyListener(null);

            //Hiding the create button since we are not creating a new one
            CreateButton.setVisibility(View.GONE);

            //Cleaning the data
            getArguments().clear();
        }

        return view;
    }

    @Override
    public TextView GetTextTitle() {
        return this.TextTitle;
    }

    @Override
    public EditText GetTaskName() {
        return this.TextName;
    }

    @Override
    public EditText GetTaskDescription() {
        return this.TextDescription;
    }

    @Override
    public EditText GetTaskDate() {
        return this.TaskDate;
    }

    @Override
    public CheckBox GetCompletedCheckBox() {
        return this.CompletedCheckBox;
    }

    @Override
    public Button GetCreateButton() {
        return this.CreateButton;
    }
}
