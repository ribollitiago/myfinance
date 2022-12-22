package com.tiagorb.sorteioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FormRegistro extends AppCompatActivity {

    private TextView text_tela_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro);

        IniciarComponentes();

        text_tela_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormRegistro.this,FormLogin.class);
                startActivity(intent);
            }
        });
    }

    private void IniciarComponentes(){
        text_tela_login = findViewById(R.id.text_login);
    }
}