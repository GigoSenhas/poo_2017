import java.io.*;
/**
 * Escreva a descrição da classe Ligeiros aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Ligeiro extends Viatura implements Serializable{
    public Ligeiro(String matricula,int disp,double velocidade,double precoB,double fiabilidade,int lugares,int priv,Coordenadas pt){
       super(matricula,disp,velocidade,precoB,fiabilidade,lugares,priv,pt);
    }

    public Ligeiro(Ligeiro m){
        super(m.getMatricula(),m.getUtil(),m.getVelocidade(),m.getPreco(),m.getFiabilidade(),m.getLugares(),m.getPriv(),m.getCoord());
    }

    /**
     * Métodos
     */
    public boolean equals(Object o){
        if(o==this)
            return true;
        if(o==null || o.getClass()!=this.getClass())
            return false;
        Ligeiro l = (Ligeiro) o;
        return (super.equals(l));
    }
    
    public Ligeiro clone(){
        return new Ligeiro(this);
    }
    
    public String toString(){
     StringBuilder blela=new StringBuilder();
      
      blela.append("Matricula: "+this.getMatricula()+"\n");
      blela.append("Velocidade Média por Km: "+ this.getVelocidade()+"\n");
      blela.append("Preço Base: "+ this.getPreco()+"\n");
      blela.append("Fiabilidade: "+this.getFiabilidade()+"\n");
      blela.append("Lugares: "+this.getLugares()+"\n");
      blela.append("Coordenadas: "+this.getCoord().toString()+"\n");
      blela.append("----------------------------\n");
      
      return blela.toString();
    }
}
