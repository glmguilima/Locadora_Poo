package InterfacesGraficas;

import Listas.ListaClientes;
import Listas.ListaLocacoes;
import Listas.ListaVeiculos;
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

    private JButton voltarAoMenuInicialButton;
    private JTextField textCodLoc;
    ListaVeiculos listaV;
    ListaLocacoes listaLoc;
    ListaClientes listaC;
    JFrame guiGeral;

    int cod;
    public GuiLocacoes(ListaLocacoes listaLoc, ListaClientes listaC, ListaVeiculos listaV, JFrame guiGeral) {
        this.listaLoc=listaLoc;
        this.listaC=listaC;
        this.listaV=listaV;
        this.guiGeral = guiGeral;
        setContentPane(painelLocacoes);
        setVisible(true);
        setSize(500,300);
        setTitle("Menu Locações");




        buttonAddLocacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GuiLocacacoesAdd(listaC, listaV,listaLoc,guiGeral);
                dispose();

            }
        });
        buttonBuscaLocacoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textCodLoc.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Preencha a informção com o código da locação ", "info", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    cod = Integer.parseInt(textCodLoc.getText());
                    buscarLoc();
                    if (buscarLoc() == 1) {
                        JOptionPane.showMessageDialog(null, listaLoc.getInfo(cod), "Informação de locação", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Locação NÂO encotrada, verique em todas as locações o código correto", "Informação de locação", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });



        voltarAoMenuInicialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiGeral.setVisible(true);
                dispose();
            }
        });
        excluirLocaçãoButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (textCodLoc.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Preencha a informção com o código da locação ", "info", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    cod = Integer.parseInt(textCodLoc.getText());
                    if (buscarLoc() == 1) {
                        int a = JOptionPane.showConfirmDialog(null, "Deseja Excluir A Locação " + listaLoc.getInfo(cod), "Confirmação", JOptionPane.OK_OPTION);
                        if (a == 0) {
                            listaLoc.remove(cod);
                            textCodLoc.setText("");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Locação não Cadastrado", "info", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

            }
        });
        relaçãoDeTodasAsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(listaLoc.listaLocacoes.size()==0){
                    JOptionPane.showMessageDialog(null,"Não Há locações cadastrados","Lista de todos as Locações",JOptionPane.INFORMATION_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(null, listaLoc.getInfo(), "Lista de todos os Locações", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }


    public int buscarLoc(){
        int cod = Integer.parseInt(textCodLoc.getText());
        if (listaLoc.existe(cod)) {
            return 1;
        }else
            System.out.println(AppCor.RED+"Locação não está cadastrada."+AppCor.RESET);
        return 0;
    }

}
