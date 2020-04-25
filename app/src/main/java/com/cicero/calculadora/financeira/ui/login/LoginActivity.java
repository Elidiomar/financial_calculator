package com.cicero.calculadora.financeira.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cicero.calculadora.financeira.R;
import com.cicero.calculadora.financeira.ui.main.MainActivity;

public class LoginActivity extends AppCompatActivity {

    private ProgressBar loadingProgressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        loadingProgressBar = findViewById(R.id.loading);

        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    login(usernameEditText.getText().toString(),
                            passwordEditText.getText().toString());
                }
                return false;
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                login(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        });
    }

    private void login(String usuario, String senha) {
        if (usuario.toUpperCase().equals("CICERO") || usuario.toUpperCase().equals("ELIDIO")){
            if (senha.equals("123456")){
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            }else{
                Toast.makeText(getApplicationContext(), "Senha inválida.", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getApplicationContext(), "Usuário inválido.", Toast.LENGTH_SHORT).show();
        }

        loadingProgressBar.setVisibility(View.INVISIBLE);
    }
}
