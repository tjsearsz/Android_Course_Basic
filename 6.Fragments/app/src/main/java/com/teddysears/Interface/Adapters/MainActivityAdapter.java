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
public class MainActivityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //Attributes of the Adapter
    private List<Object> listOfTasks;

    private String year = "";
    private String yearmonth = "";

    /**
     * Constructor that receives the list of tasks
     * @param ListOfTasks Tasks we will adapt to the RecyclerView
     */
    public MainActivityAdapter(List<Object> ListOfTasks)
    {
        //Adding a dummy value which will be the empty view
        ListOfTasks.add(new Object());
        this.listOfTasks = ListOfTasks;
    }

    /**
     * Static class that will be the ViewHolder for the Main Activity
     */
    public static class MainActivityViewHolder extends RecyclerView.ViewHolder {

        //Attributes (the element that are in the view and we will hold)
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
            this.date = itemView.findViewById(R.id.Date);
            this.time = itemView.findViewById(R.id.time);
            this.title = itemView.findViewById(R.id.title);
            this.completed = itemView.findViewById(R.id.isCompleted);
            this.CardView = itemView.findViewById(R.id.cardView);
        }
    }

    public static class YearViewHolder extends RecyclerView.ViewHolder
    {
        public TextView year;

        public YearViewHolder(View itemView)
        {
            super(itemView);
            this.year = itemView.findViewById(R.id.Year);
        }
    }

    public static class MonthViewHolder extends RecyclerView.ViewHolder
    {
        public TextView monthday;

        public MonthViewHolder(View itemView)
        {
            super(itemView);
            this.monthday = itemView.findViewById(R.id.Date);
        }
    }

    public static class FooterViewHolder extends RecyclerView.ViewHolder
    {
        public View footer;

        public FooterViewHolder(View itemView)
        {
            super(itemView);
            this.footer = itemView.findViewById(R.id.footer);
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
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View itemView;

        //When we create a view holder, we need to perform this inflate
        if(viewType == 0)
        {
            itemView = inflater.inflate(R.layout.task_item, parent , false);
            return new MainActivityViewHolder(itemView);
        }
        else if (viewType == 1)
        {
            itemView = inflater.inflate(R.layout.task_item_header, parent , false);
            return new YearViewHolder(itemView);
        }
        else if(viewType == 2)
        {
            itemView = inflater.inflate(R.layout.task_item_date, parent , false);
            return new MonthViewHolder(itemView);
        }
        else
        {
            itemView = inflater.inflate(R.layout.task_footer, parent , false);
            return new FooterViewHolder(itemView);
        }


    }

    /**
     * Method in charge of bind (attach) every value on the view with the help of the holder
     * @param holder The class that contains all the elements of the view
     * @param position The position of the list we are iterating
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        switch (holder.getItemViewType())
        {
            case 0:
                MainActivityViewHolder holder0 = (MainActivityViewHolder) holder;

                //Here, we obtain the task
                final Task TaskBeingManipulated = (Task) listOfTasks.get(position);

                //Getting views from the holder
                TextView timeOfTask = holder0.time;
                TextView title = holder0.title;
                CheckBox isCompleted = holder0.completed;
                final View CardView = holder0.CardView;

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
                //AddSpaceAfterLastRow(position, CardView);
                break;

            case 1:
                YearViewHolder holder1 = (YearViewHolder) holder;

                final Integer year = (Integer) listOfTasks.get(position);

                TextView TextViewYear = holder1.year;
                TextViewYear.
                        setText(String.valueOf(year));

                break;
            case 2:

                MonthViewHolder holder2 = (MonthViewHolder) holder;

                final String month = (String) listOfTasks.get(position);

                TextView TextViewDate = holder2.monthday;

                TextViewDate.setText(month);
                break;

        }



        /* Implementing method to display/hide TextViews depending whether
         year or month/year are the same */
       // DateTimeValidations(TaskBeingManipulated, holder, position);







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
     * Method to return the type of view we will use to fill the recyclerview
     * @param position position we are located in the list
     * @return The view type
     */
    @Override
    public int getItemViewType(int position) {
        if(listOfTasks.get(position) instanceof Task)
            return 0;
        else if (listOfTasks.get(position) instanceof Integer)
            return 1;
        else if (listOfTasks.get(position) instanceof String)
            return 2;
        else
            return 3;

    }

    /**
     * Method we will use to display/hide the years, month/day depending if they are the same
     * @param taskBeingManipulated The task we will use
     * @param holder The Holder of this view
     */
    private void DateTimeValidations(Task taskBeingManipulated, MainActivityViewHolder holder, int position) {


        TextView dateOfTask = holder.date;
       // TextView yearOfTask = holder.year;

        /* If the current year is the same as the last one, we will not display it again
         */
        if(!this.year.equals(DateUtils.YearDateToString(taskBeingManipulated.getDate()))){

            //Setting the value in the text view and saving the variable
           // yearOfTask.setText(DateUtils.YearDateToString(taskBeingManipulated.getDate()));
            this.year = DateUtils.YearDateToString(taskBeingManipulated.getDate());

            //Since we found a different year, this variable needs to be restarted
            this.yearmonth = "";
        }
        else
        {
            //Removing the view if is already repeated
         //   ViewGroup temp = ((ViewGroup)yearOfTask.
             //       getParent());

           // if(temp != null)
           //        temp.
           //         removeView(yearOfTask);

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
            ViewGroup temp2 = ((ViewGroup)dateOfTask.getParent());

            //Removing the view if is already repeated
            //if(temp2 != null)
                temp2.removeView(dateOfTask);
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
