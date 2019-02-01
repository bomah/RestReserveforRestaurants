package com.fyp115494258.restreserveforrestaurants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.fyp115494258.restreserveforrestaurants.Common.Common;
import com.fyp115494258.restreserveforrestaurants.Interface.ItemClickListener;
import com.fyp115494258.restreserveforrestaurants.Model.Reservation;
import com.fyp115494258.restreserveforrestaurants.ViewHolder.ReservationViewHolder;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ReservationList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseRecyclerAdapter<Reservation,ReservationViewHolder> adapter;


    FirebaseDatabase database;
    DatabaseReference reservation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_list);


        //Init Firebase
        database = FirebaseDatabase.getInstance();
        reservation = database.getReference("Reservation");

        //Init
        recyclerView = findViewById(R.id.listReservations);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);




        loadReservations();




    }

    private void loadReservations() {

        adapter = new FirebaseRecyclerAdapter<Reservation, ReservationViewHolder>(
                Reservation.class,
                R.layout.reservation_layout,
                ReservationViewHolder.class,
                reservation.orderByChild("adminPhoneNumber").equalTo(Common.currentUser.getPhoneNumber()))
         {
            @Override
            protected void populateViewHolder(ReservationViewHolder viewHolder,Reservation model, int position) {

                viewHolder.txtPersonName.setText(model.getPersonName());
                viewHolder.txtPersonPhoneNumber.setText(model.getPersonPhoneNumber());
                viewHolder.txtDate.setText(model.getDate());
                viewHolder.txtTime.setText(model.getTime());
                viewHolder.txtNumberOfPeople.setText(String.valueOf(model.getNumberOfPeople()).concat(" People"));




            }
        };
        //adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }
}
