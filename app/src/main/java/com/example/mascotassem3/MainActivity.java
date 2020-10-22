package com.example.mascotassem3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mascotassem3.adapters.MascotaAdapter;
import com.example.mascotassem3.model.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Mascota> mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.miActonBar);
        setSupportActionBar(toolbar);
        findViewById(R.id.five_starts_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FavoritesActivity.class);
                startActivity(intent);
            }
        });

        inicializarArrayMascotas();

        MascotaAdapter adapter = new MascotaAdapter(mascotas);
        ((RecyclerView) findViewById(R.id.recycler_mascotas)).setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        ((RecyclerView) findViewById(R.id.recycler_mascotas)).setLayoutManager(llm);
    }

    public void inicializarArrayMascotas(){
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.ic_dog_1, "Perl", 3));
        mascotas.add(new Mascota(R.drawable.ic_dog_2, "Piter", 6));
        mascotas.add(new Mascota(R.drawable.ic_dog_3, "CHarly", 2));
        mascotas.add(new Mascota(R.drawable.ic_dog_2, "Catty", 3));
        mascotas.add(new Mascota(R.drawable.ic_dog_1, "Kita", 4));
        mascotas.add(new Mascota(R.drawable.ic_dog_3, "Tom", 1));

    }
}