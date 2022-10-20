package Locadora;

import Interfaces.IClientes;

import java.util.ArrayList;

/**
 * @author glmgu on 17/10/2022
 */
public class ListaClientes implements IClientes {
    ArrayList<Cliente> lista;

    public ListaClientes() {
        lista = new ArrayList<Cliente>();
    }


    @Override
    public void add(Cliente c) {
        lista.add(c);
    }

    @Override
    public Cliente get(long CPF) {
        for (int i = 0; i < lista.size() ; i++) {
            if(lista.get(i).getCPF()==CPF){
                return lista.get(i);
            }
        }
        return null;
    }

    @Override
    public String getInfo(long CPF) {
        for (int i = 0; i < lista.size() ; i++) {
            if(lista.get(i).getCPF()==CPF){
                return lista.get(i).toString();
            }
        }
        return null;
    }

    @Override
    public String getInfo() {
        for (int i = 0; i < lista.size() ; i++) {
            return lista.toString();
        }
        return null;
    }

    @Override
    public String getResumoInfo() {
        String dados= "";
        for (int i = 0; i < lista.size() ; i++) {
            dados += " Nome: "+ lista.get(i).getNome()+ " CPF: "+lista.get(i).getCPF()+"\n";
        }
        return dados;
    }


    @Override
    public boolean remove(long CPF) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCPF()==CPF){
                lista.remove(lista.get(i));
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existe(long CPF) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCPF() == CPF) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "ListaClientes{" +
                "lista=" + lista +
                '}';
    }
}