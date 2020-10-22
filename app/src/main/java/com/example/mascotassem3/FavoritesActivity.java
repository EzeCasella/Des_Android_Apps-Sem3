package com.example.mascotassem3;

import android.os.Bundle;

import com.example.mascotassem3.adapters.MascotaAdapter;
import com.example.mascotassem3.model.Mascota;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;

public class FavoritesActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        Toolbar toolbar = findViewById(R.id.miActonBar);
        setSupportActionBar(toolbar);

        findViewById(R.id.five_starts_image).setVisibility(View.INVISIBLE);
        inicializarArrayMascotas();

        MascotaAdapter adapter = new MascotaAdapter(mascotas);
        ((RecyclerView) findViewById(R.id.recycler_mascotas_favoritas)).setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        ((RecyclerView) findViewById(R.id.recycler_mascotas_favoritas)).setLayoutManager(llm);
    }

    public void inicializarArrayMascotas(){
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.ic_dog_2, "Piter", 6));
        mascotas.add(new Mascota(R.drawable.ic_dog_1, "Kita", 4));

    }
}