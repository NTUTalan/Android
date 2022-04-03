package com.example.a109590015_hw6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public int[] data = {0, 0, 0, 0, 0};
    public String[] toastList = {"Chocolate syrup", "Sprinkles", "Crushed nuts", "Cherries", "Orio cookkie crumbles"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkBox_onClick(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId()) {
            case R.id.checkBox1:
                if(checked) { data[0] = 1; }
                else{ data[0] = 0; }
                break;
            case R.id.checkBox2:
                if(checked) { data[1] = 1; }
                else{ data[1] = 0; }
                break;
            case R.id.checkBox3:
                if(checked) { data[2] = 1; }
                else{ data[2] = 0; }
                break;
            case R.id.checkBox4:
                if(checked) { data[3] = 1; }
                else{ data[3] = 0; }
                break;
            case R.id.checkBox5:
                if(checked) { data[4] = 1; }
                else{ data[4] = 0; }
                break;
        }
    }

    public void Button_onClick(View view) {
        String message = "Toppings:";
        for(int i = 0; i < 5; i++) {
            if(data[i] == 1) {
                message = message + " " + toastList[i];
            }
        }
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }

}