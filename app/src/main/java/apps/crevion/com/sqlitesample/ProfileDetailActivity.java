package apps.crevion.com.sqlitesample;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileDetailActivity extends AppCompatActivity {

    protected Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_detail);

        DataHelper dataHelper = new DataHelper(this);
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        TextView textView5 = (TextView) findViewById(R.id.textView5);

        SQLiteDatabase db = dataHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM profile WHERE name = '" +
                getIntent().getStringExtra("name") + "'", null);
        cursor.moveToFirst();
        if(cursor.getCount() > 0 ){
            cursor.moveToPosition(0);
            textView1.setText(cursor.getString(0));
            textView2.setText(cursor.getString(1));
            textView3.setText(cursor.getString(2));
            textView4.setText(cursor.getString(3));
            textView5.setText(cursor.getString(4));
        }

        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
