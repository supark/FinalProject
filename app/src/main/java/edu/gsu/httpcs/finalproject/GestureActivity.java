package edu.gsu.httpcs.finalproject;

import android.app.Dialog;
import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

import static edu.gsu.httpcs.finalproject.R.id.textView;

public class GestureActivity extends BaseActivity implements View.OnTouchListener{


    private GestureDetector gestureDetector;
    private int sumX=0, sumY=0;

    @BindView(R.id.gesture_tv)
    TextView txtview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);
        ButterKnife.bind(this);

        gestureDetector = new GestureDetector(this, new simpleGestureListener());
        txtview.setOnTouchListener(this);
        txtview.setFocusable(true);
        txtview.setClickable(true);
        txtview.setLongClickable(true);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private class simpleGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDown(MotionEvent e) {
            //txtview.setText("ondown" +e.toString());
            return super.onDown(e);
        }

        @Override
        public void onShowPress(MotionEvent e) {
            //txtview.setText("onShowPress");
            super.onShowPress(e);
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            txtview.setText("Please double click me!!");
            return super.onSingleTapUp(e);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

            sumX += distanceX;
            sumY += distanceY;
            shortToast("Thank you!");

            final Dialog dialog;
            Button dialog_layout_btn;

            dialog = new Dialog(GestureActivity.this); // create dialog

            dialog.setContentView(R.layout.dialog_layout);  //setting the dialog view

            dialog_layout_btn =(Button)dialog.findViewById(R.id.dialog_layout_btn);  //This ID is from different layout file
            //so need to add dialog. before findViewById
            final EditText dEmail = (EditText)dialog.findViewById(R.id.etEmail);
            final EditText dPW = (EditText)dialog.findViewById(R.id.etPW);

            dialog_layout_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(!dEmail.getText().toString().isEmpty() && !dPW.getText().toString().isEmpty()) {

                        String mail = dEmail.getText().toString();
                        String pw = dPW.getText().toString();

                        if(mail.equals("1111") && pw.equals("1111")) {
                            Toast.makeText(getApplicationContext(), "Login successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(GestureActivity.this, secondActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Please try again!", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Please try again!", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            dialog.setTitle("Pleae input 1111 for login");
            dialog.show();


            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override
        public void onLongPress(MotionEvent e) {
            txtview.setText("Please scroll me!!");
            super.onLongPress(e);
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            txtview.setText("Please long press me!!");
            return super.onDoubleTap(e);
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            return super.onDoubleTapEvent(e);
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            return super.onSingleTapConfirmed(e);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {


            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
}
