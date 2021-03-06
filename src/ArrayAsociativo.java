
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

        public Node() {
            this(null,null,null);
        }

        public Node(String key, String value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
        
    }
    
    private Node first;
    private int size;

    public ArrayAsociativo() {
        this.first = null;
        size = 0;
    }
    
    public ArrayAsociativo(String key, String value) {
        first = new Node(key,value,null);
        this.size = 1;
    }
    
    public ArrayAsociativo(ArrayAsociativo array) {
        Node src = array.first;
        Node dst = null;
        
        while (src != null) {
            
            if (dst == null) {
                first = new Node(src.key,src.value,null);
                dst = first;
            }
            else
                dst.next = new Node(src.key, src.value, null);
            
            src = src.next;
        }
        
        size = array.size;
    }
    
    public int size() {
        return size;
    }
    
    private Node searchNode(String key) {
        Node curr = first;
        
        while (curr != null && curr.key.compareTo(key) != 0)
            curr = curr.next;
        
        return curr;
    }
    
    public String get(String key) {
        Node node = searchNode(key);
        
        if (node == null)
            throw new NoSuchElementException();
        
        return node.value;
    }
    
    public void put(String key, String value) {
        Node curr = first;
        Node prev = null;
        
        while (curr != null && curr.key.compareTo(key) != 0) {
            prev = curr;
            curr = curr.next;
        }
        
        if (curr != null) 
            curr.value = value;
        else {
            
            if (prev == null)
                first = new Node(key,value,null);
            else
                prev.next = new Node(key,value,null);
            
            size++;
        }
        
    }
    
    public String getOrElse(String key, String defaultValue) {
        Node node = searchNode(key);
        String value;
        
        if (node == null)            
            value = defaultValue;
        else
            value = node.value;
        
        return value;
    }

    public boolean containsKey(String key) {
        return searchNode(key) != null;
    }
    
    boolean remove(String key) {
        Node curr = first;
        Node prev = null;
        boolean removed = false;
        
        while (curr != null && curr.key.compareTo(key) != 0) {
            prev = curr;
            curr = curr.next;
        }
        
        if (curr != null) {
            
            if (prev == null)
                first = first.next;
            else
                prev.next = curr.next;
            
            removed = true;
            size--;
        }
        
        return removed;
    }
}
