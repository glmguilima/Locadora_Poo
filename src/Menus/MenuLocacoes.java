package Menus;

import Locadora.Carro;
import Locadora.ListaLocacoes;
import Locadora.ListaVeiculos;
import Locadora.Locacao;
import Utils.AppCor;

import java.util.Scanner;

/**
 * @author glmgu on 31/10/2022
 */
public class MenuLocacoes {
    long CPF;
    Scanner entrada = new Scanner(System.in);
    int op3;
    ListaVeiculos listaV =new ListaVeiculos();
    MenuCliente menuCliente= new MenuCliente();
    ListaLocacoes listaLocacoes = new ListaLocacoes();


    public void menuLocacoes() {
        menuCliente.preCadastros();
        do {
            System.out.println("\n" + AppCor.BLUE + "Menu de Gerenciamento de Locações" + AppCor.RESET + "\n");
            System.out.println(AppCor.GREEN + "1. Adiconar locaçoes");
            System.out.println("2. Buscar locações");
            System.out.println("3. Relação de todas locações ");
            System.out.println("4. Modificar informações de locações");
            System.out.println(AppCor.RED + "5. Excluir locação" + AppCor.RESET);
            System.out.println(AppCor.PURPLE + "0. Sair\n"+AppCor.RESET);
            op3 = entrada.nextInt();
            entrada.nextLine();
            switch (op3) {
                case 1:
                    addLocacao();
                    break;
                case 2:
                    buscaLocacao();
                    break;
                case 3:
                    allLoc();
                    break;
                case 4:

                    break;
                case 5:

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
        System.out.println("= = = = Adicionar Locações= = = =  ");
        System.out.println("Informe o CPF do cliente");
        CPF = entrada.nextLong();
        entrada.nextLine();
        System.out.println(listaV.getInfo());
        System.out.println("\n Informe a Placa do veiculo desejado"); // tem que fazer um tratamneto de veiculo locado
        String placa = entrada.nextLine();
        if(listaV.existe(placa)==false){
            System.out.println(AppCor.RED+" O veiculo não encontrado"+AppCor.RESET);
            addLocacao();
        }else {
            Locacao loc4 = new Locacao(menuCliente.listaC.get(CPF), listaV.get(placa), false, "23/10;2022", "25/10/2022");
            listaLocacoes.listaLoc.add(loc4);
            listaV.remove(placa);
            System.out.println("Gostaria de acionar o seguro? (1) Sim e (2) Não");
            int seg = entrada.nextInt();
            if (seg == 1) {
                loc4.setSeguro(true);
            } else loc4.setSeguro(false);
            System.out.println("Veiculo Locado");
            System.out.println(listaLocacoes.toString());
        }
    }
    public void buscaLocacao() {
        System.out.println("= = = = Bem vindo a  busca de Locação = = = = ");
        System.out.println("Digite o Código da Locação");
        int cod = entrada.nextInt();
        if (listaLocacoes.existe(cod)==true){
            System.out.println(AppCor.GREEN_BRIGHT+"Locação encontrado");
            System.out.println(listaLocacoes.get(cod)+AppCor.RESET);
        }else {
            System.out.println(AppCor.RED+"Locação não está cadastrada."+AppCor.RESET);
        }
    }

    public void allLoc(){
        System.out.println("= = = = Abaixo segue todos Locações = = = = ");
        if (listaLocacoes.listaLoc.size()==0){
            System.out.println(AppCor.RED + "Não há locações cadastradas."+AppCor.RESET);
        }else{
        System.out.println(AppCor.GREEN+listaLocacoes.listaLoc.toString()+AppCor.RESET);}
    }
    public void preCadastroVeiculos(){
        Carro car1 = new Carro("aaa1111",2022,30);
        Carro car2 = new Carro("aaa3333",2021,20);
        Carro car3 = new Carro("aaa2222",2020,10);
        listaV.listaVeiculo.add(car1);
        listaV.listaVeiculo.add(car2);
        listaV.listaVeiculo.add(car3);
    }

}
