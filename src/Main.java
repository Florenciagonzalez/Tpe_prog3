
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        GrafoDirigido grafo = new GrafoDirigido();

        grafo.agregarVertice(0);
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);
        grafo.agregarVertice(6);


        grafo.agregarArco(0, 3, "uu");
        grafo.agregarArco(3, 1, "pp");
        grafo.agregarArco(1, 5, "bb");
        grafo.agregarArco(3, 5, "bb");

        grafo.agregarArco(0, 4, "uu");
        grafo.agregarArco(4, 2, "bb");
        grafo.agregarArco(2, 5, "bb");


        grafo.agregarArco(2, 6, "bb");
        grafo.agregarArco(6, 5, "bb");


        ServicioBFS bfs = new ServicioBFS(grafo);
        ServicioDFS dfs = new ServicioDFS(grafo);
        ServicioCaminos caminos = new ServicioCaminos(grafo, 0, 5, 8);

        System.out.println(grafo.contieneVertice(6));
        grafo.borrarVertice(6);
        System.out.println(grafo.contieneVertice(6));


    }
}