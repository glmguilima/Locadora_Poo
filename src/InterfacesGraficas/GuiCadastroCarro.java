package InterfacesGraficas;

import Listas.ListaVeiculos;
import Locadora.Carro;
import Locadora.Veiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiCadastroCarro extends JFrame {
    Veiculo veiculo;
    Carro carro;
    String placa;
    int numPassageiros = 5 ,numPortas = 5;
    double mediaKM;
    boolean arCondicionado = false;

    int ano;
    double diaria;
    private JPanel cadastroVeiculos;

    private JTextField textPlaca;
    private JTextField textAno;
    private JTextField textDiaria;
    private JButton salvarButton;
    private JButton limparCamposButton;
    private JTextField textMedia;
    private JComboBox comboBoxPortas;
    private JComboBox comboBoxArCond;
    private JButton voltarMenuINI;


    public GuiCadastroCarro(ListaVeiculos listaV) {
    setContentPane(cadastroVeiculos);
    setVisible(true);
    setSize(800,600);


        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placa= textPlaca.getText();
                ano= Integer.parseInt(textAno.getText());
                diaria= Double.parseDouble(textDiaria.getText());
                mediaKM = Double.parseDouble(textMedia.getText());
                carro = new Carro(placa,ano,diaria);
                if(comboBoxPortas.getSelectedIndex()==0) {
                    JOptionPane.showMessageDialog(null, "Selecione o número de portas");
                }else{
                if (comboBoxPortas.getSelectedIndex()==2) {
                    numPortas=5 ;
                    carro.setNumPortas(numPortas);
                } else {
                    numPortas = 3;
                    carro.setNumPortas(numPortas);
                    }
                }
                if(comboBoxArCond.getSelectedIndex()==0) {
                    JOptionPane.showMessageDialog(null,"Selecione uma oção de ar condicionado");
                }else
                if(comboBoxArCond.getSelectedIndex()==1){
                    arCondicionado = true;
                    carro.setArCondicionado(true);
                }else {
                    arCondicionado = false;
                    carro.setArCondicionado(false);
                }

               // carro.setNumPortas(5);
                //carro.setArCondicionado(true);
                listaV.listaVeiculo.add(carro);
                limpaCampos();
            }

        });
        limparCamposButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpaCampos();
            }
        });

        voltarMenuINI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
    public void limpaCampos(){
        textAno.setText("");
        textDiaria.setText("");
        textPlaca.setText("");
        textPlaca.requestFocus();
        textMedia.setText("");
        comboBoxPortas.setSelectedIndex(0);
        comboBoxArCond.setSelectedIndex(0);


    }
}
