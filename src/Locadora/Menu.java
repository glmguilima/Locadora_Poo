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
                    addCliente();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    break;
                case 6:
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
        System.out.println(AppCor.GREEN_BRIGHT + "1.Cadastrar Cliente "+ AppCor.RESET) ;
        System.out.println(AppCor.GREEN_BRIGHT + "2."+ AppCor.RESET);
        System.out.println(AppCor.GREEN_BRIGHT + "3. "+ AppCor.RESET);
        System.out.println(AppCor.BLUE + "4. " + AppCor.RESET);
        System.out.println(AppCor.BLUE+"5. "+ AppCor.RESET);
        System.out.println(AppCor.RED+"6. "+ AppCor.RESET);
        System.out.println(AppCor.PURPLE + "0. Sair\n"+ AppCor.RESET);
        System.out.print(AppCor.WHITE_BOLD+ "Informe a opção desejada (0 a 6): "+ AppCor.RESET);
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
        System.out.println("Digite o numero da CNH do cliente");
        numCNH = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Digite o numero do telefone CNH do cliente");
        telefone = entrada.nextInt();
        entrada.nextLine();
        cliente = new Cliente(nome,CPF,numCNH,endereco,telefone);
        listaC.add(cliente);
        System.out.println("Cliente cadastrado "+  listaC.get(CPF));

    }

}
