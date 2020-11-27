package com.example.calculadorimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Recomendaciones extends AppCompatActivity {

    EditText txtAlimentacion, txtDeporte, txtIMC, txtCondicion;
    Button btnvolver, btnGenerarRecomendacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recomendaciones);

        txtAlimentacion=(EditText)findViewById(R.id.txtAlimentacion);
       // txtDeporte=(EditText)findViewById(R.id.txtDeporte);
        txtIMC=(EditText)findViewById(R.id.txtIMC);
        txtCondicion=(EditText)findViewById(R.id.txtCondicion);
        btnvolver=(Button)findViewById(R.id.btnVolver);
        btnGenerarRecomendacion=(Button)findViewById(R.id.btnGeneraRecomendacion);

        btnGenerarRecomendacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EvaluarIMC();
            }
        });

        btnvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VolverInicio();
            }
        });
    }

    public void EvaluarIMC(){
        Intent IMC=this.getIntent();
        Bundle extra=IMC.getExtras();
        Double miValor=extra.getDouble("IMC");

        if(miValor<16){
            txtCondicion.setText("Bajo Peso muy Grave");
            txtIMC.setText("Tu IMC: "+String.format("%.2f",miValor));
            txtAlimentacion.setText("Alimentacion de Verduras, Hortalizas\n"+
                    "Legumbres, aguacates, Aceeituna\n"+
                    "Frutos secos, aceite de oliva, miel\n"+
                    "Aumentar Alimentacion pollo, pavo, ternera, cerdo magro, conejo\n"+
                    "consumir higado, jamon serrano, mortadela\n"+
                    "pescados blanco, pescados azules");


        }
        else if(miValor>16 && miValor<17){
            txtCondicion.setText("Bajo Peso Grave");
            txtIMC.setText("Tu IMC: "+String.format("%.2f",miValor));
            txtAlimentacion.setText("Alimentacion de Verduras, Hortalizas\n"+
                    "Legumbres, aguacates, Aceeituna\n"+"Frutos secos, aceite de oliva, miel");

        }
        else if (miValor>17 && miValor< 18.50){
            txtCondicion.setText("Bajo Peso");
            txtIMC.setText("Tu IMC: "+String.format("%.2f",miValor));
            txtAlimentacion.setText("Aumentar Alimentacion pollo, pavo, ternera, cerdo magro, conejo\n"+
                    "consumir higado, jamon serrano, mortadela\n"+"pescados blanco, pescados azules");

        }
        else if(miValor>18 && miValor<25){
            txtCondicion.setText("Peso Normal");
            txtIMC.setText("Tu IMC: "+String.format("%.2f",miValor));
            txtAlimentacion.setText("Continuar con la buena alimentacion\n"+"No consumir comidad chatarras");//txtDeporte.setText("Realizar siempre 1 hora de ejercicios");
        }
        else if(miValor>25 && miValor<30){
            txtCondicion.setText("Sobrepeso");
            txtIMC.setText("Tu IMC: "+String.format("%.2f",miValor));
            txtAlimentacion.setText("Elegir alimentos de baja densidad energética: frutas con mucha agua, pescado, verduras… en esta página encontrara información \n"+
                    "Aumentar el consumo de fibra dietetica \n"+"No Exceder en las raciones");

        }
        else if(miValor>30 && miValor<35){
            txtCondicion.setText("Obesidad Grado I");
            txtIMC.setText("Tu IMC: "+String.format("%.2f",miValor));
            txtAlimentacion.setText("No excederse en las raciones \n"+
                    "Dieta  equilibrada y variada. Es la que contiene la energía y los nutrientes en la cantidad necesaria para mantener nuestra salud y no producir ni déficit ni exceso");

        }
        else if(miValor>35 && miValor<40) {
            txtCondicion.setText("Obesidad Grado II");
            txtIMC.setText("Tu IMC: "+String.format("%.2f",miValor));
            txtAlimentacion.setText("No excederse en las raciones \n " +
                    "Dieta  equilibrada y variada. Es la que contiene la energía y los nutrientes en la cantidad necesaria para mantener nuestra salud y no producir ni déficit ni exceso\n");

        }
        else if (miValor>40) {
            txtCondicion.setText("Obesidad Grado III");
            txtIMC.setText("Tu IMC: "+String.format("%.2f",miValor));
            txtAlimentacion.setText("No excederse en las raciones\n"+
                    "Dieta  equilibrada y variada. Es la que contiene la energía y los nutrientes en la cantidad necesaria para mantener nuestra salud y no producir ni déficit ni exceso");

        }
    }
    private void VolverInicio(){
        Intent menu=new Intent(Recomendaciones.this,MainActivity.class);
        startActivity(menu);
    }
}