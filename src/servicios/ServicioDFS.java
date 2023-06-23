package servicios;

import coleccion.Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ServicioDFS {
    private Grafo<?> grafo;
    private HashMap<Integer, String> registro;
    private ArrayList<Integer> lista;
    public ServicioDFS(Grafo<?> grafo) {
        this.grafo = grafo;
        this.registro = new HashMap<>();
        this.lista = new ArrayList<>();
    }

    public List<Integer> dfsForest() {
        this.asignarColor();

        Iterator<Integer> it = grafo.obtenerVertices();
        while (it.hasNext()){
            int vertice = it.next();
            if(registro.get(vertice).equals("blanco")) {
                lista.add(vertice);
                dfsVisit(vertice);
            }
        }
        return lista;
    }

    private void dfsVisit(int v) {
        registro.replace(v, "blanco", "amarillo");
        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(v);
        while (adyacentes.hasNext()){
            int ady = adyacentes.next();
            if(registro.get(ady).equals("blanco")){
                lista.add(ady);
                dfsVisit(ady);
            }
        }
        registro.replace(v, "amarillo", "negro");
    }

    private void asignarColor() {
        Iterator<Integer> vertices = grafo.obtenerVertices();
        while(vertices.hasNext()) {
            Integer v = vertices.next();
            registro.put(v, "blanco");
        }
    }
}
