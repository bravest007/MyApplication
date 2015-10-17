package com.example.user.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv, btnRem;
    TextView textResult;
    String num1, num2;
    Float result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);
        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button)findViewById((R.id.BtnMul));
        btnDiv = (Button)findViewById((R.id.BtnDiv));
        btnRem = (Button)findViewById((R.id.BtnRem));
        textResult = (TextView) findViewById((R.id.TextResult));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if( num1.isEmpty()|| num2.isEmpty()||(num1.isEmpty()&&num2.isEmpty())) {
                    Toast.makeText(getApplicationContext(), "값이 없습니다", Toast.LENGTH_LONG).show();



                }

                else {

                    result = Float.parseFloat(num1) + Float.parseFloat(num2);
                    textResult.setText("계산 결과: " +result.toString());

                }

            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if( num1.isEmpty()|| num2.isEmpty()||(num1.isEmpty()&&num2.isEmpty())) {
                    Toast.makeText(getApplicationContext(),"값이 없습니다",Toast.LENGTH_LONG).show();



                }

                else {

                    result = Float.parseFloat(num1) - Float.parseFloat(num2);
                    textResult.setText("계산 결과: " +result.toString());

                }

            }


        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if( num1.isEmpty()|| num2.isEmpty()||(num1.isEmpty()&&num2.isEmpty())) {
                    Toast.makeText(getApplicationContext(),"값이 없습니다",Toast.LENGTH_LONG).show();



                }
                else if(Float.parseFloat(num1)==0 || Float.parseFloat(num2)==0){
                    Toast.makeText(getApplicationContext(), "오류입니다", Toast.LENGTH_LONG).show();
                }

                else {

                    result = Float.parseFloat(num1) * Float.parseFloat(num2);
                    textResult.setText("계산 결과: " +result.toString());

                }

            }


        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if( num1.isEmpty()|| num2.isEmpty()||(num1.isEmpty()&&num2.isEmpty())) {
                    Toast.makeText(getApplicationContext(), "값이 없습니다", Toast.LENGTH_LONG).show();
                }

                else if(Float.parseFloat(num1)==0 || Float.parseFloat(num2)==0){
                    Toast.makeText(getApplicationContext(), "오류입니다", Toast.LENGTH_LONG).show();
                }




                else {

                    result = Float.parseFloat(num1) / Float.parseFloat(num2);
                    textResult.setText("계산 결과: " +result.toString());

                }

            }


        });

        btnRem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if( num1.isEmpty()|| num2.isEmpty()||(num1.isEmpty()&&num2.isEmpty())) {
                    Toast.makeText(getApplicationContext(), "값이 없습니다", Toast.LENGTH_LONG).show();


                }
                else if(Float.parseFloat(num1)==0 || Float.parseFloat(num2)==0){
                    Toast.makeText(getApplicationContext(), "오류입니다", Toast.LENGTH_LONG).show();
                }

                else {

                    result = Float.parseFloat(num1) % Float.parseFloat(num2);
                    textResult.setText("계산 결과: " +result.toString());

                }

            }


        });



    }

}
