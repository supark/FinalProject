package edu.gsu.httpcs.finalproject;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ThirdActivity extends AppCompatActivity {

    @BindView(R.id.animator_tv)
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ButterKnife.bind(this);
        initialScale();
    }

    public void initialScale() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(tv, "scaleY", 0, 3, 1, 2, 5, 1);  //these numbers are to make stretch
        //like these numbers since duration is 5 seconds so it changes 5 times like these numbers
        //it doesn't matter how many numbers you input because it is array
        animator.setDuration(2000);
        animator.start();

        ObjectAnimator animator2 = ObjectAnimator.ofFloat(tv, "rotationY", 0, 360, 0); //3D style
        animator2.setDuration(1000);
        animator2.setInterpolator(new AccelerateInterpolator());
        animator2.setRepeatMode(ValueAnimator.REVERSE);
        animator2.setRepeatCount(2);
        animator2.start();

        ObjectAnimator animator3 = ObjectAnimator.ofInt(tv, "BackgroundColor", 0xffff00ff, 0xffffff00, 0xffff00ff);
        //0xffff00ff - pink,0xffffff00 - yellow( it changes color from first to last)
        animator3.setDuration(2000);
        animator3.setEvaluator(new ArgbEvaluator());
        animator3.start();

    }
}
