package Locadora;

public class Main {

    public static void main(String[] args) {
        Cliente c1= new Cliente("Teste",123456789,987654321);
        Cliente c2= new Cliente("Teste2",113456789,997654321);
        Cliente c3= new Cliente("Teste3",111456789,999654321);
        ListaClientes lista = new ListaClientes();
        lista.add(c1);
        lista.add(c2);
        lista.add(c3);
        System.out.println(lista.getInfo());
        System.out.println(lista.getResumoInfo());
        Carro car1 = new Carro("iii1234",2000,15);
        Locacao loc = new Locacao(c1,car1,false);
        System.out.println(loc.toString());








    }
}
