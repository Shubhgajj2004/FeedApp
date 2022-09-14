package com.shubh.feedapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.shubh.feedapp.Adapters.feedAdapter;
import com.shubh.feedapp.Firebasevar.FirebaseVarClass;
import com.shubh.feedapp.Models.feedModel;
import com.shubh.feedapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayList<feedModel> list = new ArrayList<>();
    ArrayList<feedModel> listKey = new ArrayList<>();
    FirebaseDatabase mDatabase;

    feedAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //inflate the layout
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //instances
        mDatabase = FirebaseDatabase.getInstance();

        //Setting up the Recyclerview with adapter
        adapter = new feedAdapter(list, listKey, getApplicationContext());
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        //Fetch the data from database to populate the recycler view via model
        mDatabase.getReference().child(FirebaseVarClass.ALLPOSTS).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();

                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    feedModel adp = snapshot1.getValue(feedModel.class);
                    list.add(adp);
                }

                listKey.clear();
                for(DataSnapshot snapshot2 : snapshot.getChildren())
                {
                    feedModel adp= new feedModel(snapshot2.getKey());
                    listKey.add(adp);
                }



                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        }
}