package InterfacesGraficas;

import Listas.ListaClientes;
import Locadora.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

/**
 * @author glmgu on 05/12/2022
 */
public class GuiClientes extends JFrame {
    private JPanel painelClientes;
    private JButton editarButton;
    private JButton pesquisarButton;
    private JButton cadastrarButton;
    private JButton excluirButton;
    private JTextField textCPF;
    private JButton listarTodosOsClientesButton;
    private JButton voltarButton;

    ListaClientes listaC;
    Cliente cliente;
    String nome,endereco;
    JFrame guiGeral;
    long CPF;
    int numCNH,telefone;


    public GuiClientes(final ListaClientes listaC, JFrame guiGeral) {
        this.listaC = listaC;
        this.guiGeral = guiGeral;
        setContentPane(painelClientes);
        setVisible(true);
        setSize(400,300);
        setTitle("Menu Clientes");


        pesquisarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pesquisarClientes();
            }
        });
        listarTodosOsClientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(listaC.getResumoInfo().length()==0){
                    JOptionPane.showMessageDialog(null,"Não Há clientes cadastrados","Lista de todos os Clientes",JOptionPane.INFORMATION_MESSAGE);
                }else
                    JOptionPane.showMessageDialog(null,listaC.getInfo(),"Lista de todos os Clientes",JOptionPane.INFORMATION_MESSAGE);
            }
        });

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiCadastroCliente(listaC,guiGeral);
                setVisible(false);
            }
        });
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textCPF.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Informe o CPF do Cliente", "info", JOptionPane.INFORMATION_MESSAGE);
                }else {

                    new GuiEditarCliente(listaC,Long.valueOf(textCPF.getText()),guiGeral);
                    dispose();
                }
            }
        });
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textCPF.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Informe o CPF do Cliente", "info", JOptionPane.INFORMATION_MESSAGE);
                }else {
                    CPF = Long.valueOf(textCPF.getText());
                    if (listaC.existe(CPF)==true){
                        int a = JOptionPane.showConfirmDialog(null,"Deseja Excluir o cliente "+listaC.getInfo(CPF),"Confirmação",JOptionPane.OK_OPTION);
                        if (a==0){
                            listaC.remove(CPF);
                        }
                    }else {
                        JOptionPane.showMessageDialog(null,"Cliente não Cadastrado","info",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiGeral.setVisible(true);
                setVisible(false);
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
}

