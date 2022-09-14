package com.shubh.feedapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.shubh.feedapp.Models.feedModel;
import com.shubh.feedapp.R;

import java.util.ArrayList;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.MyHolder2> {

    ArrayList<feedModel> list;
    Context context;

    public CommentAdapter(ArrayList<feedModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_comment_model, parent, false);
        return new MyHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder2 holder, int position) {

        feedModel adp = list.get(position);

        holder.nameComment.setText(adp.getNameComment());
        holder.Message.setText(adp.getMessage());
        Glide.with(context).load(adp.getImageComment()).into(holder.imageComment);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyHolder2 extends RecyclerView.ViewHolder {
        ImageView imageComment;
        TextView Message, nameComment;

        public MyHolder2(@NonNull View itemView) {
            super(itemView);

            imageComment = itemView.findViewById(R.id.senderImgComments);
            nameComment = itemView.findViewById(R.id.nameComment);
            Message = itemView.findViewById(R.id.messageComments);
        }
    }

}
