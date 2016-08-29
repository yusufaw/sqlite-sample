package apps.crevion.com.sqlitesample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by yusufaw on 23/08/16.
 */

public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "profile.db";
    private static final int DATABASE_VERSION = 1;

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table profile(no integer primary key, name text null, birth_date text null, gender text null, address text null);";
        Log.d("Data", "onCreate: " + sql);
        sqLiteDatabase.execSQL(sql);

        sql = "INSERT INTO profile (no, name, birth_date, gender, address) VALUES ('1', 'Darsiwan', '1996-07-12', 'Laki-laki','Indramayu');";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
