package com.example.mascotassem3.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mascotassem3.R;
import com.example.mascotassem3.db.ConstructorMascotas;
import com.example.mascotassem3.model.Mascota;

import java.util.ArrayList;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>{

    private Activity activity;
    private ArrayList<Mascota> mascotas;

    public MascotaAdapter(Activity activity, ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder holder, int position) {
        final ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
        final Mascota mascota = mascotas.get(position);
        holder.imgFoto.setImageResource(mascota.getImagen());
        holder.nombreTextView.setText(mascota.getNombre());
        holder.puntajeTextView.setText(constructorMascotas.obtenerLikesMascota(mascota).toString());
        holder.yellowBoneLikes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Diste like a " + mascota.getNombre(), Toast.LENGTH_SHORT);
                constructorMascotas.darLikeMascota(mascota);

                holder.puntajeTextView.setText(constructorMascotas.obtenerLikesMascota(mascota).toString());

            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView nombreTextView;
        private TextView puntajeTextView;
        private View yellowBoneLikes;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imageView_mascota);
            nombreTextView = (TextView) itemView.findViewById(R.id.textView_nombre);
            puntajeTextView = (TextView) itemView.findViewById(R.id.textView_puntos);
            yellowBoneLikes = itemView.findViewById(R.id.yellow_bone);
        }
    }
}
