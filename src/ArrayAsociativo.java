
import java.util.NoSuchElementException;

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
    private int size;

    public ArrayAsociativo() {
        this.first = null;
        size = 0;
    }
    
    public ArrayAsociativo(String key, String value) {
        first = new Node();
        first.key = key;
        first.value = value;
        first.next = null;
        this.size = 1;
    }
    
    public int size() {
        return size;
    }
    
    public String get(String key) {
        throw new NoSuchElementException();
    }
    
}
