package apps.crevion.com.sqlitesample;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddProfileActivity extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dataHelper;
    private Button button1, button2;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profile);

        dataHelper = new DataHelper(this);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dataHelper.getWritableDatabase();
                db.execSQL("insert into profile(no, name, birth_date, gender, address) values('" +
                        editText1.getText().toString() + "','" +
                        editText2.getText().toString() + "','" +
                        editText3.getText().toString() + "','" +
                        editText4.getText().toString() + "','" +
                        editText5.getText().toString() + "')");

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
