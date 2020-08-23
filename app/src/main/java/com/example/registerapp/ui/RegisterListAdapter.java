package com.example.registerapp.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.registerapp.R;
import com.example.registerapp.model.PersonalData;

public class RegisterListAdapter extends RecyclerView.Adapter<RegisterListAdapter.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView nameTextView;
        public final TextView phoneTextView;
        public PersonalData mItem;

        public ViewHolder(View view){
            super(view);
            this.mView = view;
            this.nameTextView = (TextView) view.findViewById(R.id.tvName);
            this.phoneTextView = (TextView) view.findViewById(R.id.tvPhone);
        }
    }
}
