import java.util.*;
/**
 * Escreva a descrição da classe Coordenadas aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Coordenadas{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private double x;
    private double y;

    /**
     * COnstrutor para objetos da classe Coordenadas
     */
    public Coordenadas(){
        this.x=0.0;
        this.y=0.0;
    }
    
    public Coordenadas(double x,double y){
        this.x=x;
        this.y=y;
    }
    
    public Coordenadas(Coordenadas pt){
        this(pt.getX(),pt.getY());
    }

    /**
     * Exemplo de método - substitua este comentário pelo seu próprio
     * 
     * @param  y   exemplo de um parâmetro de método
     * @return     a soma de x com y 
     */
    public double getX(){
        return this.x;
    }
    
    public double getY(){
        return this.y;
    }
    
    public void setX(double x){
        this.x=x;
    }
    
    public void setY(double y){
        this.y=y;
    }
    
    public Coordenadas clone(){
        return new Coordenadas(this);
    }
    
    public static double calculaDistancia(Coordenadas pt1,Coordenadas pt2){
        double dist;
        double x = Math.pow ((pt2.getX()-pt1.getX()),2);
        double y = Math.pow ((pt2.getY()-pt1.getY()),2);
        dist = Math.sqrt(x+y);
        return dist;
    }
    
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        
        if(o==null || this.getClass() != o.getClass()){
            return false;
        }
        
        Coordenadas pt =(Coordenadas) o;
        
        return this.x == pt.getX() && this.y == pt.getY();
    }
}
