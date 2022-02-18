package com.example.inq_proj.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.inq_proj.R;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    private EditText reg_id, reg_pw, reg_name, reg_position, reg_skill;
    private Button reg_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_register);

        reg_id = (EditText)findViewById(R.id.edID);
        reg_pw = (EditText)findViewById(R.id.edPW);
        reg_name = (EditText)findViewById(R.id.edNAME);
        reg_position = (EditText)findViewById(R.id.edPOSITION);
        reg_skill = (EditText)findViewById(R.id.edSKILL);

        reg_btn = findViewById(R.id.btn_join);


        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = reg_id.getText().toString();
                String pw = reg_pw.getText().toString();
                String name = reg_name.getText().toString();
                String position = reg_position.getText().toString();
                String skill = reg_skill.getText().toString();


                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        boolean success = jsonObject.getBoolean("success");
                        if (success) {
                            Toast.makeText(getApplicationContext(), "success register", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "fail register", Toast.LENGTH_LONG).show();
                            return;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    }
                };
                RegisterRequest registerRequest = new RegisterRequest(id, pw, name, position, skill, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
        });
    }
}
