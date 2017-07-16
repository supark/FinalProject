package edu.gsu.httpcs.finalproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import edu.gsu.httpcs.finalproject.R;

/**
 * Created by supark on 7/5/17.
 */

public class ItemFragment extends Fragment {
    //matching ItemFragment and item.xml
    //Below code is for optimization of ViewPager, reduce the memory size in order to speed up for app
    public static ItemFragment newInstance(int position) {

        Bundle args = new Bundle();
        args.putInt("position", position);
        ItemFragment fragment = new ItemFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item, container, false);  //matching
        ImageView imageview = (ImageView) view.findViewById(R.id.item_imageview);
        imageview.setImageResource(getArguments().getInt("position"));
        return view;
    }
}
