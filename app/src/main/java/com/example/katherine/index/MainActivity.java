package com.example.katherine.index;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText peso,estatura;
    private  TextView indice,clas_gen, clas_es;
    private ImageView fotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        peso= (EditText)findViewById(R.id.peso);
        estatura=(EditText)findViewById(R.id.estatura);
        indice=(TextView) findViewById(R.id.indice);
        clas_gen=(TextView) findViewById(R.id.clas_gen);
        clas_es=(TextView) findViewById(R.id.clas_es);
        fotos = (ImageView)findViewById(R.id.fotos);


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuopciones, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.about) {
            about();
        }
        return super.onOptionsItemSelected(item);
    }

    public void calcular(View view){
        if(peso.getText().toString().equals("") && estatura.getText().toString().equals("")){
            Toast vacio = Toast.makeText(this,getResources().getString(R.string.vacios),Toast.LENGTH_SHORT);
            vacio.show();
            return;
        }
        if(peso.getText().toString().equals("")){
            Toast vacio = Toast.makeText(this,getResources().getString(R.string.ingresa_peso),Toast.LENGTH_SHORT);
            vacio.show();
            return;
        }
        if(estatura.getText().toString().equals("")){
            Toast vacio = Toast.makeText(this,getResources().getString(R.string.ingresa_estatura),Toast.LENGTH_SHORT);
            vacio.show();
            return;
        }

        String p = peso.getText().toString();
        String e = estatura.getText().toString();
        Double pe = Double.valueOf(p);
        Double es = Double.valueOf(e);

        double indi = Math.rint((pe / (es*es))*1000)/1000;
        String i = String.valueOf(indi);
        indice.setText(i);

        if( indi < 18.50){
            clas_gen.setText(getResources().getString(R.string.peso_bajo));
            clas_gen.setTextColor(clas_gen.getResources().getColor(R.color.negro));
            if(indi < 16.00){
                clas_es.setText(getResources().getString(R.string.del_leve));
                clas_es.setTextColor(clas_es.getResources().getColor(R.color.azul_o));
                fotos.setImageResource(R.drawable.delgadez_severa);
            }
            if(indi >= 16.00 && indi <= 16.99){
                clas_es.setText(getResources().getString(R.string.del_moderada));
                clas_es.setTextColor(clas_es.getResources().getColor(R.color.azul));
                fotos.setImageResource(R.drawable.delgadez_moderada);
            }
            if(indi >= 17.00 && indi <= 18.49){
                clas_es.setText(getResources().getString(R.string.del_severa));
                clas_es.setTextColor(clas_es.getResources().getColor(R.color.Celeste));
                fotos.setImageResource(R.drawable.delgadez_leve);
            }
        }

        if (indi >=18.50 && indi <= 24.99){
            clas_gen.setText(getResources().getString(R.string.peso_normal));
            clas_gen.setTextColor(clas_gen.getResources().getColor(R.color.verde));
            clas_es.setText("");
            fotos.setImageResource(R.drawable.normal);
        }

        if(indi >= 25.00){
            clas_gen.setText(getResources().getString(R.string.sobrepeso));
            clas_gen.setTextColor(clas_gen.getResources().getColor(R.color.negro));
            if (indi >= 25.00 && indi <= 29.99 ){
                clas_es.setText(getResources().getString(R.string.preobeso));
                clas_es.setTextColor(clas_es.getResources().getColor(R.color.amarillo));
                fotos.setImageResource(R.drawable.preobeso);
            }
        }

        if(indi >= 30.00){
            clas_gen.setText(getResources().getString(R.string.obesidad));
            clas_gen.setTextColor(clas_gen.getResources().getColor(R.color.negro));
            if(indi >=30.00 && indi <= 34.99){
                clas_es.setText(getResources().getString(R.string.obesidad_leve));
                clas_es.setTextColor(clas_es.getResources().getColor(R.color.naranja_c));
                fotos.setImageResource(R.drawable.obesidad_leve);
            }
            if(indi >= 35.00 && indi <= 39.99){
                clas_es.setText(getResources().getString(R.string.obesidad_media));
                clas_es.setTextColor(clas_es.getResources().getColor(R.color.naranja));
                fotos.setImageResource(R.drawable.obesidad_media);
            }
            if(indi >= 40.00 ){
                clas_es.setText(getResources().getString(R.string.obesidad_morbida));
                clas_es.setTextColor(clas_es.getResources().getColor(R.color.rojo));
                fotos.setImageResource(R.drawable.obesidad_morbida);
            }

        }


    }


    public void about(){
        Intent i = new Intent(this,ActivityAbout.class);
        startActivity(i);
    }

}
