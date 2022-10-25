package com.example.encontrarparejas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    //Creamos el array que guardara las imagenes
    ArrayList<Integer> imagenes = new ArrayList<>();
    //Creamos el array que guardara las parejas ya resueltas
    ArrayList<Integer> listaParejas = new ArrayList<>();
    Button reiniciar;
    ImageButton b1, b2,b3, b4, b5, b6;
    ImageButton ib;
    int ultimaFoto;
    int i = 0;
    int acabado=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //apuntamos a los diferentes ImageButton y Button
        reiniciar=findViewById(R.id.reinicio);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);

        //añadimos las imagenes
        imagenes.add(R.drawable.alex);
        imagenes.add(R.drawable.felipe);
        imagenes.add(R.drawable.chincheto);
        imagenes.add(R.drawable.alex);
        imagenes.add(R.drawable.felipe);
        imagenes.add(R.drawable.chincheto);
        //barajamos el array
        Collections.shuffle(imagenes);

    }
    public void reiniciar(View view) {
        Context context = getApplicationContext();
        CharSequence text = "Reiniciando";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        recreate();

    }

    public void cambiarImagen(View view){
        //Obtiene el id del boton pulsado y cambia la imagen por una del array
        if(view.getId()==b1.getId()) {
            b1.setImageResource(imagenes.get(0));
            jugar(b1, imagenes.get(0));
        }
        else if(view.getId()==b2.getId()) {
            b2.setImageResource(imagenes.get(1));
            jugar(b2, imagenes.get(1));
        }
        else if(view.getId()==b3.getId()) {
            b3.setImageResource(imagenes.get(2));
            jugar(b3, imagenes.get(2));
        }
        else if(view.getId()==b4.getId()) {
            b4.setImageResource(imagenes.get(3));
            jugar(b4, imagenes.get(3));
        }
        else if(view.getId()==b5.getId()) {
            b5.setImageResource(imagenes.get(4));
            jugar(b5, imagenes.get(4));
        }
        else if(view.getId()==b6.getId()) {
            b6.setImageResource(imagenes.get(5));
            jugar(b6, imagenes.get(5));
        }
    }

    public void jugar(ImageButton b, int imagenes) {
        for (int i = 0; i < listaParejas.size(); i++) {
            if (listaParejas.get(i) == imagenes) acabado = 1;
        }
        if (acabado != 1) {
            if (i == 0) {
                ib = b;
                ultimaFoto = imagenes;
                i++;
            } else if (i == 1) {
                if (ultimaFoto == imagenes) {
                    i = 0;
                    listaParejas.add(imagenes);
                } else {
                    ib.setImageResource(R.drawable.baraja);
                    ib = b;
                    ultimaFoto = imagenes;
                }
            }
        }if(listaParejas.size()==3){
            Context context = getApplicationContext();
            CharSequence text = "¡Has Ganado!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        acabado = 0;
    }
}