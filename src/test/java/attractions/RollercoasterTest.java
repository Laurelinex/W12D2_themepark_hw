package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor averageJoe;
    Visitor tinyGrandpa;
    Visitor lankyKid;
    Visitor basketballPlayer;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        averageJoe = new Visitor(30, 180, 200);
        tinyGrandpa = new Visitor(82, 130, 100);
        lankyKid = new Visitor(11, 168, 20);
        basketballPlayer = new Visitor(25, 210, 300);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void allowsVisitorAgeTrueHeightTrue() {
        assertEquals(true, rollerCoaster.isAllowedTo(averageJoe));
    }

    @Test
    public void allowsVisitorHeightTrueButNotAge() {
        assertEquals(false, rollerCoaster.isAllowedTo(lankyKid));
    }

    @Test
    public void allowsVisitorAgeTrueButNotHeight() {
        assertEquals(false, rollerCoaster.isAllowedTo(tinyGrandpa));
    }

    @Test
    public void chargesNormalFeeIfVisitorLess200() {
        assertEquals(8.40, rollerCoaster.priceFor(averageJoe), 0.0);
    }

    @Test
    public void chargesDoubleIfVisitorMore200() {
        assertEquals(16.80, rollerCoaster.priceFor(basketballPlayer), 0.0);
    }

}
