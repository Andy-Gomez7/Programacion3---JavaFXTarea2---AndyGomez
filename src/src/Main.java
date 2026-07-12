import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) throws Exception {
       launch(args); 
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/VistaPrincipal.fxml"));

        Scene scene = new Scene(loader.load());

        primaryStage.setTitle("Sistema de paquetes y destinos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}