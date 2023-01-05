package InterfacesGraficas;

import Exceptions.MinhaExcecoes;
import Listas.ListaClientes;
import Locadora.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author glmgu on 04/12/2022
 */
public class GuiCadastroCliente extends JFrame {
    private JPanel cadastroCliente;
    private JTextField textNome;
    private JTextField textEndereco;
    private JTextField textCNH;
    private JTextField textTelefone;
    private JButton cadastrarButton;
    private JButton voltarButton;
    private JTextField textCPF;
    private JButton limparButton;
    Cliente cliente;
    String nome,endereco;
    JFrame guiGeral;
    long CPF;
    int numCNH,telefone;

    public GuiCadastroCliente(final ListaClientes listaC , JFrame guiGeral){
        this.guiGeral = guiGeral;
        setContentPane(cadastroCliente);
        setVisible(true);
        setSize(800,600);
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiGeral.setVisible(true);
                dispose();
            }
        });
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nome =textNome.getText();
                numCNH = Integer.parseInt(textCNH.getText());
                endereco=textEndereco.getText();
                CPF = Long.parseLong(textCPF.getText());
                telefone= Integer.parseInt(textTelefone.getText());
                if (listaC.existe(CPF)==false){
                    try {
                        cliente = new Cliente(nome,CPF,numCNH,endereco,telefone);
                        listaC.listaCliente.add(cliente);

                    } catch (MinhaExcecoes ex) {
                        ex.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null,"Cliente Cadastrado com sucesso"+ listaC.get(CPF),"Cadastro de Cliente",JOptionPane.INFORMATION_MESSAGE);
                    limparCampos();
                }else{
                    JOptionPane.showMessageDialog(null,"CPF já Cadastrado"+ listaC.get(CPF),"CPF Encontrado",JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });
    }

    public void limparCampos(){
        textCNH.setText("");
        textCPF.setText("");
        textEndereco.setText("");
        textNome.setText("");
        textTelefone.setText("");
        textNome.requestFocus();
    }

}


