package com.rushikesh.bvjniot;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by rushikesh on 3/3/17.
 */

public class tyce extends AppCompatActivity {

    private Button btn4;
    private WebView view;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn5;
    private Button btn6;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tyce);

        btn1=(Button)findViewById(R.id.lsd);
        btn2=(Button)findViewById(R.id.lsm);
        btn3=(Button)findViewById(R.id.drs);
        btn4=(Button)findViewById(R.id.rrs);
        btn5=(Button)findViewById(R.id.drrs);
        btn6=(Button)findViewById(R.id.sab);
        view=(WebView)findViewById(R.id.web);

        final ConnectivityManager connec = (ConnectivityManager)getSystemService(this.CONNECTIVITY_SERVICE);
        final NetworkInfo ninfo=connec.getActiveNetworkInfo();


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ninfo!=null && ninfo.isConnected()) {

                    view.loadUrl("https://drive.google.com/open?id=0BySpcum8uic_UFBXeUVVeFczMXM");
                }
                else
                {
                    Toast.makeText(tyce.this, "No Internet Connection", Toast.LENGTH_LONG).show();
                }

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(ninfo!=null && ninfo.isConnected()) {

                view.loadUrl("https://drive.google.com/open?id=0BySpcum8uic_S3FtWGRFRV83M2s");
                    }
                    else
                    {
                        Toast.makeText(tyce.this, "No Internet Connection", Toast.LENGTH_LONG).show();
                    }

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ninfo!=null && ninfo.isConnected()) {

                view.loadUrl("https://drive.google.com/open?id=0BySpcum8uic_TF90VGZfSWZ2Z28");
        }
        else
        {
        Toast.makeText(tyce.this, "No Internet Connection", Toast.LENGTH_LONG).show();
        }

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(tyce.this,rrs.class);
                startActivity(intent);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(tyce.this,drrs.class);
                startActivity(intent);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(tyce.this,sab.class);
                startActivity(intent);
            }
        });



    }
}
