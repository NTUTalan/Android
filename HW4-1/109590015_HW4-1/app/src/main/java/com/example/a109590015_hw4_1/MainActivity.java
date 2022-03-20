package com.example.a109590015_hw4_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int count;
    private TextView text_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_count = (TextView) findViewById(R.id.text_count);
        if(savedInstanceState != null) {
            count = savedInstanceState.getInt("count");
            if(text_count != null) {
                text_count.setText(Integer.toString(count));
            }
        }
        else {
            count = 0;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle State) {
        super.onSaveInstanceState(State);
        State.putInt("count", count);
    }

    public void button_count_onClick(View View) {
        count++;
        if(text_count != null) {
            text_count.setText(Integer.toString(count));
        }
    }

}