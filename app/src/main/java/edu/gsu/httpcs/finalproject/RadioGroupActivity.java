package edu.gsu.httpcs.finalproject;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.gsu.httpcs.finalproject.util.UtilFile;

import static android.R.attr.id;
import static edu.gsu.httpcs.finalproject.R.id.imageView;
import static edu.gsu.httpcs.finalproject.R.id.radioButton1;
import static edu.gsu.httpcs.finalproject.R.id.radioGroup;


public class RadioGroupActivity extends AppCompatActivity {

    private Integer[] photos ={R.mipmap.chicken, R.mipmap.salad};
    private Animation scaleAnimation;
    private int checkedID = 0;

    @BindView(R.id.Radio_imageViewPhoto)
    ImageView imgView1;

    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;

    @OnClick(R.id.radioButton1)
    public void btn1 () {
        imgView1.setImageResource(photos[0]);
        imgView1.setVisibility(View.VISIBLE);
    }
    @OnClick(R.id.radioButton2)
    public void btn2 () {
        imgView1.setImageResource(photos[1]);
        imgView1.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.go_to_see_recipe)
    public void goToSeeRecipe (View v) {
        switch (checkedID) {
            case R.id.radioButton1:
                Intent intent = new Intent(RadioGroupActivity.this, HandlerActivity.class);
                startActivity(intent);
                break;
            case R.id.radioButton2:
                Intent intent2 = new Intent(RadioGroupActivity.this, Handler2Activity.class);
                startActivity(intent2);
                break;
            default:
        }

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_group);
        ButterKnife.bind(this);

        initialAnimation();

        View view1 = (View)findViewById(R.id.btn_background1);

        view1.startAnimation(scaleAnimation);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                checkedID = checkedId;
                //shortToast("You chose : " + checkedId);
            }
        });

    }
    private void initialAnimation() {

        scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        scaleAnimation.setRepeatCount(Animation.INFINITE);

    }
}
