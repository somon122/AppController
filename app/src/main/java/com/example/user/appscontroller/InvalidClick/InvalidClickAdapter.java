package com.example.user.appscontroller.InvalidClick;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.appscontroller.R;
import java.util.List;

public class InvalidClickAdapter extends RecyclerView.Adapter<InvalidClickAdapter.ViewHolder> {

    private Context context;
    private List<InvalidClickClass>invalidClickClassList;

    public InvalidClickAdapter(Context context, List<InvalidClickClass> invalidClickClassList) {
        this.context = context;
        this.invalidClickClassList = invalidClickClassList;
    }

    @NonNull
    @Override
    public InvalidClickAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(context).inflate(R.layout.invalid_click_layout,parent,false);
        return new InvalidClickAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull InvalidClickAdapter.ViewHolder holder, int position) {

        InvalidClickClass invalidClickClass = invalidClickClassList.get(position);

        holder.phoneNoTV.setText(invalidClickClass.getPhoneNo());
        holder.invalidClickTV.setText(invalidClickClass.getInvalidClic());



    }

    @Override
    public int getItemCount() {
        return invalidClickClassList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView phoneNoTV,invalidClickTV;


        public ViewHolder(View itemView) {
            super(itemView);

            phoneNoTV = itemView.findViewById(R.id.invalidClickPhoneNo_id);
            invalidClickTV = itemView.findViewById(R.id.invalidClickShow_id);

        }
    }
}
