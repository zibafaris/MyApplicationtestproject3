package com.example.myapplicationrecyclerview;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewAdapterHolder> {
    ArrayList<String> myList;

    public RecyclerViewAdapter(ArrayList list) {
        myList = list;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview, parent, false);
        RecyclerViewAdapterHolder holder = new RecyclerViewAdapterHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterHolder holder, int position) {

        holder.txtName.setText(myList.get(position));
        if(holder.txtName.getText()=="PROFILE"){
            holder.txtName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(),ProfileActivity.class);
                    v.getContext().startActivity(intent);
                }
            });
        } if(holder.txtName.getText() == "DIAL"){
            holder.txtName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(),DialActivity.class);
                    v.getContext().startActivity(i);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class RecyclerViewAdapterHolder extends RecyclerView.ViewHolder{
        TextView txtName;

        public RecyclerViewAdapterHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.btnName);
        }
    }

}
