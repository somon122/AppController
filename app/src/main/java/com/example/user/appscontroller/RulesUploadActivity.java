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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RulesUploadActivity extends AppCompatActivity {


    private EditText questionET,banglaAnsET,englishAnsET;
    private Button rulesUploadButton;

    private FirebaseDatabase database;
    private DatabaseReference myRef;
    ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_upload);


        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("UserBalance");
        progressDialog = new ProgressDialog(this);

        questionET = findViewById(R.id.question_id);
        banglaAnsET = findViewById(R.id.banglaAns_id);
        englishAnsET = findViewById(R.id.englishAns_id);
        rulesUploadButton = findViewById(R.id.rulesUpload_id);

        rulesUploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rulesUploadMethod();
            }
        });

    }

    private void rulesUploadMethod() {

        String question = questionET.getText().toString().trim();
        String banglaAns = banglaAnsET.getText().toString().trim();
        String englishANs = englishAnsET.getText().toString().trim();

        if (question.isEmpty()){
            questionET.setError("Please Enter Question");
        }
        else if (banglaAns.isEmpty()){
            banglaAnsET.setError("Please Enter Question");
        }
        else if (englishANs.isEmpty()){
            englishAnsET.setError("Please Enter Question");
        }else {

            progressDialog.show();
            progressDialog.setMessage("Rules is Uploading...");
            RulesUpload rulesUpload = new RulesUpload(question,banglaAns,englishANs);
            String pushId = myRef.push().getKey();

            myRef.child("UserRules").child(pushId).setValue(rulesUpload).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {

                    if (task.isSuccessful()){
                        progressDialog.dismiss();
                        Toast.makeText(RulesUploadActivity.this, "Upload Successfully", Toast.LENGTH_SHORT).show();


                    }else {
                        progressDialog.dismiss();
                        Toast.makeText(RulesUploadActivity.this, "Net Connection Problem", Toast.LENGTH_SHORT).show();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    progressDialog.dismiss();
                    Toast.makeText(RulesUploadActivity.this, "Net Connection Problem\n"+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });




        }

    }
}
