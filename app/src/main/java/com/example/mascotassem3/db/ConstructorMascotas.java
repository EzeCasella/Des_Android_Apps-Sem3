package com.example.mascotassem3.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.mascotassem3.ContactActivity;
import com.example.mascotassem3.R;
import com.example.mascotassem3.model.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {

    private static final Integer LIKE = 1;
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
//        ArrayList<Mascota> mascotas = new ArrayList<>();
//        mascotas.add(new Mascota(R.drawable.ic_dog_1, "Perl", 3));
//        mascotas.add(new Mascota(R.drawable.ic_dog_2, "Piter", 6));
//        mascotas.add(new Mascota(R.drawable.ic_dog_3, "CHarly", 2));
//        mascotas.add(new Mascota(R.drawable.ic_dog_2, "Catty", 3));
//        mascotas.add(new Mascota(R.drawable.ic_dog_1, "Kita", 4));
//        mascotas.add(new Mascota(R.drawable.ic_dog_3, "Tom", 1));
//        return mascotas;

        BaseDatos db = new BaseDatos(context);
        insertarMascotas(db);
        return db.obtenerTodasLasMascotas();
    }

    public void insertarMascotas(BaseDatos db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Perl");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_IMAGEN, R.drawable.ic_dog_1);
        db.insertarMascota(contentValues);


        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Piter");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_IMAGEN, R.drawable.ic_dog_2);
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Charly");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_IMAGEN, R.drawable.ic_dog_3);
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Catty");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_IMAGEN, R.drawable.ic_dog_2);
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Kita");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_IMAGEN, R.drawable.ic_dog_1);
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Tom");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_IMAGEN, R.drawable.ic_dog_3);
        db.insertarMascota(contentValues);
    }

    public void darLikeMascota(Mascota mascota) {
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES, LIKE);
        db.insertarPuntajeMascota(contentValues);
    }

    public Integer obtenerLikesMascota(Mascota mascota) {
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }
}
