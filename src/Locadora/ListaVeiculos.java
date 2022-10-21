package Locadora;

import Interfaces.IVeiculos;

import java.util.ArrayList;

/**
 * @author glmgu on 21/10/2022
 */
public class ListaVeiculos implements IVeiculos {
    ArrayList<Veiculo> listaVeiculo;

    public ListaVeiculos(){
        listaVeiculo = new ArrayList<Veiculo>();
    }

    @Override
    public void add(Veiculo v) {
        listaVeiculo.add(v);
    }

    @Override
    public Veiculo get(String placa) {
        for (int i = 0; i < listaVeiculo.size(); i++) {
            if (listaVeiculo.get(i).getPlaca()==placa){
                return  listaVeiculo.get(i);
            }
        }
        return null;
    }

    @Override
    public String getInfo(String placa) {
        for (int i = 0; i < listaVeiculo.size(); i++) {
            if(listaVeiculo.get(i).getPlaca()==placa) {
                return listaVeiculo.get(i).toString();
            }
        }
        return null;
    }

    @Override
    public String getInfo() {
        for (int i = 0; i < listaVeiculo.size(); i++) {
            return listaVeiculo.toString();
        }
        return null;
    }

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

    @Override
    public boolean remove(String placa) {
        for (int i = 0; i < listaVeiculo.size(); i++) {
            if(listaVeiculo.get(i).getPlaca()==placa){
                listaVeiculo.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existe(String placa) {
        for (int i = 0; i < listaVeiculo.size(); i++) {
            if(listaVeiculo.get(i).getPlaca()==placa){
            return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Lista de Veículos{" +
                "Veículos=" + listaVeiculo +
                '}';
    }
}
