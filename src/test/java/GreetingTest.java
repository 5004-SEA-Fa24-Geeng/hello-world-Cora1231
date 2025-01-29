import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import student.Greeting;

public class GreetingTest {
    private Greeting usa;
    private Greeting hawaii;
    private Greeting china;

    @BeforeEach
    public void setUp() {
        usa = new Greeting(2, "USA");
        hawaii = new Greeting(1, "Hawaii", "Aloha");
        china = new Greeting(3, "China", "Ni Hao", "你好", "%s, %s!");
    }


    @Test
    public void testGetLocalityID() {
        assertEquals(2, usa.getLocalityID());
        assertEquals(1, hawaii.getLocalityID());
        assertEquals(3, china.getLocalityID());
    }


    @Test
    public void testGetLocalityName() {
        assertEquals("USA", usa.getLocalityName());
        assertEquals("Hawaii", hawaii.getLocalityName());
        assertEquals("China", china.getLocalityName());
    }


    @Test
    public void testGetAsciiGreeting() {
        assertEquals("Hello", usa.getAsciiGreeting());
        assertEquals("Aloha", hawaii.getAsciiGreeting());
        assertEquals("Ni Hao", china.getAsciiGreeting());
    }


    @Test
    public void testGetUnicodeGreeting() {
        assertEquals("Hello", usa.getUnicodeGreeting());
        assertEquals("Aloha", hawaii.getUnicodeGreeting());
        assertEquals("你好", china.getUnicodeGreeting());
    }


    @Test
    public void testGetFormatStr() {
        String name = "Alice";
        assertEquals("你好, Alice!", String.format(china.getFormatStr(),name));
        assertEquals("Ni Hao, Alice!", String.format(china.getFormatStr(true),name));
        assertEquals("你好, Alice!", String.format(china.getFormatStr(false),name));
        assertEquals("Hello, Alice!", String.format(usa.getFormatStr(),name));
        assertEquals("Aloha, Alice!", String.format(hawaii.getFormatStr(),name));
    }


    @Test
    public void testToString() {
        assertEquals("{localityID:2, localityName:\"USA\", asciiGreeting:\"Hello\", unicodeGreeting:\"Hello\"}", usa.toString());
        assertEquals("{localityID:1, localityName:\"Hawaii\", asciiGreeting:\"Aloha\", unicodeGreeting:\"Aloha\"}", hawaii.toString());
        assertEquals("{localityID:3, localityName:\"China\", asciiGreeting:\"Ni Hao\", unicodeGreeting:\"你好\"}", china.toString());
    }


    @Test
    public void testGreet() {
        String name = "John";
        assertEquals("Hello, John!", String.format(usa.getFormatStr(),name));
        assertEquals("Aloha, John!", String.format(hawaii.getFormatStr(), name));
        assertEquals("你好, John!", String.format(china.getFormatStr(), name));
        assertEquals("Ni Hao, John!", String.format(china.getFormatStr(true), name));
    }
}