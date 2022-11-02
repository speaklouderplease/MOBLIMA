public class Movies{
    public String movietitle;
    public String director;
    public String cast;
    private String synopsis;
    private float rating;

    
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
}