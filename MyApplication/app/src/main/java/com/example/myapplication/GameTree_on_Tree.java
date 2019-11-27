package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameTree_on_Tree extends Activity implements View.OnClickListener{
    String FirstPlayerName,SecondPlayerName;
    byte schet = 0;
    boolean firststep = true;
    boolean out = false;
    TextView textView;
    byte[][] matrix = new byte[4][4];
    ImageView[][] ImageMatrix = new ImageView[4][4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tree_on_tree);

        String[] PlayerName = getIntent().getStringArrayExtra("PlayerName");
        FirstPlayerName =  PlayerName[0];
        SecondPlayerName = PlayerName[1];
        textView = findViewById(R.id.textView);
        textView.setText("Сейчас ходит "+FirstPlayerName);
        ImageMatrix[1][1] = findViewById(R.id.imageView);
        ImageMatrix[1][2] = findViewById(R.id.imageView2);
        ImageMatrix[1][3] = findViewById(R.id.imageView3);
        ImageMatrix[2][1] = findViewById(R.id.imageView4);
        ImageMatrix[2][2] = findViewById(R.id.imageView5);
        ImageMatrix[2][3] = findViewById(R.id.imageView6);
        ImageMatrix[3][1] = findViewById(R.id.imageView7);
        ImageMatrix[3][2] = findViewById(R.id.imageView8);
        ImageMatrix[3][3] = findViewById(R.id.imageView9);
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                ImageMatrix[i][j].setOnClickListener(this);
                ImageMatrix[i][j].setImageResource(R.drawable.empty);
            }
        }

    }
    void end(byte who){
        textView.setText("Ну чтож, ничья."+"");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                ImageMatrix[i][j].setBackgroundColor(getColor(R.color.colorAccent));
            }
        }
        //Toast.makeText(this,"Ничья",Toast.LENGTH_LONG).show();
        out = true;
    }
    void end(byte who,int[] x,int[] y){
        ImageMatrix[x[0]][y[0]].setBackgroundColor(getColor(R.color.colorPrimary));
        ImageMatrix[x[1]][y[1]].setBackgroundColor(getColor(R.color.colorPrimary));
        ImageMatrix[x[2]][y[2]].setBackgroundColor(getColor(R.color.colorPrimary));
        textView.setText("Победил "+(who==1?FirstPlayerName:SecondPlayerName));
        //Toast.makeText(this,"Выйграл "+who,Toast.LENGTH_LONG).show();
        out = true;
    }
    void check(){
        if(matrix[2][2]!=0&&(matrix[2][2]==matrix[2][1]&&matrix[2][2]==matrix[2][3])){
            end(matrix[2][2],new int[] {2,2,2},new int[] {1,2,3});
        }else
        if(matrix[2][2]!=0&&(matrix[2][2]==matrix[1][1]&&matrix[2][2]==matrix[3][3])){

            end(matrix[2][2],new int[] {2,1,3},new int[] {2,1,3});
        }else
        if(matrix[1][1]!=0&&(matrix[1][1]==matrix[2][1]&&matrix[1][1]==matrix[3][1])){
            end(matrix[1][1],new int[] {1,2,3},new int[] {1,1,1});
        }else
        if(matrix[3][3]!=0&&(matrix[3][3]==matrix[3][2]&&matrix[3][3]==matrix[3][1])){
            end(matrix[3][3],new int[] {3,3,3},new int[] {3,2,1});
        }else
        if(matrix[2][2]!=0&&(matrix[2][2]==matrix[1][2]&&matrix[2][2]==matrix[3][2])){
            end(matrix[2][2],new int[] {2,1,3},new int[] {2,2,2});
        }else
        if(matrix[2][2]!=0&&(matrix[2][2]==matrix[1][3]&&matrix[2][2]==matrix[3][1])){
            end(matrix[2][2],new int[] {2,1,3},new int[] {2,3,1});
        }else
        if(matrix[1][1]!=0&&(matrix[1][1]==matrix[1][2]&&matrix[1][1]==matrix[1][3])){
            end(matrix[1][1],new int[] {1,1,1},new int[] {1,2,3});
        }else
        if(matrix[3][3]!=0&&(matrix[3][3]==matrix[1][3]&&matrix[3][3]==matrix[2][3])){
            end(matrix[3][3],new int[] {3,1,2},new int[] {3,3,3});
        }else{
            boolean end = true;
            for (int i = 1; i <= 3; i++) {
                for (int j = 1; j <= 3; j++) {
                    if(matrix[i][j]==0){
                        end=false;
                        break;
                    }
                }
            }
            if(end)end((byte)0);
        }

    }
    @Override
    public void onClick(View v) {
        try {
            if(out)finish();
            //Toast.makeText(this,"x:"+v.getScaleX()+" y:"+v.getScaleY(),Toast.LENGTH_SHORT).show();
            int j = ( (int)(v.getScaleX() * 1000000) % 10);
            int i = ( (int)(v.getScaleY() * 1000000) % 10);
            //Toast.makeText(this,"i:"+i+" j:"+j,Toast.LENGTH_SHORT).show();
            if (matrix[i][j] == 0) {
                schet++;
                matrix[i][j] = firststep ? (byte) 1 : (byte) 2;
                ImageMatrix[i][j].setImageResource(firststep ? R.drawable.crosdraw : R.drawable.circledraw);
                if(schet>4)check();
                firststep = !firststep;
                textView.setText("Сейчас ходит " + (firststep ? FirstPlayerName : SecondPlayerName));
            }
        }
        catch (Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }


}

