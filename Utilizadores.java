import java.util.HashMap;
import java.util.ArrayList;
import java.util.*;
import java.io.*;

public class Utilizadores implements Serializable{
   private HashMap<String,Utilizador> utilizadores;

    /**
     * COnstrutor para objetos da classe Viaturas
     */
   public Utilizadores(){
        utilizadores=new HashMap<>();
   }
    
   public Utilizadores(Utilizadores users){
       this.utilizadores=new HashMap<>();
       HashMap<String,Utilizador> us=users.getUsers();
       for(String s:us.keySet()){
           Utilizador f=us.get(s).clone();
           this.utilizadores.put(s,f);
        }
   }
    
   public Utilizadores(HashMap<String,Utilizador> users){
        this.utilizadores=new HashMap<>();
       for(String s:users.keySet()){
           Utilizador f=users.get(s).clone();
           this.utilizadores.put(s,f);
        }
   }

    /**
     * Métodos
     */
   public void insereUtilizador(Utilizador f){
        utilizadores.put(f.getEmail(),f.clone());
   }
    
   public HashMap<String,Utilizador> getUsers(){
      HashMap<String,Utilizador> users=new HashMap<>();
      for(String s:this.utilizadores.keySet()){
          users.put(s,this.utilizadores.get(s).clone());
      }
      return users;
    }
    
   public List<String> listaMotoristas(){
       List<String> listamts = new ArrayList<>();
       
       for(String s: utilizadores.keySet()){
           if(s.equals("MT")){
               listamts.add(utilizadores.get(s).getEmail());
            }
        }
       
       return listamts;
   }
   
   public List<String> listaClientes(){
       List<String> listamts = new ArrayList<>();
       
       for(String s: utilizadores.keySet()){
           if(s.equals("CL")){
               listamts.add(utilizadores.get(s).getEmail());
            }
        }
       
       return listamts;
   }
    
   public int total(){
        return utilizadores.size();
   }

   public boolean verificaUtilizador(String email){
       return this.utilizadores.containsKey(email);
    }
}
