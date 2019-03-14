package com.acer.countappsp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button black,red,blue,green;
    int c=0;
    private int colorCode;
    SharedPreferences sp;
    private String spFileName = "com.acer.countappsp";
    private String colorKey = "colorkey";
    private String countKey = "countkey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv);
        black=findViewById(R.id.B1);
        red=findViewById(R.id.B2);
        blue=findViewById(R.id.B3);
        green=findViewById(R.id.B4);

        sp =getSharedPreferences(spFileName,MODE_PRIVATE);
        if (sp != null){
            c = sp.getInt(countKey,c);
            tv.setText(String.valueOf(c));
            colorCode = sp.getInt(colorKey,colorCode);
            if (colorCode != 0){
                tv.setBackgroundColor(colorCode);
            }
        }




    }

    public void count(View view) {
        c++;
        tv.setText(String.valueOf(c));
    }

    public void reset(View view) {
        c=0;
        tv.setText(""+c);
        int cocolor=getResources().getColor(R.color.ash);
        tv.setBackgroundColor(cocolor);
    }

    public void black(View view) {
        int coCode= getResources().getColor(R.color.black);
        tv.setBackgroundColor(coCode);
        colorCode=coCode;

    }

    public void red(View view) {
        int coCode= getResources().getColor(R.color.red);
        tv.setBackgroundColor(coCode);
        colorCode=coCode;

    }

    public void blue(View view) {
        int coCode= getResources().getColor(R.color.blue);
        tv.setBackgroundColor(coCode);
        colorCode=coCode;
    }

    public void green(View view) {
        int coCode= getResources().getColor(R.color.green);
        tv.setBackgroundColor(coCode);
        colorCode=coCode;
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor editor = sp.edit();

        editor.putInt(countKey, c);
        editor.putInt(colorKey, colorCode);
        editor.apply();
        Toast.makeText(this,"count:"+c+"\n"+colorCode+"\n Successfully Saved in SP", Toast.LENGTH_SHORT).show();


    }
}
