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

public class TYEE extends AppCompatActivity {

    private Button btn;
    private WebView view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tyee);

        btn=(Button)findViewById(R.id.note);
        view=(WebView)findViewById(R.id.webcm);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TYEE.this,IES.class);
                startActivity(intent);
                //view.loadUrl("https://drive.google.com/open?id=0BySpcum8uic_X1NGOV85TnQzTDg");
            }
        });
    }
}
