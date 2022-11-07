package Menus;

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
    ListaClientes listaC = new ListaClientes();

    public void menuCliente(){
        int op2;
        do {
            System.out.println("\n" + AppCor.BLUE + "Menu de Gerenciamento de Clientes" + AppCor.RESET + "\n");
            System.out.println(AppCor.GREEN_BRIGHT+"1. Adiconar Cliente");
            System.out.println("2. Buscar Cliente");
            System.out.println("3. Buscar todos os Clientes");
            System.out.println("4. Modificar Cliente"); // falta implementar.
            System.out.println(AppCor.RED + "5. Excluir Cliente" + AppCor.RESET);
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
            System.out.println("\n" + AppCor.GREEN_BRIGHT+ "1.Nome "+"\n");
            System.out.println( "2.CPF");
            System.out.println("3.CNH ");
            System.out.println("4.Endereço");
            System.out.println("4.Telefone"); // falta implementar.
            System.out.println(AppCor.PURPLE + "0. Voltar ao menu anterior\n"+AppCor.RESET);
            opcao = entrada.nextInt();
            entrada.nextLine();
            switch(opcao) {
                case 1:
                    System.out.println("Informe o novo Nome do Cliente:");
                    String nome = entrada.nextLine();
                    listaC.get(CPF).setNome(nome);
                    System.out.println("Nome alterado com sucesso: "+listaC.get(CPF).getNome());

                case 2:
                    System.out.println("Informe o novo CPF do Cliente: ");
                    Long novoCPF = entrada.nextLong();
                    entrada.nextLine();
                    listaC.get(CPF).setCPF(novoCPF);
                    System.out.println("CPF alterado com sucesso: "+listaC.get(novoCPF));

                case 3:
                    System.out.println("Informe a nova CNH do Cliente: ");
                    int numCNH = entrada.nextInt();
                    entrada.nextLine();
                    listaC.get(CPF).setNumCNH(numCNH);
                    System.out.println("CNH alterada com sucesso: "+listaC.get(numCNH));


                case 4:
                    System.out.println("Informe o novo Endereço do Cliente: ");
                    String endereco = entrada.nextLine();
                    listaC.get(CPF).setEndereco(endereco);
                    System.out.println("Endereço alterado com sucesso: "+listaC.get(CPF).getEndereco());

                case 5:
                    System.out.println("Informe o novo Telefone do Cliente: ");
                    int telefone = entrada.nextInt();
                    entrada.nextLine();
                    listaC.get(CPF).setTelefone(telefone);
                    System.out.println("Telefone alterado com sucesso: "+listaC.get(CPF).getTelefone());


            }
        }else {
            System.out.println(AppCor.RED+"O cliente não está cadastrado."+AppCor.RESET);
        }
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
