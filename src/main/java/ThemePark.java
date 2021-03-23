import attractions.Attraction;
import behaviours.IReviewed;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;

public class ThemePark {

    private ArrayList<Attraction> attractions;
    private ArrayList<Stall> stalls;
    private ArrayList<IReviewed> allParkLocations;

    public ThemePark() {
        this.attractions = new ArrayList<Attraction>();
        this.stalls = new ArrayList<Stall>();
        this.allParkLocations = new ArrayList<IReviewed>();
    }

    public ArrayList getAllReviewed() {
        return allParkLocations;
    }

    public void visit(Visitor visitor, Attraction attraction) {
        attraction.incrementVisitCount();
        visitor.addAttractionToVisited(attraction);
    }

}
