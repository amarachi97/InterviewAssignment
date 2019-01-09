//AMARACHI IWUH
package com.example.jeffe.touchpad;

import android.gesture.GestureLibraries;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnTouchListener;
import android.view.GestureDetector.OnGestureListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/********************************************
 * THIS CODE CHANGES COLOR OF THE BACKGROUND WHEN THE USER
 * GLIDES THEIR FINGER OVER THE COLORED PORTION OF THE SCREEN
 * ******************************************/

public class MainActivity extends AppCompatActivity {
    GestureDetector gd;
    Button pointer;
    TextView touchpad, x_axis, y_axis;
    List <String> color;
    Random rand;
    private float x, y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        touchpad = (TextView) findViewById(R.id.touchpad);
        x_axis= (TextView) findViewById(R.id.x_axis);
        y_axis= (TextView) findViewById(R.id.y_axis);
        pointer = (Button) findViewById(R.id.cursor);
        color = new ArrayList<String>();
        rand = new Random();

        x_axis.setText("x: " );
        y_axis.setText("y: " );


        //list of background colors that will the background will change to when the user interacts with the screen
        color.add("#e9967a");
        color.add("#fa8072");
        color.add("#ffa500");
        color.add("#ff8c00");
        color.add("#ff7f50");
        color.add("#f08080");
        color.add("#ff6347");
        color.add("#ff0000");


        touchpad.setOnTouchListener(new OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event){

                x = event.getX();
                y = event.getY();

                if(view.getId() == R.id.touchpad){
                    //setting text to the coordinates when the screen is touched
                    x_axis.setText("x: " + String.valueOf(String.format("%.2f", x/touchpad.getWidth())));
                    y_axis.setText("y: " + String.valueOf(String.format("%.2f", 1-(y/touchpad.getHeight()))));
                    pointer.setX(x);
                    pointer.setY(y);
                    int index = rand.nextInt(8);
                    touchpad.setBackgroundColor(Color.parseColor(color.get(index)));
                    return true;
                }
                    return false;
            }
        });
    }

}
