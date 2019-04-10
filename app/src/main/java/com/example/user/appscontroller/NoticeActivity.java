package com.example.user.appscontroller;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NoticeActivity extends AppCompatActivity {


    private Button noticeButton;
    private EditText noticeET;
    FirebaseDatabase database;
    DatabaseReference myRef;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("UserBalance");
        noticeButton = findViewById(R.id.noticeButton_id);
        noticeET = findViewById(R.id.notice_id);
        progressDialog = new ProgressDialog(this);

        noticeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               noticeUploadMethod();
            }
        });



    }

    private void noticeUploadMethod() {
        String notice = noticeET.getText().toString().trim();

        if (notice.isEmpty()){
            noticeET.setError("Please write your notice");

        }else {
            progressDialog.show();
            progressDialog.setMessage("Notice is uploading...");
            String pushId = myRef.push().getKey();
            myRef.child("NoticeBoard").child(pushId).setValue(notice).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){

                        progressDialog.dismiss();
                        Toast.makeText(NoticeActivity.this, "Notice Upload Success", Toast.LENGTH_SHORT).show();

                    }else {
                        Toast.makeText(NoticeActivity.this, " Upload is Filed", Toast.LENGTH_SHORT).show();
                    }
                }
            });


        }

    }
}
