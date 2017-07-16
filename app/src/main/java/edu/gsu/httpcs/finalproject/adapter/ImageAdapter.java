package edu.gsu.httpcs.finalproject.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import edu.gsu.httpcs.finalproject.R;
import edu.gsu.httpcs.finalproject.util.UtilDensity;
import edu.gsu.httpcs.finalproject.util.UtilFile;

import static android.R.drawable.btn_star_big_on;
import static android.R.id.list;
import static java.lang.System.load;

/**
 * Created by supark on 7/5/17.
 */

public class ImageAdapter extends ArrayAdapter{  //to use adapter, I need to inheritate ArrayAdapter

    public ImageAdapter(@NonNull Context context, String[] items) { //constructor(will get items)
        super(context, R.layout.image_layout, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.image_layout, parent, false);  //get image_layout.xml
        String item = (String) getItem(position);
        TextView textview = (TextView) convertView.findViewById(R.id.textView);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);

        textview.setText(item);
        imageView.setImageResource(R.mipmap.android);

        if(position == 0){
            textview.setBackgroundColor(Color.parseColor("#ffa500"));
            Picasso.with(getContext())
                    .load("https://lh4.ggpht.com/8mx4DhKcXgumcrV5m-ld7OoprkywPDnSvw74S0gF9BGryS2vv31jC6cHa3EkLX0PeGxS=w300-rw")
                    .placeholder(R.mipmap.ic_launcher)  //if loading image fails, this will show
                    .transform(new UtilFile.CropSquareTransformation())
                    .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                    .networkPolicy(NetworkPolicy.NO_CACHE, NetworkPolicy.NO_STORE)
                    .into(imageView);
        }
        else if(position == 1){
            textview.setBackgroundColor(Color.parseColor("#ffc0cb"));
            Picasso.with(getContext())
                    .load("http://thefoodgallery.co.uk/images/food-gallery-home.jpg")
                    .placeholder(R.mipmap.ic_launcher)  //if loading image fails, this will show
                    .transform(new UtilFile.CropSquareTransformation())
                    .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                    .networkPolicy(NetworkPolicy.NO_CACHE, NetworkPolicy.NO_STORE)
                    .into(imageView);
        }
        else if(position == 2){
            textview.setBackgroundColor(Color.parseColor("#a4fff3"));
            Picasso.with(getContext())
                    .load("http://food.fnr.sndimg.com/content/dam/images/food/unsized/2014/9/17/0/fnd_Menu-Thinkstock_s4x3.jpg")
                    .placeholder(R.mipmap.ic_launcher)  //if loading image fails, this will show
                    .transform(new UtilFile.CropSquareTransformation())
                    .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                    .networkPolicy(NetworkPolicy.NO_CACHE, NetworkPolicy.NO_STORE)
                    .into(imageView);
        }
        else if(position == 3){
            textview.setBackgroundColor(Color.parseColor("#fff0f2"));
            Picasso.with(getContext())
                    .load("http://stopwatch.onlineclock.net/stopwatch.jpg")
                    .placeholder(R.mipmap.ic_launcher)  //if loading image fails, this will show
                    .transform(new UtilFile.CropSquareTransformation())
                    .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                    .networkPolicy(NetworkPolicy.NO_CACHE, NetworkPolicy.NO_STORE)
                    .into(imageView);
        }
        else if(position == 4){
            textview.setBackgroundColor(Color.parseColor("#ff7373"));
            Picasso.with(getContext())
                    .load("http://sites.psu.edu/siowfa15/wp-content/uploads/sites/29639/2015/09/Draw-an-Old-Fashioned-Alarm-Clock-Step-15.jpg")
                     .placeholder(R.mipmap.ic_launcher)  //if loading image fails, this will show
                    .transform(new UtilFile.CropSquareTransformation())
                    .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                    .networkPolicy(NetworkPolicy.NO_CACHE, NetworkPolicy.NO_STORE)
                    .into(imageView);
        }
        else if(position == 5){
            textview.setBackgroundColor(Color.parseColor("#efe99e"));
            Picasso.with(getContext())
                    .load("https://upload.wikimedia.org/wikipedia/commons/thumb/1/1e/Tom%27s_Restaurant%2C_NYC.jpg/220px-Tom%27s_Restaurant%2C_NYC.jpg")
                    .placeholder(R.mipmap.ic_launcher)  //if loading image fails, this will show
                    .transform(new UtilFile.CropSquareTransformation())
                    .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                    .networkPolicy(NetworkPolicy.NO_CACHE, NetworkPolicy.NO_STORE)
                    .into(imageView);
        }


        return convertView;
    }
}
