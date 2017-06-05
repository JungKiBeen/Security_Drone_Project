package com.example.administrator.myapplication;


import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MainActivity extends Activity {

    TextView tv;
    ToggleButton tb;
    EditText edittext;
    Button b;

    private Socket socket;
    BufferedReader socket_in;
    PrintWriter socket_out;

    TextView output;
    String data;
    String ipad;
    boolean is_valid;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 정기빈 : 실외에서는 GPS_PROVIDER, 실내에서는 NETWORK_PROVIDER 이용

        // Location 제공자에서 정보를 얻어오기(GPS)
        // 1. Location을 사용하기 위한 권한을 얻어와야한다 AndroidManifest.xml
        //     ACCESS_FINE_LOCATION : NETWORK_PROVIDER, GPS_PROVIDER
        //     ACCESS_COARSE_LOCATION : NETWORK_PROVIDER
        // 2. LocationManager 를 통해서 원하는 제공자의 리스너 등록
        // 3. GPS 는 에뮬레이터에서는 기본적으로 동작하지 않는다
        // 4. 실내에서는 GPS_PROVIDER 를 요청해도 응답이 없다.  특별한 처리를 안하면 아무리 시간이 지나도
        //    응답이 없다.
        //    해결방법은
        //     ① 타이머를 설정하여 GPS_PROVIDER 에서 일정시간 응답이 없는 경우 NETWORK_PROVIDER로 전환
        //     ② 혹은, 둘다 한꺼번헤 호출하여 들어오는 값을 사용하는 방식.

        tv = (TextView) findViewById(R.id.textView2);
        tv.setText("");
        edittext = (EditText)findViewById(R.id.edittext);
        tb = (ToggleButton)findViewById(R.id.toggle1);
        b = (Button)findViewById(R.id.btn1);

        // LocationManager 객체를 얻어온다
        final LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        b.setOnClickListener(new Button.OnClickListener()
        {
            @Override public void onClick(View view)
            {
                ipad = edittext.getText().toString();

                Thread worker = new Thread()
                {
                    public void run()
                    {
                        try {
                            socket = new Socket(ipad, 5555);        // 정기빈: 서버  측 아이피 주소
                            socket_out = new PrintWriter(socket.getOutputStream(), true);


                        } catch (IOException e)
                        {
                            e.printStackTrace();
                        }

                        try
                        {
                            while (true)
                            {

                            }
                        } catch (Exception e) {
                        }
                    }
                };
                worker.start();

            }

        }) ;


        tb.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                try{
                    if(tb.isChecked())
                    {


                        tv.setText("Connected..");

                        // 정기빈 : 로케이션 매니져 객체에 GPS 위치제공자 등록, 최소 시간 간격 100ms, 변경 거리 1m
                        // GPS 제공자의 정보가 바뀌면 콜백하도록 리스너 등록하기~!!!
                        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, // 등록할 위치제공자
                                8000, // 통지사이의 최소 시간간격 (miliSecond)
                                4, // 통지사이의 최소 변경거리 (m)
                                mLocationListener);

                        // 정기빈 : 로케이션 매니져 객체에 NETWORK 위치 제공자 등록, 최소 시간 간격 100ms, 변경 거리 1m
                        lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, // 등록할 위치제공자
                                8000, // 통지사이의 최소 시간간격 (miliSecond)
                                4, // 통지사이의 최소 변경거리 (m)
                                mLocationListener);

                    }

                    else
                    {
                        tv.setText("Disconnected..");
                        lm.removeUpdates(mLocationListener);  //  미수신할때는 반드시 자원해체를 해주어야 한다.


                    }
                }
                catch(SecurityException ex){}
            }
        });


    } // end of onCreate


    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private final LocationListener mLocationListener = new LocationListener()
    {


        // 정기빈 : 100ms(시간),1m(거리간격) 으로 콜 됨
        public void onLocationChanged(Location location)
        {
            //여기서 위치값이 갱신되면 이벤트가 발생한다.
            //값은 Location 형태로 리턴되며 좌표 출력 방법은 다음과 같다.


            Log.d("test", "onLocationChanged, location:" + location);
            double longitude = location.getLongitude(); //경도
            double latitude = location.getLatitude();   //위도
            double altitude = location.getAltitude();   //고도
            float accuracy = location.getAccuracy();    //정확도
            String provider = location.getProvider();   //위치제공자
            //Gps 위치제공자에 의한 위치변화. 오차범위가 좁다.
            //Network 위치제공자에 의한 위치변화
            //Network 위치는 Gps에 비해 정확도가 많이 떨어진다.


            data = latitude + " " +longitude;

            Log.w("NETWORK", " " + data);
            if(data != null)
            {
                socket_out.println(data);
            }
        }

        public void onProviderDisabled(String provider) {
            // Disabled시
            Log.d("test", "onProviderDisabled, provider:" + provider);
        }

        public void onProviderEnabled(String provider) {
            // Enabled시
            Log.d("test", "onProviderEnabled, provider:" + provider);
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
            // 변경시
            Log.d("test", "onStatusChanged, provider:" + provider + ", status:" + status + " ,Bundle:" + extras);
        }
    };

} // end of class