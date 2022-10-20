package Locadora;

/**
 * @author glmgu on 13/10/2022
 */
public abstract class Veiculo {
    private String placa;
    private int ano;
    private double diaria;

    public Veiculo(String placa, int ano, double diaria){
        this.ano = ano;
        this.placa=placa;
        this.diaria = diaria;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getValorDiaria() {
        return diaria;
    }

    public void setValorDiaria(double diaria) {
        this.diaria = diaria;
    }

    @Override
    public String toString() {
        return "Veiculos{" +
                "placa='" + placa + '\'' +
                ", ano=" + ano +
                ", valorDiaria=" + diaria +
                '}';
    }
}
