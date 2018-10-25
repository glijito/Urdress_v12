package com.example.xdd.urdress_v1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Registro_3 extends AppCompatActivity {

    private ImageButton siguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_3);
        siguiente = (ImageButton) findViewById(R.id.imgSig);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(siguiente.getContext(), Registro_4.class);
                startActivity(intent);
            }
        });
    }
}
