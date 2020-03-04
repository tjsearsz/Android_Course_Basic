package com.teddysears.Interface.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.teddysears.Domain.Entity;
import com.teddysears.Domain.Task;
import com.teddysears.Interface.R;
import com.teddysears.Interface.Views.task_creation;
import com.teddysears.Utility.DateUtils;
import java.util.List;

/**
 * Adapter Class for the Main Activity
 * Notice the extends: We use RecyclerView.Adapter and in its generic we use the Holder
 * (Public static class) that is inside here, this is because this last class already extends
 * from the RecyclerView.ViewHolder
 */
public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.MainActivityViewHolder> {

    //Attributes of the Adapter
    private List<Entity> listOfTasks;

    private String year = "";
    private String yearmonth = "";

    /**
     * Constructor that receives the list of tasks
     * @param ListOfTasks Tasks we will adapt to the RecyclerView
     */
    public MainActivityAdapter(List<Entity> ListOfTasks)
    {
        this.listOfTasks = ListOfTasks;
    }

    /**
     * Static class that will be the ViewHolder for the Main Activity
     */
    public static class MainActivityViewHolder extends RecyclerView.ViewHolder {

        //Attributes (the element that are in the view and we will hold)
        public TextView year;
        public TextView date;
        public TextView time;
        public TextView title;
        public CheckBox completed;
        public View CardView;

        /**
         * Constructor of the hold class that will get all the elements
         * @param itemView The view of the class
         */
        public MainActivityViewHolder(@NonNull View itemView) {
            super(itemView);
            this.year = itemView.findViewById(R.id.Year);
            this.date = itemView.findViewById(R.id.Date);
            this.time = itemView.findViewById(R.id.time);
            this.title = itemView.findViewById(R.id.title);
            this.completed = itemView.findViewById(R.id.isCompleted);
            this.CardView = itemView.findViewById(R.id.cardView);
        }
    }

    /**
     * Method in charge to create the Holder of this Adapter
     * @param parent The class that represents the parent (principal of this class)
     * @param viewType
     * @return The instantiation of the Holder of this view
     */
    @NonNull
    @Override
    public MainActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //When we create a view holder, we need to perform this inflate
        View tasksView = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent , false);
        return new MainActivityViewHolder(tasksView);
    }

    /**
     * Method in charge of bind (attach) every value on the view with the help of the holder
     * @param holder The class that contains all the elements of the view
     * @param position The position of the list we are iterating
     */
    @Override
    public void onBindViewHolder(@NonNull MainActivityAdapter.MainActivityViewHolder holder, int position) {

        //Here, we obtain the task
        final Task TaskBeingManipulated = (Task) listOfTasks.get(position);

        //Getting views from the holder
        TextView timeOfTask = holder.time;
        TextView title = holder.title;
        CheckBox isCompleted = holder.completed;
        final View CardView = holder.CardView;

        /* Implementing method to display/hide TextViews depending whether
         year or month/year are the same */
        DateTimeValidations(TaskBeingManipulated, holder);

        //This values will always be outputted
        timeOfTask.setText(DateUtils.TimeDateToString(TaskBeingManipulated.getDate()));
        title.setText(TaskBeingManipulated.getTitle());
        isCompleted.setChecked(TaskBeingManipulated.isAlreadyFinished());

        //Creating the listener used to instantiate the activity when the user presses a task
        CardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //We create a new intent
                Intent intent = new Intent(CardView.getContext(), task_creation.class);

                //Passing parameters
                intent.putExtra("Name", TaskBeingManipulated.getTitle());
                intent.putExtra("Description", TaskBeingManipulated.getDescription());
                intent.putExtra("Date", TaskBeingManipulated.getDate());
                intent.putExtra("Finished", TaskBeingManipulated.isAlreadyFinished());

                //Starting activity
                CardView.getContext().startActivity(intent);
            }
        });

        //We will add an extra space so floating button can be seen nicely
        AddSpaceAfterLastRow(position, CardView);

    }

    /**
     * Override method to obtain the length of the lists we are iterating
     * @return the size of the list
     */
    @Override
    public int getItemCount() {
        return listOfTasks.size();
    }

    /**
     * Method we will use to display/hide the years, month/day depending if they are the same
     * @param taskBeingManipulated The task we will use
     * @param holder The Holder of this view
     */
    private void DateTimeValidations(Task taskBeingManipulated, MainActivityViewHolder holder) {

        TextView yearOfTask = holder.year;
        TextView dateOfTask = holder.date;

        /* If the current year is the same as the last one, we will not display it again
         */
        if(!this.year.equals(DateUtils.YearDateToString(taskBeingManipulated.getDate()))){

            //Setting the value in the text view and saving the variable
            yearOfTask.setText(DateUtils.YearDateToString(taskBeingManipulated.getDate()));
            this.year = DateUtils.YearDateToString(taskBeingManipulated.getDate());

            //Since we found a different year, this variable needs to be restarted
            this.yearmonth = "";
        }
        else
        {
            //Removing the view if is already repeated
            ((ViewGroup)yearOfTask.getParent()).removeView(yearOfTask);
        }

        /*
         * If the current month/day is the same as the last one, we will not display it again
         */
        if(!this.yearmonth.equals(DateUtils.MonthDayDateToString(taskBeingManipulated.getDate())))
        {
            //Setting the value in the text view and saving the variable
            dateOfTask.setText(DateUtils.MonthDayDateToString(taskBeingManipulated.getDate()));
            this.yearmonth = DateUtils.MonthDayDateToString(taskBeingManipulated.getDate());
        }
        else
        {
            //Removing the view if is already repeated
            ((ViewGroup)dateOfTask.getParent()).removeView(dateOfTask);
        }
    }

    /**
     * Method for adding an empty row after last position of the list
     * @param position The position we are currently iterating
     * @param cardView The main CardView
     */
    private void AddSpaceAfterLastRow(int position, View cardView) {

        /*If we are in the last position and the list contains at least one item, we will add an
        empty View */
        if(getItemCount()> 0 && position + 1 == getItemCount())
        {
            View view = new TextView(cardView.getContext());
            view.setPadding(0,200,0,0);
            ((ViewGroup) cardView.getParent()).addView(view);
        }
    }
}
