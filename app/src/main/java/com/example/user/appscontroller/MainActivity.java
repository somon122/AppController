package com.example.user.appscontroller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.user.appscontroller.InvalidClick.InvalidClicShowActivity;
import com.example.user.appscontroller.PhoneAuth.PhonePickActivity;
import com.example.user.appscontroller.Withdraw.WithdrawShowActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {



    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("UserBalance");




        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab =findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (FirebaseAuth.getInstance().getCurrentUser() == null) {

            Intent intent = new Intent(MainActivity.this, PhonePickActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.myWork_id) {

            startActivity(new Intent(MainActivity.this,MyWorkUploadActivity.class));

            return true;
        }
        if (id == R.id.withdraw_id) {

            startActivity(new Intent(MainActivity.this,WithdrawShowActivity.class));

            return true;
        }
        if (id == R.id.tramsAndConditions_id) {
            startActivity(new Intent(MainActivity.this,RulesUploadActivity.class));

            return true;
        }
        if (id == R.id.notify_id) {
            startActivity(new Intent(MainActivity.this,NoticeActivity.class));

            return true;
        }

        if (id == R.id.invalid_id) {

            startActivity(new Intent(MainActivity.this,InvalidClicShowActivity.class));


            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
