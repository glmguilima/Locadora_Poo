package Listas;

import Interfaces.IClientes;
import Locadora.Cliente;

import java.util.ArrayList;

/**
 * @author glmgu on 17/10/2022
 */
public class ListaClientes implements IClientes {
    public ArrayList<Cliente> listaCliente;


    public ListaClientes() {
        listaCliente = new ArrayList<Cliente>();
    }

    /**
     *
     * @param c Cliente a ser inserido.
     */
    @Override
    public void add(Cliente c) {
        listaCliente.add(c);
    }

    /**
     *
     * @param CPF CPF do cliente a ser capturado.
     * @return cliente pelo CPF
     */
    @Override
    public Cliente get(long CPF) {
        for (int i = 0; i < listaCliente.size() ; i++) {
            if(listaCliente.get(i).getCPF()==CPF){
                return listaCliente.get(i);
            }
        }
        return null;
    }

    /**
     *
     * @param CPF CPF do cliente a ser capturado.
     * @return informações do cliente.
     */
    @Override
    public String getInfo(long CPF) {
        for (int i = 0; i < listaCliente.size() ; i++) {
            if(listaCliente.get(i).getCPF()==CPF){
                return listaCliente.get(i).toString();
            }
        }
        return null;
    }

    /**
     *
     * @return informações de todos os clientes.
     */
    @Override
    public String getInfo() {
        for (int i = 0; i < listaCliente.size() ; i++) {
            return listaCliente.toString();
        }
        return null;
    }

    /**
     *
     * @return Nome e CPF de todos os clientes.
     */
    @Override
    public String getResumoInfo() {
        String dados= "";
        for (int i = 0; i < listaCliente.size() ; i++) {
            dados += " Nome: "+ listaCliente.get(i).getNome()+ " CPF: "+
                    listaCliente.get(i).getCPF()+"\n";
        }
        return dados;
    }

    /**
     *
     * @param CPF CPF do cliente a ser capturado.
     * @return Remove cliente da lista
     */
    @Override
    public boolean remove(long CPF) {
        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(i).getCPF()==CPF){
                listaCliente.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param CPF CPF do cliente a ser verificado.
     * @return Verica a existencia do cliente
     */
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
                "\nlista=" + listaCliente +
                '}';
    }
}