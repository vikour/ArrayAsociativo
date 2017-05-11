/**
 * Array asociativo (clave, valor)
 * 
 * @author Víctor Manuel Ortiz Guardeño
 */

public class ArrayAsociativo {
    
    private class Node {
        String key;
        String value;
        Node next;
    }
    
    private Node first;
    private int tam;

    public ArrayAsociativo() {
        this.first = null;
        tam = 0;
    }
    
    public int size() {
        return tam;
    }
    
}
