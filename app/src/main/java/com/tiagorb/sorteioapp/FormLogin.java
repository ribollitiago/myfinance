package com.tiagorb.sorteioapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FormLogin extends AppCompatActivity {

    private TextView txtRegistro;
    private AppCompatButton buttonLogin;
    private EditText editEmail, editSenha;
    private DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);

        IniciarComponentes();

        txtRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormLogin.this,FormRegistro.class);
                startActivity(intent);
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editEmail.getText().toString();
                String senha = editSenha.getText().toString();

                if(email.isEmpty()||senha.isEmpty())
                    Toast.makeText(FormLogin.this, "Por favor preencha tudo", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkEmailSenha = DB.checkEmailPassword(email,senha);
                    if(checkEmailSenha==true){
                        Toast.makeText(FormLogin.this, "Logado com sucesso!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), TelaPrincipal.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(FormLogin.this, "Credenciais erradas!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void IniciarComponentes(){
        txtRegistro = findViewById(R.id.text_registrar);
        buttonLogin = findViewById(R.id.bt_entrar);
        editEmail = findViewById(R.id.edit_email);
        editSenha = findViewById(R.id.edit_senha);
        DB = new DBHelper(this);
    }
}