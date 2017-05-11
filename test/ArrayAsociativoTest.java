
import java.security.NoSuchAlgorithmException;
import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayAsociativoTest {
    
    private static final ArrayAsociativo ARRAY_EMPTY = new ArrayAsociativo();
    private static final String KEY = "initial";
    private static final String VALUE = "initialValue";
    private static final ArrayAsociativo ARRAY_NOT_EMPTY =
            new ArrayAsociativo(KEY, VALUE);
    
    private ArrayAsociativo array_empty;
    private ArrayAsociativo array_not_empty;
    
    @Before
    public void linkArrays() {
        array_empty = new ArrayAsociativo(ARRAY_EMPTY);
        array_not_empty = new ArrayAsociativo(ARRAY_NOT_EMPTY);
    }
    
    @Test
    public void sizeEmpty() {
        assertEquals(0, array_empty.size());
    }
    
    @Test
    public void sizeNotEmpty() {
        assertNotEquals(0, array_not_empty.size());
    }
    
    // Buscar el valor correspondiente a una clave en un array vacío
    @Test(expected = NoSuchElementException.class)
    public void keyNotFoundEmptyArray() {
        array_not_empty.get(KEY+"hey");
    }
    
    //Buscar el valor correspondiente a una clave en un array en el que existe 
    //dicha clave
    @Test
    public void searchValueKeyInArray() {
        assertEquals(VALUE,array_not_empty.get(KEY));
    }
    
    //Buscar el valor correspondiente a una clave en un array en el que no existe
    //la clave.
    @Test(expected = NoSuchElementException.class)
    public void searchValueByKeyNotInArray() {
        array_not_empty.get(KEY+"yah");
    }
    
    //Insertar un nuevo par en un array vacío
    @Test
    public void insertPairEmptyArray() {
        array_empty.put("key","value");
        assertEquals("value", array_empty.get("key"));
    }
    
    @Test
    public void insertPairNotEmptyArray() {
        int size = array_not_empty.size();
        
        array_not_empty.put("key", "value");
        assertEquals(VALUE, array_not_empty.get(KEY));
        assertEquals("value", array_not_empty.get("key"));
        assertEquals(size + 1, array_not_empty.size());
    }
    
    @Test
    public void insertPairModifyValue() {
        int size = array_not_empty.size();
        
        array_not_empty.put(KEY,VALUE+" is new");
        assertEquals(VALUE + " is new", array_not_empty.get(KEY));
        assertEquals(size, array_not_empty.size());
    }
    
    // Test 9
    @Test
    public void testGetOrElseEmptyArray() {
        assertEquals("nothing", array_empty.getOrElse("key","nothing"));
    }
    
    // Test 10
    @Test
    public void testGetOrElseKeyExists() {
        assertEquals(VALUE, array_not_empty.getOrElse(KEY, "default"));
        array_not_empty.put("key", "tree");
        assertEquals("tree", array_not_empty.getOrElse("key", "default"));
    }
    
    // Test 11
    @Test
    public void testGetOrElseKeyDontExist() {
        assertEquals("nothing", array_not_empty.getOrElse("Not exists", "nothing"));
        array_not_empty.put("inital2", "someValue");
        assertEquals("nothing", array_not_empty.getOrElse("Not exists", "nothing"));
    }
    
    // Test 12
    @Test
    public void testContainsKeyEmptyArray() {
        assertFalse(array_empty.containsKey("initial"));
    }
    
    // Test 13
    @Test
    public void testContainsKeyNotEmptyArrayNotExistsKey() {
        assertFalse(array_not_empty.containsKey(KEY+"ya"));
    }
    
    // Test 14
    @Test
    public void testContainsKeyNotEmptyKeyExists() {
        assertTrue(array_not_empty.containsKey(KEY));
        array_not_empty.put(KEY+"ya", VALUE+" now");
        assertTrue(array_not_empty.containsKey(KEY+"ya"));
    }
    
    // Test 15
    @Test
    public void testRemoveEmptyArray() {
        assertFalse(array_empty.remove(KEY));
    }
    
    // Test 16
    @Test
    public void testRemoveNotEmptyArray() {
        System.out.println("Testing 16 : Removing an element...");
        // removed and array empty
        System.out.print("\tChecking remove first ...");
        assertTrue(array_not_empty.remove(KEY));
        assertEquals(0, array_not_empty.size());
        System.out.println("OK!");
        // remove second (last)...                      
        System.out.print("\tChecking remove last ...");        
        array_not_empty.put(KEY+"1",VALUE+"1");        // (KEY1, ..)
        array_not_empty.put(KEY+"2",VALUE+"2");        // (KEY1, KEY2 ...)
        assertTrue(array_not_empty.remove(KEY+"2"));   // (KEY1, ...)
        array_not_empty.get(KEY+"1");
        assertEquals(1, array_not_empty.size());
        System.out.println("OK!");
        
        // remove middle element. 
        System.out.print("\tChecking remove middle ..."); 
        array_not_empty.put(KEY+"2",VALUE+"2");        // (KEY1,KEY2,...)
        array_not_empty.put(KEY+"3",VALUE+"3");        // (KEY1,KEY2,KEY3)
        assertTrue(array_not_empty.remove(KEY+"2"));   // (KEY1,KEY3,...)
        array_not_empty.get(KEY+"1");
        array_not_empty.get(KEY+"3");
        assertEquals(2,array_not_empty.size());
        System.out.println("OK!");
    }
    
}
