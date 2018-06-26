package com.example.smartcar;

/**
 * Created by lijinwei on 2017/6/25.
 */

import java.io.IOException;
import java.io.OutputStream;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.View.OnTouchListener;
import android.widget.Button;

public class ButtonControlActivity extends Activity implements OnTouchListener {

    private Button upButton, downButton, leftButton, rightButton,jiasubutton,jiansubutton,stopbutton;
    private OutputStream outputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
        upButton = (Button) findViewById(R.id.upButton);
        downButton = (Button) findViewById(R.id.downButton);
        leftButton = (Button) findViewById(R.id.leftButton);
        rightButton = (Button) findViewById(R.id.rightButton);
        jiasubutton=(Button)findViewById(R.id.button);
        jiansubutton=(Button)findViewById(R.id.button2);
        stopbutton=(Button)findViewById(R.id.centerButton);

        upButton.setOnTouchListener(this);
        downButton.setOnTouchListener(this);
        leftButton.setOnTouchListener(this);
        rightButton.setOnTouchListener(this);
        stopbutton.setOnTouchListener(this);

    }

    @Override
    public boolean onTouch(View arg0, MotionEvent arg1) {
        // TODO Auto-generated method stub
            switch (arg0.getId()) {
                case R.id.upButton:
                    //writeOutputStream(arg1, "1", "1");
                    writeOutputStream("1");
                    if (arg1.getAction() == MotionEvent.ACTION_DOWN) {
                        upButton.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.up1));
                    }
                    if (arg1.getAction() == MotionEvent.ACTION_UP) {
                        upButton.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.up));
                    }
                    break;

                case R.id.downButton:
                    //writeOutputStream(arg1, "2", "2");
                    writeOutputStream("2");
                    if (arg1.getAction() == MotionEvent.ACTION_DOWN) {
                        downButton.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.down1));
                    }
                    if (arg1.getAction() == MotionEvent.ACTION_UP) {
                        downButton.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.down));
                    }
                    break;

                case R.id.leftButton:
                    //writeOutputStream(arg1, "3", "7");
                    writeOutputStream("3");
                    if (arg1.getAction() == MotionEvent.ACTION_DOWN) {
                        leftButton.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.left1));
                    }
                    if (arg1.getAction() == MotionEvent.ACTION_UP) {
                        leftButton.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.left));
                    }
                    break;

                case R.id.rightButton:
                   // writeOutputStream(arg1, "4", "7");
                     writeOutputStream("4");
                    if (arg1.getAction() == MotionEvent.ACTION_DOWN) {
                        rightButton.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.right1));
                    }
                    if (arg1.getAction() == MotionEvent.ACTION_UP) {
                        rightButton.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.right));
                    }
                    break;
                case R.id.button:
                    if (arg1.getAction() == MotionEvent.ACTION_DOWN) {
                        //writeOutputStream(arg1,"5","7");
                        writeOutputStream("5");
                    }
                    if (arg1.getAction() == MotionEvent.ACTION_UP) {

                    }
                    break;
                case R.id.button2:
                    if (arg1.getAction() == MotionEvent.ACTION_DOWN) {
                        //writeOutputStream(arg1,"6","7");
                        writeOutputStream("6");
                    }
                    if (arg1.getAction() == MotionEvent.ACTION_UP) {

                    }
                    break;
                case R.id.centerButton: writeOutputStream("7");
                    if (arg1.getAction() == MotionEvent.ACTION_DOWN) {
                        stopbutton.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.stop));
                    }
                    if (arg1.getAction() == MotionEvent.ACTION_UP) {
                        stopbutton.setBackgroundDrawable(getResources().getDrawable(
                                R.mipmap.stop));
                    }
                    break;
            }
        return false;
    }

    private void writeOutputStream(String m1) {
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
/*
    private void writeOutputStream(MotionEvent arg1, String m1, String m2) {
        // 每次点击都要重新获得输出流，以防止蓝牙断开重新连接后输出流改变了
        outputStream = MainActivity.outputStream;
        if (arg1.getAction() == MotionEvent.ACTION_DOWN) {
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
        } else if (arg1.getAction() == MotionEvent.ACTION_UP) {
            String message;
            byte[] buffer;
            message = m2;
            buffer = message.getBytes();
            try {
                outputStream.write(buffer);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
*/
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }

}

