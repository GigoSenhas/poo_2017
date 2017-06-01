/**
 * Escreva a descrição da classe Viagem aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */

public class Viagem{
    private double xI,yI;
    private double xF,yF;
    
    public Viagem (){
        xI = yI =xF =yF=0;
    }
    
    public Viagem(double xI,double yI,double xF,double yF){
        this.xI = xI;
        this.xF = xF;
        this.yI = yI;
        this.yF = yF;
    }
    
    public Viagem(Viagem f){
        this.xI = f.getXI();
        this.xF = f.getXF();
        this.yI = f.getYI();
        this.yF = f.getYF();
    }
    
    public void setXI(double xI){
        
        this.xI = xI;
    }
    
    public void setYI(double yI){
        this.yI = yI;
    }
    
    public void setXF(double xF){
        this.xF = xF;
    }
    
    public void setYF(double yF){
        this.yF = yF;
    }
    
    public double getXI(){
        return this.xI;
    }
    
    public double getXF(){
        return this.xF;
    }
    
    public double getYI(){
        return this.yI;
    }
    
    public double getYF(){
        return this.yF;
    }
    
    public boolean equals(Object o){
        
     if(this == o) return true;
       
       
     if(o == null ||o.getClass() != this.getClass()){ 
         return false;
     }
     
     Viagem f = (Viagem) o;
     
     if(f.getXI()==xI && f.getXF()==xF && f.getYI()==yI && f.getYF()==yF);
            return true;
    }
    
    public Viagem clone(){
        return new Viagem(this);
    }
    
    public double KmFeitos(){
         
        double kms;
        double x = Math.pow ((this.getXF()-this.getXI()),2);
        double y = Math.pow ((this.getYF()-this.getYI()),2);
        kms = Math.sqrt(x+y);
        return kms;
    }
    
    public String toString(){
        StringBuilder sb= new StringBuilder();
        sb.append("Posição inicial: X: "+this.xI+" ;Y: "+this.yI);
        sb.append("Posição final: X: "+this.xF+" ;Y: "+this.yF);
        sb.append("KilometrosFeitos: "+ KmFeitos());
        
        return sb.toString();
    }
        
}
