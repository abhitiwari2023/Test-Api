package com.example.testapi;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    private final String URL = "https://api.restful-api.dev/objects/7";
//    private final String URL = "https://run.mocky.io/v3/e5cbf85e-ffa1-4a81-8bbe-79435e25775c";
    private TextView txt;
    private Button btn; // Declare a Button variable

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.txt1);
        btn = findViewById(R.id.btn); // Initialize the Button variable

//        makeRequest();

        btn.setOnClickListener(new View.OnClickListener() { // Add an OnClickListener to the Button
            @Override
            public void onClick(View v) {
                onBtnClick(v); // Call onBtnClick() when the Button is clicked
            }
        });
    }

    private void onBtnClick(View view) {
        makeRequest();
    }

    private void makeRequest() {
        RequestQueue rq = Volley.newRequestQueue(MainActivity.this);

        StringRequest sq = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Res", response);
                txt.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error Occur", Toast.LENGTH_SHORT).show();
            }
        });
        rq.add(sq);
    }
}