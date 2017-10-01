package kr.anima.xd.s.categorytest;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.listener.OnDateSetListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static kr.anima.xd.s.categorytest.DatePickerManager.*;

public class AddContentActivity extends AppCompatActivity implements View.OnClickListener, OnDateSetListener{

    TextView TV_Year, TV_Month, TV_Date;
    EditText ET_Title;
    LinearLayout LL_DatePicker;
    CheckBox CB_1, CB_2, CB_3, CB_4, CB_5, CB_6, CB_7, CB_8, CB_9;
    ArrayList<CheckBox> list=new ArrayList<>();

    private ArrayList<Item> items=new ArrayList<>();
    private DatePickerManager manager;

    private Intent fromMainIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_content);

        fromMainIntent=getIntent();
        init();
        manager=new DatePickerManager(this);

    }

    private void init(){
        TV_Year= (TextView) findViewById(R.id.TV_Year);
        TV_Month= (TextView) findViewById(R.id.TV_Month);
        TV_Date= (TextView) findViewById(R.id.TV_Date);
        ET_Title= (EditText) findViewById(R.id.ET_Title);
        LL_DatePicker= (LinearLayout) findViewById(R.id.LL_DatePicker);
        LL_DatePicker.setOnClickListener(this);
        for(int i=0; i<9; i++){
            CB_1= (CheckBox) findViewById(R.id.CB_1);
            findViewById(R.id.CB_1+i).setOnClickListener(this);
            list.add((CheckBox) findViewById(R.id.CB_1+i));
        }

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.LL_DatePicker:
                manager.show(getSupportFragmentManager(), TAG_YMD);
                break;
            case R.id.Btn_AddContent:

//                String title=ET_Title.getText().toString();
//                Boolean[] category=new Boolean[9];
//                for(int i=0; i<list.size(); i++){
//                    category[i]=false;
//                    if (list.get(i).isChecked()) category[i]=true;
//                }
////                items.add(new Item(selectDate, title, category));
//                setResult(Activity.RESULT_OK, fromMainIntent);
//                finish();
                break;
            case R.id.Btn_Cancel:
                setResult(Activity.RESULT_CANCELED, fromMainIntent);
                finish();
        }
    }

    @Override
    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
        Date date=new Date(millseconds);
        intentPutExtra(millseconds);
        TV_Year.setText(new SimpleDateFormat("yyyy").format(date));
        TV_Month.setText(new SimpleDateFormat("MM").format(date));
        TV_Date.setText(new SimpleDateFormat("dd").format(date));
//        getIntent().putExtra("Date", millseconds);
    }

    private void intentPutExtra(long date){
        fromMainIntent.putExtra("Date", date);
    }

    public void saveData(View v){
        fromMainIntent.putExtra("Title", ET_Title.getText().toString());
//        fromMainIntent.putExtra("Category", );
        setResult(Activity.RESULT_OK, fromMainIntent);
        finish();
        // TODO :: 카테고리 자료구조
    }


}
