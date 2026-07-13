package controller;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import model.Destino;
import model.Paquete;
import utils.ArchivoUtil;

public class ConsultaPaquetes {

    @FXML
    private ListView<String> ListView;

    @FXML
    private VBox Vbox;

    @FXML
    private Button btnCargar;

    @FXML
    private Label lbMensajeUsur;

    private ArchivoUtil filePaq;

    @FXML
    public void initialize(){
        filePaq = new ArchivoUtil("Paquetes.txt");
    }

    @FXML
    public void Cargar(){
        ArrayList<Paquete> paquetes = filePaq.LeerPaquete();
        ArrayList<String> StrDestinos = Convertir(paquetes);

        if(!paquetes.isEmpty()){
            ListView.getItems().addAll(StrDestinos);
            lbMensajeUsur.setText("Paquetes cargados");    
        }
        else{
            lbMensajeUsur.setText("El registro de paquetes esta vacio");
        }
        
    }

    private ArrayList<String> Convertir(ArrayList<Paquete> paquetes){
        ArrayList<String> StrDestinos = new ArrayList<>();

        for(int i = 0; i < paquetes.size(); i++){
            StrDestinos.add(paquetes.get(i).GetCodigo()+";"+paquetes.get(i).GetDestinatario()+";"+paquetes.get(i).GetPeso()+";"+paquetes.get(i).GetDestino());
        }

        return StrDestinos;
    }
}