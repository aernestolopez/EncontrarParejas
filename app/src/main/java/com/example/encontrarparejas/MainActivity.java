package com.example.encontrarparejas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> mylist = new ArrayList<Integer>();
    Button reiniciar;
    ImageButton b1, b2,b3, b4, b5, b6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reiniciar=findViewById(R.id.reinicio);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);

        mylist.add(R.drawable.alex);
        mylist.add(R.drawable.felipe);
        mylist.add(R.drawable.chincheto);
        mylist.add(R.drawable.alex);
        mylist.add(R.drawable.felipe);
        mylist.add(R.drawable.chincheto);
        Collections.shuffle(mylist);

    }
    public void reiniciar(View view) {
        recreate();
    }

    public void cambiarImagen(View view){
        if(view.getId()==b1.getId()) {
            b1.setImageResource(mylist.get(0));
        }
        else if(view.getId()==b2.getId()) {
            b2.setImageResource(mylist.get(1));
        }
        else if(view.getId()==b3.getId()) {
            b3.setImageResource(mylist.get(2));
        }
        else if(view.getId()==b4.getId()) {
            b4.setImageResource(mylist.get(3));
        }
        else if(view.getId()==b5.getId()) {
            b5.setImageResource(mylist.get(4));
        }
        else if(view.getId()==b6.getId()) {
            b6.setImageResource(mylist.get(5));
        }
    }
}