package Menus;

import Listas.ListaVeiculos;
import Locadora.Caminhao;
import Locadora.Carro;
import Locadora.Onibus;
import Locadora.Veiculo;
import Utils.AppCor;

import java.util.Scanner;

/**
 * @author glmgu on 06/11/2022
 */
public class MenuVeiculos {
    String placa;
    int op2, ano;
    double diaria;
    Scanner entrada = new Scanner(System.in);
    ListaVeiculos listaV;


    public MenuVeiculos(ListaVeiculos listaV){
        this.listaV=listaV;
    }

    public void menuVeiculos(){
        int op3;
        do {
            System.out.println("\n" + AppCor.BLUE + "Menu de Gerenciamento de Clientes" + AppCor.RESET + "\n");
            System.out.println( AppCor.GREEN_BRIGHT+"1. Adiconar Veiculo");
            System.out.println("2. Buscar Veiculo");
            System.out.println("3. Buscar todos os Veículos");
            System.out.println("4. Modificar Veículo");
            System.out.println(AppCor.RED + "5. Excluir Veículo" + AppCor.RESET);
            System.out.println(AppCor.PURPLE + "0. Voltar ao menu anterior\n"+AppCor.RESET);
            op3 = entrada.nextInt();
            entrada.nextLine();
            switch (op3) {
                case 1:
                    addVeiculo();
                    break;
                case 2:
                    buscarVeiculo();
                    break;
                case 3:
                    System.out.println( listaV.toString());
                    break;
                case 4:
                    modificaVeiculo();
                    break;
                case 5:
                    excluirVeiculo();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida");
                    System.out.println("digite uma opção correta");
            }
        } while(op3!=0);
    }

    public void addVeiculo(){
        System.out.println("= = = = Adicionar Veículos= = = =  ");
        System.out.println("Informe a placa do cliente");
        placa = entrada.nextLine();
        if (listaV.existe(placa)==true){
            System.out.println("Veiculo já cadastrado.");
            System.out.println(listaV.get(placa));
        }else {
            System.out.println("Selecionar tipo de veiculo");
            System.out.println("1. Carro ; 2. Ônibus 3. Caminhão");
            op2 = entrada.nextInt();
            entrada.nextLine();
            switch (op2) {
                case 1:
                    novoCar();
                    break;
                case 2:
                    novoOni();
                    break;
                case 3:
                    novoCam();
                    break;
                default:
                    System.out.println("Opção inválida");
                    System.out.println("digite uma opção correta");
            }
        }

    }

    public void novoCar(){
        System.out.println("Digite o ano do carro");
        ano=entrada.nextInt();
        System.out.println("Digite o valor da diaria");
        diaria= entrada.nextDouble();
        Carro novoCar = new Carro(placa,ano,diaria);
        listaV.add(novoCar);
        System.out.println("veiculo cadastrado");
    }
    public void novoOni(){
       System.out.println("Digite o ano do Ônibus");
        ano=entrada.nextInt();
        System.out.println("Digite o valor da diária");
        diaria= entrada.nextDouble();
        Onibus novoO = new Onibus(placa,ano,diaria);
        listaV.add(novoO);
        System.out.println("veiculo cadastrado");
    }
    public void novoCam(){
        System.out.println("Digite o ano do Caminhão");
        ano=entrada.nextInt();
        System.out.println("Digite o valor da diária");
        diaria= entrada.nextDouble();
        Caminhao novoCam = new Caminhao(placa,ano,diaria);
        listaV.add(novoCam);
        System.out.println("veiculo cadastrado");
    }
    public void buscarVeiculo(){
        System.out.println("informe a placa do veiculo");
        placa=entrada.nextLine();
        if (listaV.existe(placa)==true){
            System.out.println(listaV.get(placa).toString());
        }
        else {
            System.out.println("Veiculo nao cadastrado");
        }
    }
    public void excluirVeiculo(){
        System.out.println("informe a placa do veiculo");
        placa=entrada.nextLine();
        if (listaV.existe(placa)==true){
            listaV.remove(placa);
            System.out.println("veiculo removido");
        }
        else {
            System.out.println("Veiculo nao cadastrado");
        }
    }

    public void modificaVeiculo(){
        int opcao = 0;
        System.out.println("Digite a Placa do veiculo:");
        placa = entrada.nextLine();
        if (listaV.existe(placa)==true){
            System.out.println("O que deseja alterar :");
            System.out.println("\n" + AppCor.GREEN_BRIGHT+ "1.placa ");
            System.out.println( "2.Ano");
            System.out.println("3.Diária");
            System.out.println(AppCor.PURPLE + "0. Voltar ao menu anterior\n"+AppCor.RESET);
            opcao = entrada.nextInt();
            entrada.nextLine();
            switch(opcao) {
                case 1:
                    System.out.println("Informe a Nova placa do veiculo  ");
                    String placaNova = entrada.nextLine();
                    listaV.get(placa).setPlaca(placaNova);
                    System.out.println(AppCor.GREEN+"Placa alterada com sucesso: "+listaV.getInfo(placaNova)+AppCor.RESET);
                    break;
                case 2:
                    System.out.println("Informe o novo Ano do Veículo: ");
                    int novoAno = entrada.nextInt();
                    entrada.nextLine();
                    listaV.get(placa).setAno(novoAno);
                    System.out.println(AppCor.GREEN+"Ano alterado com sucesso: "+listaV.getInfo(placa)+AppCor.RESET);
                    break;
                case 3:
                    System.out.println("Informe a nova Diária do Veículo: ");
                    double diariaNova = entrada.nextDouble();
                    entrada.nextLine();
                    listaV.get(placa).setValorDiaria(diariaNova);
                    System.out.println(AppCor.GREEN+"Diária alterada com sucesso: "+listaV.getInfo(placa)+AppCor.RESET);
                    break;
                default:
                    System.out.println("Opção inválida");
                    System.out.println("Digite uma opção correta");
            }
        }else {
            System.out.println(AppCor.RED+"O Veiculo não está cadastrado."+AppCor.RESET);
        }
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
