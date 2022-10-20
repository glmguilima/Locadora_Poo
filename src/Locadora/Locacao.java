package Locadora;

import java.util.Date;

/**
 * @author glmgu on 13/10/2022
 */
public class Locacao {
    private static int codgeral =1;
    private int codigo;
    private boolean seguro = false;
    private Date retirada,entrega;
    private Cliente cliente;
    private  Veiculo veiculo;




    public Locacao( Cliente cliente, Veiculo veiculo, boolean seguro) { // implementar data
        codigo = codgeral++;
        this.seguro = seguro;
        this.veiculo = veiculo;
        this.cliente = cliente;
    }

    public static int getCodgeral() {
        return codgeral;
    }

    public static void setCodgeral(int codgeral) {
        Locacao.codgeral = codgeral;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public boolean isSeguro() {
        return seguro;
    }

    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }


    public Date getRetirada() {
        return retirada;
    }

    public void setRetirada(Date retirada) {
        this.retirada = retirada;
    }

    public Date getEntrega() {
        return entrega;
    }

    public void setEntrega(Date entrega) {
        this.entrega = entrega;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    @Override
    public String toString() {
        return "Locacao {" +
                "Código=" + codigo +
                ", seguro=" + seguro +
                ", retirada=" + retirada +
                ", entrega=" + entrega +
                ", Cliente=" + cliente +
                ", Veículo=" + veiculo +
                '}';
    }
}
