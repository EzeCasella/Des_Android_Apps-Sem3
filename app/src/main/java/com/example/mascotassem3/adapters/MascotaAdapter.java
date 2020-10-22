package com.example.mascotassem3.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mascotassem3.R;
import com.example.mascotassem3.model.Mascota;

import java.util.ArrayList;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>{

    private ArrayList<Mascota> mascotas;

    public MascotaAdapter(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        Mascota mascota = mascotas.get(position);
        holder.imgFoto.setImageResource(mascota.getImagen());
        holder.nombreTextView.setText(mascota.getNombre());
        holder.puntajeTextView.setText(mascota.getPuntaje().toString());
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView nombreTextView;
        private TextView puntajeTextView;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imageView_mascota);
            nombreTextView = (TextView) itemView.findViewById(R.id.textView_nombre);
            puntajeTextView = (TextView) itemView.findViewById(R.id.textView_puntos);
        }
    }
}
