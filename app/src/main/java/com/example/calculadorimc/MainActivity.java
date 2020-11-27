package com.example.calculadorimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnRecomendacion,btnCalcular;
    EditText txtPeso,txtAltura,txtRecomendacion,txtResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAltura=(EditText)findViewById(R.id.txtAltura);
        txtPeso=(EditText)findViewById(R.id.txtPeso);
        txtResultado=(EditText)findViewById(R.id.txtResultado);
        txtRecomendacion=(EditText)findViewById(R.id.txtRecomendacion);
        btnCalcular=(Button)findViewById(R.id.btnCalcular);
        btnRecomendacion=(Button)findViewById(R.id.btnRecomendacion);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalcularIMC();

            }
        });

        btnRecomendacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Recomendacion();
            }
        });
    }

    public  void CalcularIMC(){
        Double altura=Double.valueOf(txtAltura.getText().toString());
        Double peso=Double.valueOf(txtPeso.getText().toString());

        double IMC=peso/Math.pow(altura,2);
        txtResultado.setText("su IMC: "+String.format("%.2f",IMC));
        MostarIMCadecuado(IMC);

    }

    public void Recomendacion(){
        Double altura=Double.valueOf(txtAltura.getText().toString());
        Double peso=Double.valueOf(txtPeso.getText().toString());

        double IMC=peso/Math.pow(altura,2);
        Intent irecomendaciones=new Intent(MainActivity.this,Recomendaciones.class);
        irecomendaciones.putExtra("IMC",IMC);
        startActivity(irecomendaciones);

    }

    public  void MostarIMCadecuado(double IMC){

        if(IMC<16)
            txtRecomendacion.setText("Bajo Peso muy Grave");
        else if(IMC>16 && IMC<17)
            txtRecomendacion.setText("Bajo Peso Grave");
        else if (IMC>17 && IMC< 18.50)
            txtRecomendacion.setText("Bajo Peso");
        else if(IMC>18 && IMC<25)
            txtRecomendacion.setText("Peso Normal");
        else if(IMC>25 && IMC<30)
            txtRecomendacion.setText("Sobrepeso");
        else if(IMC>30 && IMC<35)
            txtRecomendacion.setText("Obesidad Grado I");
        else if(IMC>35 && IMC<40)
            txtRecomendacion.setText("Obesidad Grado II");
        else if (IMC>40)
            txtRecomendacion.setText("Obesidad Grado III");


    }
}