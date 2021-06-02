package edu.ues.fia.eisi.prj2pdm.Funciones3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import edu.ues.fia.eisi.prj2pdm.R;


public class principalJuego extends Fragment implements View.OnClickListener {
    Departamento d = new Departamento();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_principal_juego, container, false);

        d.puntos=0;

        Button btnInicio = (Button)v.findViewById(R.id.btnInicio);
        btnInicio.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnInicio:
                cuestionario cuestionario = new cuestionario();
                FragmentTransaction tr = getFragmentManager().beginTransaction();
                tr.replace(R.id.contenedor, cuestionario);
                tr.commit();
                break;
        }

    }

}
