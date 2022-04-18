package com.example.a109590015_hw7_1;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void donut_onClick(View view){
        Intent intent = new Intent(MainActivity.this, DonutActivity.class);
        startActivity(intent);
    }

    public void froyo_onClick(View view){
        Intent intent = new Intent(MainActivity.this, FroyoActivity.class);
        startActivity(intent);
    }

    public void iceCream_onClick(View view){
        Intent intent = new Intent(MainActivity.this, IceCreamActivity.class);
        startActivity(intent);
    }
}