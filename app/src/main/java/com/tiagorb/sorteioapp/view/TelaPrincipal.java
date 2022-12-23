package com.tiagorb.sorteioapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tiagorb.sorteioapp.R;
import com.tiagorb.sorteioapp.database.DBHelper;

public class TelaPrincipal extends AppCompatActivity {

    private ImageView icRight, icClose;
    private Dialog mDialog;
    private AppCompatButton btSair;
    private TextView txtEmail, txtUser, txtUser2;
    private DBHelper DB;
    private String nomeID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        onStart();
        IniciarComponentes();
        clickIcRight();
        txtUser2.setText(showNome());

    }

    public String showNome(){
        String nome = null;
        Cursor res  = DB.getData();
        while (res.moveToNext()){
            nome = res.getString(1);
        }
        return nome;
    }

    private void IniciarComponentes(){
        mDialog = new Dialog(this);
        icRight = findViewById(R.id.right_icon);
        txtUser = findViewById(R.id.user_account);
        txtUser2 = findViewById(R.id.user_accounttest);
        txtEmail = findViewById(R.id.user_email);
        DB = new DBHelper(this);
    }

    private void clickIcRight(){
        icRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog.setContentView(R.layout.popup_user);
                mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                icClose = (ImageView) mDialog.findViewById(R.id.ic_close);
                btSair = (AppCompatButton) mDialog.findViewById(R.id.bt_sair);

                icClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mDialog.dismiss();
                    }
                });

                btSair.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(TelaPrincipal.this, "Deslogado com sucesso!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), FormLogin.class);
                        startActivity(intent);
                    }
                });

                mDialog.show();
            }
        });
    }

}