package Menus;

import Listas.ListaClientes;
import Listas.ListaLocacoes;
import Listas.ListaVeiculos;
import Utils.AppCor;

import java.util.Scanner;

/**
 * @author glmgu on 21/10/2022
 */
public class Menu {
    long CPF;
    Scanner entrada = new Scanner(System.in);
    int op;

    ListaClientes listaClientes = new ListaClientes();
    ListaLocacoes listaLocacoes = new ListaLocacoes();
    ListaVeiculos listaVeiculos = new ListaVeiculos();
    MenuVeiculos menuVeiculos = new MenuVeiculos(listaVeiculos);
    MenuCliente menuCliente =new MenuCliente(listaClientes);
    MenuLocacoes menuLocacoes = new MenuLocacoes(listaLocacoes,listaClientes,listaVeiculos);

    public void iniciarMenu(){

        menuCliente.preCadastros();
        menuVeiculos.preCadastroVeiculos();
        do{
            telaInicial();
            op = entrada.nextInt();
            entrada.nextLine();
            switch(op){
                case 1:
                  menuCliente.menuCliente();
                    break;
                case 2:
                    menuLocacoes.menuLocacoes();
                    break;
                case 3:
                    menuVeiculos.menuVeiculos();
                    break;
                case 4:

                    System.out.println(menuCliente.listaC.getResumoInfo());
                    break;
                case 5:
                    System.out.println(menuLocacoes.listaLoc.toString());
                    break;
                case 6:
                    System.out.println( menuVeiculos.listaV.toString());
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
        System.out.println( "3.Gerenciar Veículos");
        System.out.println("4.Relação de todos os Clientes ");
        System.out.println("5.Relação de todas as locações ");
        System.out.println("6.Relação de todos os veículos "); //Em espera
        System.out.println(AppCor.PURPLE + "0. Sair\n");
        System.out.print( "Informe a opção desejada (0 a 6): "+ AppCor.RESET);
    }


}
