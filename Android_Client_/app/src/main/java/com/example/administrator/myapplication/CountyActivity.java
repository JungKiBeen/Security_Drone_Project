package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Administrator on 2017-06-08.
 */

public class CountyActivity extends Activity {

    Button county_btn1; Button county_btn6;
    Button county_btn2; Button county_btn7;
    Button county_btn3; Button county_btn8;
    Button county_btn4;
    Button county_btn5;



    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_county);
        county_btn1 = (Button)findViewById(R.id.county_btn1);
        county_btn2 = (Button)findViewById(R.id.county_btn2);       // 경기도
        county_btn3 = (Button)findViewById(R.id.county_btn3);
        county_btn4 = (Button)findViewById(R.id.county_btn4);
        county_btn5 = (Button)findViewById(R.id.county_btn5);
        county_btn6 = (Button)findViewById(R.id.county_btn6);
        county_btn7 = (Button)findViewById(R.id.county_btn7);
        county_btn8 = (Button)findViewById(R.id.county_btn8);


        county_btn1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(),"서비스 불가 지역", Toast.LENGTH_LONG).show();
            }
        });

        county_btn3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(),"서비스 불가 지역", Toast.LENGTH_LONG).show();
            }
        });
        county_btn4.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(),"서비스 불가 지역", Toast.LENGTH_LONG).show();
            }
        });
        county_btn5.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(),"서비스 불가 지역", Toast.LENGTH_LONG).show();
            }
        });
        county_btn6.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(),"서비스 불가 지역", Toast.LENGTH_LONG).show();
            }
        });
        county_btn7.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(),"서비스 불가 지역", Toast.LENGTH_LONG).show();
            }
        });

        county_btn8.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(),"서비스 불가 지역", Toast.LENGTH_LONG).show();
            }
        });

        county_btn2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getBaseContext(), CityActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }



}
