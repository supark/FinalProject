package edu.gsu.httpcs.finalproject;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.gsu.httpcs.finalproject.dialog.CustomDialog;
import edu.gsu.httpcs.finalproject.dialog.CustomeDialog2;

import static edu.gsu.httpcs.finalproject.R.id.see_recipe;
import static edu.gsu.httpcs.finalproject.R.style.dialog;

public class HandlerActivity extends AppCompatActivity {

    Handler handler = new Handler();
    private Animation scaleAnimation;


    @BindView(R.id.handler_txt)
    TextView txt;

    @BindView(R.id.handler_timer)
    TextView timer;

    @BindView(R.id.handler_image)
    ImageView handlerImg;

    @BindView(R.id.see_recipe)
     Button seeRecipe;


    @OnClick(R.id.see_recipe)
    public void setSeeRecipe() {
        CustomDialog customDialog = new CustomDialog(this, new CustomDialog.ICustomDialogListener(){

            @Override
            public void onCancelClicked(Dialog dialog) {
                dialog.dismiss();
            }
        });

        customDialog.setCanceledOnTouchOutside(true);
        customDialog.show();

    }
    @OnClick(R.id.go_back)
    public void goBack() {
        Intent intent = new Intent(HandlerActivity.this, secondActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        ButterKnife.bind(this);

        handler.postDelayed(runnable, 1000);
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            updatetimer();
        }
    };

    public void updatetimer() {
        timer.setText("" + (Integer.parseInt(timer.getText().toString())-1));

        if(Integer.parseInt(timer.getText().toString()) == 0) {
            initialAnimation();
            View view1 = (View)findViewById(R.id.btn_background2);
            view1.startAnimation(scaleAnimation);
            handlerImg.setVisibility(View.VISIBLE);
            txt.setVisibility(View.VISIBLE);
            view1.setVisibility(View.VISIBLE);
            seeRecipe.setVisibility(View.VISIBLE);
        }

        else{handler.postDelayed(runnable, 1000);}
    }

    private void initialAnimation() {
        scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        scaleAnimation.setRepeatCount(Animation.INFINITE);
    }


}
