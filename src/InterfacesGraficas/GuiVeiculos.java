package InterfacesGraficas;

import Listas.ListaVeiculos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiVeiculos extends JFrame  {
    String placa;
    int op2, ano;
    double diaria;
    ListaVeiculos listaV;
    private JPanel MenuVeiculos;
    private JButton voltarAoMenuInicialButton;
    private JButton modificarVeículoButton;
    private JButton listarTodosOsVeículosButton;
    private JButton buscarVeiculoButton;
    private JButton adicionarCarroButton;
    private JButton excluirVeículoButton;
    private JTextField textPlaca;
    private JButton adicionarÔnibusButton;
    private JButton adicionarCaminhãoButton;
    GuiGeral getMenuInicial;
public GuiVeiculos(ListaVeiculos listaV) {
    setContentPane(MenuVeiculos);
    setVisible(true);
    setSize(500,300);
    setTitle("Menu Veíuclos");



    buscarVeiculoButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            placa = textPlaca.getText();
            if (listaV.existe(placa)){
                System.out.println("Veiculo Cadastrado");
                JOptionPane.showMessageDialog(null,listaV.getInfo(placa),"info",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Veículo não Cadastrado","info",JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Veículo não está cadastrado.");
            }
        }
    });

    listarTodosOsVeículosButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(listaV.getResumoInfo().length()==0){
                JOptionPane.showMessageDialog(null,"Não Há Veículos cadastrados","Lista de todos os Clientes",JOptionPane.INFORMATION_MESSAGE);
            }else
                JOptionPane.showMessageDialog(null,listaV.getInfo(),"Lista de todos os Clientes",JOptionPane.INFORMATION_MESSAGE);
        }

    });

    adicionarCarroButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new GuiCadastroCarro(listaV);
            setVisible(false);
        }
    });
    excluirVeículoButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    });
    voltarAoMenuInicialButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        }
    });
    adicionarÔnibusButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
    adicionarCaminhãoButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
}


}