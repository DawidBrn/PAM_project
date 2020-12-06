package com.example.pam_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    String title_text[],content_text[],phone_text[],userId_text;
    Context context;
    public Adapter(Context ct,String title[],String content[],String phone[], String userId)
    {
        context = ct;
        title_text = title;
        content_text = content;
        phone_text = phone;
        userId_text = userId;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(title_text[position]);
        holder.content.setText(content_text[position]);
        holder.phoneLabel.setText("Telefon :");
        holder.phone.setText(phone_text[position]);
    }

    @Override
    public int getItemCount() {
        return title_text.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title,content,phone,phoneLabel;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_text);
            content = itemView.findViewById(R.id.content_text);
            phone = itemView.findViewById(R.id.phone_text);
            phoneLabel= itemView.findViewById(R.id.phone);
        }
    }


}
