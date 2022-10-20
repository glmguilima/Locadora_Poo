package Locadora;

/**
 * @author glmgu on 13/10/2022
 */
public class Onibus extends Veiculo {
    private int numPassageiros;
    private String categoria;
    private boolean wifi = false;
    private boolean arCondicionado = false;

    public Onibus(String placa, int ano, double valorDiaria) {
        super(placa, ano, valorDiaria);
    }

    public int getNumPassageiros() {
        return numPassageiros;
    }

    public void setNumPassageiros(int numPassageiros) {
        this.numPassageiros = numPassageiros;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isArCondionado() {
        return Onibus.this.arCondicionado;
    }

    public void setarCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    @Override
    public String toString() {
        return "Onibus{" +
                "numPassageiros=" + numPassageiros +
                ", categoria='" + categoria + '\'' +
                ", wifi=" + wifi +
                ", arCondionado=" + Onibus.this.arCondicionado +
                "} " + super.toString();
    }
}
