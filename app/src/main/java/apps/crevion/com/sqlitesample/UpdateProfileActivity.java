package apps.crevion.com.sqlitesample;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateProfileActivity extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dataHelper;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        dataHelper = new DataHelper(this);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);

        SQLiteDatabase db = dataHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM profile WHERE name = '" +
                getIntent().getStringExtra("name") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            editText1.setText(cursor.getString(0));
            editText2.setText(cursor.getString(1));
            editText3.setText(cursor.getString(2));
            editText4.setText(cursor.getString(3));
            editText5.setText(cursor.getString(4));
        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dataHelper.getWritableDatabase();
                String sql = "update profile set name='"+
                        editText2.getText().toString() +"', birth_date='" +
                        editText3.getText().toString()+"', gender='"+
                        editText4.getText().toString() +"', address='" +
                        editText5.getText().toString() + "' where no='" +
                        editText1.getText().toString()+"'";
                db.execSQL(sql);

                Toast.makeText(getApplicationContext(), "Successfully", Toast.LENGTH_LONG).show();
                MainActivity.mainActivity.refreshList();
                finish();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
