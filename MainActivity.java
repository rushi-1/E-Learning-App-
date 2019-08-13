package com.rushikesh.bvjniot;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    public DatabaseReference mDatabase;
    public FirebaseAuth mAuth;
    public DatabaseReference mDatabaseusers;
    public FirebaseAuth.AuthStateListener mAuthlistener;


    private Button comp;
    private Button mech;
    private Button civil;
    private Button elect;
    private Button prod;
    private Button it;
    private Button chem;
    private Button etc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        comp=(Button)findViewById(R.id.button4);
        mech=(Button) findViewById(R.id.button6);
        civil=(Button)findViewById(R.id.button8);
        elect=(Button)findViewById(R.id.button9);
        prod=(Button)findViewById(R.id.button10);
        it=(Button)findViewById(R.id.button5);
        chem=(Button)findViewById(R.id.button7);
        etc=(Button)findViewById(R.id.button11);

        comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(MainActivity.this,TYCM.class);
                startActivity(intent);

            }
        });

        mech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,TYME.class);
                startActivity(intent);
            }
        });

        civil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,tyce.class);
                startActivity(intent);
            }
        });

        elect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,TYEE.class);
                startActivity(intent);
            }
        });

        prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,type.class);
                startActivity(intent);
            }
        });

        it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,TYIF.class);
                startActivity(intent);
            }
        });

        chem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,CHEM.class);
                startActivity(intent);
            }
        });

        etc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,TYETC.class);
                startActivity(intent);
            }
        });

        mAuth=FirebaseAuth.getInstance();
        mAuthlistener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()==null)
                {
                    Intent intent= new Intent(MainActivity.this, LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            }
        };

        mDatabase= FirebaseDatabase.getInstance().getReferenceFromUrl("https://bvjniot-ca0d7.firebaseio.com");
        mDatabaseusers=FirebaseDatabase.getInstance().getReference().child("Users");

    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthlistener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthlistener != null) {
            mAuth.removeAuthStateListener(mAuthlistener);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_logout) {
            logout();

        }
        if (item.getItemId() == R.id.set)
        {
            pogo();
        }
        if (item.getItemId() == R.id.up)
        {
            upd();
        }

        if(item.getItemId() == R.id.abt)
        {
            about();
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        mAuth.signOut();
    }

    private void pogo()
    {
        Intent intent=new Intent(MainActivity.this,sett.class);
        startActivity(intent);
    }

    private void about()
    {
        Intent intent=new Intent(MainActivity.this,abot.class);
        startActivity(intent);
    }

    private void upd()
    {
        Intent intent=new Intent(MainActivity.this,update.class);
        startActivity(intent);
    }



}







