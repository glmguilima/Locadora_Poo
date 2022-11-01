package Locadora;

import Utils.AppCor;

import java.util.Scanner;

/**
 * @author glmgu on 31/10/2022
 */
public class MenuLocacoes {
    long CPF;
    Scanner entrada = new Scanner(System.in);
    int op3;
    ListaVeiculos listaVeiculos=new ListaVeiculos();
    MenuCliente menuCliente= new MenuCliente();

    public void menuLocacoes() {
        int op3;
        do {
            System.out.println("\n" + AppCor.BLUE + "Menu de Gerenciamento de Locações" + AppCor.RESET + "\n");
            System.out.println(AppCor.GREEN + "1. Adiconar locaçoes");
            System.out.println("2. Buscar locações");
            System.out.println("3. Modificar informações de locações");
            System.out.println(AppCor.RED + "4. Excluir locação" + AppCor.RESET);
            System.out.println(AppCor.PURPLE + "0. Sair\n"+AppCor.RESET);
            op3 = entrada.nextInt();
            entrada.nextLine();
            switch (op3) {
                case 1:
                addLocacao();
                    break;
                case 2:
                   ;

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 0:

                    break;
                default:
                    System.out.println("Opção inválida");
                    System.out.println("digite uma opção correta");
            }
        } while(op3!=0);
    }

    public void addLocacao(){
        System.out.println("nova locacao ");
        System.out.println("CPF");
        CPF = entrada.nextLong();
        entrada.nextLine();
        System.out.println(menuCliente.listaC.listaCliente.toString());
        Locacao loc4 = new Locacao(menuCliente.listaC.get(CPF), listaVeiculos.get("iii2222"),false,"23/10;2022","25/10/2022");


    }

}
