package Locadora;

/**
 * @author glmgu on 13/10/2022
 */
public class Caminhao extends Veiculo {
    private int numEixo, cargaMax;

    public Caminhao(String placa, int ano, double valorDiaria) {
        super(placa, ano, valorDiaria);
    }

    public int getNumEixo() {
        return numEixo;
    }

    public void setNumEixo(int numEixo) {
        this.numEixo = numEixo;
    }

    public int getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    @Override
    public String toString() {
        return "\nCaminhao{" +
                "numEixo=" + numEixo +
                ", cargaMax=" + cargaMax +
                "} " + super.toString();
    }
}
