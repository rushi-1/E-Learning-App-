package com.rushikesh.bvjniot;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by rushikesh on 3/3/17.
 */

public class BRM extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private WebView wb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brm);

        btn1=(Button)findViewById(R.id.note);
        btn2=(Button)findViewById(R.id.ppt);
        btn3=(Button)findViewById(R.id.ques);
        wb=(WebView)findViewById(R.id.web);

        final ConnectivityManager connec = (ConnectivityManager)getSystemService(this.CONNECTIVITY_SERVICE);
        final NetworkInfo ninfo=connec.getActiveNetworkInfo();


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ninfo!=null && ninfo.isConnected()) {
                wb.loadUrl("https://drive.google.com/open?id=0BySpcum8uic_cHNDbDk0Z04yZms");
                }
                else
                {
                    Toast.makeText(BRM.this, "No Internet Connection", Toast.LENGTH_LONG).show();
                }

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(ninfo!=null && ninfo.isConnected()) {
                wb.loadUrl("https://drive.google.com/open?id=0BySpcum8uic_OC1hSXlvT2VXYVE");
                    }
                    else
                    {
                        Toast.makeText(BRM.this, "No Internet Connection", Toast.LENGTH_LONG).show();
                    }

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ninfo!=null && ninfo.isConnected()) {
                wb.loadUrl("https://drive.google.com/open?id=0BySpcum8uic_S0FVbEZlTnZrVHc");
        }
        else
        {
        Toast.makeText(BRM.this, "No Internet Connection", Toast.LENGTH_LONG).show();
        }

            }
        });
    }
}
