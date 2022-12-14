import enums.MovieStatus;
import java.util.ArrayList;
/**
 * @author Justin Seah
 * Contains all attributes and methods for Movie objects such as Title, set/get methods
 */
public class Movies implements Comparable<Movies>, Reviews{
    public String MovieTitle;
    public String Director;
    public String Cast;
    public float rating;
    private String synopsis;
    private ArrayList<String> allReviews;
    private ArrayList<Float> allRatings;
    private ArrayList<Integer> ScreenTimes;
    public MovieStatus currentstatus;

    /**
     * Default constructor
     */
    public Movies(){};
    /**
     * 
     * @param title
     * @param director
     * @param cast
     * @param rating
     * @param synopsis
     * Constructor for Movies object
     */
    public Movies(String title,String director,String cast,float rating,String synopsis,MovieStatus currentstatus){
        MovieTitle = title;
        Director = director;
        Cast = cast;
        this.rating = rating;
        this.synopsis = synopsis;
        allReviews = new ArrayList<String>();
        allRatings = new ArrayList<Float>();        
        allRatings.add(3.0f);
        allRatings.add(2.3f);
        allRatings.add(rating);
        allReviews.add("Met my expectations!");
        ScreenTimes = (ArrayList<Integer>)serializer.readSerializedObject("timings.dat");
        this.currentstatus = currentstatus;
    }

    public void getScreenTime(){
        ScreenTimes = (ArrayList<Integer>)serializer.readSerializedObject("timings.dat");
        System.out.println("Avaliable showtimes: ");
        for(int i:ScreenTimes){
            System.out.println(i+":00");
        }
    }

    
    /** 
     * @param timings
     */
    public void setScreenTime(int timings){
        ScreenTimes.add(timings);
    }

    /** 
     * @return provide the summary upon request
     */
    public String getSynopsis(){
        return synopsis;
    }
    
    
    /** 
     * @param p
     */
    public void setSynopsis(String p){
        synopsis = p;
    }
    /** 
     * @return provide the aggregate rating
     */
    public float getrating(){
        return rating;
    }

    public void getReview(){
        for(int i=0;i<allReviews.size();i++){
            System.out.println(i+":"+allReviews.get(i));
        }
    }

    
    /** 
     * @param u
     */
    public void setRating(float u){
        allRatings.add(u);
        float sum = 0;
        for(float i: allRatings){
            sum += i;
        }
        rating = sum/(allRatings.size());
    }

    
    /** 
     * @param review
     */
    public void setReview(String review){
        allReviews.add(review);
    }

    /**
     * Prints out the important information of the movie
     * - Movie Title
     * - Director
     * - 2 cast members
     * - rating
     * - summary
     */
    public void MovieInfo(){
        System.out.println(MovieTitle);
        System.out.println("Director: " + Director);
        System.out.println("Starring: " + Cast);
        System.out.println("Rating: " + rating);
        System.out.println("<-------Summary------->");
        System.out.println(getSynopsis());
        System.out.println(currentstatus);
        System.out.println();
    }

    /**
     * @see Sorting,java
     * Overrides the compareTo method of the Comparable class and sorts movie objects according to aggregate rating score
     */
    @Override
    public int compareTo(Movies m){
		if(this.getrating() > m.getrating()){
            return 1;
        }
        else {return -1;}
    } 
}
