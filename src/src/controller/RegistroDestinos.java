
package controller;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Destino;
import utils.ArchivoUtil;

public class RegistroDestinos {

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private ListView<String> ListView;

    @FXML
    private ProgressBar PBar;

    @FXML
    private Button btnCargar;

    @FXML
    private Button btnGuardar;

    @FXML
    private Label lbMensajeUsur;

    @FXML
    private Label lbTitulo;

    @FXML
    private TextField txtFDestino;

    private ArchivoUtil fileDest;

    @FXML
    public void initialize(){
        fileDest = new ArchivoUtil("Destinos.txt");
    }

    @FXML
    public void Guardar(){
        if(!txtFDestino.getText().isEmpty()){
            hilo();
            Destino destino = new Destino(txtFDestino.getText());
            fileDest.EscribirDestino(destino);
            lbMensajeUsur.setText("Destino guardado");
        }
        else{
            lbMensajeUsur.setText("Introduzca un destino a registrar");
        }
    }

    @FXML
    public void Cargar(){
        ArrayList<Destino> destinos = fileDest.LeerDestino();
        ArrayList<String> StrDestinos = Convertir(destinos);

        if(!destinos.isEmpty()){
            hilo();
            ListView.getItems().clear();
            ListView.getItems().addAll(StrDestinos);
            lbMensajeUsur.setText("Destinos cargados");    
        }
        else{
            lbMensajeUsur.setText("El registro de destinos esta vacio");
        }
        
    }

    private ArrayList<String> Convertir(ArrayList<Destino> destinos){
        ArrayList<String> StrDestinos = new ArrayList<>();

        for(int i = 0; i < destinos.size(); i++){
            StrDestinos.add(destinos.get(i).GetNombre());
        }

        return StrDestinos;
    }

    private void hilo(){
        PBar.setProgress(0);

        Thread hilo = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    Thread.sleep(300);
                    int progreso = i;

                    Platform.runLater(() -> {
                        PBar.setProgress(progreso / 10.0);
                        lbMensajeUsur.setText("Guardando... " + (progreso * 10) + "%");
                    });

                }
                Platform.runLater(() -> {
                    lbMensajeUsur.setText("Estudiante guardado en el archivo con hilo");

                });
            } catch (Exception e) {
                System.out.println("Error al guardar el estudiante: " + e.getMessage());
            } finally {
                PBar.setProgress(0);
                lbMensajeUsur.setText("Estudiante guardado en el archivo");
            }
        });

        hilo.start();
    }
}