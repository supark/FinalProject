package edu.gsu.httpcs.finalproject.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import edu.gsu.httpcs.finalproject.R;

/**
 * Created by supark on 7/5/17.
 */

public class MyViewPagerAdapter extends FragmentPagerAdapter {

    int image[] = {R.mipmap.chicken, R.mipmap.eggplant, R.mipmap.salad};

    public MyViewPagerAdapter(FragmentManager fm) {  //constructor
        super(fm);
    }

    //implements methods
    @Override
    public Fragment getItem(int position) {
        return ItemFragment.newInstance(image[position]);
    }

    @Override
    public int getCount() {
        return image.length;
    }
}
