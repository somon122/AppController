package com.example.user.appscontroller.InvalidClick;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.user.appscontroller.R;
import com.example.user.appscontroller.Withdraw.WithdrawAdapter;
import com.example.user.appscontroller.Withdraw.WithdrawClass;
import com.example.user.appscontroller.Withdraw.WithdrawShowActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class InvalidClicShowActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    FirebaseDatabase database;
    DatabaseReference myRef;
    InvalidClickAdapter adapter;
    InvalidClickClass invalidClickClass;
    List<InvalidClickClass> invalidClickClassList;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invalid_clic_show);


        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("UserBalance");
        recyclerView = findViewById(R.id.invalidRecyclerView_id);
        progressDialog = new ProgressDialog(this);
        invalidClickClassList = new ArrayList<>();

        RecyclerView.LayoutManager manager = new LinearLayoutManager(InvalidClicShowActivity.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);

        progressDialog.show();
        progressDialog.setMessage("Invalid Click List is loading...");


        myRef.child("InvalidClick").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()){

                    progressDialog.dismiss();
                    invalidClickClassList.clear();
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()){

                        invalidClickClass = snapshot.getValue(InvalidClickClass.class);
                        invalidClickClassList.add(invalidClickClass);

                        adapter = new InvalidClickAdapter (getApplicationContext(),invalidClickClassList);
                        recyclerView.setAdapter(adapter);

                    }
                    adapter.notifyDataSetChanged();

                }else {
                    progressDialog.dismiss();
                    Toast.makeText(InvalidClicShowActivity.this, "Data is Empty", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }
}
