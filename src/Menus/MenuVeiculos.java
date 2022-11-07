package Menus;

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
    Veiculo veiculo;
    Carro carrro;
    Onibus onibus;
    Caminhao caminhao;
    String placa;
    int op2, ano;
    double diaria;
    Scanner entrada = new Scanner(System.in);
    MenuLocacoes menuLocacoes =new MenuLocacoes();

    public void menuVeiculos(){
        menuLocacoes.preCadastroVeiculos();
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
                    System.out.println( menuLocacoes.listaV.toString());
                    break;
                case 4://falta implementar
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
        if (menuLocacoes.listaV.existe(placa)==true){
            System.out.println("Veiculo já cadastrado.");
            System.out.println(menuLocacoes.listaV.get(placa));
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
        menuLocacoes.listaV.add(novoCar);
        System.out.println("veiculo cadastrado");
    }
    public void novoOni(){
       System.out.println("Digite o ano do Ônibus");
        ano=entrada.nextInt();
        System.out.println("Digite o valor da diária");
        diaria= entrada.nextDouble();
        Onibus novoO = new Onibus(placa,ano,diaria);
        menuLocacoes.listaV.add(novoO);
        System.out.println("veiculo cadastrado");
    }
    public void novoCam(){
        System.out.println("Digite o ano do Caminhão");
        ano=entrada.nextInt();
        System.out.println("Digite o valor da diária");
        diaria= entrada.nextDouble();
        Caminhao novoCam = new Caminhao(placa,ano,diaria);
        menuLocacoes.listaV.add(novoCam);
        System.out.println("veiculo cadastrado");
    }
    public void buscarVeiculo(){
        System.out.println("informe a placa do veiculo");
        placa=entrada.nextLine();
        if (menuLocacoes.listaV.existe(placa)==true){
            System.out.println(menuLocacoes.listaV.get(placa).toString());
        }
        else {
            System.out.println("Veiculo nao cadastrado");
        }
    }
    public void excluirVeiculo(){
        System.out.println("informe a placa do veiculo");
        placa=entrada.nextLine();
        if (menuLocacoes.listaV.existe(placa)==true){
            menuLocacoes.listaV.remove(placa);
            System.out.println("veiculo removido");
        }
        else {
            System.out.println("Veiculo nao cadastrado");
        }
    }


}
