package com.example.locationpage;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HeaderViewHolder extends RecyclerView.ViewHolder {

    public EditText search;
    public TextView sort;
    public TextView filter;

    public HeaderViewHolder(@NonNull View itemView, int viewType) {
        super(itemView);

        search= itemView.findViewById(R.id.search);
        sort = (TextView)itemView.findViewById(R.id.sort);
        filter=(TextView)itemView.findViewById(R.id.filter);

    }
}