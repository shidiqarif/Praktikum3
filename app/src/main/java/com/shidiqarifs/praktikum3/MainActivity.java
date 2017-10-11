package com.shidiqarifs.praktikum3;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static TextView t1,t2;
    static SeekBar s1;
    String Warna ;
    CheckBox bold,italic,underline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        diskSeekBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        t1 = (TextView) findViewById(R.id.texttenggah);
        switch (item.getItemId()){
            case R.id.action_merah:
                t1.setText("Warna Merah");
                t1.setTextColor(Color.RED);
                Warna = "Red";
                break;

            case R.id.action_hijau:
                t1.setText("Warna Hijau");
                t1.setTextColor(Color.GREEN);
                Warna = "Green";
                break;

            case R.id.action_biru:
                t1.setText("Warna BIRU");
                t1.setTextColor(Color.BLUE);
                Warna = "Blue";
                break;
        }
        return true;
    }

    public void diskSeekBar(){
        t1 = (TextView) findViewById(R.id.texttenggah);
        t2=(TextView) findViewById(R.id.labelmerah);
        s1=(SeekBar) findViewById(R.id.seek_merah);
        bold = (CheckBox) findViewById(R.id.bold);
        italic = (CheckBox) findViewById(R.id.italic);
        underline = (CheckBox) findViewById(R.id.underline);

        italic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(italic.isChecked()){
                    t1.setTypeface(null, Typeface.ITALIC);
                }else if(!italic.isChecked()){
                    t1.setTypeface(null, Typeface.NORMAL);
                }else{
                    t1.setTypeface(null, Typeface.NORMAL);
                }

            }
        });

        bold.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(bold.isChecked()){
                    t1.setTypeface(null, Typeface.BOLD);
                }else if(!bold.isChecked()){
                    t1.setTypeface(null, Typeface.NORMAL);
                }else{
                    t1.setTypeface(null, Typeface.NORMAL);
                }

            }
        });

        underline.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(underline.isChecked()){
                    t1.setPaintFlags(t1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                }else if(!underline.isChecked()){
                    t1.setPaintFlags(0);
                }else{
                    t1.setPaintFlags(0);
                }

            }
        });



        s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b){
                int color = 0;
                if (Warna.equals("Red")){
                    color = colorRed(i);
                    t1.setTextColor(color);
                    t2.setText(String.valueOf(i));
                }else if (Warna.equals("Blue")){
                    color = colorBlue(i);
                    t1.setTextColor(color);
                    t2.setText(String.valueOf(i));
                }else if (Warna.equals("Green")){
                    color = colorGreen(i);
                    t1.setTextColor(color);
                    t2.setText(String.valueOf(i));
                }else{
                    t1.setText("Silahkan Pilih Warna");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar){

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar){

            }
        });
    }

    private int colorRed(int Red) {
        int color = Color.rgb(Red, 0, 0);
        return color;
        // Do something with color
    }

    private int colorGreen(int Green) {
        int color = Color.rgb(0, Green, 0);
        return color;
        // Do something with color
    }

    private int colorBlue(int Blue) {
        int color = Color.rgb(0, 0, Blue);
        return color;
        // Do something with color
    }
}
