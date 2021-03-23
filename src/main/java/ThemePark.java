import attractions.Attraction;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {

    private ArrayList<IReviewed> allParkLocations;

    public ThemePark() {
        this.allParkLocations = new ArrayList<IReviewed>();
    }

    public void addLocation(IReviewed location) {
        this.allParkLocations.add(location);
    }

    public ArrayList getAllReviewed() {
        return allParkLocations;
    }

    public void visit(Visitor visitor, Attraction attraction) {
        attraction.incrementVisitCount();
        visitor.addAttractionToVisited(attraction);
    }

    public HashMap<String, Integer> getAllReviewsHashMap() {
        HashMap<String, Integer> allReviews = new HashMap<String, Integer>();
        for(IReviewed location : allParkLocations) {
            allReviews.put(location.getName(), location.getRating());
        }
        return allReviews;
    }

    public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor) {
        ArrayList<IReviewed> allowedAttractions = new ArrayList<>();
        for(IReviewed attraction : allParkLocations) {
            if(attraction instanceof ISecurity) {
                if(((ISecurity) attraction).isAllowedTo(visitor)) {
                    allowedAttractions.add((IReviewed) attraction);
                }
            } else {
                allowedAttractions.add(attraction);
            }
        }
        return allowedAttractions;
    }

}
