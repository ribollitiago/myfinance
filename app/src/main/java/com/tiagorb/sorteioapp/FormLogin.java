package com.tiagorb.sorteioapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FormLogin extends AppCompatActivity {

    private TextView text_tela_registro;
    private AppCompatButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);

        IniciarComponentes();

        text_tela_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormLogin.this,FormRegistro.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormLogin.this,TelaPrincipal.class);
                startActivity(intent);
            }
        });
    }

    private void IniciarComponentes(){
        text_tela_registro = findViewById(R.id.text_registrar);
        button = findViewById(R.id.bt_entrar);
    }
}