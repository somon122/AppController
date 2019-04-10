package com.example.user.appscontroller.Withdraw;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.user.appscontroller.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class WithdrawShowActivity extends AppCompatActivity {

    private RecyclerView recyclerView;


    FirebaseDatabase database;
    DatabaseReference myRef;
    WithdrawAdapter adapter;
    WithdrawClass withdrawClass;
    List<WithdrawClass>withdrawClassList;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw_show);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("UserBalance");

        recyclerView = findViewById(R.id.withdrawRecyclerView_id);
        progressDialog = new ProgressDialog(this);
        withdrawClassList = new ArrayList<>();

        RecyclerView.LayoutManager manager = new LinearLayoutManager(WithdrawShowActivity.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);

        progressDialog.show();
        progressDialog.setMessage("Withdraw List is loading...");

        myRef.child("Withdraw").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()){

                    progressDialog.dismiss();
                    withdrawClassList.clear();
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()){

                        withdrawClass = snapshot.getValue(WithdrawClass.class);
                        withdrawClassList.add(withdrawClass);

                        adapter = new WithdrawAdapter (getApplicationContext(),withdrawClassList);
                        recyclerView.setAdapter(adapter);

                    }
                    adapter.notifyDataSetChanged();

                }else {
                    progressDialog.dismiss();
                    Toast.makeText(WithdrawShowActivity.this, "Data is Empty", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }
}
