package com.teddysears.Interface.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.teddysears.Domain.Entity;
import com.teddysears.Domain.Task;
import com.teddysears.Interface.R;

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
    private TextView Task;

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
        public TextView title;

        /**
         * Constructor of the hold class that will get all the elements
         * @param itemView The title of the class
         */
        public MainActivityViewHolder(@NonNull View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.title);
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

        //When we create a niew holder, we need to perform this inflate
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
        Task TaskBeingManipulated = (Task) listOfTasks.get(position);

        //Add the title
        TextView title = holder.title;

        //Set text in the view
        title.setText(TaskBeingManipulated.getTitle());
    }

    /**
     * Override method to obtain the length of the lists we are iterating
     * @return the size of the list
     */
    @Override
    public int getItemCount() {
        return listOfTasks.size();
    }
}
