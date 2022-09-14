package com.shubh.feedapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.shubh.feedapp.Firebasevar.FirebaseVarClass;
import com.shubh.feedapp.Models.feedModel;
import com.shubh.feedapp.R;
import com.shubh.feedapp.commentsActivity;

import java.util.ArrayList;

public class feedAdapter extends RecyclerView.Adapter<feedAdapter.MyHolder> {

    ArrayList<feedModel> list;
    ArrayList<feedModel> listKey;
    Context context;

    public feedAdapter(ArrayList<feedModel> list, ArrayList<feedModel> listKey, Context context) {
        this.list = list;
        this.listKey = listKey;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_feed_model, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        feedModel adp= list.get(position);
        feedModel adp2= listKey.get(position);

        holder.profileName.setText(adp.getName());
        holder.postDes.setText(adp.getDescription());
        holder.postLikes.setText(Integer.toString(adp.getLikes()));
        holder.postComments.setText(Integer.toString(adp.getnComments()));

        Glide.with(context).load(adp.getSender()).into(holder.sender);
        Glide.with(context).load(adp.getImage()).into(holder.postImg);

        holder.commentsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, commentsActivity.class);
                intent.putExtra(FirebaseVarClass.KEY, adp2.getKey());


                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        ImageView sender, postImg;
        TextView profileName, postDes, postComments, postLikes, commentsBtn;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            sender = itemView.findViewById(R.id.profileImg);
            postImg = itemView.findViewById(R.id.feedImg);
            profileName = itemView.findViewById(R.id.proileName);
            postDes = itemView.findViewById(R.id.postDes);
            postComments = itemView.findViewById(R.id.postComments);
            postLikes  = itemView.findViewById(R.id.postLikes);
            commentsBtn = itemView.findViewById(R.id.commentsBtn);

        }
    }
}
