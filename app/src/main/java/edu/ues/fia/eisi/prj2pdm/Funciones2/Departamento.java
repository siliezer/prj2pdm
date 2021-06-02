package edu.ues.fia.eisi.prj2pdm.Funciones2;

import android.support.v4.app.Fragment;

import java.util.Random;


public class Departamento extends Fragment {
    static int puntos=0;

    public static void main (String [] args) {
        Departamento d = new Departamento();
        System.out.println(".:.Respuesta 4.:.");
        d.cuatroRespuestas();
        System.out.println(".:.Respuesta 3.:.");
        d.tresRespuestas();
        System.out.println(".:.Respuesta 2.:.");
        d.dosRespuestas();
    }

    public String[] dosRespuestas(){
        Random random = new Random();
        Departamento d = new Departamento();

        int pregunta[] = new int[2];
        String respuesta,f1;

        for (int r = 0; r<2; r++){
            pregunta[r] = random.nextInt(14);
        }

        respuesta=d.municipioRespuesta(pregunta);
        f1=d.municioFallo(1,pregunta);

        String[] rDepartamento = respuesta.split("-");
        String[] rMunicipios= new String[4];

        rMunicipios[0]="";

        //Municipios Aleatorios
        rMunicipios[1]=f1;

        //Departamento Correcto
        rMunicipios[2]=rDepartamento[0];

        //Municipio Correcto
        rMunicipios[3]=rDepartamento[1];

        int posicionRespuesta=random.nextInt(2);
        String aux;
        aux=rMunicipios[posicionRespuesta];
        rMunicipios[0]=aux;
        rMunicipios[posicionRespuesta]=rMunicipios[3];

        //Posicion aleatoria
        System.out.println(posicionRespuesta);
        //Impresion elementos
        for (String e: rMunicipios){
            System.out.println(e);
        }

        return  rMunicipios;
    }

    public String[] tresRespuestas(){
        Random random = new Random();
        Departamento d = new Departamento();

        int pregunta[] = new int[3];
        String respuesta,f1,f2;

        for (int r = 0; r<3; r++){
            pregunta[r] = random.nextInt(14);
        }

        respuesta=d.municipioRespuesta(pregunta);
        f1=d.municioFallo(1,pregunta);
        f2=d.municioFallo(2,pregunta);

        String[] rDepartamento = respuesta.split("-");
        String[] rMunicipios= new String[5];

        rMunicipios[0]="";

        //Municipios Aleatorios
        rMunicipios[1]=f1;
        rMunicipios[2]=f2;


        //Departamento Correcto
        rMunicipios[3]=rDepartamento[0];

        //Municipio Correcto
        rMunicipios[4]=rDepartamento[1];

        int posicionRespuesta=random.nextInt(3);
        String aux;
        aux=rMunicipios[posicionRespuesta];
        rMunicipios[0]=aux;
        rMunicipios[posicionRespuesta]=rMunicipios[4];

        //Posicion aleatoria
        System.out.println(posicionRespuesta);
        //Impresion elementos
        for (String e: rMunicipios){
            System.out.println(e);
        }

        return  rMunicipios;
    }

    public String[] cuatroRespuestas(){
        Random random = new Random();
        Departamento d = new Departamento();

        int pregunta[] = new int[4];
        String respuesta,f1,f2,f3;

        for (int r = 0; r<4; r++){
            pregunta[r] = random.nextInt(14);
        }

        respuesta=d.municipioRespuesta(pregunta);
        f1=d.municioFallo(1,pregunta);
        f2=d.municioFallo(2,pregunta);
        f3=d.municioFallo(3,pregunta);

        String[] rDepartamento = respuesta.split("-");
        String[] rMunicipios= new String[6];

        rMunicipios[0]="";

        //Municipios Aleatorios
        rMunicipios[1]=f1;
        rMunicipios[2]=f2;
        rMunicipios[3]=f3;

        //Departamento Correcto
        rMunicipios[4]=rDepartamento[0];

        //Municipio Correcto
        rMunicipios[5]=rDepartamento[1];

        int posicionRespuesta=random.nextInt(4);
        String aux;
        aux=rMunicipios[posicionRespuesta];
        rMunicipios[0]=aux;
        rMunicipios[posicionRespuesta]=rMunicipios[5];

        //Posicion aleatoria
        System.out.println(posicionRespuesta);
        //Impresion elementos
        for (String e: rMunicipios){
            System.out.println(e);
        }

        return  rMunicipios;
    }

    private String municipioRespuesta(int[] pregunta){
        Random random = new Random();
        Departamento d = new Departamento();
        String dR="", mR="";
        switch (pregunta[0]) {
            case 0:
                dR="Ahuachapán";
                mR = d.listaAhuachapan[random.nextInt(d.listaAhuachapan.length)];
                break;
            case 1:
                dR="Santa Ana";
                mR = d.listaSantaAna[random.nextInt(d.listaSantaAna.length)];
                break;
            case 2:
                dR="Sonsonate";
                mR = d.listaSonsonate[random.nextInt(d.listaSonsonate.length)];
                break;
            case 3:
                dR="Chalatenango";
                mR = d.listaChalatenango[random.nextInt(d.listaChalatenango.length)];
                break;
            case 4:
                dR="Cuscatlán";
                mR = d.listaCuscatlan[random.nextInt(d.listaCuscatlan.length)];
                break;
            case 5:
                dR="San Salvador";
                mR = d.listaSanSalvador[random.nextInt(d.listaSanSalvador.length)];
                break;
            case 6:
                dR="La Libertad";
                mR = d.listaLaLibertad[random.nextInt(d.listaLaLibertad.length)];
                break;
            case 7:
                dR="San Vicente";
                mR = d.listaSanVicente[random.nextInt(d.listaSanVicente.length)];
                break;
            case 8:
                dR="Cabañas";
                mR = d.listaCabanas[random.nextInt(d.listaCabanas.length)];
                break;
            case 9:
                dR="La Paz";
                mR = d.listaLaPaz[random.nextInt(d.listaLaPaz.length)];
                break;
            case 10:
                dR="Usulután";
                mR = d.listaUsulutan[random.nextInt(d.listaUsulutan.length)];
                break;
            case 11:
                dR="San Miguel";
                mR = d.listaSanMiguel[random.nextInt(d.listaSanMiguel.length)];
                break;
            case 12:
                dR="Morazán";
                mR = d.listaMorazan[random.nextInt(d.listaMorazan.length)];
                break;
            case 13:
                dR="La Unión";
                mR = d.listaLaUnion[random.nextInt(d.listaLaUnion.length)];
                break;
        }
        return dR+"-"+mR;
    }

    private String municioFallo(int p,int[] pregunta){
        Random random = new Random();
        Departamento d = new Departamento();
        String f = "";
        switch (pregunta[p]) {
            case 0:
                f = d.listaAhuachapan[random.nextInt(d.listaAhuachapan.length)];
                break;
            case 1:
                f = d.listaSantaAna[random.nextInt(d.listaSantaAna.length)];
                break;
            case 2:
                f = d.listaSonsonate[random.nextInt(d.listaSonsonate.length)];
                break;
            case 3:
                f = d.listaChalatenango[random.nextInt(d.listaChalatenango.length)];
                break;
            case 4:
                f = d.listaCuscatlan[random.nextInt(d.listaCuscatlan.length)];
                break;
            case 5:
                f = d.listaSanSalvador[random.nextInt(d.listaSanSalvador.length)];
                break;
            case 6:
                f = d.listaLaLibertad[random.nextInt(d.listaLaLibertad.length)];
                break;
            case 7:
                f = d.listaSanVicente[random.nextInt(d.listaSanVicente.length)];
                break;
            case 8:
                f = d.listaCabanas[random.nextInt(d.listaCabanas.length)];
                break;
            case 9:
                f = d.listaLaPaz[random.nextInt(d.listaLaPaz.length)];
                break;
            case 10:
                f = d.listaUsulutan[random.nextInt(d.listaUsulutan.length)];
                break;
            case 11:
                f = d.listaSanMiguel[random.nextInt(d.listaSanMiguel.length)];
                break;
            case 12:
                f = d.listaMorazan[random.nextInt(d.listaMorazan.length)];
                break;
            case 13:
                f = d.listaLaUnion[random.nextInt(d.listaLaUnion.length)];
                break;
        }

        return f;
    }

    private String ahuachapan ="Ahuachapán,Apaneca,Atiquizaya,Concepción de Ataco," +
            "El Refugio,Guaymango,Jujutla,San Francisco Menéndez,San Lorenzo," +
            "San Pedro Puxtla,Tacuba,Turín";

    private String santaAna ="Candelaria de la Frontera,Chalchuapa,Coatepeque,El Congo," +
            "El Porvenir,Masahuat,Metapán,San Antonio Pajonal,San Sebastián Salitrillo," +
            "Santa Ana,Santa Rosa Guachipilín,Santiago de la Frontera,Texistepeque";

    private String sonsonate ="Acajutla,Armenia,Caluco,Cuisnahuat,Izalco,Juayúa,Nahuizalco,Nahulingo," +
            "Salcoatitán,San Antonio del Monte,San Julián,Santa Catarina Masahuat," +
            "Santa Isabel Ishuatán,Santo Domingo Guzmán,Sonsonate,Sonzacate";

    private String chalatenango ="Agua Caliente,Arcatao,Azacualpa,Chalatenango (ciudad),Comalapa," +
            "Citalá,Concepción Quezaltepeque,Dulce Nombre de María,El Carrizal,El Paraíso," +
            "La Laguna,La Palma,La Reina,Las Vueltas,Nueva Concepción,Nueva Trinidad," +
            "Nombre de Jesús,Ojos de Agua,Potonico,San Antonio de la Cruz," +
            "San Antonio Los Ranchos,San Fernando,San Francisco Lempa,San Francisco Morazán," +
            "San Ignacio,San Isidro Labrador,San José Cancasque,San José Las Flores," +
            "San Luis del Carmen,San Miguel de Mercedes,San Rafael,Santa Rita,Tejutla";

    private String cuscatlan ="Candelaria,Cojutepeque,El Carmen,El Rosario,Monte San Juan," +
            "Oratorio de Concepción,San Bartolomé Perulapía,San Cristóbal,San José Guayabal," +
            "San Pedro Perulapán,San Rafael Cedros,San Ramón,Santa Cruz Analquito," +
            "Santa Cruz Michapa,Suchitoto,Tenancingo";

    private String sanSalvador ="Aguilares,Apopa,Ayutuxtepeque,Cuscatancingo,Ciudad Delgado," +
            "El Paisnal,Guazapa,Ilopango,Mejicanos,Nejapa,Panchimalco,Rosario de Mora," +
            "San Marcos,San Martín,San Salvador,Santiago Texacuangos,Santo Tomás," +
            "Soyapango,Tonacatepeque";

    private String laLibertad ="Antiguo Cuscatlán,Chiltiupán,Ciudad Arce,Colón,Comasagua,Huizúcar," +
            "Jayaque,Jicalapa,La Libertad,Nueva San Salvador (Santa Tecla),Nuevo Cuscatlán," +
            "San Juan Opico,Quezaltepeque,Sacacoyo,San José Villanueva,San Matías," +
            "San Pablo Tacachico,Talnique,Tamanique,Teotepeque,Tepecoyo,Zaragoza";

    private String sanVicente ="Apastepeque,Guadalupe,San Cayetano Istepeque,San Esteban Catarina," +
            "San Ildefonso,San Lorenzo,San Sebastián,San Vicente,Santa Clara,Santo Domingo," +
            "Tecoluca,Tepetitán,Verapaz";

    private String cabanas ="Cinquera,Dolores,Guacotecti,Ilobasco,Jutiapa,San Isidro,Sensuntepeque," +
            "Tejutepeque,Victoria";

    private String laPaz ="Cuyultitán,El Rosario,Jerusalén,Mercedes La Ceiba,Olocuilta," +
            "Paraíso de Osorio,San Antonio Masahuat,San Emigdio,San Francisco Chinameca," +
            "San Juan Nonualco,San Juan Talpa,San Juan Tepezontes,San Luis Talpa," +
            "San Luis La Herradura,San Miguel Tepezontes,San Pedro Masahuat," +
            "San Pedro Nonualco,San Rafael Obrajuelo,Santa María Ostuma," +
            "Santiago Nonualco,Tapalhuaca,Zacatecoluca";

    private String usulutan ="Alegría,Berlín,California,Concepción Batres,El Triunfo," +
            "Ereguayquín,Estanzuelas,Jiquilisco,Jucuapa,Jucuarán,Mercedes Umaña," +
            "Nueva Granada,Ozatlán,Puerto El Triunfo,San Agustín,San Buenaventura," +
            "San Dionisio,San Francisco Javier,Santa Elena,Santa María," +
            "Santiago de María,Tecapán,Usulután";

    private String sanMiguel ="Carolina,Chapeltique,Chinameca,Chirilagua,Ciudad Barrios," +
            "Comacarán,El Tránsito,Lolotique,Moncagua,Nueva Guadalupe," +
            "Nuevo Edén de San Juan,Quelepa,San Antonio del Mosco,San Gerardo," +
            "San Jorge,San Luis de la Reina,San Miguel,San Rafael Oriente,Sesori,Uluazapa";

    private String morazan ="Arambala,Cacaopera,Chilanga,Corinto,Delicias de Concepción," +
            "El Divisadero,El Rosario,Gualococti,Guatajiagua,Joateca,Jocoaitique,Jocoro," +
            "Lolotiquillo,Meanguera,Osicala,Perquín,San Carlos,San Fernando," +
            "San Francisco Gotera,San Isidro,San Simón,Sensembra,Sociedad,Torola," +
            "Yamabal,Yoloaiquín";

    private String laUnion ="Anamorós,Bolivar,Concepción de Oriente,Conchagua,El Carmen,El Sauce," +
            "Intipucá,La Unión,Lislique,Meanguera del Golfo,Nueva Esparta,Pasaquina,Polorós," +
            "San Alejo,San José,Santa Rosa de Lima,Yayantique,Yucuaiquín";

    public String[] listaAhuachapan = ahuachapan.split(",");
    public String[] listaSantaAna = santaAna.split(",");
    public String[] listaSonsonate = sonsonate.split(",");
    public String[] listaChalatenango = chalatenango.split(",");
    public String[] listaCuscatlan = cuscatlan.split(",");
    public String[] listaSanSalvador = sanSalvador.split(",");
    public String[] listaLaLibertad = laLibertad.split(",");
    public String[] listaSanVicente = sanVicente.split(",");
    public String[] listaCabanas = cabanas.split(",");
    public String[] listaLaPaz = laPaz.split(",");
    public String[] listaUsulutan = usulutan.split(",");
    public String[] listaSanMiguel = sanMiguel.split(",");
    public String[] listaMorazan = morazan.split(",");
    public String[] listaLaUnion = laUnion.split(",");

}


