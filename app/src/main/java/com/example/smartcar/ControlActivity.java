package com.example.smartcar;

/**
 * Created by lijinwei on 2017/6/25.
 */

import java.io.IOException;
import java.io.OutputStream;

//import com.example.bluetoothcar.R;
import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import android.widget.Button;

//import com.google.*;
//import com.google.android.gms.appindexing.AppIndex;
//import com.google.android.gms.appindexing.Thing;
//import com.google.android.gms.common.api.GoogleApiClient;
import android.view.View;
import android.view.WindowInsets;
import android.view.View.OnTouchListener;

public class ControlActivity extends Activity {

    private OutputStream outputStream;
    private Sensor sensor;
    private SensorManager sensorManager;
    private boolean upOneTime = true;
    private boolean downOneTime = true;
    private boolean leftOneTime = true;
    private boolean rightOneTime = true;
    private boolean stopOneTime = true;
    // ��Ļ����
    private PowerManager powerManager = null;
    private WakeLock wakeLock = null;

    private Button upbutton, button2, button3, button4,stopbutton;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
   // private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        powerManager = (PowerManager) this.getSystemService(POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK,
                "My Lock");

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        buttonInit();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
  //      client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        wakeLock.acquire();
        sensorManager.registerListener(eventListener, sensor,
                SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        wakeLock.release();
        sensorManager.unregisterListener(eventListener);
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        try {
            outputStream.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        super.onDestroy();
    }

    private SensorEventListener eventListener = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent arg0) {
            // TODO Auto-generated method stub
                if (arg0.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

                    if (arg0.values[1] < -2.4 && rightOneTime) {
                        writeOutputStream("4");
                        upbutton.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.up));
                        button2.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.down));
                        button3.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.left));
                        button4.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.right1));
                        stopbutton.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.start));
                        upOneTime = true;
                        downOneTime = true;
                        leftOneTime = true;
                        rightOneTime = false;
                        stopOneTime = true;
                    }
                    if (arg0.values[1] > 2.4 && leftOneTime) {
                        writeOutputStream("3");
                        upbutton.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.up));
                        button2.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.down));
                        button3.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.left1));
                        button4.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.right));
                        stopbutton.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.start));
                        upOneTime = true;
                        downOneTime = true;
                        leftOneTime = false;
                        rightOneTime = true;
                        stopOneTime = true;

                    }
                    if (arg0.values[0] >2.2 && upOneTime) {
                        writeOutputStream("1");
                        upbutton.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.up1));
                        button2.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.down));
                        button3.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.left));
                        button4.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.right));
                        stopbutton.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.start));
                        upOneTime = false;
                        downOneTime = true;
                        leftOneTime = true;
                        rightOneTime = true;
                        stopOneTime = true;

                    }
                    if (arg0.values[0] <- 2.2 && downOneTime) {
                        writeOutputStream("2");
                        upbutton.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.up));
                        button2.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.down1));
                        button3.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.left));
                        button4.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.right));
                        stopbutton.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.start));
                        upOneTime = true;
                        downOneTime = false;
                        leftOneTime = true;
                        rightOneTime = true;
                        stopOneTime = true;

                    }
                    if ((-2.4 < arg0.values[0] && arg0.values[0] < 2.4)
                            && (-2.4 < arg0.values[1] && arg0.values[1] < 2.4)
                            && stopOneTime) {
                        writeOutputStream("7");
                        upbutton.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.up));
                        button2.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.down));
                        button3.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.left));
                        button4.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.right));
                        stopbutton.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.stop));
                        upOneTime = true;
                        downOneTime = true;
                        leftOneTime = true;
                        rightOneTime = true;
                        stopOneTime = false;
                    }
                }

        }

        @Override
        public void onAccuracyChanged(Sensor arg0, int arg1) {
            // TODO Auto-generated method stub

        }
    };

    private void writeOutputStream(String m1) {
        // ÿ�ε����Ҫ���»����������Է�ֹ�����Ͽ��������Ӻ�������ı���
        outputStream = MainActivity.outputStream;
        String message;
        byte[] buffer;
        message = m1;
        buffer = message.getBytes();
        try {
            outputStream.write(buffer);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void buttonInit() {
        upbutton = (Button) findViewById(R.id.upButton);
        button2 = (Button) findViewById(R.id.downButton);
        button3 = (Button) findViewById(R.id.leftButton);
        button4 = (Button) findViewById(R.id.rightButton);
        stopbutton=(Button)findViewById(R.id.centerButton);
        upbutton.setText("前进");
        button2.setText("后退");
        button3.setText("左转");
        button4.setText("右转");
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
  /*  public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Control Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }*/

    /* @Override
   public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }*/
}

