package controller;


import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import model.Destino;
import utils.ArchivoUtil;

public class ConsultaDestinos {
    @FXML
    private ListView<String> ListView;

    @FXML
    private VBox Vbox;

    @FXML
    private Button btnCargar;

    @FXML
    private Label lbMensajeUsur;

    private ArchivoUtil fileDest;

    @FXML
    public void initialize(){
        fileDest = new ArchivoUtil("Destinos.txt");
    }

    @FXML
    public void Cargar(){
        ArrayList<Destino> destinos = fileDest.LeerDestino();
        ArrayList<String> StrDestinos = Convertir(destinos);

        if(!destinos.isEmpty()){
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
}