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
    ArrayList<Integer> mylist = new ArrayList<Integer>();
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
        mylist.add(R.drawable.alex);
        mylist.add(R.drawable.felipe);
        mylist.add(R.drawable.chincheto);
        mylist.add(R.drawable.alex);
        mylist.add(R.drawable.felipe);
        mylist.add(R.drawable.chincheto);
        //barajamos el array
        Collections.shuffle(mylist);

    }
    public void reiniciar(View view) {
        recreate();
    }

    public void cambiarImagen(View view){
        //Obtiene el id del boton pulsado y cambia la imagen por una del array
        if(view.getId()==b1.getId()) {
            b1.setImageResource(mylist.get(0));
            jugar(b1,mylist.get(0));
        }
        else if(view.getId()==b2.getId()) {
            b2.setImageResource(mylist.get(1));
            jugar(b2,mylist.get(1));
        }
        else if(view.getId()==b3.getId()) {
            b3.setImageResource(mylist.get(2));
            jugar(b3,mylist.get(2));
        }
        else if(view.getId()==b4.getId()) {
            b4.setImageResource(mylist.get(3));
            jugar(b4,mylist.get(3));
        }
        else if(view.getId()==b5.getId()) {
            b5.setImageResource(mylist.get(4));
            jugar(b5,mylist.get(4));
        }
        else if(view.getId()==b6.getId()) {
            b6.setImageResource(mylist.get(5));
            jugar(b6,mylist.get(5));
        }
    }

    public void jugar(ImageButton b,int foto) {
        //controlamos la logica del programa donde mantendremos las fotos correctas o la ultima dada
        if(acabado!=3) {
            if (i == 0) {
                ib = b;
                ultimaFoto = foto;
                i++;
            } else if (i == 1) {
                if (ultimaFoto == foto) {
                    i = 0;
                    acabado++;
                } else {
                    ib.setImageResource(R.drawable.baraja);
                    ib = b;
                    ultimaFoto = foto;
                }
            }
        }else{
            Context context = getApplicationContext();
            CharSequence text = "Has ganado!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}