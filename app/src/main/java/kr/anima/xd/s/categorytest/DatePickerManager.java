package kr.anima.xd.s.categorytest;

import android.support.v4.app.FragmentManager;

import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;

/**
 * Created by PC on 2017-09-25.
 */

public class DatePickerManager {

    public static final String TAG_YMD="year_month_day";

    TimePickerDialog timePickerDialog;


    public DatePickerManager(OnDateSetListener listener) {

        long tenYears = 10L * 365 * 1000 * 60 * 60 * 24L;
        timePickerDialog=new TimePickerDialog.Builder()
                .setCallBack(listener)
                .setCancelStringId("Cancel")
                .setSureStringId("Sure")
                .setDayText("일")
                .setMonthText("월")
                .setYearText("년")
                .setThemeColor(R.color.colorAccent)
                .setMinMillseconds(System.currentTimeMillis()-(tenYears*100))
                .setMaxMillseconds(System.currentTimeMillis()+(tenYears*100))
                .setCurrentMillseconds(System.currentTimeMillis())
                .setType(Type.YEAR_MONTH_DAY)
                .build();
    }

    public void show(FragmentManager fm, String tag){
        timePickerDialog.show(fm, tag);
    }


}
