package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by Administrator on 2017-06-08.
 */

public class CityActivity extends Activity
{
    Button city_btn1; Button city_btn6;
    Button city_btn2; Button city_btn7;
    Button city_btn3;
    Button city_btn4;
    Button city_btn5;
    EditText edittext;
    String ip;


    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        city_btn1 = (Button)findViewById(R.id.city_btn1);
        city_btn2 = (Button)findViewById(R.id.city_btn2);       // 수원
        city_btn3 = (Button)findViewById(R.id.city_btn3);
        city_btn4 = (Button)findViewById(R.id.city_btn4);
        city_btn5 = (Button)findViewById(R.id.city_btn5);
        city_btn6 = (Button)findViewById(R.id.city_btn6);
        city_btn7 = (Button)findViewById(R.id.city_btn7);
        edittext = (EditText)findViewById(R.id.edittext);


        city_btn1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(),"서비스 불가 지역", Toast.LENGTH_LONG).show();
            }
        });

        city_btn3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(),"서비스 불가 지역", Toast.LENGTH_LONG).show();
            }
        });
        city_btn4.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(),"서비스 불가 지역", Toast.LENGTH_LONG).show();
            }
        });
        city_btn5.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(),"서비스 불가 지역", Toast.LENGTH_LONG).show();
            }
        });
        city_btn6.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(),"서비스 불가 지역", Toast.LENGTH_LONG).show();
            }
        });
        city_btn7.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(),"서비스 불가 지역", Toast.LENGTH_LONG).show();
            }
        });


        city_btn2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                String temp = edittext.getText().toString();

                if(!temp.equals(""))
                {
                    ip = temp;
                }

                else
                {
                    ip = "172.20.10.2";
                }
                intent.putExtra("IP",ip);
                startActivity(intent);
                finish();
            }
        });

    }


}
