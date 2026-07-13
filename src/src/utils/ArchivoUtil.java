package utils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Destino;
import model.Paquete;

public class ArchivoUtil {

    private File archivo;

    public ArchivoUtil(String nombreArchivo){
        archivo = new File(nombreArchivo);
        
    }

    public void EscribirDestino(Destino destino) {
        try{
            
            FileWriter write = new FileWriter(archivo,true);
            BufferedWriter bufWrite = new BufferedWriter(write);

            bufWrite.write(destino.GetNombre());
            bufWrite.newLine();

            bufWrite.close();
                 
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void EscribirPaquete(Paquete paquete) {
        try{
            FileWriter write = new FileWriter(archivo,true);
            write.write(paquete.GetCodigo()+";"+paquete.GetDestinatario()+";"+paquete.GetPeso()+";"+paquete.GetDestino());
            write.close();

        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Destino> LeerDestino(){
        ArrayList<Destino> destinos = new ArrayList<>();
        
        try{
            FileReader read = new FileReader(archivo);
            BufferedReader bufread = new BufferedReader(read);

            String linea;

            while((linea =  bufread.readLine()) != null){
                Destino Destino = new Destino(linea);
                destinos.add(Destino);
            }

            read.close();
            bufread.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }

        return destinos;
    }

    public ArrayList<Paquete> LeerPaquete(){
        ArrayList<Paquete> paquetes = new ArrayList<>();
        
        try{
            FileReader read = new FileReader(archivo);
            BufferedReader bufread = new BufferedReader(read);
            
            String[] aux;

            String linea;

            while((linea =  bufread.readLine()) != null){
                aux = linea.split(";");
                if(aux.length == 4){
                    Paquete paquete = new Paquete(aux[0], aux[1], Double.parseDouble(aux[2]), aux[3]);
                    paquetes.add(paquete);
                }
            }

            read.close();
            bufread.close();

        }catch(IOException e){
            e.printStackTrace();
        }
        
        return paquetes;
    }
}