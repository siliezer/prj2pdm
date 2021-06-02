package edu.ues.fia.eisi.prj2pdm.Funciones2;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import edu.ues.fia.eisi.prj2pdm.R;

public class fin extends Fragment implements View.OnClickListener {
    Departamento d = new Departamento();
    private String departamento = "";
    private AccionArchivo accion;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fin, container, false);

        //Obtener el departamento que se pregunto de la vista anterior
        Bundle args = getArguments();
        departamento = args.getString("Departamento", "Ninguno");
        //int puntos = args.getInt("Puntos");

        TextView txtPuntosFinal = (TextView)v.findViewById(R.id.txtPuntosFinal);
        txtPuntosFinal.setText("Puntaje final: "+d.puntos);

        Button btnE = (Button) v.findViewById(R.id.btnE);
        btnE.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        WebMap mapaweb = new WebMap();
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

        Button btnPDF = v.findViewById(R.id.btnDescargarPDF);
        btnPDF.setText("Descargar PDF con municipios de " + departamento);
        btnPDF.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public  void onClick(View v) {
                        if (!departamento.isEmpty()){
                            accion = AccionArchivo.ExportarPDF;
                            GenerarArchivoPDF();
                        }
                    }
                }
        );

        Button btnBluetooth = v.findViewById(R.id.btnCompartirBluetooth);
        btnBluetooth.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public  void onClick(View v) {
                        if (!departamento.isEmpty()){
                            accion = AccionArchivo.EnviarPorBluetooth;
                            GenerarArchivoPDF();
                        }
                    }
                }
        );

        return v;
    }

    private void GenerarArchivoPDF() {
        try {
            //region Impresión de PDF por municipios
            switch (departamento) {
                case "San Salvador":
                    createPdfWrapper(departamento, d.listaSanSalvador);
                    break;
                case "Santa Ana":
                    createPdfWrapper(departamento, d.listaSantaAna);
                    break;
                case "Sonsonate":
                    createPdfWrapper(departamento, d.listaSonsonate);
                    break;
                case "Ahuachapán":
                    createPdfWrapper(departamento, d.listaAhuachapan);
                    break;
                case "Chalatenango":
                    createPdfWrapper(departamento, d.listaChalatenango);
                    break;
                case "La Libertad":
                    createPdfWrapper(departamento, d.listaLaLibertad);
                    break;
                case "Cabañas":
                    createPdfWrapper(departamento, d.listaCabanas);
                    break;
                case "Morazán":
                    createPdfWrapper(departamento, d.listaMorazan);
                    break;
                case "Cuscatlán":
                    createPdfWrapper(departamento, d.listaCuscatlan);
                    break;
                case "San Vicente":
                    createPdfWrapper(departamento, d.listaSanVicente);
                    break;
                case "La Paz":
                    createPdfWrapper(departamento, d.listaLaPaz);
                    break;
                case "La Unión":
                    createPdfWrapper(departamento, d.listaLaUnion);
                    break;
                case "San Miguel":
                    createPdfWrapper(departamento, d.listaSanMiguel);
                    break;
                case "Usulután":
                    createPdfWrapper(departamento, d.listaUsulutan);
                    break;
            }
            //endregion
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    final private int REQUEST_CODE_ASK_PERMISSIONS = 111;
    private static final String TAG = "GenerarPDFActivity";
    private File pdfFile;
    private String Departamento;
    private String[] Municipios;

    public void createPdfWrapper(String DepartamentoParam, String[] MunicipiosParam) throws FileNotFoundException,DocumentException{
        this.Departamento = DepartamentoParam;
        this.Municipios = MunicipiosParam;
        int hasWriteStoragePermission = ActivityCompat.checkSelfPermission(this.getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (hasWriteStoragePermission != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!shouldShowRequestPermissionRationale(Manifest.permission.WRITE_CONTACTS)) {
                    showMessageOKCancel("Debe permitir el acceso a almacenamiento en el dispositivo",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                                REQUEST_CODE_ASK_PERMISSIONS);
                                    }
                                }
                            });
                    return;
                }
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        REQUEST_CODE_ASK_PERMISSIONS);
            }
            return;
        }else {
            createPdf(Departamento, Municipios);
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permiso autorizado
                    try {
                        createPdfWrapper(Departamento, Municipios);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }
                } else {
                    // Permission Denied
                    Toast.makeText(this.getContext(), "Permiso denegado WRITE_EXTERNAL", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(this.getContext())
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancelar", null)
                .create()
                .show();
    }

    private void createPdf(String Departamento, String[] Municipios) throws FileNotFoundException, DocumentException {

        File docsFolder = new File(Environment.getExternalStorageDirectory() + "/Documents");
        if (!docsFolder.exists()) {
            docsFolder.mkdir();
            Log.i(TAG, "Se ha creado un nuevo directorio para el PDF");
        }

        pdfFile = new File(docsFolder.getAbsolutePath(),"Municipios de " + Departamento + ".pdf");
        OutputStream output = new FileOutputStream(pdfFile);
        Document document = new Document();
        PdfWriter.getInstance(document, output);
        document.open();

        Font fuenteEncabezado = new Font();
        fuenteEncabezado.setSize(22);
        fuenteEncabezado.isBold();
        document.add(new Paragraph("Aplicación para el Aprendizaje", fuenteEncabezado));

        Font fuente = new Font();
        fuente.setSize(18);
        fuente.isBold();
        document.add(new Paragraph("Municipios del departamento: " + departamento, fuente));
        int i = 1;
        for (String municipio : Municipios) {
            document.add(new Paragraph(String.valueOf(i) + " - " + municipio));
            i++;
        }
        Date fechaHoy = new Date();
        java.text.DateFormat df = DateFormat.getDateFormat(this.getContext());

        document.add(new Paragraph("      "));
        document.add(new Paragraph("      "));

        Chunk underline = new Chunk("Universidad de El Salvador - Programación Para Dispositivos Móviles - Grupo 9. " + df.format(fechaHoy));
        underline.setUnderline(0.1f, -2f); //0.1 thick, -2 y-location
        document.add(underline);

        document.close();

        if (accion == AccionArchivo.EnviarPorBluetooth)
            transferirViaBluetooth();
        else if (accion == AccionArchivo.ExportarPDF)
            previsualizarPDF();
    }

    private void previsualizarPDF() {
        PackageManager packageManager = this.getActivity().getPackageManager();
        Intent testIntent = new Intent(Intent.ACTION_VIEW);
        testIntent.setType("application/pdf");
        List list = packageManager.queryIntentActivities(testIntent, PackageManager.MATCH_DEFAULT_ONLY);
        if (list.size() > 0) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            Uri uri = FileProvider.getUriForFile(this.getContext(), this.getContext().getApplicationContext().getPackageName() + ".provider", pdfFile);
            intent.setDataAndType(uri, "application/pdf");
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(intent);
        }else{
            Toast.makeText(this.getContext(),"Descargue un visor de PDF para ver el archivo generado...",Toast.LENGTH_SHORT).show();
        }
    }

    public void transferirViaBluetooth() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("application/pdf");
        Uri uri = FileProvider.getUriForFile(this.getContext(), this.getContext().getApplicationContext().getPackageName() + ".provider", pdfFile);
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {

    }

    private enum AccionArchivo {
        ExportarPDF,
        EnviarPorBluetooth
    }
}
