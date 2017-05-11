
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
    
}
