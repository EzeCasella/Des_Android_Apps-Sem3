package com.example.mascotassem3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mascotassem3.adapters.MascotaAdapter;
import com.example.mascotassem3.db.ConstructorMascotas;
import com.example.mascotassem3.model.Mascota;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private ArrayList<Mascota> mascotas;
    private ConstructorMascotas constructorMascotas;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        obtenerContactosBaseDatos();

        MascotaAdapter adapter = new MascotaAdapter(getActivity(), mascotas);
        ((RecyclerView) v.findViewById(R.id.recycler_mascotas)).setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        ((RecyclerView) v.findViewById(R.id.recycler_mascotas)).setLayoutManager(llm);

        return v;
    }

    public void obtenerContactosBaseDatos(){
        constructorMascotas = new ConstructorMascotas(getContext());
        mascotas= constructorMascotas.obtenerDatos();
    }
}