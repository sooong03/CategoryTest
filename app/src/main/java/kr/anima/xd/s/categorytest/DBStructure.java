package kr.anima.xd.s.categorytest;

import android.provider.BaseColumns;

/**
 * Created by PC on 2017-10-01.
 */

public class DBStructure {

    public static abstract class TestEntry implements BaseColumns {
        public static final String TABLE_NAME="test_entry";
        public static final String COLUMN_TITLE="test_title";
        public static final String COLUMN_DATE="test_date";
        public static final String COLUMN_TIMESTAMP="test_timestamp";
    }
}
