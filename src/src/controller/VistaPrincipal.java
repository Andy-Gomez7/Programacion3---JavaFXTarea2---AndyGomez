package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import utils.Navegacion;

public class VistaPrincipal {
    
    @FXML
    private AnchorPane AnchorPane;

    @FXML
    private MenuItem ItemConsltDest;

    @FXML
    private MenuItem ItemSalir;

    @FXML
    private MenuBar MenuBar;

    @FXML
    private Menu SMenuConsultar;

    @FXML
    private Menu SMenuOtros;

    @FXML
    private Menu SMenuRegistro;

    @FXML
    private MenuItem itemConsltPaq;

    @FXML
    private MenuItem itemRegDest;

    @FXML
    private MenuItem itemRegPaq;

    @FXML
    public void AbrirRegistroPaquetes(){
        Navegacion.abrirVentana("/view/RegistrodePaquetes.fxml", "Registro de paquetes");
    }

    @FXML
    public void AbrirRegistroDestinos(){
        Navegacion.abrirVentana("/view/RegistroDestinos.fxml", "Registro de destinos");
    }

    @FXML
    public void AbrirConsultaPaquetes(){
        Navegacion.abrirVentana("/view/ConsultaPaquetes.fxml", "Consulta de paquetes");
    }

    @FXML
    public void AbrirConsultaDestinos(){
        Navegacion.abrirVentana("/view/ConsultaDestinos.fxml", "Consulta de destinos");
    }
}