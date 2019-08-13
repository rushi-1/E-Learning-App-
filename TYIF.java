package com.rushikesh.bvjniot;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by rushikesh on 3/3/17.
 */

public class TYIF extends AppCompatActivity {

    private Button btn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tyif);

        btn=(Button)findViewById(R.id.awt);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(TYIF.this, AWT.class);
                    startActivity(intent);

            }
        });
    }
}
