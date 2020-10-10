package com.leonardo.androidfundamentos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SegundaActividad extends AppCompatActivity implements View.OnClickListener{
    Intent intent;
    String nombre;
    TextView txt1;
    Button boton1;
    static String LLAVE_CURSO="CURSO";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);
        intent = getIntent();
        nombre=intent.getStringExtra(MainActivity.LLAVE_ENVIA);
        txt1= findViewById(R.id.nombreRecibido);
        if(nombre != null){
            txt1.append(nombre);
        }
        boton1 = findViewById(R.id.button2);
        boton1.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        String curso= "Android Fundamentals";
        Intent intentReply = new Intent();
        intentReply.putExtra(LLAVE_CURSO,curso);
        setResult(RESULT_OK,intentReply);
        finish();
        Toast.makeText(SegundaActividad.this,"Curso Enviado",Toast.LENGTH_LONG).show();
    }
}