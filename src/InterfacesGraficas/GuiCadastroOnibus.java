package InterfacesGraficas;

import Listas.ListaVeiculos;
import Locadora.Carro;
import Locadora.Onibus;
import Locadora.Veiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;

public class GuiCadastroOnibus extends JFrame{
    Veiculo veiculo;
    Onibus onibus;
    String placa;
    int ano;
    double diaria;
    int numPassageiros;
    String categoria;
    boolean wifi = false;
    boolean arCondicionado = false;
    private JComboBox comboBoxWifi;
    private JComboBox comboBoxCategoria;
    private JTextField textPlaca;
    private JComboBox comboBoxPessoas;
    private JButton salvarButton;
    private JButton limparCamposButton;
    private JButton voltarMenuINI;
    private JPanel cadastroOnibus;
    private JTextField textDiaria;
    private JComboBox comboBoxArCondicionado;
    private JTextField textAno;
    ListaVeiculos listaV;
    JFrame guiGeral;

    public GuiCadastroOnibus(ListaVeiculos listaV,JFrame guiGeral) {
        this.guiGeral = guiGeral;
        this.listaV = listaV;
        setContentPane(cadastroOnibus);
        setVisible(true);
        setSize(800,600);


        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textPlaca.getText().length()==0||textDiaria.getText().length()==0|| textAno.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Preencha as informações do veículo (placa, ano, diária) ", "info", JOptionPane.INFORMATION_MESSAGE);
                }else {
                    placa= textPlaca.getText();
                    ano= Integer.parseInt(textAno.getText());
                    diaria= Double.parseDouble(textDiaria.getText());

                    if (listaV.existe(placa)==false){
                        onibus = new Onibus(placa,ano,diaria);
                        listaV.listaVeiculo.add(onibus);

                        if (comboBoxCategoria.getSelectedIndex()==0||comboBoxPessoas.getSelectedIndex()==0||
                                comboBoxArCondicionado.getSelectedIndex()==0||comboBoxWifi.getSelectedIndex()==0){
                            JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
                        }else{
                            if (comboBoxCategoria.getSelectedIndex()==1){

                                categoria="Normal" ;
                                onibus.setCategoria(categoria);
                            }else {
                                if (comboBoxCategoria.getSelectedIndex()==2) {
                                    categoria="Executivo" ;
                                    onibus.setCategoria(categoria);
                                } else {
                                    categoria="Leito" ;
                                    onibus.setCategoria(categoria);
                                }
                            }
                            if (comboBoxPessoas.getSelectedIndex()==1) {
                                numPassageiros=30 ;
                                onibus.setNumPassageiros(30);
                            } else if (comboBoxPessoas.getSelectedIndex()==2) {
                                numPassageiros=50 ;
                                onibus.setNumPassageiros(numPassageiros);
                            } else if (comboBoxPessoas.getSelectedIndex()==3){
                                numPassageiros=60 ;
                                onibus.setNumPassageiros(numPassageiros);
                            }

                            if (comboBoxPessoas.getSelectedIndex()==1) {
                                numPassageiros=30 ;
                                onibus.setNumPassageiros(30);
                            } else if (comboBoxPessoas.getSelectedIndex()==2) {
                                numPassageiros=50 ;
                                onibus.setNumPassageiros(numPassageiros);
                            } else if (comboBoxPessoas.getSelectedIndex()==3){
                                numPassageiros=60 ;
                                onibus.setNumPassageiros(numPassageiros);
                            }
                            JOptionPane.showMessageDialog(null,"Veículo Cadastrado com sucesso"+ listaV.get(placa),"Cadastro de Veiculo",JOptionPane.INFORMATION_MESSAGE);
                            limpaCampos();
                        }

                    }else{
                        JOptionPane.showMessageDialog(null,"Veiculo já consta no  cadastro"+ listaV.get(placa),"Veículo Encontrado",JOptionPane.INFORMATION_MESSAGE);
                    }

                }}


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
                guiGeral.setVisible(true);
                dispose();
            }
        });
    }
    public void limpaCampos(){
        textAno.setText("");
        textDiaria.setText("");
        textPlaca.setText("");
        textPlaca.requestFocus();
        comboBoxArCondicionado.setSelectedIndex(0);
        comboBoxCategoria.setSelectedIndex(0);
        comboBoxPessoas.setSelectedIndex(0);
        comboBoxWifi.setSelectedIndex(0);

    }
}
