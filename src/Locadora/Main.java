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
        // System.out.println(lista.get(123456789));
        //System.out.println(lista.getResumoInfo());
        Carro car1 = new Carro("iii1234",2000,15);
        Carro car2 = new Carro("iii2222",2222,22);
        Locacao loc = new Locacao(c1,car1,false);
        Locacao loc2 = new Locacao(c2,car2,false);
        ListaLocacoes listaLoc = new ListaLocacoes();
        listaLoc.add(loc);
        listaLoc.add(loc2);
        System.out.println(listaLoc.get(2));
        System.out.println(listaLoc.getInfo());
        listaLoc.remove(2);
        System.out.println(listaLoc.getInfo());
        System.out.println(listaLoc.existe(1));













    }
}
