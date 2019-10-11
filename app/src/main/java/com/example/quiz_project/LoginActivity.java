package com.example.quiz_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Paint;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn = findViewById(R.id.login_btn);

        getSupportActionBar().hide();

        final EditText username = findViewById(R.id.username_edit);
        final EditText password = findViewById(R.id.password_edit);

        //"Sign up here" underline.
        TextView underline = findViewById(R.id.sign_up_text);
        underline.setPaintFlags(underline.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        //"Sign up here" text, to change page.
        TextView signup = findViewById(R.id.sign_up_text);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        //Login button, to verify the user
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(username.getText().toString().equals("test")){
                    if(password.getText().toString().equals("test")){
                        Toast.makeText(LoginActivity.this, "Login Success",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                        Bundle extras = new Bundle();
                        extras.putString("username", String.valueOf(username.getText()));
                        extras.putString("password", String.valueOf(password.getText()));
                        intent.putExtras(extras);

                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(LoginActivity.this, "Wrong Password or Username",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(LoginActivity.this, "Wrong Password or Username",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
