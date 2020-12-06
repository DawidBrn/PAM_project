package com.example.pam_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class CreateActivity extends AppCompatActivity {

    private static final String TAG = "TAG CREATE";
    private FirebaseAuth mAuth;
    EditText title_et;
    EditText content_et;
    EditText phone_et;
    FirebaseFirestore db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        title_et = (EditText) findViewById(R.id.title_et);
        content_et =(EditText) findViewById(R.id.content_et);
        phone_et =(EditText) findViewById(R.id.phone_et);



    }
    public void createAd(View view){
        String title = title_et.getText().toString();
        String content = content_et.getText().toString();
        String phone = phone_et.getText().toString();

        Map<String, Object> ad = new HashMap<>();
        ad.put("title", title);
        ad.put("content", content);
        ad.put("phone", phone);
        if(!title.isEmpty() && !content.isEmpty() && !phone.isEmpty())
        {
            db.collection("mainPage").add(ad).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                @Override
                public void onComplete(@NonNull Task<DocumentReference> task) {
                    Log.d(TAG ,"Udalo sie dodac");

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d(TAG,"Cos sie popsulo");
                }
            });
            Toast.makeText(CreateActivity.this,"Utworzono",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getApplicationContext(),HomeActivity.class);
            startActivity(i);
        }
        else
        {
            Toast.makeText(CreateActivity.this,"Uzupełnij pola",Toast.LENGTH_SHORT).show();
        }
    }
    public void goBack(View view){
        Intent i = new Intent(getApplicationContext(),HomeActivity.class);
        startActivity(i);
    }

}
