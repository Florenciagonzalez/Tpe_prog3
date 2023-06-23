
import coleccion.GrafoDirigido;
import servicios.ServicioDFS;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        GrafoDirigido grafo = new GrafoDirigido();

        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(1);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);


        grafo.agregarArco(1, 5, "pp");
        grafo.agregarArco(2, 4, "pp");
        grafo.agregarArco(4, 3, "pp");
        grafo.agregarArco(3, 5, "pp");


        ServicioDFS sv = new ServicioDFS(grafo);
        System.out.println(sv.dfsForest());

        Iterator<Integer> it = grafo.obtenerVertices();
        while (it.hasNext()){
            int v = it.next();
            System.out.println(v);
        }

    }
}