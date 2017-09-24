package kr.anima.xd.s.categorytest;


import java.util.Calendar;

import static kr.anima.xd.s.categorytest.Category.*;

/**
 * Created by PC on 2017-09-24.
 */

public class Item {

    long date;
    String title;
    Boolean[] category=new Boolean[9];
    Boolean isChecked;

    private Calendar calendar;

    public Item() {
        calendar=Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        date=calendar.getTimeInMillis();
        title="NO TITLE";
        isChecked=false;
    }

    public Item(long date, String title, Boolean[] category) {
        this.date = date;
        this.title = title;
        this.category = category;
    }

    public Item(long date, String title, Boolean[] category, Boolean isChecked) {
        this.date = date;
        this.title = title;
        this.category = category;
        this.isChecked = isChecked;
    }
}
