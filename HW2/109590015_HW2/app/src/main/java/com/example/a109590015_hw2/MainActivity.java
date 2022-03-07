package com.example.a109590015_hw2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private Button b_zero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCount = 0;
        mShowCount = (TextView) findViewById(R.id.show_count);
        b_zero = (Button) findViewById(R.id.button_Zero);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
        if (mCount != 0)
            b_zero.setBackground(getResources().getDrawable(R.color.pink));

    }

    public void setZero(View View) {
        if(mCount != 0) {
            mCount = 0;
            mShowCount.setText(Integer.toString(mCount));
            b_zero.setBackground(getResources().getDrawable(R.color.gray));
        }
    }
}