package com.rushikesh.bvjniot;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by rushikesh on 3/3/17.
 */

public class TYETC extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.etc);

        btn1=(Button)findViewById(R.id.adm);
        btn2=(Button)findViewById(R.id.brm);
        btn3=(Button)findViewById(R.id.mom);
        btn4=(Button)findViewById(R.id.fom);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //wb.loadUrl("https://drive.google.com/open?id=0BySpcum8uic_NGw0NmF6d0lST2s");
                Intent intent= new Intent(TYETC.this,ADM.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //wb.loadUrl("https://drive.google.com/open?id=0BySpcum8uic_UWhNOC1IbUdCcU0");
                Intent intent= new Intent(TYETC.this,BRM.class);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // wb.loadUrl("https://drive.google.com/open?id=0BySpcum8uic_VGNvejFKU1RTQWc");
                Intent intent= new Intent(TYETC.this,MOM.class);
                startActivity(intent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // wb.loadUrl("https://drive.google.com/open?id=0BySpcum8uic_VGNvejFKU1RTQWc");
                Intent intent= new Intent(TYETC.this,FOM.class);
                startActivity(intent);
            }
        });



    }
}
