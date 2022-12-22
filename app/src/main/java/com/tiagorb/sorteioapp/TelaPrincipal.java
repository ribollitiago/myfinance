package com.tiagorb.sorteioapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TelaPrincipal extends AppCompatActivity {

    private ImageView rightIcon;
    private Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        IniciarComponentes();

        rightIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog.setContentView(R.layout.popup_user);
                mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mDialog.show();
            }
        });
    }
    private void IniciarComponentes(){
        ImageView leftIcon = findViewById(R.id.left_icon);
        rightIcon = findViewById(R.id.right_icon);
        TextView title = findViewById(R.id.title_bar);
        mDialog = new Dialog(this);
    }
}