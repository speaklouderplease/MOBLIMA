import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.Objects;

public class MovieGoer extends User implements Reviews{
    public MovieGoer(String firstname,String lastname){
        super(firstname,lastname);
        super.setPassword("guest9876");
    }
    public void viewMovies(){
        String filename = "MoviesCatalogue.txt";
        try{
            ArrayList filmlist = MovieRecord.readMovies(filename);
				for (int i = 0 ; i < filmlist.size() ; i++) {
					Movies c = (Movies)filmlist.get(i);
					c.MovieInfo();
				}
            }catch(Exception d){
                System.out.println(d.getMessage());
            }
    }

    public void checkMovie(String Title){
        Movies c = new Movies();
        String filename = "MoviesCatalogue.txt";
        try{
        ArrayList filmlist = MovieRecord.readMovies(filename);
				for (int i = 0 ; i < filmlist.size() ; i++) {
					c = (Movies)filmlist.get(i);
					if(c.MovieTitle.equalsIgnoreCase(Title)){
                        break;
                    }
                    else{c=null;}
				}
                if(!Objects.isNull(c)){
                    c.MovieInfo();
                    c.getScreenTime();
                }
                else{
                    System.out.println("No such movie exists");
                }
       
            }catch(IOException d){
                System.out.println(d.getMessage());
        }
    }

    public void getDescription(String Title){
        try{
            ArrayList filmlist = MovieRecord.readMovies("MoviesCatalogue.txt");
				for (int i = 0 ; i < filmlist.size() ; i++) {
					Movies c = (Movies)filmlist.get(i);
                    if(c.MovieTitle.equalsIgnoreCase(Title)){
                        c.getReview();
                    }
                }
            }catch(Exception d){
                System.out.println(d.getMessage());
            }
    }

    public void setDescription(String Title,String review){
        try{
            ArrayList filmlist = MovieRecord.readMovies("MoviesCatalogue.txt");
				for (int i = 0 ; i < filmlist.size() ; i++) {
					Movies c = (Movies)filmlist.get(i);
                    if(c.MovieTitle.equalsIgnoreCase(Title)){
                        c.setReview(review);
                    }
                }
            }catch(Exception d){
                System.out.println(d.getMessage());
            }
    }
}
