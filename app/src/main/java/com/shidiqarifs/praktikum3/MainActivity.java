package com.shidiqarifs.praktikum3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static TextView t1,t2;
    static SeekBar s1;

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
                t1.setTextColor(Color.RED);
                break;

            case R.id.action_hijau:
                t1.setTextColor(Color.GREEN);
                break;

            case R.id.action_biru:
                t1.setTextColor(Color.BLUE);
                break;
        }
        return true;
    }

    public void diskSeekBar(){
        t2=(TextView) findViewById(R.id.labelmerah);
        s1=(SeekBar) findViewById(R.id.seek_merah);
        s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b){
                t2.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar){

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar){

            }
        });
    }
}
