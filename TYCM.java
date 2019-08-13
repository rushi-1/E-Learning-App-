package com.rushikesh.bvjniot;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;

/**
 * Created by rushikesh on 1/3/17.
 */

public class TYCM extends AppCompatActivity
{

    private Button ST;
    private Button AWT;
    private WebView view;

    @Override
    public void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tycm);

        ST = (Button) findViewById(R.id.button14);
        AWT = (Button) findViewById(R.id.awt);
        view=(WebView)findViewById(R.id.webcm);




        ST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(TYCM.this,st.class);
                startActivity(intent);
                //view.loadUrl("https://drive.google.com/open?id=0BySpcum8uic_U1gxQkJMeTZMczA");

            }
        });
        AWT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(TYCM.this,AWT.class);
                startActivity(intent);
                //view.loadUrl("https://drive.google.com/open?id=0BySpcum8uic_U1gxQkJMeTZMczA");

            }
        });







    }
}












