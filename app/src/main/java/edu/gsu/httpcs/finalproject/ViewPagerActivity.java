package edu.gsu.httpcs.finalproject;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.gsu.httpcs.finalproject.fragment.MyViewPagerAdapter;

public class ViewPagerActivity extends AppCompatActivity {
    //connect MyViewPagerAdapter to activity_view_pager.xml

    @BindView((R.id.activity_advance_view_pager))
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        ButterKnife.bind(this);

        viewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));
    }
}
