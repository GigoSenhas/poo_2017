
/**
 * Escreva a descrição da classe Viaturas aqui.
 * 
 * @author (Bruno) 
 * @version (versão 1)
 */
public abstract class Viatura{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private String matricula;
    private int utilizado;
    private double velocidadeM;
    private double precoBase;
    private double fiabilidade;
    private int lugares;
    private Coordenadas local;
    

    /**
     * Construtor para objetos da classe Viaturas
     */
    public Viatura(){
        this.matricula="n/a";
        this.utilizado=0;
        this.velocidadeM=0.0;
        this.precoBase=0.0;
        this.fiabilidade=0.0;
        this.lugares=0;
        this.local= new Coordenadas(0,0);
    }
    
    public Viatura(String matricula,int util,double velocidadeM,double preco,double fiabilidade,int lugares,Coordenadas pt){
        this.matricula=matricula;
        this.utilizado=util;
        this.velocidadeM=velocidadeM;
        this.precoBase=preco;
        this.fiabilidade=fiabilidade;
        this.lugares=lugares;
        this.local=pt;
    }
    
    public Viatura(Viatura f){
        this(f.getMatricula(),f.getUtil(),f.getVelocidade(),f.getPreco(),f.getFiabilidade(),f.getLugares(),f.getCoord());
    }

    /**
     * Métodos
     * Gets e Sets
     */
    
    public String getMatricula(){
        return this.matricula;
    }
    
    public int getUtil(){
        return this.utilizado;
    }
    
    public double getVelocidade(){
        return this.velocidadeM;
    }
    
    public double getPreco(){
        return this.precoBase;
    }
    
    public double getFiabilidade(){
        return this.fiabilidade;
    }
    
    public int getLugares(){
        return this.lugares;
    }
    
    public Coordenadas getCoord(){
        return this.local;
    }
    
    public void setMatricula(String matricula){
        this.matricula=matricula;
    }
    
    public void setUtil(int n){
        this.utilizado=n;
    }
    
    public void setVelocidade(double veloc){
        this.velocidadeM=veloc;
    }
    
    public void setPreco(double preco){
        this.precoBase=preco;
    }
    
    public void setFiabilidade(double fia){
        this.fiabilidade=fiabilidade;
    }
    
    public void setLugares(int lug){
        this.lugares=lug;
    }
    
    public void setCoordenadas(Coordenadas pt){
        this.local=pt;
    }
    
     /**
     * Equals,clone,toString
     */
    
    //public abstract boolean equals(Object o);
    
    /**{
     *   if(o==this){
     *     return true;
     *   }
     *   
     *   if(o==null || o.getClass() != this.getClass()){
     *       return false;
     *   }
     *   
     *   Viaturas teste = (Viaturas) o;
     *   
     *   return teste.getVelocidade()==velocidadeM && teste.getPreco()==precoBase && teste.getFiabilidade()==fiabilidade;
     *  }
     */
    
    public abstract Viatura clone();
    
   
    public abstract String toString();
}
