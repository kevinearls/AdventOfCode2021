import org.junit.jupiter.api.Test;

public class SquareTest {

    @Test
    void simpleTest() throws Exception {
        Square s = new Square(("24"));
        System.out.println("" + s.toString());
    }
}
