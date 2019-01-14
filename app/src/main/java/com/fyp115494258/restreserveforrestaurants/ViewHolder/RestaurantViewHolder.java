package com.fyp115494258.restreserveforrestaurants.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fyp115494258.restreserveforrestaurants.Common.Common;
import com.fyp115494258.restreserveforrestaurants.Interface.ItemClickListener;
import com.fyp115494258.restreserveforrestaurants.R;

public class RestaurantViewHolder extends RecyclerView.ViewHolder implements
        View.OnClickListener,
        View.OnCreateContextMenuListener
{


    //2ND ITERATION
    public TextView txtRestaurantName;
    public ImageView imageView;

    private ItemClickListener itemClickListener;

    public RestaurantViewHolder(@NonNull View itemView) {
        super(itemView);

        txtRestaurantName=(TextView)itemView.findViewById(R.id.restaurant_name);
        imageView =(ImageView)itemView.findViewById(R.id.restaurant_image);

        itemView.setOnCreateContextMenuListener(this);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {

        itemClickListener.onClick(v,getAdapterPosition(),false);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        menu.setHeaderTitle("Select action");

        menu.add(0,0,getAdapterPosition(), Common.UPDATE);
      //  menu.add(0,1,getAdapterPosition(), Common.DELETE);
    }
}





