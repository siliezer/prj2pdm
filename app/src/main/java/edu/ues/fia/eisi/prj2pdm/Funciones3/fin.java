package edu.ues.fia.eisi.prj2pdm.Funciones3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import edu.ues.fia.eisi.prj2pdm.R;


public class fin extends Fragment {
    Departamento d = new Departamento();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fin, container, false);

        TextView txtPuntosFinal = (TextView)v.findViewById(R.id.txtPuntosFinal);
        txtPuntosFinal.setText("Puntaje final: "+d.puntos);


        Button btnE = (Button) v.findViewById(R.id.btnE);
        btnE.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        mapaweb mapaweb = new mapaweb();
                        FragmentTransaction tr = getFragmentManager().beginTransaction();
                        tr.replace(R.id.contenedor, mapaweb);
                        tr.commit();

                    }
                }
        );

        Button btnF = (Button) v.findViewById(R.id.btnF);
        btnF.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        principalJuego principalJuego = new principalJuego();
                        FragmentTransaction tr = getFragmentManager().beginTransaction();
                        tr.replace(R.id.contenedor, principalJuego);
                        tr.commit();

                    }
                }
        );

        return v;
    }


}
