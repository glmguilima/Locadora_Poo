package Locadora;

import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * @author glmgu on 13/10/2022
 */
public class Locacao {
    private static int codgeral =1;
    private int codigo;
    private boolean seguro = false;
    private Cliente cliente;
    private  Veiculo veiculo;
    private String dataInicial,dataFinal;




    public Locacao(Cliente cliente, Veiculo veiculo, boolean seguro, String dataInicial, String dataFinal) {
        codigo = codgeral++;
        this.seguro = seguro;
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
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


    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    @Override
    public String toString() {
        return "Locacao{" +
                "codigo=" + codigo +
                ", seguro=" + seguro +
                ", cliente=" + cliente +
                ", veiculo=" + veiculo +
                ", dataInicial='" + dataInicial + '\'' +
                ", dataFinal='" + dataFinal + '\'' +
                '}';
    }

    /**
     * pode ser usado para converter String para calendario, mas não foi usado até entao.
     */
    public void formatterCalendar() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        System.out.println(formatter.format(calendar.getTime()));
    }
}
