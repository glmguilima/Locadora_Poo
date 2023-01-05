package InterfacesGraficas;

import Listas.ListaClientes;
import Locadora.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author glmgu on 04/12/2022
 */
public class GuiEditarCliente extends JFrame{
    private JPanel editarCliente;
    private JTextField textNome;
    private JTextField textEndereco;
    private JTextField textCNH;
    private JTextField textTelefone;
    private JButton salvarButton;
    private JButton voltarButton;
    ListaClientes listaC;
    Cliente cliente;
    JFrame guiGeral;
    String nome,endereco;
    long CPF;
    int numCNH,telefone;

    public GuiEditarCliente(final ListaClientes listaC, final long CPF,JFrame guiGeral) {
        this.CPF = CPF;
        this.guiGeral=guiGeral;
        setVisible(true);
        setSize(900,300);
        setContentPane(editarCliente);
        this.listaC = listaC;
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaC.get(CPF);
                nome =textNome.getText();
                endereco = textEndereco.getText();
                numCNH = Integer.parseInt(textCNH.getText());
                telefone = Integer.parseInt(textTelefone.getText());
                listaC.get(CPF).setNome(nome);
                listaC.get(CPF).setEndereco(endereco);
                listaC.get(CPF).setNumCNH(numCNH);
                listaC.get(CPF).setTelefone(telefone);

                JOptionPane.showMessageDialog(null,"Cliente salvo "+listaC.getInfo(CPF),"Editar CLiente",JOptionPane.INFORMATION_MESSAGE);

            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiGeral.setVisible(true);
                dispose();
            }
        });
    }


}
