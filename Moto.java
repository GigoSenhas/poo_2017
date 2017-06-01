
/**
 * Escreva a descrição da classe Moto aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Moto extends Viatura{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio

    /**
     * COnstrutor para objetos da classe Moto
     */
    public Moto(){
        super();
    }
    
    public Moto(String matricula,int disp,double velocidade,double precoB,double fiabilidade,int lugares,Coordenadas pt){
       super(matricula,disp,velocidade,precoB,fiabilidade,lugares,pt);
    }

    public Moto(Moto m){
        super(m.getMatricula(),m.getUtil(),m.getVelocidade(),m.getPreco(),m.getFiabilidade(),m.getLugares(),m.getCoord());
    }

    /**
     * Métodos
     */
    public Moto clone(){
        return new Moto(this);
    }
    
    public String toString(){
     StringBuilder blela=new StringBuilder();
      
      blela.append("Matricula:"+this.getMatricula()+"\n");
      blela.append("Velocidade Média por Km: "+ this.getVelocidade()+"\n");
      blela.append("Preço Base: "+ this.getPreco()+"\n");
      blela.append("Fiabilidade: "+this.getFiabilidade()+"\n");
      blela.append("Lugares: "+this.getLugares()+"\n");
      blela.append("Coordenadas:"+this.getCoord().toString()+"\n");
      blela.append("----------------------------\n");
      
      return blela.toString();
    }
}
