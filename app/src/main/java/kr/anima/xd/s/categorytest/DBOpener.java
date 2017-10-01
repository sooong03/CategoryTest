package kr.anima.xd.s.categorytest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by PC on 2017-10-01.
 */

public class DBOpener extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "test.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";

    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_TOPIC_ENTRIES =
            "CREATE TABLE " + DBStructure.TestEntry.TABLE_NAME + " (" +
                    DBStructure.TestEntry._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT," +
                    DBStructure.TestEntry.COLUMN_TITLE + TEXT_TYPE + COMMA_SEP +
                    DBStructure.TestEntry.COLUMN_DATE + INTEGER_TYPE + COMMA_SEP +
                    DBStructure.TestEntry.COLUMN_TIMESTAMP + INTEGER_TYPE +
                    " )";

    public DBOpener(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_TOPIC_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
