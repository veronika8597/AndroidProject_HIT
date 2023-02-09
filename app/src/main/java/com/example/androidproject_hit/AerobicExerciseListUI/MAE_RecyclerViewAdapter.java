package com.example.androidproject_hit.AerobicExerciseListUI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject_hit.R;
import com.example.androidproject_hit.RecyclerViewInterface;

import java.util.ArrayList;


public class MAE_RecyclerViewAdapter extends RecyclerView.Adapter<MAE_RecyclerViewAdapter.MyViewHolder> {

    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<AerobicExerciseTypeModel> aerobicExerciseTypeModels;

    public MAE_RecyclerViewAdapter(Context context, ArrayList<AerobicExerciseTypeModel> aerobicExerciseTypeModels,
                                   RecyclerViewInterface recyclerViewInterface){
        this.context = context;
        this.aerobicExerciseTypeModels = aerobicExerciseTypeModels;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    // Inflates the layout (Gives a look to the rows)
    @NonNull
    @Override
    public MAE_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view2_row, parent, false);

        return new MAE_RecyclerViewAdapter.MyViewHolder(view, recyclerViewInterface);
    }

    // assigning values to the views we created in the recycler_view_row layout file based on the position
    // of the recycler view.
    @Override
    public void onBindViewHolder(@NonNull MAE_RecyclerViewAdapter.MyViewHolder holder, int position) {

        holder.textView.setText(aerobicExerciseTypeModels.get(position).getExerciseTypeName());
        holder.imageView.setImageResource(aerobicExerciseTypeModels.get(position).getImage());

    }

    // checks the number of items that we want to display.
    @Override
    public int getItemCount() {
        return aerobicExerciseTypeModels.size();
    }

    // Grabbing all the views from our recycler_view_row layout file (can be looked as an onCreate file)
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            imageView = itemView.findViewById(R.id.aerobicExerciseImage);
            textView = itemView.findViewById(R.id.aerobicExerciseName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recyclerViewInterface != null){

                        int pos= getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
