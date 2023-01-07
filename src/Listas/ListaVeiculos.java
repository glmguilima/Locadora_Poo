package Listas;

import Interfaces.IVeiculos;
import Locadora.Veiculo;

import java.util.ArrayList;

/**
 * @author glmgu on 21/10/2022
 */
public class ListaVeiculos implements IVeiculos {
    public ArrayList<Veiculo> listaVeiculo;

    public ListaVeiculos(){
        listaVeiculo = new ArrayList<Veiculo>();
    }

    /**
     *
     * @param v Veiculo a ser inserido.
     */
    @Override
    public void add(Veiculo v) {
        listaVeiculo.add(v);
    }

    /**
     *
     * @param placa Placa do veiculo a ser capturado.
     * @return veiculo
     */
    @Override
    public Veiculo get(String placa) {
        for (Veiculo veiculo : listaVeiculo) {
            if (veiculo.getPlaca().equals(placa))
                return veiculo;
        }
        return null;
    }

    /**
     *
     * @param placa Placa do veículo a ser capturado.
     * @return informações do veículo.
     */
    @Override
    public String getInfo(String placa) {
        for (int i = 0; i < listaVeiculo.size(); i++) {
            if(listaVeiculo.get(i).getPlaca().equals(placa)) {
                return listaVeiculo.get(i).toString();
            }
        }
        return null;
    }

    /**
     *
     * @return informações de todos os veiculos.
     */
    @Override
    public String getInfo() {
        for (int i = 0; i < listaVeiculo.size(); i++) {
            return listaVeiculo.toString();
        }
        return null;
    }

    /**
     *
     * @return Placa ano e diaria de todos os veiculos
     */
    @Override
    public String getResumoInfo() {
        String dados= "";
        for (int i = 0; i < listaVeiculo.size(); i++) {
            dados+= "==== Carro Placa: "+listaVeiculo.get(i).getPlaca()+ "; Ano: "+
                    listaVeiculo.get(i).getAno()+
                    ";  Valor diária: "+listaVeiculo.get(i).getValorDiaria()+" ====\n";
        }
        return dados;
    }

    /**
     *
     * @param placa Placa do veiculo a ser capturado.
     * @return remove veiculo da lista
     */
    @Override
    public boolean remove(String placa) {
        for (int i = 0; i < listaVeiculo.size(); i++) {
            if(listaVeiculo.get(i).getPlaca().equals(placa)){
                listaVeiculo.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param placa Placa do veiculo a ser verificada.
     * @return verifica existencia
     */
    @Override
    public boolean existe(String placa) {
        for (int i = 0; i < listaVeiculo.size(); i++) {
            if(listaVeiculo.get(i).getPlaca().equals(placa)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Lista de Veículos{" +
                "\nVeículos=" + listaVeiculo +
                '}';
    }
}
