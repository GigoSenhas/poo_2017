import java.util.ArrayList;
import java.time.LocalDate;
import java.io.*;
/**
 * Escreva a descrição da classe Cliente aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */

public class Cliente extends Utilizador implements Serializable{
    //Variáveis de instância
    private ArrayList<Viagem> viagens;
    
    public Cliente(){
        super();
        this.viagens= new ArrayList<>();
    }
    
    public Cliente(String code,String email,String nome,String pass,LocalDate dataNascimento,String morada,ArrayList<Viagem> viag){
        super(code,email,nome,pass,dataNascimento,morada);
        if (viag!=null){
            for(Viagem f:viag){
                this.viagens.add(f.clone());
            }
        }
        else {this.viagens= new ArrayList<>();}
    }
    
    public Cliente(Cliente c){
        super(c);
        this.viagens=getViagens();
    }
    //Métodos de Instância
    public ArrayList<Viagem> getViagens(){
        ArrayList<Viagem> vias= new ArrayList<>();
        if(viagens!=null){
            for(Viagem f: viagens){
                vias.add(f.clone());
            }
        }
        return vias;
    }
    
    public String toString(){
        StringBuilder novo= new StringBuilder();
        novo.append(super.toString());
        for(Viagem f: viagens){
            novo.append(f.toString());
        }
        return novo.toString();
    }
    
    public Cliente clone(){
        return new Cliente(this);
    }
    
    /**
     * Restantes métodos
     */
    public void addViagem (Viagem f){
        if(f != null){
            this.viagens.add(f.clone());
        }
    }
}
