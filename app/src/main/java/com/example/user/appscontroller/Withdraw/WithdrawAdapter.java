package com.example.user.appscontroller.Withdraw;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.appscontroller.R;

import java.util.List;

public class WithdrawAdapter extends RecyclerView.Adapter<WithdrawAdapter.ViewHolder> {

    private Context context;
    private List<WithdrawClass>withdrawList;

    public WithdrawAdapter(Context context, List<WithdrawClass> withdrawList) {
        this.context = context;
        this.withdrawList = withdrawList;
    }

    @NonNull
    @Override
    public WithdrawAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.withdraw_layout,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull WithdrawAdapter.ViewHolder holder, int position) {

        WithdrawClass withdrawClass = withdrawList.get(position);
        holder.userPhoneNumberTV.setText(withdrawClass.getUserNumber());
        holder.dateTV.setText("Date Time : "+withdrawClass.getWithDrawDate());
        holder.paymentNumberTV.setText("Request Number : "+withdrawClass.getRequestNumber());
        holder.paymentMethodTV.setText("Payment Method : "+withdrawClass.getPaymentMethod());
        holder.amountTV.setText("Amount : "+withdrawClass.getAmount());


    }

    @Override
    public int getItemCount() {
        return withdrawList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView userPhoneNumberTV,dateTV,paymentNumberTV,paymentMethodTV,amountTV;

        public ViewHolder(View itemView) {
            super(itemView);

            userPhoneNumberTV = itemView.findViewById(R.id.userPhoneNo_id);
            dateTV = itemView.findViewById(R.id.date_id);
            paymentNumberTV = itemView.findViewById(R.id.paymentNumber_id);
            paymentMethodTV = itemView.findViewById(R.id.paymentMethod_id);
            amountTV = itemView.findViewById(R.id.amount_id);


        }
    }
}
