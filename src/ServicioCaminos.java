import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ServicioCaminos {
    private Grafo<?> grafo;
    private int origen;
    private int destino;
    private int lim;

    public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {
        this.grafo = grafo;
        this.origen = origen;
        this.destino = destino;
        this.lim = lim;
    }

    public List<List<Integer>> caminos() {
        ArrayList<ArrayList<Integer>> resultado = new ArrayList<>();
        ArrayList<Integer> camino = new ArrayList<>();
        camino.add(origen);

        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(origen);

        while(adyacentes.hasNext()){
            int actual = adyacentes.next();
            ArrayList<Integer> copia = (ArrayList<Integer>) camino.clone();
            copia.add(actual);
            caminos(actual, destino, copia, resultado, 0);
        }
        return new ArrayList<>(resultado);
    }

    private void caminos(int origen, int destino, ArrayList<Integer> camino, ArrayList<ArrayList<Integer>> resultado, int cantArcos){
        if(origen == destino && cantArcos < lim){
            resultado.add(camino);
        }
        else{
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(origen);
            while(adyacentes.hasNext()){
                int actual = adyacentes.next();
                ArrayList<Integer> copia = (ArrayList<Integer>) camino.clone();
                if(!copia.contains(actual)) {
                    copia.add(actual);
                    caminos(actual, destino, copia, resultado, cantArcos +1);
                }
            }
        }
    }

}
