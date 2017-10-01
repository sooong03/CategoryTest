package kr.anima.xd.s.categorytest;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by PC on 2017-10-01.
 */

public class DBManager {


    public static final String RESULT_SUCCESSFUL="SUCCESSFUL";
    public static final String RESULT_FAIL="FAIL";


    private Context context;
    private SQLiteDatabase db;
    private DBOpener opener;

    public DBManager(Context context) {
        this.context = context;
    }

    public DBManager(SQLiteDatabase db) {
        this.db = db;
    }

    public void openDB(){
        opener=new DBOpener(context);
        this.db=opener.getWritableDatabase();
    }

    public void closeDB(){
        opener.close();
    }

    public long insertTest(String title, long date, long timestamp){
        return db.insert(title, null, this.createPurposeContentValues(title, date, timestamp));
    }

    public ContentValues createPurposeContentValues(String title, long date, long timestamp){
        ContentValues values=new ContentValues();
        values.put(DBStructure.TestEntry.COLUMN_TITLE, title);
        values.put(DBStructure.TestEntry.COLUMN_DATE, date);
        values.put(DBStructure.TestEntry.COLUMN_TIMESTAMP, timestamp);

        return values;
    }
}
