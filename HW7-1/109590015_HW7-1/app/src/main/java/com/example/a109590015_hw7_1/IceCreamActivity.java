package com.example.a109590015_hw7_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.Toolbar;

public class IceCreamActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.icecream_child_activity);
        Toolbar toolbar = findViewById(R.id.toolbar3);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IceCreamActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
