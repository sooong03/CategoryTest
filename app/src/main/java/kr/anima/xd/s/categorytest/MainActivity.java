package kr.anima.xd.s.categorytest;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView TV_Year, TV_Month, TV_Date, TV_DayOfWeek;
    RecyclerView RV_List;
    FloatingActionButton FAB;

    // Intent
    public final int ADD_CONTENT=0;

    // Set Date
    private Calendar calendar;

    // RecyclerView
    private ArrayList<Item> list=new ArrayList<>();
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init(){
        TV_Year= (TextView) findViewById(R.id.TV_Year);
        TV_Month= (TextView) findViewById(R.id.TV_Month);
        TV_Date= (TextView) findViewById(R.id.TV_Date);
        TV_DayOfWeek= (TextView) findViewById(R.id.TV_DayOfWeek);
        RV_List= (RecyclerView) findViewById(R.id.RV_List);
        FAB= (FloatingActionButton) findViewById(R.id.FAB);
        FAB.setOnClickListener(this);

        initCurrentDate();

        RV_List.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter=new MyAdapter(list);
        RV_List.setAdapter(adapter);
    }

    private void initCurrentDate(){
        calendar=Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        TV_Year.setText(calendar.get(Calendar.YEAR)+"");
        TV_Month.setText(calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.UK));
        TV_Date.setText(calendar.get(Calendar.DATE)+"");
        TV_DayOfWeek.setText(calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.UK));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.FAB:
                Intent addContentIntent=new Intent(MainActivity.this, AddContentActivity.class);
                startActivityForResult(addContentIntent, ADD_CONTENT);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case ADD_CONTENT:
                switch (resultCode){
                    case Activity.RESULT_OK:
                        String title=data.getStringExtra("Title");
                        long date=data.getLongExtra("Date", 0);
                        long timestamp=calendar.getTimeInMillis();

                        insertDB(title, date, timestamp);
                        list.add(new Item(data.getLongExtra("Date", 0), data.getStringExtra("Title")));
                        adapter.notifyDataSetChanged();
                        break;
                    case Activity.RESULT_CANCELED:
                        break;
                }
                break;
        }
    }

    private void insertDB(String title, long date, long timestamp){
        DBManager dbManager=new DBManager(MainActivity.this);
        dbManager.openDB();

        dbManager.insertTest(title, 1, 1);
        dbManager.closeDB();
    }





}
