package InterfacesGraficas;

import Interfaces.IClientes;
import Listas.ListaClientes;
import Listas.ListaLocacoes;
import Listas.ListaVeiculos;
import Menus.Menu;
import Menus.MenuCliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GuiGeral extends Frame {
    private static IClientes listaC;
    private JPanel menuInicial;
    private JButton clientesButton;
    private JButton locaçõesButton;
    private JButton veiculosButton;
    private JButton clientesButton1;
    ListaClientes listaClientes = new ListaClientes();
    ListaLocacoes listaLocacoes = new ListaLocacoes();
    ListaVeiculos listaVeiculos = new ListaVeiculos();

    public static void main(String[] args) {
        new GuiGeral();
    }


    public JPanel getMenuInicial() {
        return menuInicial;
    }

    public void setMenuInicial(JPanel menuInicial) {
        this.menuInicial = menuInicial;
    }

    public JButton getClientesButton() {
        return clientesButton;
    }

    public void setClientesButton(JButton clientesButton) {
        this.clientesButton = clientesButton;
    }

    public JButton getLocaçõesButton() {
        return locaçõesButton;
    }

    public void setLocaçõesButton(JButton locaçõesButton) {
        this.locaçõesButton = locaçõesButton;
    }

    public JButton getVeiculosButton() {
        return veiculosButton;
    }

    public void setVeiculosButton(JButton veiculosButton) {
        this.veiculosButton = veiculosButton;
    }

    public ListaClientes getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ListaClientes listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ListaLocacoes getListaLocacoes() {
        return listaLocacoes;
    }

    public void setListaLocacoes(ListaLocacoes listaLocacoes) {
        this.listaLocacoes = listaLocacoes;
    }

    public ListaVeiculos getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(ListaVeiculos listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public GuiGeral() {
        JFrame frame = new JFrame("Locadora Defora da Pampa");
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Locadora de Fora da Pampa");
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500, 400);
        frame.setContentPane(menuInicial);


        clientesButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiClientes(listaClientes,frame);
                frame.dispose();
            }
        });
        locaçõesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiLocacoes guiLocacoes = new GuiLocacoes(listaLocacoes, listaClientes,listaVeiculos, frame);
                guiLocacoes.setVisible(true);
                frame.dispose();

            }
        });


        veiculosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiVeiculos  guiVeiculos =  new GuiVeiculos(listaVeiculos, frame);
                guiVeiculos.setVisible(true);
                frame.dispose();
            }
        });
    }

}