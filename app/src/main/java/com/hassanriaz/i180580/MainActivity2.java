package com.hassanriaz.i180580;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView tv;
    ImageView add;
    SharedPreferences mpref;
    SharedPreferences.Editor prefEditor;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mpref=getSharedPreferences("count",MODE_PRIVATE);
        tv=findViewById(R.id.tv);
        add=findViewById(R.id.add);
        prefEditor= mpref.edit();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                tv.setText(count);

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        prefEditor.putInt("count",0);
        prefEditor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        count=mpref.getInt("count",count);
        tv.setText(count);
    }
}