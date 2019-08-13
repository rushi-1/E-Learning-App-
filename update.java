package com.rushikesh.bvjniot;

import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by rushikesh on 5/3/17.
 */

public class update extends AppCompatActivity {

    private TextView mtext;
    private TextView ntext;
    private TextView utext;
    private DatabaseReference mRef;
    private DatabaseReference nRef;
    private WebView wb;
    private Button unb;
    private Button up;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);

        mtext=(TextView)findViewById(R.id.lver);
        utext=(TextView)findViewById(R.id.one);
        ntext=(TextView)findViewById(R.id.version);
        wb=(WebView) findViewById(R.id.web);
        unb=(Button)findViewById(R.id.un);
        up=(Button)findViewById(R.id.cfu);
        final ConnectivityManager connec = (ConnectivityManager)getSystemService(this.CONNECTIVITY_SERVICE);
        final NetworkInfo ninfo=connec.getActiveNetworkInfo();


        unb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ninfo!=null && ninfo.isConnected()) {
                dialog();
            }
                else
                {
                    Toast.makeText(update.this, "No Internet Connection", Toast.LENGTH_LONG).show();
                }
            }
        });
        unb.setVisibility(View.INVISIBLE);


        mRef=FirebaseDatabase.getInstance().getReferenceFromUrl("https://bvjniot-ca0d7.firebaseio.com").child("Version");
        nRef=FirebaseDatabase.getInstance().getReferenceFromUrl("https://bvjniot-ca0d7.firebaseio.com").child("Update");
         mRef.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 String value =dataSnapshot.getValue(String.class);
                 mtext.setText(value);

             }


             @Override
             public void onCancelled(DatabaseError databaseError) {

             }
         });


        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ninfo!=null && ninfo.isConnected())
                {
                if(ntext.getText().toString().equals(mtext.getText().toString()))
                {
                    Toast.makeText(update.this, "App is already updated", Toast.LENGTH_LONG).show();
                    unb.setVisibility(View.INVISIBLE);
                    utext.setVisibility(View.INVISIBLE);


                }
                else
                {


                    Toast.makeText(update.this, "New Version available", Toast.LENGTH_LONG).show();
                    unb.setVisibility(View.VISIBLE);
                    nRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String value =dataSnapshot.getValue(String.class);
                            utext.setText(value);

                        }


                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                }
                else
                {
                    Toast.makeText(update.this, "No Internet Connection", Toast.LENGTH_LONG).show();
                }


            }
        });



    }
    public void dialog()
    {
        new AlertDialog.Builder(this)
                .setTitle("Update")
                .setMessage("Do you want to update App?")
                .setNegativeButton("No",null)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        wb.loadUrl("https://drive.google.com/open?id=0BySpcum8uic_YUJIXzFvMGlfTHM");

                    }
                }).create().show();
    }
}
