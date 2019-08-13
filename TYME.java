package com.rushikesh.bvjniot;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

/**
 * Created by rushikesh on 3/3/17.
 */

public class TYME extends AppCompatActivity {

    private Button ty;
    private WebView view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tyme);


        ty = (Button) findViewById(R.id.button16);
        view=(WebView)findViewById(R.id.web);




        ty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(TYME.this,ame.class);
                startActivity(intent);

                //view.loadUrl("https://drive.google.com/open?id=0BySpcum8uic_QW1DNWlHdGwwYVE");

            }
        });


    }
}
