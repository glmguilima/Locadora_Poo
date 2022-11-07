package Listas;

import Interfaces.ILocacoes;
import Locadora.Locacao;

import java.util.ArrayList;

/**
 * @author Guilherme Menezes on 20/10/2022
 */
public class ListaLocacoes implements ILocacoes {
    public ArrayList<Locacao> listaLoc;


    public ListaLocacoes(){
        listaLoc = new ArrayList<Locacao>();
    }

    @Override
    /**
     * método que implementa a locação @param l a uma lista @param listaLoc.
     */
    public void add(Locacao l) {
        listaLoc.add(l);
    }

    @Override
    /**
     * Implementado.
     *
     */
    public  Locacao get(int codigo) {
        for (int i = 0; i < listaLoc.size() ; i++) {
            if(listaLoc.get(i).getCodigo() == codigo){
                return listaLoc.get(i);
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
        for (int i = 0; i < listaLoc.size() ; i++) {
            if(listaLoc.get(i).getCodigo()==codigo){
                return listaLoc.get(i).toString();
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
        for (int i = 0; i < listaLoc.size() ; i++) {
            return listaLoc.toString();
        }
        return null;
    }

    @Override
    /**
     * Implementado.
     *
     */
    public boolean remove(int codigo) {
        for (int i = 0; i < listaLoc.size() ; i++) {
            if(listaLoc.get(i).getCodigo() == codigo){
                listaLoc.remove(i);
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
        for (int i = 0; i < listaLoc.size() ; i++) {
            if(listaLoc.get(i).getCodigo() == codigo){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Lista de Locações {" +
                "\n listaLoc=" + listaLoc +
                '}';
    }
}
