package com.example.a109590015_hw10_2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;

public class MainActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<String> {

    private String pickItem;
    private EditText urlText;
    private TextView srcText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        urlText = findViewById(R.id.url_text);
        srcText = findViewById(R.id.src_text);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.picker, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner picker = findViewById(R.id.picker);
        if(picker != null) {
            picker.setOnItemSelectedListener(onItemClick);
            picker.setAdapter(adapter);
        }

        if(getSupportLoaderManager().getLoader(0) != null) {
            getSupportLoaderManager().initLoader(0, null, this);
        }
    }

    public void btn_onclick(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null){
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
        String queryString = urlText.getText().toString();

        ConnectivityManager conn = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = null;
        if(conn != null) {
            info = conn.getActiveNetworkInfo();
        }

        if(info != null && info.isConnected()) {
            if(queryString.length() == 0){
                Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
            }
            else {
                Bundle bundle = new Bundle();
                bundle.putString("queryString", queryString);
                bundle.putString("pickType", pickItem);
                getSupportLoaderManager().restartLoader(0, bundle, this);
                srcText.setText("loading...");
            }
        }
    }

    private AdapterView.OnItemSelectedListener onItemClick = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, android.view.View view, int i, long l) {
            pickItem = adapterView.getItemAtPosition(i).toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
            String[] values = getResources().getStringArray(R.array.picker);
            pickItem = values[0];
        }};


    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        String queryString = "";
        String pickType = "";
        if(args != null) {
            queryString = args.getString("queryString");
            pickType = args.getString("pickType");
        }
        return new com.example.a109590015_hw10_2.Loader(this, queryString, pickType);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        try{
            srcText.setText(data);
        }
        catch (Exception e){
            e.printStackTrace();
            srcText.setText("Error");
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) { }
}