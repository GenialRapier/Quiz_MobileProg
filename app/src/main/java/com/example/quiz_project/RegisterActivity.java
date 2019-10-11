package com.example.quiz_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().hide();

        Button registerButton = findViewById(R.id.RegisterButton);

        final EditText userText = findViewById(R.id.username_text);
        final EditText ageText = findViewById(R.id.age_text);
        final EditText emailText = findViewById(R.id.email_text);
        final EditText passText = findViewById(R.id.password_text);
        final EditText confPassText = findViewById(R.id.conf_password_text);

        registerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Boolean validity = true;

                if (userText.getText().toString().isEmpty()) {
                    userText.requestFocus();
                    Toast.makeText(RegisterActivity.this, "Username cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (passText.getText().toString().isEmpty()) {
                    passText.requestFocus();
                    Toast.makeText(RegisterActivity.this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (confPassText.getText().toString().isEmpty()) {
                    confPassText.requestFocus();
                    Toast.makeText(RegisterActivity.this, "Confirmation password cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (emailText.getText().toString().isEmpty()) {
                    emailText.requestFocus();
                    Toast.makeText(RegisterActivity.this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!confPassText.getText().toString().isEmpty() && !passText.getText().toString().isEmpty() && confPassText.getText().toString().equals(passText.getText().toString())) {

                }
                else {
                    validity = false;
                    Toast.makeText(RegisterActivity.this, "Wrong confirmation password", Toast.LENGTH_SHORT).show();
                }

                if (!emailText.getText().toString().isEmpty() && isEmailValid(emailText.getText().toString())) {

                }
                else {
                    validity = false;
                    Toast.makeText(RegisterActivity.this, "Email format not valid", Toast.LENGTH_SHORT).show();
                }

                if (!validity) {

                }
                else {
                    // Push data to database
                    Toast.makeText(RegisterActivity.this, "Account created", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean isEmailValid(String email)
    {
        String regExpn =
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                        +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                        +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(regExpn,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        if(matcher.matches())
            return true;
        else
            return false;
    }
}
