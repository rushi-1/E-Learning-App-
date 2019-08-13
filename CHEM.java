package com.rushikesh.bvjniot;

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

public class CHEM extends AppCompatActivity {

    private Button btn;
    private Button btn1;
    private WebView wb;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chem);

        btn=(Button)findViewById(R.id.note);
        btn1 =(Button)findViewById(R.id.ppt);
        wb=(WebView)findViewById(R.id.web);

        final ConnectivityManager connec = (ConnectivityManager)getSystemService(this.CONNECTIVITY_SERVICE);
        final NetworkInfo ninfo=connec.getActiveNetworkInfo();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ninfo!=null && ninfo.isConnected()) {
                    wb.loadUrl("https://drive.google.com/open?id=0BySpcum8uic_WHZrX2xsY1FtSDQ");
                }
                    else
                    {
                        Toast.makeText(CHEM.this, "No Internet Connection", Toast.LENGTH_LONG).show();
                    }

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(ninfo!=null && ninfo.isConnected()) {
                        wb.loadUrl("https://drive.google.com/open?id=0BySpcum8uic_RnlrUXkwamNzT2s");
                    }
                        else
                        {
                            Toast.makeText(CHEM.this, "No Internet Connection", Toast.LENGTH_LONG).show();
                        }

            }
        });


    }
}
