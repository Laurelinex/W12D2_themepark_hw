import attractions.Dodgems;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.IceCreamStall;
import stalls.ParkingSpot;

import static org.junit.Assert.assertEquals;


public class ThemeParkTest {

    ThemePark park;
    Visitor visitor;
    Dodgems dodgems;
    IceCreamStall iceCreamStall;

    @Before
    public void setUp() throws Exception {
        park = new ThemePark();
        visitor = new Visitor(14, 1.2, 40.0);
        dodgems = new Dodgems("Bumper Cars", 5);
        iceCreamStall = new IceCreamStall("Dream Cones", "Vanilla Ice", ParkingSpot.A4, 6);
    }

    @Test
    public void canGetAllReviewed() {
        assertEquals(0, park.getAllReviewed().size());
    }

    @Test
    public void canAddLocation() {
        park.addLocation(dodgems);
        assertEquals(1, park.getAllReviewed().size());
    }

    @Test
    public void canVisit() {
        park.visit(visitor, dodgems);
        assertEquals(1, visitor.getVisitedAttractions().size());
        assertEquals(1, dodgems.getVisitCount());
    }

    @Test
    public void canGetAllReviewsHashMap() {
        park.addLocation(dodgems);
        park.addLocation(iceCreamStall);
        assertEquals(2, park.getAllReviewsHashMap().size());
        assertEquals(true, park.getAllReviewsHashMap().containsKey("Bumper Cars"));
        assertEquals(true, park.getAllReviewsHashMap().containsValue(5));
        assertEquals(true, park.getAllReviewsHashMap().containsKey("Dream Cones"));
        assertEquals(true, park.getAllReviewsHashMap().containsValue(6));
    }

}
