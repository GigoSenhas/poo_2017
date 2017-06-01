
import java.util.ArrayList;
 
public class Umer {
    private ArrayList <Cliente> clientes = new ArrayList<>();
    private ArrayList <Viatura> veiculos = new ArrayList<>();
    private ArrayList <Motorista> motoristas = new ArrayList<>();
   
   public void adicionaCliente(Cliente c){
        clientes.add(c.clone());
   }
   
   public void adicionaVeiculo(Viatura veiculo){
        veiculos.add(veiculo.clone());
   }
   
   public void printClientes(){
       for (Cliente c : clientes){
           System.out.println (c.toString());
       }
   }
   
   public void printVeiculos(){
       for (Viatura c : veiculos){ 
           System.out.println (c.toString());
        }
   }
 
   public void adicionaMotorista(Motorista c){
        this.motoristas.add(c.clone());
   }
   
   public void printMotoristas(){
       for (Motorista c : this.motoristas){
           System.out.println (c.toString());
       }
   }
   
   
   public boolean verificaUtilizador(String email){
       for ( Cliente c: this.clientes){
           if(c.getEmail().equals(email)){ 
               return true;
            }
       }
    
       for( Motorista d: this.motoristas){
            if(d.getEmail().equals(email)) {
                return true;
            }
       }
       return false;
   }
   
   public int doTipo(String email){
       for ( Cliente c: this.clientes){
           if(c.getEmail().equals(email)){ 
               return 1;
            }
       }
    
       for( Motorista d: this.motoristas){
            if(d.getEmail().equals(email)) {
                return 2;
            }
       }
       return 0;
   }
   
   public Viatura buscaViatura(String mat){
       for(Viatura m: veiculos){
           if(m.getMatricula().equals(mat)){
               return m;
            }
        }
       return null;
    }
   
   public boolean verificaPassword(String password){
        for(Cliente c: this.clientes){ 
           if(c.getPassword().equals(password)) {
               return true;
           }
        }
        
        for(Utilizador d : this.motoristas){ 
            if(d.getPassword().equals(password)) {
                return true;
            } 
        }
        
        return false;
   }
   
   public void getListaViagens(String email,int tipo){
       if(tipo==1){
           for(Cliente c: clientes){
               if(c.getEmail().equals(email)){
                   if(c.getViagens()!=null){
                       System.out.println(c.getViagens().toString());
                   }
                   else{
                       System.out.println("Ainda não realizou nenhuma viage");
                    }
                }
            }
        }
       else{
           for(Motorista mt : motoristas){
               if(mt.getEmail().equals(email)){
                   if(mt.getListViagem() !=null){
                       System.out.println(mt.getListViagem().toString());
                    }
                    else{
                        System.out.println("Ainda não fez nenhuma viagem!");
                    }
                
                }
            }
        }
    }
   
   public void addTriptohist(String email,Viagem f){
       for(Cliente c: clientes){
           if(c.getEmail().equals(email)){
               c.addViagem(f);
            }
        }
   }
   
   public int verificaMatricula(String mat){
       for(Viatura carro : veiculos){
           if(carro.getMatricula().equals(mat)){
               return 1;
            }
        }
       return 0;
   }
   
   public void mtcriou(String email,String matricula){
       for(Motorista m: motoristas){
           if(m.getEmail().equals(email)){
               m.setCarro(matricula);
            }
        }
    }
    
   public void apresentaCarrosDisponiveis(){
       for(Viatura m: veiculos){
           if(m.getUtil()==0){
               System.out.println(m.toString());
           }
       }
   }
   
   public void setOFFCarro(String mat){
       for(Viatura m:veiculos){
           if(m.getMatricula().equals(mat)){
               m.setUtil(1);
            }
        }
    }
   
   public void setONCarro(String mat){
       for(Viatura m:veiculos){
           if(m.getMatricula().equals(mat)){
               m.setUtil(0);
            }
        }
   }
   
   public void setONMotor(String email,String mat,double x,double y){
       for(Motorista m: motoristas){
           if(m.getEmail().equals(email)){
               m.comecarTrab(mat);
               setOFFCarro(mat);
            }
        }
       
       for(Viatura m: veiculos){
           if(m.getMatricula().equals(mat)){
               m.setCoordenadas(new Coordenadas(x,y));
            }
        }
   }
   
   public void setOFFMotor(String email){
       String carro;
       for(Motorista m: motoristas){
           if(m.getEmail().equals(email)){
               m.pararTrab();
               carro=m.getCarro();
               setONCarro(carro);
            }
        }
    }
    
   public void apresentaMotoristasDisp(){
       for(Motorista m: motoristas){
           if(m.getCarro()!=null){
               System.out.println(buscaViatura(m.getCarro()));
            }
        }
    }
    
   public Viatura getViaturamaisprox(Coordenadas cliente){
       double result= Double.MAX_VALUE;
       Viatura v=null;
       for(Viatura m:veiculos){
           if(Coordenadas.calculaDistancia(cliente,m.getCoord()) <  result){
               result = Coordenadas.calculaDistancia(cliente,m.getCoord());
               v= m;
            }
        }
        return v;
    }
}

