package com.cookandroid.totaltest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Switch swStart;
    EditText edtName, midTest, endTest, Test, Check;
    RadioGroup rgGrade;
    RadioButton rb1, rb2, rb3;
    Button calBtn, initBtn;
    LinearLayout linear;
    TableLayout table;
    int grade = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("최윤영 간단 학점 계산기");

        swStart = findViewById(R.id.swStart);
        edtName = findViewById(R.id.edtName);
        midTest = findViewById(R.id.midTest);
        endTest = findViewById(R.id.endTest);
        Test = findViewById(R.id.Test);
        Check = findViewById(R.id.Check);
        rgGrade = findViewById(R.id.rgGrade);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        calBtn = findViewById(R.id.calBtn);
        initBtn = findViewById(R.id.initBtn);
        linear = findViewById(R.id.linear);
        linear.setVisibility(View.INVISIBLE);
        table = findViewById(R.id.table);
        table.setVisibility(View.INVISIBLE);

        swStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    table.setVisibility(View.VISIBLE);
                    linear.setVisibility(View.VISIBLE);
                } else {
                    table.setVisibility(View.INVISIBLE);
                    linear.setVisibility(View.INVISIBLE);
                }
            }
        });

        calBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int mid = Integer.parseInt(midTest.getText().toString());
                int end = Integer.parseInt(endTest.getText().toString());
                int test = Integer.parseInt(Test.getText().toString());
                int check = Integer.parseInt(Check.getText().toString());
                String name = edtName.getText().toString();
                double total = (mid * 0.3) + (end * 0.3) + (test * 0.2) + (check * 0.2);
                String s = "";
                if(total >= 90 && total <= 100) {
                    s = "A 학점";
                } else if(total >= 80) {
                    s = "B 학점";
                } else if(total >= 70) {
                    s = "C 학점";
                } else if(total >= 60) {
                    s = "D 학점";
                } else {
                    s = "E 학점";
                }
                String out = grade + "학년 " + name + "님 총점 : " + total + "\n학점 : " + s;
                Toast.makeText(getApplicationContext(), out, Toast.LENGTH_SHORT).show();
            }
        });

        rgGrade.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.rb1: grade = 1; break;
                    case R.id.rb2: grade = 2; break;
                    case R.id.rb3: grade = 3; break;
                }
            }
        });

        initBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grade = 0;
                rgGrade.clearCheck();
                edtName.setText("");
                midTest.setText("0");
                endTest.setText("0");
                Test.setText("0");
                Check.setText("0");

            }
        });

    }
}