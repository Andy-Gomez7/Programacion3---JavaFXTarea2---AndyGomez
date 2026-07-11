package model;

public class Paquete {
    private String codigo;
    private String destinatario;
    private Double peso;
    private String destino;

    public Paquete(String codigo, String destinatario, Double peso, String destino){
        SetCodigo(codigo);
        SetDestinatario(destinatario);
        SetPeso(peso);
        SetDestino(destino);
    }

    public void SetCodigo(String Codigo){
        codigo = Codigo;
    }

    public String GetCodigo(){
        return codigo;
    }
    
    public void SetDestinatario(String Destinatario){
        destinatario = Destinatario;
    }

    public String GetDestinatario(){
        return destinatario;
    }   

    public void SetPeso(Double Peso){
        peso = Peso;
    }

    public Double GetPeso(){
        return peso;
    }   

    public void SetDestino(String Destino){
        destino = Destino;
    }

    public String GetDestino(){
        return destino;
    }   
}