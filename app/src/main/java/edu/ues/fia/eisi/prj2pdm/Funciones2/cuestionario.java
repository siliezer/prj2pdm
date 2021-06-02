package edu.ues.fia.eisi.prj2pdm.Funciones2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import edu.ues.fia.eisi.prj2pdm.R;

public class cuestionario extends Fragment {

    Departamento d = new Departamento();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cuestionario, container, false);

        TextView txtPregunta = (TextView)v.findViewById(R.id.txtPregunta);
        TextView txtPuntos = (TextView)v.findViewById(R.id.txtPuntos);
        final TextView counttime = (TextView)v.findViewById(R.id.counttime);

        final String[] pregunta = d.cuatroRespuestas();

        txtPregunta.setText("Selecciona el municipio que pertenece a "+pregunta[4]);
        txtPuntos.setText(""+d.puntos);


        final Button btnA = (Button) v.findViewById(R.id.btnA);
        btnA.setText(pregunta[0]);

        final Button btnB = (Button) v.findViewById(R.id.btnB);
        btnB.setText(pregunta[1]);

        final Button btnC = (Button) v.findViewById(R.id.btnC);
        btnC.setText(pregunta[2]);

        final Button btnD = (Button) v.findViewById(R.id.btnD);
        btnD.setText(pregunta[3]);

        //No mostrar respuesta
        //Toast toast1 = Toast.makeText(getActivity(), "La respuesta es: "+pregunta[5], Toast.LENGTH_SHORT);
        //toast1.show();

        btnA.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        if(pregunta[0].equals(pregunta[5])){
                            cuestionario cuestionario = new cuestionario();
                            FragmentTransaction tr = getFragmentManager().beginTransaction();
                            tr.replace(R.id.contenedor, cuestionario);
                            tr.commit();
                            d.puntos++;
                        }else {
                            fin finalJuego = new fin();
                            FragmentTransaction tr = getFragmentManager().beginTransaction();
                            //Envía al fragment "fin" el parámetro del departamento para poder exportar
                            //los municipios de ese departamento en PDF o compartir por Bluetooth
                            finalJuego.setArguments(getArgumentDepartamento(pregunta[4]));

                            tr.replace(R.id.contenedor, finalJuego);
                            tr.commit();
                        }
                    }
                }
        );

        btnB.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        if(pregunta[1].equals(pregunta[5])){
                            cuestionario cuestionario = new cuestionario();
                            FragmentTransaction tr = getFragmentManager().beginTransaction();
                            tr.replace(R.id.contenedor, cuestionario);
                            tr.commit();
                            d.puntos++;
                        }else {
                            fin finalJuego = new fin();
                            FragmentTransaction tr = getFragmentManager().beginTransaction();
                            finalJuego.setArguments(getArgumentDepartamento(pregunta[4]));
                            tr.replace(R.id.contenedor, finalJuego);
                            tr.commit();
                        }
                    }
                }
        );

        btnC.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        if(pregunta[2].equals(pregunta[5])){
                            cuestionario cuestionario = new cuestionario();
                            FragmentTransaction tr = getFragmentManager().beginTransaction();
                            tr.replace(R.id.contenedor, cuestionario);
                            tr.commit();
                            d.puntos++;
                        }else {
                            fin finalJuego = new fin();
                            FragmentTransaction tr = getFragmentManager().beginTransaction();
                            finalJuego.setArguments(getArgumentDepartamento(pregunta[4]));
                            tr.replace(R.id.contenedor, finalJuego);
                            tr.commit();
                        }
                    }
                }
        );

        btnD.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        if(pregunta[3].equals(pregunta[5])){
                            cuestionario cuestionario = new cuestionario();
                            FragmentTransaction tr = getFragmentManager().beginTransaction();
                            tr.replace(R.id.contenedor, cuestionario);
                            tr.commit();
                            d.puntos++;
                        }else {
                            fin finalJuego = new fin();
                            FragmentTransaction tr = getFragmentManager().beginTransaction();
                            finalJuego.setArguments(getArgumentDepartamento(pregunta[4]));
                            tr.replace(R.id.contenedor, finalJuego);
                            tr.commit();
                        }
                    }
                }
        );
        return v;
    }

    private Bundle getArgumentDepartamento(String departamento) {
        Bundle args = new Bundle();
        args.putString("Departamento", departamento);
        return  args;
    }

}
