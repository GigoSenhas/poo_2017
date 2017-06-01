import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.time.LocalDate;
/**
 * Escreva a descrição da classe Motorista aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Motorista extends Utilizador{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private String carro;
    private int pontualidade;
    private int classificacao;
    private double kmsRealizados;
    private int working;
    private ArrayList<Viagem> viagens;
    
    /**
     * COnstrutor para objetos da classe Motorista
     */
    public Motorista(){
        super();
        this.carro=null;
        this.pontualidade=0;
        this.classificacao=0;
        this.kmsRealizados=0;
        this.viagens = new ArrayList<Viagem>();
    }
    
    public Motorista(String codigo,String email,String nome,String pass,LocalDate dataNascimento,String morada,String manz,int pontual,int classif,double kmsRealizados,int working,
                       ArrayList<Viagem> viag){
        super(codigo,email,nome,pass,dataNascimento,morada);
        this.pontualidade=pontual;
        this.classificacao=classif;
        this.kmsRealizados=kmsRealizados;
        this.carro=manz;
        this.working=working;
        if (viag!=null){
            for(Viagem f:viag){
                this.viagens.add(f.clone());
            }
        }
        else {this.viagens= new ArrayList<>();}
    }
    
    public Motorista(Motorista m){
        super(m);
        this.carro=m.getCarro();
        this.pontualidade=m.getPontualidade();
        this.classificacao=m.getClassif();
        this.viagens=m.getListViagem();
    }

    /**
     * Métodos
     * Gets e sets
     */
    public String getCarro(){
        return this.carro;
    }
    
    public int getPontualidade(){
        return this.pontualidade;
    }
    
    public int getClassif(){
        return this.classificacao;
    }
    
    public int getWorking(){
        return this.working;
    }
    
    public ArrayList<Viagem> getListViagem(){
       ArrayList<Viagem> vias= new ArrayList<>();
       if(viagens!=null){
            for(Viagem f: viagens){
            vias.add(f.clone());
           }
       }
       return vias;
    }
    
    public double getKmsRealizados(){
       return kmsFeitos();
    }
    
    public void setCarro(String mat){
        this.carro= mat;
    }
    
    public void comecarTrab(String mat){
        this.carro=mat;
    }
    
    public void pararTrab(){
        this.carro=null;
        this.working=1;
    }
    
    public void setPontualidade(int pontual){
        this.pontualidade=pontual;
    }
    
    public void setClassif(int classif){
        int n = this.viagens.size();
        int notafinal= (int) ((this.classificacao+classif)/n);
        this.classificacao=notafinal;
    }
    
    public void setWorking(int w){
        this.working=w;
    }
    
    /**
     * Equals,clone,toString
     */
    public boolean equals(Object o){
        if(this==o){
            return true;
        }
        
        if(o==null || o.getClass() != this.getClass()){
            return false;
        }
        
        Motorista a = (Motorista) o;
        return (super.equals(a) && this.pontualidade==a.getPontualidade() 
                  && this.classificacao==a.getClassif());
    }
    
    public Motorista clone(){
        return new Motorista(this);
    }
    
    public String toString(){
        StringBuilder manz= new StringBuilder(); 
        manz.append(super.toString());
        manz.append("Classificaçao: "+this.classificacao+"\n");
        return manz.toString();
    }
    
    /**
     * Métodos
     * Restantes Métodos
     */
    public void addViagem (Viagem f){
        if(f != null){
            this.viagens.add(f.clone());
        }
    }
    
    public void removeViagem(Viagem f){
        if(this.viagens.contains(f)){
            this.viagens.remove(f);
        }
    }
 
    private double kmsFeitos(){
        for(Viagem f : viagens){
            this.kmsRealizados += f.KmFeitos();
        }
        return this.kmsRealizados;
    }
}
   
