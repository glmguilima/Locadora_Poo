package Locadora;

/**
 * @author glmgu on 13/10/2022
 */
public  class Cliente {
    private long CPF;
    private String nome,endereco;
    private   int numCNH, telefone;


    public Cliente(String nome,long CPF, int numCNH,String endereco,int telefone){
        this.nome=nome;
        this.CPF=CPF;
        this.numCNH=numCNH;
        this.endereco=endereco;
        this.telefone=telefone;
    }


    public long getCPF() {
        return CPF;
    }

    public void setCPF(long CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumCNH() {
        return numCNH;
    }

    public void setNumCNH(int numCNH) {
        this.numCNH = numCNH;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "\n Cliente{" +
                "Nome = '" + nome + '\'' +
                ", CPF = " + CPF +
                ", Número da CNH = " + numCNH + '\'' +
                ", Endereço = '" + endereco + '\'' +
                ", Telefone = " + telefone +
                '}';
    }
}
