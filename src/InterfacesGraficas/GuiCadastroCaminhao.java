package InterfacesGraficas;

import Listas.ListaVeiculos;
import Locadora.Caminhao;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiCadastroCaminhao extends JFrame{
    private JPanel cadastroCaminhao;
    private JTextField textPlaca;
    private JTextField textDiaria;
    private JTextField textCargaMax;
    private JTextField textAno;
    private JTextField textnumEixos;
    private JButton voltarAoMenuInicialButton;
    private JButton salvarButton;
    private JButton limparCamposButton;

    Caminhao caminhao;
    String placa;
    int ano;
    double diaria;
    JFrame guiGeral;
    ListaVeiculos listaV;



public GuiCadastroCaminhao(ListaVeiculos listaV, JFrame guiGeral) {
    this.listaV=listaV;
    this.guiGeral=guiGeral;
    setContentPane(cadastroCaminhao);
    setTitle("Cadastro de Caminhão");
    setVisible(true);
    setSize(800,600);


    limparCamposButton.addActionListener(e -> limpaCampos());
    salvarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            placa= textPlaca.getText();
            ano= Integer.parseInt(textAno.getText());
            diaria= Double.parseDouble(textDiaria.getText());
            if (!listaV.existe(placa)){
                caminhao = new Caminhao(placa,ano,diaria);
                listaV.listaVeiculo.add(caminhao);
                if (textCargaMax.getText()==null||textnumEixos.getText()==null){
                    JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
                }else {
                    caminhao.setCargaMax(Integer.parseInt(textCargaMax.getText()));
                    caminhao.setNumEixo(Integer.parseInt(textnumEixos.getText()));
                    JOptionPane.showMessageDialog(null,"Veículo Cadastrado com sucesso"+ listaV.get(placa),"Cadastro de Veiculo",JOptionPane.INFORMATION_MESSAGE);
                    limpaCampos();
                }
            }else{
                JOptionPane.showMessageDialog(null,"Veiculo já consta no  cadastro"+ listaV.get(placa),"Veículo Encontrado",JOptionPane.INFORMATION_MESSAGE);
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
}
    public void limpaCampos(){
        textAno.setText("");
        textDiaria.setText("");
        textPlaca.setText("");
        textPlaca.requestFocus();
        textCargaMax.setText("");
        textnumEixos.setText("");
    }
}
