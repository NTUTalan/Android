package com.example.a109590015_hw8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private int level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        level = 0;
        imageView.setImageLevel(level);
    }

    public void buttons_onclick(View view) {
        switch(view.getId()) {
            case R.id.button_add:
                if(level < 7) {
                    level++;
                }
                imageView.setImageLevel(level);
                break;
            case R.id.button_minus:
                if(level > 0) {
                    level--;
                }
                imageView.setImageLevel(level);
                break;
            default:
                break;
        }
    }
}