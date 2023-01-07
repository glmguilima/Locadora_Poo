package Menus;

import Exceptions.MinhaExcecoes;
import Listas.ListaClientes;
import Locadora.Cliente;
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
    static ListaClientes listaC ;

    public MenuCliente(ListaClientes listaC){
        this.listaC = listaC;
    }

    public void menuCliente() throws MinhaExcecoes {
        int op2;
        do {
            System.out.println("\n" + AppCor.BLUE + "Menu de Gerenciamento de Clientes" + AppCor.RESET + "\n");
            System.out.println(AppCor.GREEN_BRIGHT+"1. Adiconar Cliente"); //ok
            System.out.println("2. Buscar Cliente"); // ok
            System.out.println("3. Buscar todos os Clientes"); // ok
            System.out.println("4. Modificar Cliente"); // falta implementar.
            System.out.println(AppCor.RED + "5. Excluir Cliente" + AppCor.RESET); // ok
            System.out.println(AppCor.PURPLE + "0. Voltar ao menu anterior\n"+AppCor.RESET);
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
                    modificarC();
                    break;
                case 5:
                    excluirCliente();
                    break;
                case 0:

                    break;
                default:
                    System.out.println("Opção inválida");
                    System.out.println("digite uma opção correta");
            }
        } while(op2!=0);
    }


    public void addCliente() throws MinhaExcecoes {
        System.out.println("= = = = Bem vindo ao Cadastro de Cliente = = = = ");
        System.out.println("Digite o nome do cliente");
        nome = entrada.nextLine();
        System.out.println("Digite o endereco do cliente");
        endereco = entrada.nextLine();
        System.out.println("Digite o CPF do cliente");
        try {
            CPF = entrada.nextLong();
            entrada.nextLine();
            if (String.valueOf(CPF).length() == 9) {
            }
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
        }catch (MinhaExcecoes e1){e1.printStackTrace();
        }
    }

    public void excluirCliente(){
        System.out.println("Digite o CPF do cliente");
        CPF = entrada.nextLong();
        entrada.nextLine();
        if (listaC.existe(CPF)==true){
            System.out.println(AppCor.GREEN_BRIGHT+"Cliente encontrado");
            listaC.listaCliente.remove(listaC.get(CPF));
            System.out.println("Cliente Excluído.");
        }else {
            System.out.println(AppCor.RED+"O cliente não está cadastrado."+AppCor.RESET);
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
        System.out.println(listaC.listaCliente.toString());
    }

    public void modificarC() {
        int opcao = 0;
        System.out.println("Digite o CPF do Cliente:");
        CPF = entrada.nextLong();
        entrada.nextLine();
        if(listaC.existe(CPF)==true) {
            System.out.println("O que deseja alterar :");
            System.out.println(AppCor.GREEN_BRIGHT+ "1.Nome ");
            System.out.println( "2.CPF");
            System.out.println("3.CNH ");
            System.out.println("4.Endereço");
            System.out.println("5.Telefone");
            System.out.println(AppCor.PURPLE + "0. Voltar ao menu anterior"+AppCor.RESET);
            opcao = entrada.nextInt();
            entrada.nextLine();
            switch(opcao) {
                case 1:
                    System.out.println("Informe o novo Nome do Cliente:");
                    String nome = entrada.nextLine();
                    listaC.get(CPF).setNome(nome);
                    System.out.println("Nome alterado com sucesso: "+listaC.get(CPF).getNome());
                    break;
                case 2:
                    System.out.println("Informe o novo CPF do Cliente: ");
                    Long novoCPF = entrada.nextLong();
                    entrada.nextLine();
                    listaC.get(CPF).setCPF(novoCPF);
                    System.out.println("CPF alterado com sucesso: "+listaC.get(novoCPF));
                    break;
                case 3:
                    System.out.println("Informe a nova CNH do Cliente: ");
                    int numCNH = entrada.nextInt();
                    entrada.nextLine();
                    listaC.get(CPF).setNumCNH(numCNH);
                    System.out.println("CNH alterada com sucesso: "+listaC.get(numCNH));
                    break;
                case 4:
                    System.out.println("Informe o novo Endereço do Cliente: ");
                    String endereco = entrada.nextLine();
                    listaC.get(CPF).setEndereco(endereco);
                    System.out.println("Endereço alterado com sucesso: "+listaC.get(CPF).getEndereco());
                    break;
                case 5:
                    System.out.println("Informe o novo Telefone do Cliente: ");
                    int telefone = entrada.nextInt();
                    entrada.nextLine();
                    listaC.get(CPF).setTelefone(telefone);
                    System.out.println("Telefone alterado com sucesso: "+listaC.get(CPF).getTelefone());
                    break;
                default:
                    System.out.println("Opção inválida");
                    System.out.println("Digite uma opção correta");
            }
        }else {
            System.out.println(AppCor.RED+"O cliente não está cadastrado."+AppCor.RESET);
        }
    }


    public void preCadastros() throws MinhaExcecoes {
        Cliente c1 = null;
        try {
            c1 = new Cliente("Teste", 123456789, 987654321, "rua1", 11);
        } catch (MinhaExcecoes e) {
            e.printStackTrace();
        }
        Cliente c2 = null;
        try {
            c2 = new Cliente("Teste2", 113456789, 997654321, "rua2", 22);
        } catch (MinhaExcecoes e) {
            e.printStackTrace();
        }
        Cliente c3 = null;
        try {
            c3 = new Cliente("Teste3", 111456789, 999654321, "rua3", 33);
        } catch (MinhaExcecoes e) {
            e.printStackTrace();
        }
        listaC.add(c1);
        listaC.add(c2);
        listaC.add(c3);
    }


}
