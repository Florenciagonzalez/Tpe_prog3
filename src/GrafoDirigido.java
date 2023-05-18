import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
    private HashMap<Integer, ArrayList<Arco<T>>> grafo;

    public GrafoDirigido() {
        this.grafo = new HashMap<>();
    }



    /**
     * Complejidad: O(n) donde n es ... debido a que debe
     * "realizar lo siguiente" para verificar si existe un arco.
     */
    @Override
    public void agregarVertice(int verticeId) {
       if(!contieneVertice(verticeId)){
           grafo.put(verticeId, new ArrayList<>());
       }
    }


    /**
     * Complejidad: O(n) donde n es ... debido a que debe
     * "realizar lo siguiente" para verificar si existe un arco.
     */
    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        if(!contieneVertice(verticeId1)){
            grafo.put(verticeId1, new ArrayList<>());
        }
        if(!contieneVertice(verticeId2)){
            grafo.put(verticeId2, new ArrayList<>());
        }
        Arco<T> aux = new Arco<>(verticeId1, verticeId2, etiqueta);
        if(!grafo.get(verticeId1).contains(aux)) {
            grafo.get(verticeId1).add(aux);
        }
    }


    /**
     * Complejidad: O(n) donde n es ... debido a que debe
     * "realizar lo siguiente" para verificar si existe un arco.
     */
    @Override
    public void borrarVertice(int verticeId) {
        if(contieneVertice(verticeId)){
            grafo.remove(verticeId);
            Iterator<Integer> iterador = obtenerVertices();

            while(iterador.hasNext()){
                Integer vertice = iterador.next();
                ArrayList<Arco<T>> arcos = grafo.get(vertice);
                for(int i = 0; i < arcos.size(); i++){
                    Arco a = arcos.get(i);
                    if(a.getVerticeDestino() == verticeId){
                        arcos.remove(a);
                    }
                }
            }
        }

    }


    /**
     * Complejidad: O(n) donde n es ... debido a que debe
     * "realizar lo siguiente" para verificar si existe un arco.
     */
    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        if(existeArco(verticeId1, verticeId2)) {
            ArrayList<Arco<T>> aux = grafo.get(verticeId1);
            if (aux != null) {
                aux.removeIf(arco -> arco.getVerticeDestino() == verticeId2);
            }
        }
    }

    /**
     * Complejidad: O(n) donde n es ... debido a que debe
     * "realizar lo siguiente" para verificar si existe un arco.
     */
    @Override
    public boolean contieneVertice(int verticeId) {
        return grafo.containsKey(verticeId);
    }



    /**
     * Complejidad: O(n) donde n es ... debido a que debe
     * "realizar lo siguiente" para verificar si existe un arco.
     */
    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        if (contieneVertice(verticeId1) && contieneVertice(verticeId2)) {
            ArrayList<Arco<T>> aux = grafo.get(verticeId1);
            if (aux != null) {
                for (Arco a : aux) {
                    if (a.getVerticeDestino() == verticeId2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }



    /**
     * Complejidad: O(n) donde n es ... debido a que debe
     * "realizar lo siguiente" para verificar si existe un arco.
     */
    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        if(existeArco(verticeId1, verticeId2)){
            ArrayList<Arco<T>> aux = grafo.get(verticeId1);
            for (Arco a: aux){
                if(a.getVerticeDestino() == verticeId2){
                    return a;
                }
            }
        }
        return null;
    }


    /**
     * Complejidad: O(n) donde n es ... debido a que debe
     * "realizar lo siguiente" para verificar si existe un arco.
     */
    @Override
    public int cantidadVertices() {
        return grafo.size();
    }


    /**
     * Complejidad: O(n) donde n es ... debido a que debe
     * "realizar lo siguiente" para verificar si existe un arco.
     */
    @Override
    public int cantidadArcos() {
        int cant = 0;
        Iterator<Integer> iterador = obtenerVertices();

        while(iterador.hasNext()){
            Integer vertice = iterador.next();
            ArrayList<Arco<T>> aux = grafo.get(vertice);
            cant += aux.size();
        }

        return cant;
    }

    /**
     * Complejidad: O(n) donde n es ... debido a que debe
     * "realizar lo siguiente" para verificar si existe un arco.
     */
    @Override
    public Iterator<Integer> obtenerVertices() {
        return grafo.keySet().iterator();
    }


    /**
     * Complejidad: O(n) donde n es ... debido a que debe
     * "realizar lo siguiente" para verificar si existe un arco.
     */
    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        ArrayList<Arco<T>> arcos = grafo.get(verticeId);
        ArrayList<Integer> adyacentes = new ArrayList<>();

        if(arcos !=null) {
            for (Arco a : arcos) {
                adyacentes.add(a.getVerticeDestino());
            }
            return adyacentes.iterator();
        }
        return null;
    }


    /**
     * Complejidad: O(n) donde n es ... debido a que debe
     * "realizar lo siguiente" para verificar si existe un arco.
     */
    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        ArrayList<Arco<T>> arcos = new ArrayList<>();
        Iterator<Integer> iterador = obtenerVertices();

        while(iterador.hasNext()){
            Integer vertice = iterador.next();
            arcos.addAll(grafo.get(vertice));
        }

        return arcos.iterator();
    }

    /**
     * Complejidad: O(n) donde n es ... debido a que debe
     * "realizar lo siguiente" para verificar si existe un arco.
     */
    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        return grafo.get(verticeId).iterator();
    }

}
