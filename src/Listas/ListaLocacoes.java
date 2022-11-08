package Listas;

import Interfaces.ILocacoes;
import Locadora.Locacao;

import java.util.ArrayList;

/**
 * @author Guilherme Menezes on 20/10/2022
 */
public class ListaLocacoes implements ILocacoes {
    public ArrayList<Locacao> listaLocacoes;


    public ListaLocacoes(){
        listaLocacoes = new ArrayList<Locacao>();
    }

    @Override
    /**
     * método que implementa a locação @param l a uma lista @param listaLoc.
     */
    public void add(Locacao l) {
        listaLocacoes.add(l);
    }

    @Override
    /**
     * Implementado.
     *
     */
    public  Locacao get(int codigo) {
        for (int i = 0; i < listaLocacoes.size() ; i++) {
            if(listaLocacoes.get(i).getCodigo() == codigo){
                return listaLocacoes.get(i);
            }
        }
        return null;
    }


    @Override
    /**
     * Implementado.
     *
     */
    public String getInfo(int codigo) {
        for (int i = 0; i < listaLocacoes.size() ; i++) {
            if(listaLocacoes.get(i).getCodigo()==codigo){
                return listaLocacoes.get(i).toString();
            }
        }
        return null;
    }


    @Override
    /**
     * Implementado.
     *
     */
    public String getInfo() {
        for (int i = 0; i < listaLocacoes.size() ; i++) {
            return listaLocacoes.toString();
        }
        return null;
    }

    @Override
    /**
     * Implementado.
     *
     */
    public boolean remove(int codigo) {
        for (int i = 0; i < listaLocacoes.size() ; i++) {
            if(listaLocacoes.get(i).getCodigo() == codigo){
                listaLocacoes.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    /**
     * Implementado.
     *
     */
    public boolean existe(int codigo) {
        for (int i = 0; i < listaLocacoes.size() ; i++) {
            if(listaLocacoes.get(i).getCodigo() == codigo){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Lista de Locações {" +
                "\n listaLoc=" + listaLocacoes +
                '}';
    }
}
