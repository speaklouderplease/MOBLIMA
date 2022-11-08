import enums.MovieStatus;
import java.util.ArrayList;

public class Movies{
    public String MovieTitle;
    public String Director;
    public String Cast;
    public float rating;
    private String synopsis;
    private ArrayList<String> allReviews;
    private ArrayList<Float> allRatings;
    public MovieStatus currentstatus;
    private String ScreenTimes;

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
        allRatings.add(0.0f);
        allReviews.add("Met my expectations!");
        this.currentstatus = currentstatus;
    }

    public String getScreentime(){
        return ScreenTimes;
    }

    public void setScreenTime(String timings){
        ScreenTimes = timings;
    }

    /** 
     * @return provide the summary upon request
     */
    public String getSynopsis(){
        return synopsis;
    }
    
    /** 
     * @return provide the aggregate rating
     */
    public float getrating(){
        return rating;
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
    }
}
