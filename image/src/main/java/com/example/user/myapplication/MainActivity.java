package com.example.user.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

public class MainActivity extends Activity {

    Switch sw;
    RadioGroup radioGroup;
    RadioButton r1, r2, r3;
    ImageView image;
    Button ex, reStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sw = (Switch) findViewById(R.id.Sw);
        radioGroup = (RadioGroup) findViewById(R.id.RadioGroup);
        r1 = (RadioButton) findViewById(R.id.R1);
        r2 = (RadioButton) findViewById(R.id.R2);
        r3 = (RadioButton) findViewById(R.id.R3);
        image = (ImageView) findViewById(R.id.Image);
        ex = (Button) findViewById(R.id.Ex);
        reStart = (Button) findViewById(R.id.ReStart);


        sw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sw.isChecked()) {
                    radioGroup.setVisibility(View.VISIBLE);
                    r1.setVisibility(View.VISIBLE);
                    r2.setVisibility(View.VISIBLE);
                    r3.setVisibility(View.VISIBLE);
                    image.setVisibility(View.INVISIBLE);
                    ex.setVisibility(View.VISIBLE);
                    reStart.setVisibility(View.VISIBLE);

                } else if (sw.isChecked() == false) {
                    radioGroup.setVisibility(View.INVISIBLE);
                    r1.setVisibility(View.INVISIBLE);
                    r2.setVisibility(View.INVISIBLE);
                    r3.setVisibility(View.INVISIBLE);
                    image.setVisibility(View.INVISIBLE);
                    ex.setVisibility(View.INVISIBLE);
                    reStart.setVisibility(View.INVISIBLE);
                }


            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.R1:
                        image.setImageResource(R.drawable.jelly);
                        image.setVisibility(View.VISIBLE);
                        break;
                    case R.id.R2:
                        image.setImageResource(R.drawable.kitket);
                        image.setVisibility(View.VISIBLE);
                        break;
                    case R.id.R3:
                        image.setImageResource(R.drawable.roly);
                        image.setVisibility(View.VISIBLE);
                        break;


                }

            }


        });
        ex.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }


        });
        reStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sw.setChecked(false);
                radioGroup.clearCheck();
                radioGroup.setVisibility(View.INVISIBLE);
                r1.setVisibility(View.INVISIBLE);
                r2.setVisibility(View.INVISIBLE);
                r3.setVisibility(View.INVISIBLE);
                image.setVisibility(View.INVISIBLE);
                ex.setVisibility(View.INVISIBLE);
                reStart.setVisibility(View.INVISIBLE);


            }


        });
    }


}
