package com.example.rgbbead;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    private  int piros,zold,kek;
    TextView color, textColor;
    SeekBar csuszkaPiros,csuszkaZold,csuszkaKek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        color = (TextView) findViewById(R.id.szinValats);
        textColor = (TextView) findViewById(R.id.szinmenyiseg);
        csuszkaPiros= (SeekBar) findViewById(R.id.prosCsuszka);
        csuszkaZold= (SeekBar) findViewById(R.id.zoldCsuszka);
        csuszkaKek= (SeekBar) findViewById(R.id.kekCsuszka);

        csuszkaPiros.setOnSeekBarChangeListener(this);
        csuszkaZold.setOnSeekBarChangeListener(this);
        csuszkaKek.setOnSeekBarChangeListener(this);

        frissites();


    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("piros",csuszkaPiros.getProgress());
        savedInstanceState.putInt("zold",csuszkaZold.getProgress());
        savedInstanceState.putInt("kek",csuszkaKek.getProgress());
        savedInstanceState.putString("textColor","("+piros+","+zold+","+kek+")");
        savedInstanceState.putInt("color",0xff000000+piros*0x10000+zold*0x100+kek);
        super.onSaveInstanceState(savedInstanceState);
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        piros=savedInstanceState.getInt("piros");
        zold=savedInstanceState.getInt("zold");
        kek=savedInstanceState.getInt("kek");
        color.setBackgroundColor(savedInstanceState.getInt("color"));
        textColor.setText(savedInstanceState.getString("textColor"));

    }
    private void frissites(){
        piros= csuszkaPiros.getProgress();
        zold= csuszkaZold.getProgress();
        kek= csuszkaKek.getProgress();
        textColor.setText("("+piros+","+zold+","+kek+")");
        color.setBackgroundColor(0xff000000+piros*0x10000+zold*0x100+kek);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        frissites();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
