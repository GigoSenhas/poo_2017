import java.time.LocalDate;
/**
 * Escreva a descrição da classe Utilizador aqui.
 * 
 * @author 
 * @version 1;
 */
public abstract class Utilizador{
    // variáveis de instância
    private String codigo;
    private String email;
    private String nome;
    private String password;
    private LocalDate dataNascimento;
    private String morada;

    /**
     * COnstrutor para objetos da classe Utilizador
     */
    public Utilizador(){
        this.codigo="n/a";
        this.email="n/a";
        this.nome="n/a";
        this.password="n/a";
        this.dataNascimento=LocalDate.now();
        this.morada="n/a";
    }
    
    public Utilizador(String cod,String user,String nome,String pass,LocalDate birth,String morada){
        this.codigo=cod;
        this.email=user;
        this.nome=nome;
        this.password=pass;
        this.dataNascimento=birth;
        this.morada=morada;
    }
    
    public Utilizador(Utilizador f){
        this(f.getCodigo(),f.getEmail(),f.getNome(),f.getPassword(),f.getDataNasci(),f.getMorada());
    }

    /**
     * Métodos
     * Gets e Sets;
     */
    public String getEmail(){
        return this.email;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getCodigo(){
        return this.codigo;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public LocalDate getDataNasci(){
        return this.dataNascimento;
    }
    
    public String getMorada(){
        return this.morada;
    }
    
    public void setCodigo(String code){
        this.codigo=code;
    }
    
    public void setEmail(String email){
        this.email=email;
    }
    
    public void setNome(String nome){
        this.nome=nome;
    }
    
    public void setPassword(String pass){
        this.password=pass;
    }
    
    public void setDataNasc(LocalDate data){
        this.dataNascimento=data;
    }
    
    public void setMorada(String morada){
        this.morada=morada;
    }
    
    /**
     * Equals e clone
     */
    
    public abstract Utilizador clone();
    
     public String toString(){
        StringBuilder estranho=new StringBuilder();
        
        estranho.append("Código: "+this.codigo);
        estranho.append("Email: "+ this.email);
        estranho.append("Nome: "+ this.nome);
        estranho.append("Password: "+ this.password);
        estranho.append("Data de Nascimento: "+ this.dataNascimento);
        estranho.append("Morada: "+this.morada);
        
        return estranho.toString();
    }
    
    /*
    public boolean equals(Object o){
        if(o==this){
            return true;
        }
        
        if(o==null || o.getClass() != this.getClass()){
            return false;
        }
        
        Utilizador teste= (Utilizador) o;
        
        return teste.getEmail().equals(email) && teste.getNome().equals(nome) && teste.getPassword().equals(password) 
                && teste.getDataNasci().equals(dataNascimento)  && teste.getMorada().equals(morada);
    }
    
    public Utilizador clone(){
        return new Utilizador(this);
    }
    */
}
