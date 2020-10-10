package com.leonardo.androidfundamentos;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Intent intento1;
    TextView txt1, txt2;
    Button boton1;
    ImageView imageView1;
    static String LLAVE_ENVIA="NOMBRE";
    public  String LLAVE_SHAREPREFERENCES="RECUPERANDO_VALOR";
    public static final int TEXT_REQUEST=1;
    String recuperandoDato;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1=findViewById(R.id.textView);
        imageView1 = findViewById(R.id.imageView2);
        boton1 = findViewById(R.id.button);
        txt2 = findViewById(R.id.txtrecibido);
        boton1.setOnClickListener(this);
        if(savedInstanceState != null){
            recuperandoDato = savedInstanceState.getString(LLAVE_SHAREPREFERENCES,"");
            txt2.setText(recuperandoDato);
        }
    }
    @Override
    public void onClick(View v) {
       intento1 = new Intent(MainActivity.this, SegundaActividad.class);
       intento1.putExtra(LLAVE_ENVIA,"Leonardo Manzano Salazar");
       startActivityForResult(intento1, TEXT_REQUEST);
        Toast.makeText(MainActivity.this, "Nombre enviado", Toast.LENGTH_LONG).show();
       //startActivity(intento1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                String respuesta = data.getStringExtra(SegundaActividad.LLAVE_CURSO);
                txt2.setText(respuesta);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle bundle) { //guardo los datos al girar la pantalla para usarlo luego, se ejecua al rotar el dispostivo
        super.onSaveInstanceState(bundle);
        String curso = txt2.getText().toString();
        bundle.putString(LLAVE_SHAREPREFERENCES,curso);
    }
}