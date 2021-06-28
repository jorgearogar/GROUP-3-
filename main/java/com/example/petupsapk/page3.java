package com.example.petupsapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class page3 extends AppCompatActivity {
    TextView textView_name, textView_place;
    Button button_logout;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final  String KEY_NAME = "name";
    private static final String KEY_ADDRESS = "address";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        textView_name = (TextView)findViewById(R.id.pangalan);
        textView_place = (TextView)findViewById(R.id.lugar);
        button_logout =(Button)findViewById(R.id.button4);

       sharedPreferences = getSharedPreferences(SHARED_PREF_NAME , MODE_PRIVATE);

       String name = sharedPreferences.getString(KEY_NAME,  null);
       String address = sharedPreferences.getString(KEY_ADDRESS, null);

       if (name !=null || address != null){

           textView_name.setText("SHOP NAME = " +name);
           textView_place.setText("SHOP PLACE = "+address);
       }


       button_logout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               SharedPreferences.Editor editor = sharedPreferences.edit();
               editor.clear();
               editor.commit();
               Toast.makeText(page3.this,
                       "SALAMAAAAAAATTTT ",
                       Toast.LENGTH_SHORT).show();
               finish();
           }
       });
            }
        }
