package com.example.petupsapk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class page2 extends AppCompatActivity {
    Button b;
    EditText n,m;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final  String KEY_NAME = "name";
    private static final String KEY_ADDRESS = "address";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        b=(Button)findViewById(R.id.button3);
        n=(EditText) findViewById(R.id.txtname);
        m=(EditText) findViewById(R.id.txtaddress);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        String name = sharedPreferences.getString(KEY_NAME, null) ;

        if (name!= null){
            Intent intent = new Intent(page2.this,page3.class);
            startActivity(intent);


        }
        b.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putString(KEY_NAME, n.getText().toString());
                editor.putString(KEY_ADDRESS , m.getText().toString());

                editor.apply();

                Intent intent = new Intent( page2.this, page3.class);
                startActivity(intent);

                Toast.makeText(page2.this, "HORHEY!!", Toast.LENGTH_SHORT).show();





            }
        });
    }
}