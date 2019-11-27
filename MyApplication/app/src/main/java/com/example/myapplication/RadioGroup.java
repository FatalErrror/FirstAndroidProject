package com.example.myapplication;

import android.view.View;
import android.widget.RadioButton;

public class RadioGroup implements View.OnClickListener{
    int isActivID;
    RadioButton[] Buttons;
    public RadioGroup(RadioButton[] Buttons){
        this.Buttons = Buttons;
        for (int i = 0; i < this.Buttons.length; i++) {
            this.Buttons[i].setOnClickListener(this);
            if(this.Buttons[i].isChecked()) {
                isActivID = this.Buttons[i].getId();
            }
        }
    }
    //<background android:drawable="@drawable/ic_launcher_background"/>
    //<foreground android:drawable="@drawable/ic_launcher_foreground" />
    @Override
    public void onClick(View v) {
        isActivID = v.getId();
        for (int i = 0; i < Buttons.length; i++) {
            if (Buttons[i].getId()!=isActivID)
            Buttons[i].setChecked(false);
        }
    }
}
