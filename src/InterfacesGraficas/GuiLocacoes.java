package InterfacesGraficas;

import Listas.ListaClientes;
import Listas.ListaLocacoes;
import Listas.ListaVeiculos;
import Locadora.Locacao;
import Utils.AppCor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiLocacoes extends JFrame{
    private JPanel painelLocacoes;
    private JButton excluirLocaçãoButton;
    private JButton relaçãoDeTodasAsButton;
    private JButton buttonBuscaLocacoes;
    private JButton buttonAddLocacao;
    private JButton modificarInformaçõesDeLocaçãoButton;
    private JButton voltarAoMenuInicialButton;
    ListaVeiculos listaV;
    ListaLocacoes listaLoc;
    ListaClientes listaC;
    String placa;
    Long CPF;
public GuiLocacoes(ListaLocacoes listaLoc, ListaClientes listaC, ListaVeiculos listaV) {
    this.listaLoc=listaLoc;
    this.listaC=listaC;
    this.listaV=listaV;

    setContentPane(painelLocacoes);
    setVisible(true);
    setSize(500,300);
    setTitle("Menu Locações");


    buttonAddLocacao.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {


        }
    });
    buttonBuscaLocacoes.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
    relaçãoDeTodasAsButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
    modificarInformaçõesDeLocaçãoButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });

    voltarAoMenuInicialButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
    excluirLocaçãoButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
}


}
