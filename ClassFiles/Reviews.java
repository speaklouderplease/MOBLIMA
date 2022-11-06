import java.util.ArrayList;

public class Reviews {
    public float rating;
    public int ReviewID;
    private ArrayList<String> allReviews;
    private ArrayList<Float> allRatings;
      
    /** 
     * @return String
     * post all reviews
     */
    public void getDescription(){
        for(String i: allReviews){
            System.out.println(i);
        }
    }

    /** 
     * @param review
     * allow user to add a written review
     */
    public void setDescription(String description){
        allReviews.add(description);
    }

    /**
     * @param rate
     * to collate all ratings inside a resizeable array.
     */
    public void addRating(float rate){
        allRatings.add(rate);

    }

    /**
     * calculates the average rating by taking the mean of all the ratings stored
     */
    protected void setReview(){
        float sum = 0;
        for(float i: allRatings){
            sum += i;
        }
        rating = sum/allRatings.size();
    }

}
