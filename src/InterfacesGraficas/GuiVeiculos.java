package InterfacesGraficas;

import Listas.ListaVeiculos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiVeiculos extends JFrame  {
    String placa;
    private JPanel MenuVeiculos;
    private JButton voltarAoMenuInicialButton;
    private JButton modificarVeículoButton;
    private JButton listarTodosOsVeículosButton;
    private JButton buscarVeiculoButton;
    private JButton adicionarCarroButton;
    private JButton excluirVeículoButton;
    private JTextField textPlaca;
    private JButton adicionarÔnibusButton;
    private JButton adicionarCaminhaoButton;
    ListaVeiculos listaV;
    JFrame guiGeral;


    public GuiVeiculos(ListaVeiculos listaV , JFrame guiGeral) {
        this.listaV = listaV;
        this.guiGeral = guiGeral;
        setContentPane(MenuVeiculos);
        setVisible(true);
        setSize(500,300);
        setTitle("Menu Veíuclos");



        buscarVeiculoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textPlaca.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Informe a placa do veículo ", "info", JOptionPane.INFORMATION_MESSAGE);
                }else {

                    placa = textPlaca.getText();
                    if (listaV.existe(placa)){
                        JOptionPane.showMessageDialog(null,listaV.getInfo(placa),"info",JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null,"Veículo não Cadastrado","info",JOptionPane.INFORMATION_MESSAGE);
                    }
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
                new GuiCadastroCarro(listaV,guiGeral);
                setVisible(false);
            }
        });
        excluirVeículoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textPlaca.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Informe a placa do veículo ", "info", JOptionPane.INFORMATION_MESSAGE);
                }else {
                    placa = textPlaca.getText();
                    if (listaV.existe(placa)==true){
                        int a = JOptionPane.showConfirmDialog(null,"Deseja Excluir o Veículo "+listaV.getInfo(placa),"Confirmação",JOptionPane.OK_OPTION);
                        if (a==0){
                            listaV.remove(placa);
                        }
                    }else {
                        JOptionPane.showMessageDialog(null,"Veículo não Cadastrado","info",JOptionPane.INFORMATION_MESSAGE);
                    }
                }}
        });
        voltarAoMenuInicialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiGeral.setVisible(true);
                dispose();
            }
        });
        adicionarÔnibusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new GuiCadastroOnibus(listaV,guiGeral);
            }
        });

        adicionarCaminhaoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiCadastroCaminhao(listaV,guiGeral);
                setVisible(false);
            }
        });


    }



}
