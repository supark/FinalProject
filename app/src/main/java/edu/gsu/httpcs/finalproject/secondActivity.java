package edu.gsu.httpcs.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import butterknife.ButterKnife;
import edu.gsu.httpcs.finalproject.adapter.ImageAdapter;

public class secondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        list();

    }
    public void list(){
    String[] items = {"Greeting", "Food Gallery", "Menu", "Stopwatch",  "Alarm Clock", "Restaurant Information"};
    ListAdapter adapter  = new ImageAdapter(this, items);
    //store real contents like a, b, c
    ListView listview = (ListView) findViewById(R.id.listView);
        listview.setAdapter(adapter);  //store adapter into listview

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position) {
                case 0:
                    Intent intent = new Intent(secondActivity.this, ThirdActivity.class);
                    startActivity(intent);   //query, to go to activity, to store startActivity method, this is for first listView
                    break;
                case 1:
                    Intent intent1 = new Intent(secondActivity.this, ViewPagerActivity.class);
                    startActivity(intent1);   //query, to go to activity, to store startActivity method, this is for first listView
                    break;
                case 2:
                    Intent intent2 = new Intent(secondActivity.this, RadioGroupActivity.class);
                    startActivity(intent2);   //query, to go to activity, to store startActivity method, this is for first listView
                    break;
                case 3:
                    Intent intent3 = new Intent(secondActivity.this, StopWatchActivity.class);
                    startActivity(intent3);   //query, to go to activity, to store startActivity method, this is for first listView
                    break;
                case 4:
                    Intent intent4 = new Intent(secondActivity.this, AlarmClockActivity.class);
                    startActivity(intent4);   //query, to go to activity, to store startActivity method, this is for first listView
                    break;
                case 5:
                    Intent intent5 = new Intent(secondActivity.this, GoogleMapActivity.class);
                    startActivity(intent5);   //query, to go to activity, to store startActivity method, this is for first listView
                    break;
//                case 6:
//                    Intent intent6 = new Intent(secondActivity.this, MapsActivity.class);
//                    startActivity(intent6);   //query, to go to activity, to store startActivity method, this is for first listView
//                    break;
                default:
            }
        }
    });
    }
}
