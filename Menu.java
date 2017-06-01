 
import static java.lang.Boolean.FALSE;
import static java.lang.System.out;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.*;
import java.lang.String;
 
public class Menu {
 
    Umer umer = new Umer();
 
    public void menu() {
        Scanner entrada = new Scanner(System.in);
        int menu;
        
        System.out.println("----*MENU*----");
        System.out.println("(1)- Login");
        System.out.println("(2)- Registar");
        System.out.println("(0)- Sair");
        out.println("--------------");
        menu = entrada.nextInt();
 
        if (menu == 1) {
            login();
        }
        
        if (menu == 2) {
            registo();
        }
        
        if (!((menu == 1) || (menu == 2) || (menu == 0))) {
            System.out.println("Opção inválida");
            menu();
        }
    }
 
    public void login() {
 
        Scanner scan = new Scanner(System.in);
 
        String email, password;
 
        out.println("Insira o seu email:");
        email = scan.next().trim();
        out.println("Insira a sua password:");
        password = scan.next();
        if (!(umer.verificaUtilizador(email,password))) {
            out.println("Oops, email ou password inválida");
            login();
        } 
        
            
        else {
            int getTipe=umer.doTipo(email);
            out.println("Está agora online");
            if(getTipe==1){
                menuafterlogCliente(email);
            }
                
            if(getTipe==2){
                menuafterlogMotorista(email);
            }
        }
    }
    
    public void menuafterlogCliente(String email){
        int op;
        
        
        Scanner scan = new Scanner(System.in);
        out.println("-----*UMER-Cliente*-----");
        out.println("(1)-Histórico");
        out.println("(2)-Fazer uma viagem");
        out.println("(3)-Terminar Sessão");
        out.println("------------------------");
        
        op=scan.nextInt();
        
        if (op==1) {
                umer.getListaViagens(email,1);
                menuafterlogCliente(email);
        }
        
        if (op==2) {
            double x,y,fx,fy;
            int lop;
            System.out.println("Indique a sua posição:");
            out.println("x:");
            x=scan.nextDouble();
            out.println("y:");
            y=scan.nextDouble();
            out.println("Indique o seu destino");
            out.println("x:");
            fx=scan.nextDouble();
            out.println("y:");
            fy=scan.nextDouble();
            out.println("Escolha:");
            out.println("(1)-Viatura mais próxima");
            out.println("(2)-Escolher viatura");
            lop=scan.nextInt();
            Coordenadas spotcl = new Coordenadas(x,y);
            Coordenadas spotfinal = new Coordenadas(fx,fy);
            double distfinal = Coordenadas.calculaDistancia(spotcl,spotfinal);
            if(lop==1){
                Viatura lindo=umer.getViaturamaisprox(spotcl);
                double tempo= umer.getTempomaisprox(spotcl);
                String mtDAviagem = umer.getMotoristaViagem(lindo);
                double dura= umer.getTimeTrip(lindo.getMatricula(),spotcl,spotfinal);
                double preco= umer.getPrecoViagem(spotcl,spotfinal,lindo.getMatricula());
                Viagem nova = new Viagem(email,mtDAviagem,spotcl,spotfinal,preco);
                out.println("Viatura in coming:\n"+ lindo.toString());
                out.println("Tempo para o taxi chegar a si: " + tempo);
                umer.addTriptohist(email,nova,mtDAviagem);
                teladeClass(mtDAviagem,dura,preco,email);
            }
            
            if(lop==2){
                umer.apresentaCarrosworking();
                String linda;
                out.println("Digite a matricula da viatura que pretende utilizar:");
                linda=scan.next();
                int ver=umer.verificaMatricula(linda);
                if(ver==1){
                    Viatura m=umer.buscaViatura(linda);
                    double dura= umer.getTimeTrip(linda,spotcl,spotfinal);
                    double preco= umer.getPrecoViagem(spotcl,spotfinal,linda);
                    double time= umer.getTempoTaxi(spotcl,m);
                    String mtDAviagem = umer.getMotoristaViagem(m);
                    Viagem trip=new Viagem(email,mtDAviagem,spotcl,spotfinal,preco);
                    out.println(trip.toString());
                    out.println("Viatura in coming:\n"+ m.toString());
                    out.println("Tempo para o taxi chegar a si: " + time);
                    umer.addTriptohist(email,trip,mtDAviagem);
                    teladeClass(mtDAviagem,dura,preco,email);
                }
                
                else{
                    out.println("Matricula inválida");
                    menuafterlogCliente(email);
                }
            }
            
            if(lop != 1 || lop!= 2){
            }
        }
        
        if(op==3){
            menu();
        }
        
        if(op!=1 && op!=2 && op!=3){
            out.println("Opção inválida");
            menuafterlogCliente(email);
        }
    }
    
    public void teladeClass(String motorista, double dura,double preco,String email){
        int nota;
        Scanner scan = new Scanner(System.in);
        System.out.println("Duração da Viagem: " +dura);
        System.out.println("Motorista: "+ motorista);
        System.out.println("Preço: "+preco);
        System.out.println("Dar uma nota ao motorista (0-100):");
        nota=scan.nextInt();
        
        umer.atualizaClassif(nota,motorista);
        menuafterlogCliente(email);
    }
    
    public void menuafterlogMotorista(String email){
        int op;
 
        Scanner scan = new Scanner(System.in);
        out.println("-----*UMER*-Motorista-----");
        out.println("(1)-Histórico");
        out.println("(2)-Trabalhar com viatura da empresa");
        out.println("(3)-Trabalhar com a sua viatura");
        out.println("(4)-Encerrar trabalho");
        out.println("(5)-Sair");
        out.println("--------------------------");
        
        op=scan.nextInt();
        
        if(op==1){
            umer.getListaViagens(email,2);
            menuafterlogMotorista(email);
        }
        
        if(op==2){
            String mat;
            double x,y;
            umer.apresentaCarrosDisponiveis();
            out.println("Introduza a matrícula do carro que quer Utilizar:");
            mat=scan.next();
            out.println("A sua localização:");
            out.println("X:");
            x=scan.nextDouble();
            out.println("Y:");
            y=scan.nextDouble();
            umer.setONMotor(email,mat,x,y);
            menuafterlogMotorista(email);
        }
        
        if(op==3){
            criaViatura(email);
        }
        
        if(op==4){
            umer.setOFFMotor(email);
            menuafterlogMotorista(email);
        }
        
        if(op==5){
            menu();
        }
        
        if(op!=1 || op!=2 || op!=3 || op!=4 || op!=5){
            out.println("Opção inválida");
            menuafterlogMotorista(email);
        }
    }
 
    public void registo() {
        Scanner scan = new Scanner(System.in);
        String utilizador;
        out.println("----*REGISTO*----");
        out.println("Quer se registar como:");
        out.println("(1)- Cliente");
        out.println("(2)- Motorista");
        out.println("-----------------");
        utilizador = scan.next();
        if ("1".equals(utilizador)) {
            registaCliente();
        }
        
        if ("2".equals(utilizador)) {
            registaMotorista();
        }
    }
 
    public void registaCliente() {
        Scanner scan = new Scanner(System.in);
        int ano, mes, dia;
        String email, nome, password, morada;
        LocalDate dataNascimento;
        out.println("Email:");
        email = scan.next().trim();
        if (!email.contains("@")){
            out.println("Email não é válido");
            registaCliente();
        }
        out.println("Nome:");
        nome = scan.next().trim();
        out.println("Password:");
        password = scan.next().trim();
        if(password.length() < 4){
            out.println("Password demasiado pequena");
            registaCliente();
        }
        out.println("Morada:");
        morada = scan.next().trim();
        out.println("Data de Nascimento:\n Ano:");
        ano = scan.nextInt();
        out.println("Mes:");
        mes = scan.nextInt();
        out.println("Dia:");
        dia = scan.nextInt();
        dataNascimento = LocalDate.of(ano, mes, dia);
        Cliente c = new Cliente("CL",email, nome, password, dataNascimento, morada,null);
        umer.adicionaCliente(c);
        menu();
    }
 
    public void registaMotorista() {
        Scanner scan = new Scanner(System.in);
        int x, y,op, ano, mes, dia;
        String email, nome, password, morada;
        LocalDate dataNascimento;
        out.println("Email:");
        email = scan.next().trim();
        if(!email.contains("@")){
            out.println("Email não é válido");
            registaMotorista();
        }
        out.println("Nome:");
        nome = scan.next().trim();
        out.println("Password: (Pelo menos 4 carateres)");
        password = scan.next().trim();
        if(password.length() < 4){
            out.println("Password demasiado pequena");
            registaMotorista();
        }
        out.println("Morada:");
        morada = scan.next().trim();
        out.println("Data de Nascimento:\n Ano:");
        ano = scan.nextInt();
        out.println("Mes:");
        mes = scan.nextInt();
        out.println("Dia:");
        dia = scan.nextInt();
        dataNascimento = LocalDate.of(ano, mes, dia);
        Motorista m = new Motorista("MT",email, nome, password, dataNascimento,morada,null,0,0,0.0,0,null);
        umer.adicionaMotorista(m);
        out.println("Conta criada");
        menu();
    }
 
    public void criaViatura(String email) {
        int op;
        Scanner scan = new Scanner(System.in);
        out.println("(1)-Já criei viatura");
        out.println("(2)-Criar viatura nova");
        op=scan.nextInt();
       if(op==1){
           String mat;
           out.println("Insira a matricula do seu veiculo");
           mat=scan.next();
           int novo=umer.verificaMatricula(mat);
           if(novo==1){
            double x,y;
            out.println("A sua localização:");
            out.println("X:");
            x=scan.nextDouble();
            out.println("Y:");
            y=scan.nextDouble();
            umer.setONMotor(email,mat,x,y);
           }
           else{
               out.println("Não existe veiculo com essa matricula");
               criaViatura(email);
            }
       }
        
       if(op==2){
        String viatura,mat;
        int lugs,engodo;
        double velocidadeMedia, precoBaseporKm,x,y;
        out.println("Que viatura quer criar?");
        out.println("(1)-Moto");
        out.println("(2)-Veiculo Ligeiro");
        out.println("(3)-Carrinha de 9 Lugares");
        viatura = scan.next().trim();
 
        if ("1".equals(viatura)) {
            out.println("Matricula:");
            mat=scan.next();
            engodo=umer.verificaMatricula(mat);
            if(engodo != 0){
                out.println("Erro:Matricula já existe!");
                criaViatura(email);
            }
            out.println("Velociade Media da Viatura?");
            velocidadeMedia = scan.nextDouble();
            out.println("Preco Base por Km?");
            precoBaseporKm = scan.nextDouble();
            out.println("Quantos Lugares?");
            lugs=scan.nextInt();
            out.println("A sua localização:");
            out.println("X:");
            x=scan.nextDouble();
            out.println("Y:");
            y=scan.nextDouble();
            if(lugs > 3 || lugs <= 0){
                out.println("Dados fornecidos incompativeis!");
                criaViatura(email);
            }
            
            else{
                Moto moto = new Moto(mat,0,velocidadeMedia, precoBaseporKm,0.0,lugs,0,new Coordenadas(x,y));
                out.println("Veiculo Criado");
                umer.adicionaVeiculo(moto);
                umer.mtcriou(email,mat);
                menuafterlogMotorista(email);
            }
        }
        
        if ("2".equals(viatura)) {
            out.println("Matricula:");
            mat=scan.next();
            engodo=umer.verificaMatricula(mat);
            if(engodo != 0){
                out.println("Erro:Matricula já existe!");
                criaViatura(email);
            }
            out.println("Velociade Media da Viatura?");
            velocidadeMedia = scan.nextDouble();
            out.println("Preco Base por Km?");
            precoBaseporKm = scan.nextDouble();
            out.println("Quantos Lugares?");
            lugs=scan.nextInt();
            out.println("A sua localização:");
            out.println("X:");
            x=scan.nextDouble();
            out.println("Y:");
            y=scan.nextDouble();
            
            if(lugs > 7 || lugs <= 0){
                out.println("Dados fornecidos incompativeis!");
                criaViatura(email);
            }
            
            else{
                Ligeiro ligeiro = new Ligeiro(mat,0,velocidadeMedia, precoBaseporKm,0.0,lugs,0,new Coordenadas(x,y));
                out.println("Veiculo Criado");
                umer.adicionaVeiculo(ligeiro);
                umer.mtcriou(email,mat);
                menuafterlogMotorista(email);
            }
        }
        
        if ("3".equals(viatura)) {
            out.println("Matricula:");
            mat=scan.next();
            engodo=umer.verificaMatricula(mat);
            if(engodo != 0){
                out.println("Erro:Matricula já existe!");
                criaViatura(email);
            }
            out.println("Velociade Media da Viatura?");
            velocidadeMedia = scan.nextDouble();
            out.println("Preco Base por Km?");
            precoBaseporKm = scan.nextDouble();
            out.println("A sua localização:");
            out.println("X:");
            x=scan.nextDouble();
            out.println("Y:");
            y=scan.nextDouble();
            NoveLugares carrinha = new NoveLugares(mat,0,velocidadeMedia, precoBaseporKm,0.0,9,0,new Coordenadas(x,y));
            out.println("Veiculo Criado");
            umer.adicionaVeiculo(carrinha);
            umer.mtcriou(email,mat);
            menuafterlogMotorista(email);
        }
 
        if (!(("1".equals(viatura)) || ("2".equals(viatura)) || "3".equals(viatura))) {
            out.println("Opção inválida");
            criaViatura(email);
        }
       }
       
       if(op!=1 || op!=2){
           out.println("Opção inválida");
           
        }
    }
}