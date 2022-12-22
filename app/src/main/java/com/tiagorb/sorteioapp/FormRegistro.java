package com.tiagorb.sorteioapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FormRegistro extends AppCompatActivity {

    private TextView txtLogin;
    private EditText editNome, editEmail, editSenha;
    private AppCompatButton btRegistro;
    private DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_registro);

        IniciarComponentes();

        btRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = editNome.getText().toString();
                String email = editEmail.getText().toString();
                String senha = editSenha.getText().toString();

                if(nome.isEmpty() || email.isEmpty() || senha.isEmpty()){
                    Toast.makeText(FormRegistro.this, "Por favor preencha tudo", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkUser = DB.checkUserName(nome);
                    Boolean checkEmail = DB.checkEmail(email);
                    if(checkUser == false) {
                        if (checkEmail == false) {
                            Boolean insert = DB.insertData(nome, email, senha);
                            DB.close();
                            if (insert == true) {
                                Toast.makeText(FormRegistro.this, "Registro concluído", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), TelaPrincipal.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(FormRegistro.this, "Falha no registro", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(FormRegistro.this, "Email já existe!", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(FormRegistro.this, "Nome de usuário já existe!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormRegistro.this,FormLogin.class);
                startActivity(intent);
            }
        });
    }

    private void IniciarComponentes(){
        editNome = findViewById(R.id.edit_nome);
        editEmail = findViewById(R.id.edit_email);
        editSenha = findViewById(R.id.edit_senha);
        btRegistro = findViewById(R.id.bt_registro);
        txtLogin = findViewById(R.id.text_login);
        DB = new DBHelper(this);
    }
}