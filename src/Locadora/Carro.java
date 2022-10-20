package Locadora;

/**
 * @author glmgu on 13/10/2022
 */
public class Carro extends Veiculo {
    private int numPassageiros = 5 ,numPortas = 5;
    private double mediaKM;
    private boolean arCondicionado = false;


    public Carro(String placa,int ano,double diaria) {
        super(placa,ano,diaria);
    }

    public int getNumPassageiros() {
        return numPassageiros;
    }

    public void setNumPassageiros(int numPassageiros) {
        this.numPassageiros = numPassageiros;
    }

    public int getNumPortas() {
        return numPortas;
    }

    public void setNumPortas(int numPortas) {
        this.numPortas = numPortas;
    }

    public double getMediaKM() {
        return mediaKM;
    }

    public void setMediaKM(double mediaKM) {
        this.mediaKM = mediaKM;
    }

    public boolean isArCondicionado() {
        return arCondicionado;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "numPassageiros=" + numPassageiros +
                ", numPortas=" + numPortas +
                ", mediaKM=" + mediaKM +
                ", arCondicionado=" + arCondicionado +
                "} " + super.toString();
    }
}
