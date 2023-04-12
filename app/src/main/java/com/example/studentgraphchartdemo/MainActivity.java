package com.example.studentgraphchartdemo;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextNum,
            editTextA,
            editTextB,
            editTextC,
            editTextD,
            editTextF;

    //Android IDs for EditTexts declared. From editTextNum to editTextF
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//XML file context
        editTextNum=findViewById(R.id.editTextNum);
        editTextA=findViewById(R.id.editTextA);
        editTextB=findViewById(R.id.editTextB);
        editTextC=findViewById(R.id.editTextC);
        editTextD=findViewById(R.id.editTextD);
        editTextF=findViewById(R.id.editTextF);
//FindViewByIDs declared
        btn=findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float a,b,c,d,f,totalStudent;
                totalStudent=Integer.parseInt(editTextNum.getText().toString());
                a=Integer.parseInt(editTextA.getText().toString());
                b=Integer.parseInt(editTextB.getText().toString());
                c=Integer.parseInt(editTextC.getText().toString());
                d=Integer.parseInt(editTextD.getText().toString());
                f=Integer.parseInt(editTextF.getText().toString());

                a=a/totalStudent*100;

                b=b/totalStudent*100;

                c=c/totalStudent*100;

                d=d/totalStudent*100;

                f=f/totalStudent*100;

                //As instructed, if there were to be say  20 students in the group "A" and the total number of students is 50,
                // the percentage for this "A" group is 20/50*100 = 40%//

                Context context = getApplicationContext();
                String text = "Here is the grade percentage distribution for the students:\n"

                        +"GroupA: "+a+"\nGroupB: "+b+"\nGroupC: "+c+"\nGroupD: "+d+"\nGroupF: "+f;

                int duration = Toast.LENGTH_LONG;

                LayoutInflater inflater = getLayoutInflater();
//The grade percentage is calculated and sent through via a Toast file. The message displays the calculation
                //of the ratios correctly
                View toastRoot = inflater.inflate(R.layout.toastfile, null);
                TextView tv = (TextView) toastRoot.findViewById(R.id.toasttext);
                tv.setText(text); tv.setWidth(500); tv.setHeight(500);
                tv.setTextColor(Color.parseColor("Black")); Toast toast = new Toast(context);
                toast.setView(toastRoot); toast.show();
                toast.setDuration(Toast.LENGTH_LONG);
                //Intent for MainActivity/Fill in sheet to be transferred over to the generated chart
                Intent i= new Intent(MainActivity.this, GradeChart.class);
                i.putExtra("Number of Students",Float.toString(totalStudent));
                i.putExtra("GroupA",Float.toString(a));
                i.putExtra("GroupB",Float.toString(b));
                i.putExtra("GroupC",Float.toString(c));
                i.putExtra("GroupD",Float.toString(d));
                i.putExtra("GroupF",Float.toString(f));
                startActivity(i);
            }
        });
    }
}