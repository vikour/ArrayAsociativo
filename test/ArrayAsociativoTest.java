
import java.security.NoSuchAlgorithmException;
import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayAsociativoTest {
    
    @Test
    public void sizeEmpty() {
        ArrayAsociativo a = new ArrayAsociativo();
        assertEquals(0, a.size());
    }
    
    @Test
    public void sizeNotEmpty() {
        ArrayAsociativo a = new ArrayAsociativo("key","value");
        assertNotEquals(0, a.size());
    }
    
    // Buscar el valor correspondiente a una clave en un array vacío
    @Test(expected = NoSuchElementException.class)
    public void keyNotFoundEmptyArray() {
        ArrayAsociativo a= new ArrayAsociativo();
        String key = "key";
        a.get("key");
    }
    
    //Buscar el valor correspondiente a una clave en un array en el que existe 
    //dicha clave
    public void searchValueKeyInArray() {
        ArrayAsociativo a = new ArrayAsociativo("key","value");
        assertEquals("value",a.get("key"));
    }
    
    //Buscar el valor correspondiente a una clave en un array en el que no existe
    //la clave.
    @Test(expected = NoSuchElementException.class)
    public void searchValueByKeyNotInArray() {
        ArrayAsociativo a = new ArrayAsociativo("hola", "adios");
        a.get("key");
    }
    
    //Insertar un nuevo par en un array vacío
    @Test
    public void insertPairEmptyArray() {
        ArrayAsociativo a = new ArrayAsociativo();
        a.put("key","value");
        assertEquals("value", a.get("key"));
    }
    
    @Test
    public void insertPairNotEmptyArray() {
        ArrayAsociativo a = new ArrayAsociativo("initial", "initialValue");
        int size = a.size();
        
        a.put("key", "value");
        assertEquals("initialValue", a.get("initial"));
        assertEquals("value", a.get("key"));
        assertEquals(size + 1, a.size());
    }
    
    @Test
    public void insertPairModifyValue() {
        ArrayAsociativo a = new ArrayAsociativo("initial", "initialValue");
        int size = a.size();
        
        a.put("initial","newValue");
        assertEquals("newValue", a.get("initial"));
        assertEquals(size, a.size());
    }
    
    // Test 8
    @Test
    public void testGetOrElseEmptyArray() {
        ArrayAsociativo a = new ArrayAsociativo();
        
        assertEquals("nothing", a.getOrElse("key","nothing"));
    }
    
    // Test 9
    @Test
    public void testGetOrElseKeyExists() {
        ArrayAsociativo a = new ArrayAsociativo("initial","Value");
        
        assertEquals("Value", a.getOrElse("initial", "default"));
        a.put("key", "tree");
        assertEquals("tree", a.getOrElse("key", "default"));
    }
    
}
