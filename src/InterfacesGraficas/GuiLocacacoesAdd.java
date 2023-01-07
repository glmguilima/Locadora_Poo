package InterfacesGraficas;

import Listas.ListaClientes;
import Listas.ListaLocacoes;
import Listas.ListaVeiculos;
import Locadora.Locacao;
import javax.swing.*;
import java.awt.event.*;

public class GuiLocacacoesAdd extends JFrame {
    private JPanel painelAddLocacoes;
    private JTextField textCPF;
    private JTextField textPlaca;
    private JTextField textDataEntrega;
    private JTextField textDataRetirada;
    private JComboBox comboBoxSeguro;
    private JButton salvarLocaçãoButton;
    private JButton voltarAoMenuInicialButton;
    private JButton limparCamposButton;
    private JButton pesquisarVeiculosDisponíveisButton;
    private JButton pesquisarClienteButton;
    private long CPF;
    private int seguroInt;
    private String placa;
    private boolean seguro;
    ListaClientes listaC;
    ListaLocacoes listaL;
    ListaVeiculos listaV;
    JFrame guiGeral;

    /**
     *
     * @param listaC
     * @param listaV
     * @param listaL
     */
    public GuiLocacacoesAdd(ListaClientes listaC,ListaVeiculos listaV,ListaLocacoes listaL,JFrame guiGeral) {
        this.listaC = listaC;
        this.listaV = listaV;
        this.listaL = listaL;
        this.guiGeral=guiGeral;
        setContentPane(painelAddLocacoes);
        setVisible(true);
        setSize(400,300);
        setTitle("Menu Locações");


        salvarLocaçãoButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (textCPF.getText().length() == 0||textPlaca.getText().length()==0||textDataEntrega.getText().length()==0||textDataRetirada.getText().length()==0) {
                    JOptionPane.showMessageDialog(null, "Preencha as informações ( CPF, Placa, data entrega, data retirada. ", "info", JOptionPane.INFORMATION_MESSAGE);
                } else {

                    if (!listaC.existe(Long.parseLong(textCPF.getText()))) {
                        JOptionPane.showMessageDialog(null, "Cliente não cadastrado no Sistema", "info", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (!listaV.existe(textPlaca.getText())){
                            JOptionPane.showMessageDialog(null, "Veículo não disponível ", "info", JOptionPane.INFORMATION_MESSAGE);
                        }else{

                            int seguroInt = comboBoxSeguro.getSelectedIndex();
                            if (seguroInt == 0) {
                                JOptionPane.showMessageDialog(null, "Selecione uma opção de Seguro");
                            } else {
                                Locacao nova = new Locacao(listaC.get(Long.parseLong(textCPF.getText())), listaV.get(textPlaca.getText()), false, textDataRetirada.getText(), textDataEntrega.getText());
                                listaL.add(nova);
                                listaV.remove(textPlaca.getText());

                                if (seguroInt == 1) {
                                    nova.setSeguro(true);
                                } else {
                                    nova.setSeguro(false);
                                }
                                JOptionPane.showMessageDialog(null, "Locação Cadastrado com sucesso "+listaL.getInfo(nova.getCodigo()), "Cadastro de Locações", JOptionPane.INFORMATION_MESSAGE);
                                limparCampos();
                            }
                        }
                    }
                }
            }
        });

        limparCamposButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });

        voltarAoMenuInicialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiGeral.setVisible(true);
                dispose();
            }
        });


        pesquisarVeiculosDisponíveisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pesquisarVeiculos();
            }
        });
        pesquisarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pesquisarClientes();
            }
        });
    }
    public void pesquisarClientes() {
        if (textCPF.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Informe o CPF do Cliente", "info", JOptionPane.INFORMATION_MESSAGE);
        }else {
            CPF = Long.valueOf(textCPF.getText());
            if (listaC.existe(CPF) == true) {

                JOptionPane.showMessageDialog(null, listaC.get(CPF), "info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não Cadastrado", "info", JOptionPane.INFORMATION_MESSAGE);

            }

        }
    }

    public void pesquisarVeiculos(){
        if(listaV.getResumoInfo().length()==0){
            JOptionPane.showMessageDialog(null,"Não Há Veículos cadastrados","Lista de todos os Clientes",JOptionPane.INFORMATION_MESSAGE);
        }else
            JOptionPane.showMessageDialog(null,listaV.getInfo(),"Lista de todos os Clientes",JOptionPane.INFORMATION_MESSAGE);
    }

    public void limparCampos(){
        textCPF.setText("");
        textDataEntrega.setText("");
        textDataRetirada.setText("");
        textPlaca.setText("");
        comboBoxSeguro.setSelectedIndex(0);
    }


}
