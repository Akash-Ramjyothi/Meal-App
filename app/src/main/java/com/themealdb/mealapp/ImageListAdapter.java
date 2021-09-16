package com.themealdb.mealapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;
import com.themealdb.mealapp.model.ResultModel;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ViewHolder> {

    public ImageListAdapter(Context context, ResultModel resultModels) {
        this.context = context;
        this.resultModels = resultModels;
    }

    private Context context;
    private ResultModel resultModels;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_file,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.i("ListAdapter","ID "+resultModels.getItemsArrayList().get(position).getIdMeal());
        Picasso.get().load(resultModels.getItemsArrayList().get(position).getStrMealThumb()).into(holder.imageView);
        holder.name.setText(resultModels.getItemsArrayList().get(position).getStrMeal());
    }

    @Override
    public int getItemCount() {
        return resultModels.getItemsArrayList().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
        }
    }
}
