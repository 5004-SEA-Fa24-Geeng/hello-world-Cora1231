import org.junit.jupiter.api.Test;

import student.Greeter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.List;
public class GreeterTest {
    private static final String NAME_ONE = "John";
    private static final String NAME_TWO = "Alice";

    private static final Greeter greeter = new Greeter(NAME_ONE, 1);
    private static final Greeter greeter2 = new Greeter(NAME_ONE, 1);
    private static final Greeter greeter3 = new Greeter(NAME_ONE);
    private static final Greeter greeter4 = new Greeter(NAME_TWO, 3);

    @Test
    public void testConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new Greeter(NAME_ONE, 0));
        assertThrows(IllegalArgumentException.class, () -> new Greeter(NAME_ONE, 5));
        Greeter greeter = new Greeter(NAME_ONE, 1);
        assertTrue(greeter instanceof Greeter);
        greeter = new Greeter(NAME_ONE);
        assertTrue(greeter instanceof Greeter);
    }

    @Test
    public void testGetName() {
        assertEquals(NAME_ONE, greeter.getName());
    }

    @Test
    public void testGetLocality() {
        assertEquals(1, greeter.getLocality());
        assertEquals(2, greeter3.getLocality());
    }

    @Test
    public void testGetLocalityList() {
        List<String> localityList = List.of("Hawaii", "USA", "China", "Italy");
        assertEquals(localityList, Greeter.getLocalityList());
    }

    @Test
    public void testEquals() {
        assertTrue(greeter.equals(greeter2));
        assertEquals(greeter.hashCode(), greeter2.hashCode());
        assertFalse(greeter.equals(greeter3));
        assertNotEquals(greeter2.hashCode(), greeter3.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("{name:\"John\", locality:\"Hawaii\"}", greeter.toString());
        assertEquals("{name:\"Alice\", locality:\"China\"}", greeter4.toString());
    }

    @Test
    public void testGreet() {
        Greeter greeter = new Greeter(NAME_ONE, 1);
        assertEquals("Aloha, John!", greeter.greet());
        greeter = new Greeter(NAME_ONE, 2);
        assertEquals("Hello, John!", greeter.greet());
        greeter = new Greeter(NAME_ONE, 3);
        assertEquals("John, Ni Hao!", greeter.greet(true));
        assertEquals("John, 你好!", greeter.greet(false));
        greeter = new Greeter(NAME_ONE, 4);
        assertEquals("Ciao, John!", greeter.greet());
    }

    @Test
    public void testSetLocality() {
        Greeter greeter = new Greeter(NAME_ONE, 1);
        greeter.setLocality(2);
        assertEquals(2, greeter.getLocality());
        greeter.setLocality(3);
        assertEquals(3, greeter.getLocality());
        greeter.setLocality(4);
        assertEquals(4, greeter.getLocality());
        assertThrows(IllegalArgumentException.class, () -> greeter.setLocality(5));
        assertThrows(IllegalArgumentException.class, () -> greeter.setLocality(0));
    }
}