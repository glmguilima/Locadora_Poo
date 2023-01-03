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
    private String placa;
    private boolean seguro;
    ListaClientes listaC;
    ListaLocacoes listaL;
    ListaVeiculos listaV;


    public GuiLocacacoesAdd(ListaClientes listaC,ListaVeiculos listaV,ListaLocacoes listaL) {
        this.listaC = listaC;
        this.listaV = listaV;
        this.listaL = listaL;
        setContentPane(painelAddLocacoes);
        setVisible(true);
        setSize(400,300);
        setTitle("Menu Locações");


    salvarLocaçãoButton.addActionListener(new ActionListener() {        @Override
        public void actionPerformed(ActionEvent e) {
        int seguroInt = comboBoxSeguro.getSelectedIndex();
        if (seguroInt == 0) {
            JOptionPane.showMessageDialog(null, "Selecione os campos obrigatórios");
        } else {
            Locacao nova = new Locacao(listaC.get(CPF), listaV.get(textPlaca.getText()), false, textDataRetirada.getText(), textDataEntrega.getText());
            listaL.add(nova);
            listaV.remove(textPlaca.getText());

            if (seguroInt == 1) {
                nova.setSeguro(seguro);
            }else {
                nova.setSeguro(false);
            }


            JOptionPane.showMessageDialog(null,"Locação Cadastrado com sucesso"+ listaLoc,"Cadastro de Locações",JOptionPane.INFORMATION_MESSAGE);
            limparCampos();
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
            setVisible(false);
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
        CPF = Long.valueOf(textCPF.getText());
        if (listaC.existe(CPF) == true) {

            JOptionPane.showMessageDialog(null, listaC.get(CPF), "info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não Cadastrado", "info", JOptionPane.INFORMATION_MESSAGE);

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
    }


}
