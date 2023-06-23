package coleccion;

public class Arco<T> {

    private int verticeOrigen;
    private int verticeDestino;
    private T etiqueta;

    public Arco(int verticeOrigen, int verticeDestino, T etiqueta) {
        this.verticeOrigen = verticeOrigen;
        this.verticeDestino = verticeDestino;
        this.etiqueta = etiqueta;
    }

    public int getVerticeOrigen() {
        return verticeOrigen;
    }

    public int getVerticeDestino() {
        return verticeDestino;
    }

    public T getEtiqueta() {
        return etiqueta;
    }

    @Override
    public String toString(){
        return "Origen: " + getVerticeOrigen() + "\nDestino: " + getVerticeDestino() + "\nEtiqueta: " + getEtiqueta();
    }

    @Override
    public boolean equals(Object o){
        try{
            Arco<T> a = (Arco<T>) o;
            return a.getVerticeOrigen() == this.getVerticeOrigen() && a.getVerticeDestino() == this.getVerticeDestino();
        }
        catch(Exception e){
            return false;
        }
    }

}
