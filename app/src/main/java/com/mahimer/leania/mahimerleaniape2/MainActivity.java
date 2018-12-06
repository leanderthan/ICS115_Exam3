package com.mahimer.leania.mahimerleaniape2;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText fname,age,gender;
    DBHelper helper = new DBHelper(this);
    Cursor table;
    TextView name, ag, gen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fname = findViewById(R.id.etName);
        age = findViewById(R.id.etAge);
        gender = findViewById(R.id.etGender);

        name = findViewById(R.id.tvName);
        ag = findViewById(R.id.tvAge);
        gen = findViewById(R.id.tvGender);
    }

    public void addRecord(View v){
        String f = fname.getText().toString();
        String g = gender.getText().toString();
        int a = Integer.parseInt(age.getText().toString());
        boolean inserted = helper.insert(f,a,g);
        if (inserted == true){
            Toast.makeText(this, "Record inserted", Toast.LENGTH_LONG).show();
        } else
            Toast.makeText(this, "Record not inserted", Toast.LENGTH_LONG).show();
    }

    public void select(View v){
        String f = fname.getText().toString();
        table = helper.selectRecord(f);
    }
    public void data(){
        name.setText(table.getString(1));
        ag.setText(table.getString(2));
        gen.setText(table.getString(3));
    }
}
