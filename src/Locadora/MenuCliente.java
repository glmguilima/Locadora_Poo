package Locadora;

import Utils.AppCor;

import java.util.Scanner;

/**
 * @author glmgu on 31/10/2022
 */
public class MenuCliente {
    Cliente cliente;
    String nome,endereco;
    long CPF;
    int numCNH,telefone;
    Scanner entrada = new Scanner(System.in);
    ListaClientes listaC = new ListaClientes();

    public void menuCliente(){
        int op2;
        preCadastros();
        do {
            System.out.println("\n" + AppCor.BLUE + "Menu de Gerenciamento de Clientes" + AppCor.RESET + "\n");
            System.out.println(AppCor.GREEN + "1. Adiconar Cliente");
            System.out.println("2. Buscar Cliente");
            System.out.println("3. Modificar informações do Cliente");
            System.out.println(AppCor.RED + "4. Excluir Cliente" + AppCor.RESET);
            System.out.println(AppCor.PURPLE + "0. Sair\n"+AppCor.RESET);
            op2 = entrada.nextInt();
            entrada.nextLine();
            switch (op2) {
                case 1:
                    addCliente();

                    break;
                case 2:
                    buscarCliente();
                    break;
                case 3:
                    buscaAllClientes();
                    break;
                case 4:

                    break;
                case 0:

                    break;
                default:
                    System.out.println("Opção inválida");
                    System.out.println("digite uma opção correta");
            }
        } while(op2!=0);
    }


    public void addCliente(){

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
            listaC.listaCliente.add(cliente);
            System.out.println("Cliente cadastrado "+  listaC.get(CPF));
        } else {
            System.out.println(AppCor.RED+"Cliente já cadastrado com este CPF");
            System.out.println(listaC.get(CPF)+AppCor.RESET);
        }
    }

    public void buscarCliente(){
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

    public void preCadastros() {
        Cliente c1 = new Cliente("Teste", 123456789, 987654321, "rua1", 11);
        Cliente c2 = new Cliente("Teste2", 113456789, 997654321, "rua2", 22);
        Cliente c3 = new Cliente("Teste3", 111456789, 999654321, "rua3", 33);
        listaC.listaCliente.add(c1);
        listaC.listaCliente.add(c2);
        listaC.listaCliente.add(c3);

    }
}
