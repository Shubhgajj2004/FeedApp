package com.shubh.feedapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.shubh.feedapp.Adapters.CommentAdapter;
import com.shubh.feedapp.Adapters.feedAdapter;
import com.shubh.feedapp.Firebasevar.FirebaseVarClass;
import com.shubh.feedapp.Models.feedModel;
import com.shubh.feedapp.databinding.ActivityCommentsBinding;

import org.w3c.dom.Comment;

import java.util.ArrayList;

public class commentsActivity extends AppCompatActivity {

    ActivityCommentsBinding binding;
    ArrayList<feedModel> list = new ArrayList<>();
    FirebaseDatabase mDatabase;

    CommentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //inflate layout
        binding = ActivityCommentsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //instances
        mDatabase = FirebaseDatabase.getInstance();

        //Setting up the Recyclerview with adapter
        adapter = new CommentAdapter(list, getApplicationContext());
        binding.resComments.setAdapter(adapter);
        binding.resComments.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        //Fetch the data from database to populate the recycler view via model
        mDatabase.getReference().child(FirebaseVarClass.ALLPOSTS).child(getIntent().getStringExtra(FirebaseVarClass.KEY)).child(FirebaseVarClass.COMMENTS).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();

                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    feedModel adp = snapshot1.getValue(feedModel.class);
                    list.add(adp);
                }



                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}