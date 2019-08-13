package com.rushikesh.bvjniot;

/**
 * Created by rushikesh on 28/2/17.
 */


import android.app.Application;
import android.app.ProgressDialog;
import android.content.Intent;
import android.renderscript.ScriptGroup;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.logging.Handler;

public class LoginActivity extends AppCompatActivity {
    private EditText mlogin;
    private EditText mpassword;
    private Button mbtn;
    private Button mbtn1;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabaseusers;
    private ProgressDialog mprogress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mlogin=(EditText) findViewById(R.id.loginemailfield);
        mpassword=(EditText) findViewById(R.id.loginpassword);
        mbtn=(Button) findViewById(R.id.loginbutton);
        mbtn1=(Button) findViewById(R.id.button3);
        mAuth=FirebaseAuth.getInstance();
        mDatabaseusers= FirebaseDatabase.getInstance().getReferenceFromUrl("https://bvjniot-ca0d7.firebaseio.com");
        mDatabaseusers.keepSynced(true);
        mprogress = new ProgressDialog(this);

        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                checklogin();
            }
        });

        mbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });

    }

    private void checklogin() {
        String email=mlogin.getText().toString().trim();
        String password=mpassword.getText().toString().trim();

        if(!TextUtils.isEmpty(email)&&!TextUtils.isEmpty(password))
        {
            mprogress.setMessage("Checking Login");
            mprogress.show();
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        mprogress.dismiss();
                        checkuserexist();

                    } else {
                        mprogress.dismiss();
                        Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    private void checkuserexist() {
        final String user_id=mAuth.getCurrentUser().getUid();
        mDatabaseusers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {   if (dataSnapshot.hasChild(user_id))
            {
                Intent mainintent= new Intent(LoginActivity.this, MainActivity.class);
                mainintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(mainintent);
            }

            else
            {
                Toast.makeText(LoginActivity.this, "Account does not exist", Toast.LENGTH_LONG).show();

            }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    public void onBackPressed() {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);

    }




    }

