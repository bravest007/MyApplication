package com.example.designer.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends Activity {

    TextView textView1,dialogtext2;
    Button button1;
    EditText editText1;
    DatePicker datePicker;
    View dialogView;
    String fileName;

    Calendar cal ;

    int cYear ;
    int cMonth;
    int cDay ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("정원영 diary");

        textView1 = (TextView) findViewById(R.id.textView1);
        button1 = (Button) findViewById(R.id.button1);
        editText1 = (EditText) findViewById(R.id.editText1);


        final String strSDpath = Environment.getExternalStorageDirectory().getAbsolutePath();
        final File myDir = new File(strSDpath + "/mydiary");
        if(myDir.exists() != true) {
            myDir.mkdirs();
        }


        Calendar cal = Calendar.getInstance();
        cYear = cal.get(Calendar.YEAR);
        cMonth = cal.get(Calendar.MONTH);
        cDay = cal.get(Calendar.DAY_OF_MONTH);
        textView1.setText(cYear+"년"+Integer.toString(cMonth+1)+"월"+cDay+"일");
        fileName = Integer.toString(cYear) + "_" + Integer.toString(cMonth +1) +"_"
                +Integer.toString(cDay) + ".txt";
        String str = readDiary(fileName);
        editText1.setText(str);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    FileOutputStream outFs = openFileOutput(fileName, Context.MODE_WORLD_WRITEABLE);
                    String str = editText1.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(), fileName + "이 저장되었습니다.", Toast.LENGTH_SHORT).show();

                    /*
                    FileOutputStream fos = new FileOutputStream(strSDpath + "/mydiary/" + fileName);
                    String str = editText1.getText().toString();
                    fos.write(str.getBytes());
                    fos.close();
                    Toast.makeText(getApplicationContext(), fileName + "이 저장됨", Toast.LENGTH_SHORT).show();
                    */
                } catch (IOException e) {
                }
            }
        });



        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);


                datePicker = (DatePicker)  dialogView.findViewById(R.id.datePicker1);

                datePicker.init(cYear, cMonth,cDay, new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {



                    }
                });
                dlg.setTitle("사용자 정보 입력");
                dlg.setView(dialogView);



                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        int year = datePicker.getYear();
                        int month = datePicker.getMonth();
                        int date = datePicker.getDayOfMonth();

                        fileName = Integer.toString(year) + "_" + Integer.toString(month +1) +"_"
                                +Integer.toString(date) + ".txt";
                        textView1.setText(Integer.toString(year)+"년" +Integer.toString(month+1)+"월"+Integer.toString(date)+"일");
                        String str = readDiary(fileName);
                        editText1.setText(str);




                    }


                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {



                    }
                });
                dlg.show();

            }
        });
    }

    String readDiary(String fName){
        String diaryStr = null;
        FileInputStream inFs;
        try {

            inFs = openFileInput(fName);
            byte[] txt = new byte[500];
            inFs.read(txt);
            inFs.close();
            diaryStr = (new String(txt)).trim();
        }
        catch (IOException e){
            editText1.setHint("일기없음");
        }
        return diaryStr;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        // Inflate the menu; this adds items to the action bar if it is present.
        mInflater.inflate(R.menu.menu_content, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.read:
                String str = readDiary(fileName);
                editText1.setText(str);
                return true;
            case R.id.delete:
                dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog2, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);

                dialogtext2 =(TextView) dialogView.findViewById(R.id.dialogText2);

                dlg.setTitle("일기 삭제");

                dialogtext2.setText(textView1.getText().toString() + "일기를 삭제하시겠습니까?");

                dlg.setView(dialogView);

                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        File file = new File("/data/data/com.example.user.myapplication/files/" + fileName);
                        file.delete();
                        editText1.setText("");
                        Toast.makeText(getApplicationContext(), "삭제 했습니다.", Toast.LENGTH_SHORT).show();

                        //String strSDpath = Environment.getExternalStorageDirectory().getAbsolutePath();
                        //File file = new File(strSDpath + "/mydiary/" + fileName);
                        //file.delete();
                        //Toast.makeText(getApplicationContext(), "삭제했습니다.", Toast.LENGTH_SHORT).show();
                    }
                });

                dlg.setNegativeButton("취소", null);

                dlg.show();

            case R.id.large:
                editText1.setTextSize(30.0f);
                break;
            case R.id.medium:
                editText1.setTextSize(20.0f);
                break;
            case R.id.small:
                editText1.setTextSize(10.0f);
                break;


        }
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}