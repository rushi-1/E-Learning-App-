package com.rushikesh.bvjniot;

/**
 * Created by rushikesh on 28/2/17.
 */


import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private EditText mname;
    private EditText memail;
    private EditText mpass;
    private DatabaseReference mDatabase;
    private Button mregister;
    private FirebaseAuth mAuth;
    private ProgressDialog mprogress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth=FirebaseAuth.getInstance();
        mname = (EditText) findViewById(R.id.nameField);
        memail = (EditText) findViewById(R.id.emailField);
        mpass = (EditText) findViewById(R.id.passField);
        mregister = (Button) findViewById(R.id.btn);
        mprogress=new ProgressDialog(this);
        mDatabase= FirebaseDatabase.getInstance().getReferenceFromUrl("https://bvjniot-ca0d7.firebaseio.com");


        mregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startRegister();

            }
        });
    }

    private void startRegister() {
        final String name=mname.getText().toString().trim();
        String email=memail.getText().toString().trim();
        String pass=mpass.getText().toString().trim();

        if(!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(email)&&!TextUtils.isEmpty(pass))
        {
            mprogress.setMessage("Signing up");
            mprogress.show();
            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {

                        String user_id=mAuth.getCurrentUser().getUid();
                        DatabaseReference current_user_db = mDatabase.child(user_id);
                        current_user_db.child("name").setValue(name);

                        mprogress.dismiss();

                        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);


                    }
                    else
                    {
                        mprogress.dismiss();
                        Toast.makeText(RegisterActivity.this, "Email Address already exist", Toast.LENGTH_LONG).show();
                    }

                }
            });
        }
    }
}