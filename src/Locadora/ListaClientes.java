package Locadora;

import Interfaces.IClientes;

import java.util.ArrayList;

/**
 * @author glmgu on 17/10/2022
 */
public class ListaClientes implements IClientes {
    ArrayList<Cliente> listaCliente;

    public ListaClientes() {
        listaCliente = new ArrayList<Cliente>();
    }


    @Override
    public void add(Cliente c) {
        listaCliente.add(c);
    }

    @Override
    public Cliente get(long CPF) {
        for (int i = 0; i < listaCliente.size() ; i++) {
            if(listaCliente.get(i).getCPF()==CPF){
                return listaCliente.get(i);
            }
        }
        return null;
    }

    @Override
    public String getInfo(long CPF) {
        for (int i = 0; i < listaCliente.size() ; i++) {
            if(listaCliente.get(i).getCPF()==CPF){
                return listaCliente.get(i).toString();
            }
        }
        return null;
    }

    @Override
    public String getInfo() {
        for (int i = 0; i < listaCliente.size() ; i++) {
            return listaCliente.toString();
        }
        return null;
    }

    @Override
    public String getResumoInfo() {
        String dados= "";
        for (int i = 0; i < listaCliente.size() ; i++) {
            dados += " Nome: "+ listaCliente.get(i).getNome()+ " CPF: "+
                    listaCliente.get(i).getCPF()+"\n";
        }
        return dados;
    }


    @Override //Testar
    public boolean remove(long CPF) {
        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(i).getCPF()==CPF){
                listaCliente.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existe(long CPF) {
        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(i).getCPF() == CPF) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "ListaClientes{" +
                "lista=" + listaCliente +
                '}';
    }
}