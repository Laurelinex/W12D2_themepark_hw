import attractions.Dodgems;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    ThemePark park;
    Visitor visitor;
    Dodgems dodgems;

    @Before
    public void setUp() throws Exception {
        park = new ThemePark();
        visitor = new Visitor(14, 1.2, 40.0);
        dodgems = new Dodgems("Bumper Cars", 5);
    }

    @Test
    public void canGetAllReviewed() {
        assertEquals(0, park.getAllReviewed().size());
    }

    @Test
    public void canVisit() {
        park.visit(visitor, dodgems);
        assertEquals(1, visitor.getVisitedAttractions().size());
        assertEquals(1, dodgems.getVisitCount());
    }



}
