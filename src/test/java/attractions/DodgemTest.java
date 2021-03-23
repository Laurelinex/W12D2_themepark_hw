package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class DodgemTest {

    Dodgems dodgems;
    Visitor tinyTim;
    Visitor teenTom;

    @Before
    public void setUp() throws Exception {
        dodgems = new Dodgems("Bumper Cars", 5);
        tinyTim = new Visitor(8, 120, 10);
        teenTom = new Visitor(14, 150, 20);
    }


    @Test
    public void hasName() {
        assertEquals("Bumper Cars", dodgems.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(5, dodgems.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, dodgems.getVisitCount());
    }

    @Test
    public void chargesNormalFeeIf12orOver() {
        assertEquals(4.50, dodgems.priceFor(teenTom), 0.0);
    }

    @Test
    public void chargesHalfFeeIfLess12() {
        assertEquals(2.25, dodgems.priceFor(tinyTim), 0.0);
    }
}
