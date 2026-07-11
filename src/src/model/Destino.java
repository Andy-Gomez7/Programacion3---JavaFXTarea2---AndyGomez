package model;

public class Destino {
    private String nombre;

    public Destino(String Nombre){
        SetNombre(Nombre);
    }

    public void SetNombre(String Nombre){
        nombre = Nombre;
    }

    public String GetNombre(){
        return nombre;
    }
}