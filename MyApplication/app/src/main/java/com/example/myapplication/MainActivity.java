package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{
Button button;
RadioGroup radioGroup;
RadioButton[] Buttons = new RadioButton[5];
EditText editText1,editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.startbutton);

        editText1 = (EditText) findViewById(R.id.etxt1);
        editText2 = (EditText) findViewById(R.id.etxt2);
        button.setOnClickListener(this);

        editText1.setOnClickListener(this);
        editText2.setOnClickListener(this);
        ImageView imv1 = findViewById(R.id.imagev);
        imv1.setImageResource(R.drawable.crosd);
        ImageView imv2 = findViewById(R.id.imagev1);
        imv2.setImageResource(R.drawable.circled);
        Buttons[0] = findViewById(R.id.radioButton0);
        Buttons[1] = findViewById(R.id.radioButton1);
        Buttons[2] = findViewById(R.id.radioButton2);
        Buttons[3] = findViewById(R.id.radioButton3);
        Buttons[4] = findViewById(R.id.radioButton4);
        radioGroup = new RadioGroup(Buttons);
    }

    @Override
    public void onClick(View v) {


        if(v.getId() == R.id.startbutton){
            Intent I;
            switch(radioGroup.isActivID){
                case R.id.radioButton0: I = new Intent(MainActivity.this,GameTree_on_Tree.class);break;
                case R.id.radioButton1: I = new Intent(MainActivity.this,GameTree_on_Tree.class);break;
                case R.id.radioButton2: I = new Intent(MainActivity.this,GameTree_on_Tree.class);break;
                case R.id.radioButton3: I = new Intent(MainActivity.this,GameTree_on_Tree.class);break;
                case R.id.radioButton4: I = new Intent(MainActivity.this,GameTree_on_Tree.class);break;
                default: I = new Intent(MainActivity.this,GameTree_on_Tree.class);
            }
            String[] PlayerName = new String[] {editText1.getText().toString(),editText2.getText().toString()};
            I.putExtra("PlayerName",PlayerName);
            startActivity(I);

        }
    }
}
