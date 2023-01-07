package Menus;

import Listas.ListaClientes;
import Listas.ListaLocacoes;
import Listas.ListaVeiculos;
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
    MenuCliente menuCliente;
    ListaVeiculos listaV;
    ListaLocacoes listaLoc;
    ListaClientes listaC;

    public MenuLocacoes(ListaLocacoes listaLoc, ListaClientes listaC,ListaVeiculos listaV){
        this.listaLoc=listaLoc;
        this.listaC=listaC;
        this.listaV=listaV;
    }



    public void menuLocacoes() {
        do {
            System.out.println("\n" + AppCor.BLUE + "Menu de Gerenciamento de Locações" + AppCor.RESET + "\n");
            System.out.println(AppCor.GREEN_BRIGHT+ "1. Adiconar locaçoes");
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
                    modificarLocacao();
                    break;
                case 5:
                    excluirLocacao();
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
        if (listaC.existe(CPF)){
            System.out.println(AppCor.GREEN_BRIGHT+"O cliente que irá alugar é: "+listaC.get(CPF).getNome()+AppCor.RESET);
            System.out.println(listaV.getInfo());
            System.out.println("\n Informe a Placa do veiculo desejado");
            String placa = entrada.nextLine();
            if(listaV.existe(placa)==false){
                System.out.println(AppCor.RED+" O veiculo não encontrado"+AppCor.RESET);
                addLocacao();
            }else {
                System.out.println("Digite a data de Hoje no formato: dd/mm/yyyy");
                String dataInicial = entrada.nextLine();
                System.out.println("Digite a data de encerramento no formato: dd/mm/yyyy");
                String dataFinal = entrada.nextLine();
                Locacao nova = new Locacao(listaC.get(CPF), listaV.get(placa), false, dataInicial, dataFinal);
                listaLoc.add(nova);
                listaV.remove(placa); // Remove o veiculo da lista de veiculo disponivel
                System.out.println("Gostaria de acionar o seguro? (1) Sim e (2) Não");
                int seg = entrada.nextInt();
                if (seg == 1) {
                    nova.setSeguro(true);
                } else nova.setSeguro(false);
                System.out.println("Veiculo Locado");
                System.out.println(nova.toString());
            }
        }else {
            System.out.println(AppCor.RED+"Cliente não cadastrado"+AppCor.RESET);
        }
    }
    public void buscaLocacao() {
        System.out.println("= = = = Bem vindo a  busca de Locação = = = = ");
        System.out.println("Digite o Código da Locação");
        int cod = entrada.nextInt();
        if (listaLoc.existe(cod)==true){
            System.out.println(AppCor.GREEN_BRIGHT+"Locação encontrado");
            System.out.println(listaLoc.get(cod)+AppCor.RESET);
        }else {
            System.out.println(AppCor.RED+"Locação não está cadastrada."+AppCor.RESET);
        }
    }

    public void allLoc(){
        System.out.println("= = = = Abaixo segue todos Locações = = = = ");
        if (listaLoc.listaLocacoes.size()==0){
            System.out.println(AppCor.RED + "Não há locações cadastradas."+AppCor.RESET);
        }else{
            System.out.println(AppCor.GREEN+listaLoc.getInfo().toString()+AppCor.RESET);}
    }

    public void excluirLocacao() {
        System.out.println("Informe o Código da Locação: ");
        int cod = entrada.nextInt();
        if (listaLoc.existe(cod)==true) {
            System.out.println(AppCor.GREEN_BRIGHT+"Locação Encontrada");
            listaLoc.remove(cod);
        }else {
            System.out.println(AppCor.RED+"Locação não está cadastrada."+AppCor.RESET);
        }
    }

    public void modificarLocacao() {
        int opcao = 0;
        System.out.println("Segues a lista de locações em aberto");
        if (listaLoc.listaLocacoes.size()==0){
            System.out.println("Lista vazia, não há locações");
        }else{
            System.out.println(toString());
            System.out.println("Informe o Código de Locação: ");
            int cod = entrada.nextInt();
            entrada.nextLine();
            if(listaLoc.existe(cod)==true) {
                System.out.println(AppCor.GREEN_BRIGHT + "Locação Encontrada \n");
                System.out.println("O que deseja alterar: ");
                System.out.println("1. Seguro: ");
                System.out.println("2. Cliente: ");
                opcao = entrada.nextInt();
                entrada.nextLine();
                switch (opcao) {
                    case 1:
                        System.out.println("Deseja obter seguro: 1 - Sim | 2 - Não");
                        int seguro = entrada.nextInt();
                        entrada.nextLine();
                        if (seguro == 1) {
                            listaLoc.get(cod).setSeguro(true);
                        }
                        if (seguro == 0) {
                            listaLoc.get(cod).setSeguro(false);
                        } else {
                            System.out.println("Opção Inválida.");
                            break;
                        }

                    case 2:
                        System.out.println("Informe o CPF do novo cliente: ");
                        long novoCPF = entrada.nextLong();
                        entrada.nextLine();
                        if (listaC.existe(novoCPF) == false) {
                            System.out.println(AppCor.RED + " O Cliente não encontrado" + AppCor.RESET);
                            addLocacao();
                        } else {
                            listaLoc.get(cod).setSeguro(true);
                            System.out.println("Cliente da Locacao Alterado com Sucesso!!");
                            break;
                        }

                    case 3:
                        System.out.println(listaV.getInfo());
                        System.out.println("\n Informe a Placa do veiculo desejado"); // tem que fazer um tratamneto de veiculo locado
                        String novaPlaca = entrada.nextLine();
                        if (listaV.existe(novaPlaca) == false) {
                            System.out.println(AppCor.RED + " O veiculo não encontrado" + AppCor.RESET);
                        } else {

                            // get(cod).setVeiculo(listaV.get(novaPlaca));
                            System.out.println("Veiculo da Locacao Alterado com Sucesso!!");
                            break;

                        }
                    case 4:
                        System.out.println("Informe a nova data de Inicio");
                        String novaDataI = entrada.nextLine();

                        // get(cod).setDataInicial(novaDataI);
                        System.out.println("Data inicial da Locacao Alterada com Sucesso!!");
                        break;

                    case 5:
                        System.out.println("Informe a nova data final:");
                        String novaDataF = entrada.nextLine();

                        //get(cod).setDataFinal(novaDataF);
                        System.out.println("Data Final da Locacao Alterado com Sucesso!!");
                        break;
                    default:
                        System.out.println("Opção inválida");
                        System.out.println("digite uma opção correta");
                }
            }
            else {
                System.out.println(AppCor.RED+"Locação não está cadastrada."+AppCor.RESET);
            }
        }
    }


}
