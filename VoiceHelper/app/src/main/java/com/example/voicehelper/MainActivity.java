package com.example.voicehelper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.Voice;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
private ImageButton SendButton;
private EditText editText;
private TextView textView;
private TextToSpeech tts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SendButton = findViewById(R.id.SendButton);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    tts.setLanguage(Locale.forLanguageTag("ru"));
                    //tts.setVoice(Voice.);
                }
            }
        });


        SendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String queztion = editText.getText().toString().toLowerCase();
                editText.setText(null);
                String answer = AI.GetAnsver(queztion);
                textView.setText(textView.getText()+"\n\n"+answer);
                tts.speak(answer,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }
}
