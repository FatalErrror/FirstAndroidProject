package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button[] allButtons = new Button[16];
ImageButton backspace;
TextView showresult,shownumber;
char activ = ' ';
String firstNumb = "",secondNumb = "",resultNumb = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onStart(){
        super.onStart();
        backspace = findViewById(R.id.backspace);
        backspace.setOnClickListener(this);
        allButtons[0] = findViewById(R.id.ziro);
        allButtons[1] = findViewById(R.id.one);
        allButtons[2] = findViewById(R.id.two);
        allButtons[3] = findViewById(R.id.three);
        allButtons[4] = findViewById(R.id.four);
        allButtons[5] = findViewById(R.id.five);
        allButtons[6] = findViewById(R.id.six);
        allButtons[7] = findViewById(R.id.seven);
        allButtons[8] = findViewById(R.id.eght);
        allButtons[9] = findViewById(R.id.nine);
        allButtons[10] = findViewById(R.id.delit);
        allButtons[11] = findViewById(R.id.umnogit);
        allButtons[12] = findViewById(R.id.minus);
        allButtons[13] = findViewById(R.id.plus);
        allButtons[14] = findViewById(R.id.delete);
        allButtons[15] = findViewById(R.id.solve);
        showresult = findViewById(R.id.showResult);
        shownumber = findViewById(R.id.showNumber);
        for (int i = 0; i < 16; i++) {
            allButtons[i].setOnClickListener(this);
        }
    }
    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.delit:activ='/';if (resultNumb!="")firstNumb=resultNumb;show();break;
            case R.id.umnogit:activ='*';if (resultNumb!="")firstNumb=resultNumb;show();break;
            case R.id.minus:activ='-';if (resultNumb!="")firstNumb=resultNumb;show();break;
            case R.id.plus:activ='+';if (resultNumb!="")firstNumb=resultNumb;show();break;
            case R.id.delete:firstNumb="";secondNumb="";activ=' ';resultNumb="";show();break;
            case R.id.backspace:backspace();break;
            case R.id.solve:solve();break;
            default:switch (view.getId()){
                case R.id.ziro:number(0);break;
                case R.id.one:number(1);break;
                case R.id.two:number(2);break;
                case R.id.three:number(3);break;
                case R.id.four:number(4);break;
                case R.id.five:number(5);break;
                case R.id.six:number(6);break;
                case R.id.seven:number(7);break;
                case R.id.eght:number(8);break;
                case R.id.nine:number(9);break;
            }break;
        }
    }
    public void backspace(){//bug
        resultNumb="";
        try {
        if(activ == ' '){
            if(firstNumb.length()==1 || firstNumb=="")firstNumb="";else
            firstNumb = new String(firstNumb.toCharArray(),0,firstNumb.length()-1);

            show();
        }else{
            if(secondNumb==""){
                activ=' ';
                show();
            }else {
                if(secondNumb.length()==1)secondNumb="";else
                secondNumb = new String(secondNumb.toCharArray(),0,secondNumb.length()-1);

                show();
            }
        }
        }catch (Exception e){Toast.makeText(this,"backspace",Toast.LENGTH_SHORT).show();}
    }
    public void show(){
        if(activ == ' '){
            showresult.setText(firstNumb);
            shownumber.setText(null);
        }else{
            if(firstNumb=="")firstNumb="0";
            shownumber.setText(firstNumb);
            showresult.setText(activ+secondNumb);
        }
    }
    public void number(int numb){
        resultNumb="";
        if(activ == ' '){
            firstNumb+=numb;
        }else{
            if (activ=='/' && numb==0){
                Toast.makeText(this,"Делить на ноль нельзя",Toast.LENGTH_LONG).show();
            }else
            secondNumb+=numb;
        }
        show();
    }
    public void solve(){
        if (activ==' '){
            shownumber.setText(firstNumb);

            showresult.setText(firstNumb);
        }else {//bug
            int first=0,second=0,result=0;

                first = Integer.parseInt(firstNumb);
                if(secondNumb=="")secondNumb = activ=='/'||activ=='*'?"1":"0";
                second = Integer.parseInt(secondNumb);

            switch (activ)
            {
                case '/':result = first/second;break;
                case '*':result = first*second;break;
                case '-':result = first-second;break;
                case '+':result = first+second;break;
            }
            try {
            shownumber.setText(firstNumb+"\n"+activ+secondNumb);
            showresult.setText("= "+result);
            resultNumb = ""+result;
            firstNumb="";secondNumb="";activ=' ';
            }catch (Exception e){Toast.makeText(this,"solve",Toast.LENGTH_SHORT).show();}
        }

    }

}
