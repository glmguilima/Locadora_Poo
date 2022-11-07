package Menus;

import Listas.ListaLocacoes;
import Listas.ListaVeiculos;
import Locadora.Carro;
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
            System.out.println("\n" + AppCor.BLUE + "Menu de Gerenciamento de Loca��es" + AppCor.RESET + "\n");
            System.out.println(AppCor.GREEN_BRIGHT+ "1. Adiconar loca�oes");
            System.out.println("2. Buscar loca��es");
            System.out.println("3. Rela��o de todas loca��es ");
            System.out.println("4. Modificar informa��es de loca��es");
            System.out.println(AppCor.RED + "5. Excluir loca��o" + AppCor.RESET);
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
                    modificarLocacao();
                    break;
                case 5:
                    excluirLocacao();
                    break;
                default:
                    System.out.println("Op��o inv�lida");
                    System.out.println("digite uma op��o correta");
            }
        } while(op3!=0);
    }

    public void addLocacao(){
        System.out.println("= = = = Adicionar Loca��es= = = =  ");
        System.out.println("Informe o CPF do cliente");
        CPF = entrada.nextLong();
        entrada.nextLine();
        if (menuCliente.listaC.existe(CPF)){
            System.out.println(listaV.getInfo());
            System.out.println("\n Informe a Placa do veiculo desejado");
            String placa = entrada.nextLine();
            if(listaV.existe(placa)==false){
                System.out.println(AppCor.RED+" O veiculo n�o encontrado"+AppCor.RESET);
                addLocacao();
            }else {
                System.out.println("Digite a data de Hoje no formato: dd/mm/yyyy");
                String dataInicial = entrada.nextLine();
                System.out.println("Digite a data de encerramento no formato: dd/mm/yyyy");
                String dataFinal = entrada.nextLine();
                Locacao nova = new Locacao(menuCliente.listaC.get(CPF), listaV.get(placa), false, dataInicial, dataFinal);
                listaLocacoes.listaLoc.add(nova);
                listaV.remove(placa); // Remove o veiculo da lista de veiculo disponivel
                System.out.println("Gostaria de acionar o seguro? (1) Sim e (2) N�o");
                int seg = entrada.nextInt();
                if (seg == 1) {
                    nova.setSeguro(true);
                } else nova.setSeguro(false);
                System.out.println("Veiculo Locado");
                System.out.println(nova.toString());
            }
        }else {
            System.out.println(AppCor.RED+"Cliente n�o cadastrado"+AppCor.RESET);
        }
    }
    public void buscaLocacao() {
        System.out.println("= = = = Bem vindo a  busca de Loca��o = = = = ");
        System.out.println("Digite o C�digo da Loca��o");
        int cod = entrada.nextInt();
        if (listaLocacoes.existe(cod)==true){
            System.out.println(AppCor.GREEN_BRIGHT+"Loca��o encontrado");
            System.out.println(listaLocacoes.get(cod)+AppCor.RESET);
        }else {
            System.out.println(AppCor.RED+"Loca��o n�o est� cadastrada."+AppCor.RESET);
        }
    }

    public void allLoc(){
        System.out.println("= = = = Abaixo segue todos Loca��es = = = = ");
        if (listaLocacoes.listaLoc.size()==0){
            System.out.println(AppCor.RED + "N�o h� loca��es cadastradas."+AppCor.RESET);
        }else{
            System.out.println(AppCor.GREEN+listaLocacoes.getInfo().toString()+AppCor.RESET);}
    }

    public void excluirLocacao() {
        System.out.println("Informe o C�digo da Loca��o: ");
        int cod = entrada.nextInt();
        if (listaLocacoes.existe(cod)==true) {
            System.out.println(AppCor.GREEN_BRIGHT+"Loca��o Encontrada");
            listaLocacoes.listaLoc.remove(listaLocacoes.get(cod));
        }else {
            System.out.println(AppCor.RED+"Loca��o n�o est� cadastrada."+AppCor.RESET);
        }
    }

    public void modificarLocacao() {
    	int opcao = 0;
        System.out.println("Segues a lista de loca��es em aberto");
        if (listaLocacoes.listaLoc.size()==0){
            System.out.println("Lista vazia, n�o h� loca��es");
        }else{
            System.out.println(listaLocacoes.toString());
            System.out.println("Informe o C�digo de Loca��o: ");
            int cod = entrada.nextInt();
            entrada.nextLine();
            if(listaLocacoes.existe(cod)==true) {
                System.out.println(AppCor.GREEN_BRIGHT + "Loca��o Encontrada \n");
                System.out.println("O que deseja alterar: ");
                System.out.println("1. Seguro: ");
                System.out.println("2. Cliente: ");
                opcao = entrada.nextInt();
                entrada.nextLine();
                switch (opcao) {
                    case 1:
                        System.out.println("Deseja obter seguro: 1 - Sim | 2 - N�o");
                        int seguro = entrada.nextInt();
                        entrada.nextLine();
                        if (seguro == 1) {
                            listaLocacoes.get(cod).setSeguro(true);
                        }
                        if (seguro == 0) {
                            listaLocacoes.get(cod).setSeguro(false);
                        } else {
                            System.out.println("Op��o Inv�lida.");
                            break;
                        }

                    case 2:
                        System.out.println("Informe o CPF do novo cliente: ");
                        long novoCPF = entrada.nextLong();
                        entrada.nextLine();
                        if (menuCliente.listaC.existe(novoCPF) == false) {
                            System.out.println(AppCor.RED + " O Cliente n�o encontrado" + AppCor.RESET);
                            addLocacao();
                        } else {
                            listaLocacoes.get(cod).setSeguro(true);
                            System.out.println("Cliente da Locacao Alterado com Sucesso!!");
                            break;
                        }

                    case 3:
                        System.out.println(listaV.getInfo());
                        System.out.println("\n Informe a Placa do veiculo desejado"); // tem que fazer um tratamneto de veiculo locado
                        String novaPlaca = entrada.nextLine();
                        if (listaV.existe(novaPlaca) == false) {
                            System.out.println(AppCor.RED + " O veiculo n�o encontrado" + AppCor.RESET);
                        } else {

                            // listaLocacoes.get(cod).setVeiculo(listaV.get(novaPlaca));
                            System.out.println("Veiculo da Locacao Alterado com Sucesso!!");
                            break;

                        }
                    case 4:
                        System.out.println("Informe a nova data de Inicio");
                        String novaDataI = entrada.nextLine();

                        // listaLocacoes.get(cod).setDataInicial(novaDataI);
                        System.out.println("Data inicial da Locacao Alterada com Sucesso!!");
                        break;

                    case 5:
                        System.out.println("Informe a nova data final:");
                        String novaDataF = entrada.nextLine();

                        //listaLocacoes.get(cod).setDataFinal(novaDataF);
                        System.out.println("Data Final da Locacao Alterado com Sucesso!!");
                        break;
                }
            }
            else {
                System.out.println(AppCor.RED+"Loca��o n�o est� cadastrada."+AppCor.RESET);
            }
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
