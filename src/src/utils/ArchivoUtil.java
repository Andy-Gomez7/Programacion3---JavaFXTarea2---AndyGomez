package utils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import model.Destino;
import model.Paquete;

public class ArchivoUtil {

    private File archivo;

    public ArchivoUtil(String nombreArchivo){
        archivo = new File(nombreArchivo);
        
    }

    public void EscribirArch(Destino destino) {
        try{
            if(archivo.exists()){
                FileWriter write = new FileWriter("Registro de destino.txt",true);
                BufferedWriter bufWrite = new BufferedWriter(write);

                bufWrite.write(destino.GetNombre());
                bufWrite.newLine();

                bufWrite.close();
            }         
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void EscribirArch(Paquete paquete) {
        try{
            if(archivo.exists()){
                FileWriter write = new FileWriter("Registro de paquete.txt",true);
                BufferedWriter bufWrite = new BufferedWriter(write);

                bufWrite.write(paquete.GetCodigo()+";"+paquete.GetDestinatario()+";"+paquete.GetPeso()+";"+paquete.GetDestino());

                bufWrite.close();
            }         
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void LeerArch(){
           try{
            FileReader read = new FileReader("Leer Registro.txt");
            BufferedReader bufread = new BufferedReader(read);

            String linea;

            while((linea =  bufread.readLine()) != null){
                System.out.println(linea);
                System.out.println();
            }
            bufread.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}