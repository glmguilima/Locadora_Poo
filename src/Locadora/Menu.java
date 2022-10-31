package Locadora;

import Utils.AppCor;

import java.util.Scanner;

/**
 * @author glmgu on 21/10/2022
 */
public class Menu {
   private Scanner entrada = new Scanner(System.in);
    private int op;
    private ListaVeiculos listaV = new ListaVeiculos();
    private ListaLocacoes listaL = new ListaLocacoes();
    private ListaClientes listaC = new ListaClientes();

    public void Menu(){
        do{
            telaInicial();
            op = entrada.nextInt();
            entrada.nextLine();
            switch(op){
                case 1:
                   menuGerenciarClientes();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    buscaAllClientes();
                    break;
                case 6:
                    buscaALLLocacoes();
                    break;
                case 0: break;
                default:
                    System.out.println("Opção inválida");
                    System.out.println("digite uma opção correta");
            }
        }while(op!=0);
    }

    public void telaInicial(){
        System.out.println("\n"+ AppCor.BLUE +"Locadora De Fora da Pampa"+"\n"+AppCor.RESET);
        System.out.println(AppCor.GREEN_BRIGHT + "1.Gerenciar Cliente ") ;
        System.out.println( "2.Gerenciar Locações");
        System.out.println( "3. ");
        System.out.println("4. ");
        System.out.println("5.Relação de todos os Clientes ");
        System.out.println("6. Relação de todas Locações"); //Em espera
        System.out.println(AppCor.PURPLE + "0. Sair\n");
        System.out.print( "Informe a opção desejada (0 a 6): "+ AppCor.RESET);
    }

// Opções para clientes

    public void menuGerenciarClientes(){
        int op2 ;
        do {
            System.out.println("\n" + AppCor.BLUE + "Menu de Gerenciamento de Clientes" + AppCor.RESET + "\n");
            System.out.println(AppCor.GREEN + "1. Adiconar Cliente");
            System.out.println("2. Buscar Cliente");
            System.out.println("3. Modificar informações do Cliente");
            System.out.println(AppCor.RED + "4. Excluir Cliente" + AppCor.RESET);
            op2 = entrada.nextInt();
            entrada.nextLine();
            switch (op2) {
                case 1:
                    addCliente();
                    Menu();
                    break;
                case 2:
                    buscarCliente();
                    Menu();
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 0:
                    Menu();
                    break;
                default:
                    System.out.println("Opção inválida");
                    System.out.println("digite uma opção correta");
            }
        } while(op2!=0);
    }


    public void addCliente(){
        Cliente cliente;
        String nome,endereco;
        long CPF;
        int numCNH,telefone;
        System.out.println("= = = = Bem vindo ao Cadastro de Cliente = = = = ");
        System.out.println("Digite o nome do cliente");
        nome = entrada.nextLine();
        System.out.println("Digite o endereco do cliente");
        endereco = entrada.nextLine();
        System.out.println("Digite o CPF do cliente");
        CPF = entrada.nextLong();
        entrada.nextLine();
        if (listaC.existe(CPF)==false){
            System.out.println("Digite o numero da CNH do cliente");
            numCNH = entrada.nextInt();
            entrada.nextLine();
            System.out.println("Digite o numero do telefone do cliente");
            telefone = entrada.nextInt();
            entrada.nextLine();
            cliente = new Cliente(nome,CPF,numCNH,endereco,telefone);
            listaC.add(cliente);
            System.out.println("Cliente cadastrado "+  listaC.get(CPF));
            } else {
            System.out.println(AppCor.RED+"Cliente já cadastrado com este CPF");
            System.out.println(listaC.get(CPF)+AppCor.RESET);
            }
    }

    public void buscarCliente(){
        Cliente cliente;
        long CPF;
        System.out.println("= = = = Bem vindo a  busca de Cliente = = = = ");
        System.out.println("Digite o CPF do cliente");
        CPF = entrada.nextLong();
        entrada.nextLine();
        if (listaC.existe(CPF)==true){
            System.out.println(AppCor.GREEN_BRIGHT+"Cliente encontrado");
            System.out.println(listaC.get(CPF)+AppCor.RESET);
        }else {
            System.out.println(AppCor.RED+"O cliente não está cadastrado."+AppCor.RESET);
        }
    }

    public void buscaAllClientes(){
        System.out.println("= = = = Abaixo segue todos os clientes cadastrados = = = = ");
        System.out.println(listaC.getInfo());
    }

// opções para locações

    public void menuGerenciarLocacoes() {
        int op3;
        do {
            System.out.println("\n" + AppCor.BLUE + "Menu de Gerenciamento de Locações" + AppCor.RESET + "\n");
            System.out.println(AppCor.GREEN + "1. Adiconar locaçoes");
            System.out.println("2. Buscar locações");
            System.out.println("3. Modificar informações de locações");
            System.out.println(AppCor.RED + "4. Excluir locação" + AppCor.RESET);
            op3 = entrada.nextInt();
            entrada.nextLine();
            switch (op3) {
                case 1:
                    
                    Menu();
                    break;
                case 2:
                    
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 0:
                    Menu();
                    break;
                default:
                    System.out.println("Opção inválida");
                    System.out.println("digite uma opção correta");
            }
        } while(op3!=0);
    }

    public void addLocacao(){
        Locacao locacao;
    }
    public void buscaALLLocacoes(){
        System.out.println("= = = = Abaixo segue todos as locações realizada  = = = = ");
        System.out.println(listaL.getInfo()); 

    }
    
}
