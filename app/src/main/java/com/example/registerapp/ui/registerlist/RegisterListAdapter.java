package com.example.registerapp.ui.registerlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.registerapp.R;
import com.example.registerapp.model.PersonalData;

import java.util.ArrayList;
import java.util.List;

public class RegisterListAdapter extends RecyclerView.Adapter<RegisterListAdapter.ViewHolder> {

    private List<PersonalData> mDatas;
    private RegisterListContract.OnItemClickListener mOnItemClickListener;

    public RegisterListAdapter(RegisterListContract.OnItemClickListener onItemClickListener){
        mDatas = new ArrayList<>();
        mOnItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StringBuilder builder = new StringBuilder();

        holder.mItem = mDatas.get(position);
        holder.nameTextView.setText(mDatas.get(position).getName());

        builder.append(mDatas.get(position).getAge()).append(" anos");
        holder.ageTextView.setText(builder.toString());
        builder.setLength(0);

        builder.append(mDatas.get(position).getCity()).append(", ").append(mDatas.get(position).getUf());
        holder.locationTextView.setText(builder.toString());
        builder.setLength(0);

        holder.phoneTextView.setText(mDatas.get(position).getPhone());

        holder.mView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mOnItemClickListener.clickLongItem(holder.mItem);
                return false;
            }
        });

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.clickItem(holder.mItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void setDatas(List<PersonalData> datas){
        mDatas = datas;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView nameTextView;
        public final TextView ageTextView;
        public final TextView locationTextView;
        public final TextView phoneTextView;
        public PersonalData mItem;

        public ViewHolder(View view){
            super(view);
            this.mView = view;
            this.nameTextView = view.findViewById(R.id.nameTextView);
            this.ageTextView = view.findViewById(R.id.ageTextView);
            this.locationTextView = view.findViewById(R.id.locationTextView);
            this.phoneTextView = view.findViewById(R.id.phoneTextView);
        }
    }
}
