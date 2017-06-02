import java.io.*;
/**
 * Escreva a descrição da classe Viagem aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */

public class Viagem implements Serializable{
    private String cl;
    private String mt;
    private Coordenadas origem;
    private Coordenadas destino;
    private double preco;
    
    public Viagem (){
        this.cl = "n/a";
        this.mt= "n/a";
        this.origem=new Coordenadas();
        this.destino=new Coordenadas();
        this.preco=0.0;
    }
    
    public Viagem(String cl,String mt,Coordenadas inicio,Coordenadas fim,double preco){
        this.cl = cl;
        this.mt= mt;
        this.origem=inicio;
        this.destino=fim;
        this.preco=preco;
    }
    
    public Viagem(Viagem f){
        this.cl=getCl();
        this.mt= getMt();
        this.origem=f.getOrigem();
        this.destino=f.getDestino();
        this.preco=f.getPreco();
    }
    
    public void setOrigem(Coordenadas inicio){
        this.origem=inicio;
    }
    
    public void setDestino(Coordenadas fim){
        this.destino=fim;
    }
    
    public String getCl(){
        return this.cl;
    }
    
    public String getMt(){
        return this.mt;
    }
    
    public Coordenadas getOrigem(){
        return this.origem;
    }
    
    public Coordenadas getDestino(){
        return this.destino;
    }
    
    public double getPreco(){
        return this.preco;
    }
    
    public boolean equals(Object o){
        
     if(this == o) return true;
       
       
     if(o == null ||o.getClass() != this.getClass()){ 
         return false;
     }
     
     Viagem f = (Viagem) o;
     
     if(f.getOrigem()==origem && f.getDestino()==destino);
            return true;
    }
    
    public Viagem clone(){
        return new Viagem(this);
    }
    
    public double KmFeitos(){
        double dist;
        double x = Math.pow ((this.origem.getX()-this.destino.getX()),2);
        double y = Math.pow ((this.origem.getY()-this.destino.getY()),2);
        dist = Math.sqrt(x+y);
        return dist;
    }
    
    public String toString(){
        StringBuilder sb= new StringBuilder();
        sb.append("Cliente: "+this.cl.toString()+"\n");
        sb.append("Motorista: "+this.mt.toString()+"\n");
        sb.append("Posição inicial: "+this.origem.toString()+"\n");
        sb.append("Posição final: "+this.destino.toString()+"\n");
        sb.append("KilometrosFeitos: "+ KmFeitos()+"\n");
        sb.append("Preço da Viagem: "+this.preco+"\n");
        
        return sb.toString();
    }
        
}
