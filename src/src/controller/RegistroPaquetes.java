package controller;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Destino;
import model.Paquete;
import utils.ArchivoUtil;

public class RegistroPaquetes {

    @FXML
    private ComboBox<String> CBDestinos;

    @FXML
    private HBox Hbox;

    @FXML
    private ProgressBar PBar;

    @FXML
    private VBox VboxIz;

    @FXML
    private Button btnCargar;

    @FXML
    private Button btnGuardar;

    @FXML
    private Label lbCodPaq;

    @FXML
    private Label lbMensajeUsur;

    @FXML
    private Label lbNomDest;

    @FXML
    private Label lbPesoPaq;

    @FXML
    private Label lbTitulo;

    @FXML
    private TextField txtFNomDest;

    @FXML
    private TextField txtFPesoPaq;

    @FXML
    private TextField txtFieldCodPaq;

    private ArchivoUtil filePaq;

    private ArchivoUtil fileDes;

    @FXML
    public void initialize(){
        filePaq = new ArchivoUtil("Paquetes.txt");
        fileDes = new ArchivoUtil("Destinos.txt");
    }

    @FXML
    public void Guardar(){
        if(!txtFNomDest.getText().isEmpty() && !txtFPesoPaq.getText().isEmpty() && !txtFNomDest.getText().isEmpty()){
            Paquete paquete = new Paquete(txtFieldCodPaq.getText(), txtFNomDest.getText(), Double.parseDouble(txtFPesoPaq.getText()), CBDestinos.getValue());

            filePaq.EscribirPaquete(paquete);
            lbMensajeUsur.setText("Paquete guardado");
        }
        else{
            lbMensajeUsur.setText("Porfavor llene todos los campos");
        }
    }

    @FXML
    public void Cargar(){
        ArrayList<Destino> destinos = fileDes.LeerDestino();
        ArrayList<String> StrDestinos = Convertir(destinos);

        if(!destinos.isEmpty()){
            CBDestinos.getItems().addAll(StrDestinos);
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
}