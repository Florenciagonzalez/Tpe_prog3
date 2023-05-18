import java.util.Iterator;

public interface Grafo<T> {

    public void agregarVertice(int verticeId);

    public void borrarVertice(int verticeId);

    public void agregarArco(int verticeId1, int verticeId2, T etiqueta);

    public void borrarArco(int verticeId1, int verticeId2);


    public boolean contieneVertice(int verticeId);

    public boolean existeArco(int verticeId1, int verticeId2);


    public Arco<T> obtenerArco(int verticeId1, int verticeId2);

    public int cantidadVertices();

    // Devuelve la cantidad total de arcos en el grafo
    public int cantidadArcos();

    // Obtiene un iterador que me permite recorrer todos los vertices almacenados en el grafo
    public Iterator<Integer> obtenerVertices();

    // Obtiene un iterador que me permite recorrer todos los vertices adyacentes a verticeId
    public Iterator<Integer> obtenerAdyacentes(int verticeId);

    // Obtiene un iterador que me permite recorrer todos los arcos del grafo
    public Iterator<Arco<T>> obtenerArcos();

    // Obtiene un iterador que me permite recorrer todos los arcos que parten desde verticeId
    public Iterator<Arco<T>> obtenerArcos(int verticeId);


}