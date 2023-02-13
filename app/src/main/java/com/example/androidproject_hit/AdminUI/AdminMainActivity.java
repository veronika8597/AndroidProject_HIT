package com.example.androidproject_hit.AdminUI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.androidproject_hit.AdminUI.MyAdapter;
import com.example.androidproject_hit.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Users.Customer;

public class AdminMainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    FirebaseDatabase database;
    MyAdapter myAdapter;
    ArrayList<Customer> list;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);

        recyclerView = findViewById(R.id.userInfoList);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Customer");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        myAdapter = new MyAdapter(this, list);
        recyclerView.setAdapter(myAdapter);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //list.clear();

                for(DataSnapshot dataSnapshot : snapshot.getChildren())
                {
                    Customer customer = dataSnapshot.getValue(Customer.class);
                    list.add(customer);
                }
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}

