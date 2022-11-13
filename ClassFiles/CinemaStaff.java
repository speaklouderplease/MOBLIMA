import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.Objects;

import enums.MovieStatus;
import java.util.Collections;
import enums.UserType;
/**
 * Required classes: MovieRecord,Movies,MovieStatus
 */
public class CinemaStaff extends User{
    UserType CINEMASTAFF;
    CinemaStaff(String firstname,String lastname){
        super(firstname,lastname);
        super.setPassword("qwerty12345");
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
    /** 
     * @param title
     * @param director
     * @param cast
     * @param rating
     * @param synopsis
     * @param currentstatus
     * Reads the avaliable movies into an ArrayList and adds the new movie into the list.
     */
    public void addMovie(String title,String director,String cast,float rating,String synopsis,MovieStatus currentstatus){
        String filename = "MoviesCatalogue.txt";
        System.out.println("New Movie added:");
        try{
            ArrayList filmlist = MovieRecord.readMovies(filename); //To read text file which contains movie data
            Movies newfilm = new Movies(title,director,cast,rating,synopsis,currentstatus); //Read movie object based on data
            newfilm.MovieInfo(); 
            filmlist.add(newfilm); //Add movie object into the ArrayList
            MovieRecord.saveMovies(filename,filmlist); //save the text file after the movie has been added
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    
    /** 
     * @param Title
     * Reads the avaliable movies into an ArrayList and loops throught to find the remove the movie
     */
    public void removeMovie(String Title){
        String filename = "MoviesCatalogue.txt";
        System.out.println(Title + " will be removed and if there is no message stating it was removed, then it is a invalid request");
        try{
            ArrayList filmlist = MovieRecord.readMovies(filename);
            for(int i=0;i<filmlist.size();i++){
                Movies removedFilm = (Movies)filmlist.get(i);
                if(removedFilm.MovieTitle.equalsIgnoreCase(Title)){ //Checks the titles to see if any match
                    filmlist.remove(i);
                    System.out.println(removedFilm.MovieTitle + " has been removed successfully. See you again");
                }
            }
            MovieRecord.saveMovies(filename,filmlist); //save the text file after the movie has been removed
        }catch(IOException f){
            System.out.println(f.getMessage());
        }
    }

    
    /** 
     * @param Title
     * @param newstatus
     * Changes the enum status of the movie (MUST FOLLOW THE EXACT WORDING AS IN MOVIESTATUS.JAVA)
     */
    public void updateStatus(String Title, MovieStatus newstatus){
        String filename = "MoviesCatalogue.txt";
        try{
            ArrayList filmlist = MovieRecord.readMovies(filename);
            for(int i=0;i<filmlist.size();i++){
                Movies changedFilm = (Movies)filmlist.get(i);
                if(changedFilm.MovieTitle.equalsIgnoreCase(Title)){ //Checks the titles to see if any match
                    changedFilm.currentstatus = newstatus;
                    System.out.println(changedFilm.MovieTitle + " has its status changed successfully. See you again");
                }
            }
            MovieRecord.saveMovies(filename,filmlist); //save the text file after the movie has been removed
        }catch(IOException f){
            System.out.println(f.getMessage());
        }
    }

    /**
     * @param Title
     * @param newCast
     * Change the cast of the movie
     */
    public void updateSynopsis(String Title, String newstory){
        String filename = "MoviesCatalogue.txt";
        try{
            ArrayList filmlist = MovieRecord.readMovies(filename);
            for(int i=0;i<filmlist.size();i++){
                Movies changedFilm = (Movies)filmlist.get(i);
                if(changedFilm.MovieTitle.equalsIgnoreCase(Title)){ //Checks the titles to see if any match
                    changedFilm.setSynopsis(newstory);
                    System.out.println(changedFilm.MovieTitle + " has its cast members changed successfully. See you again");
                }
            }
            MovieRecord.saveMovies(filename,filmlist); //save the text file after the movie has been removed
        }catch(IOException f){
            System.out.println(f.getMessage());
        }
    }

    
    /** 
     * @param Title
     * @param times
     * Change the avaliable screenings of the movies which are in the database
     */
    public void updateScreenings(String Title, int times){
        try{
            String filename = "MoviesCatalogue.txt";
            List jikan = (ArrayList)serializer.readSerializedObject("timings.dat");
            ArrayList filmlist = MovieRecord.readMovies(filename);
            for(int i=0;i<filmlist.size();i++){
                Movies changedFilm = (Movies)filmlist.get(i);
                if(changedFilm.MovieTitle.equalsIgnoreCase(Title)){ //Checks the titles to see if any match
                    jikan.add(times);
                    Collections.sort(jikan);
                    serializer.writeSerializedObject("timings.dat",jikan);
                    System.out.println(changedFilm.MovieTitle + " has its screentimes changed successfully. See you again");
                    break;
                }              
            }
        }catch(Exception f){
            System.out.println(f.getMessage());
        }
    }


    
    /** 
     * @param Title
     * @param time
     * change the avaliable screenings of the movies
     */
    public void removeScreening(String Title, int time){
        try{
            String filename = "MoviesCatalogue.txt";
            List jikan = (ArrayList)serializer.readSerializedObject("timings.dat");
            ArrayList filmlist = MovieRecord.readMovies(filename);
            for(int i=0;i<filmlist.size();i++){
                Movies changedFilm = (Movies)filmlist.get(i);
                if(changedFilm.MovieTitle.equalsIgnoreCase(Title)){ //Checks the titles to see if any match
                    jikan.remove(Integer.valueOf(time));
                    Collections.sort(jikan);
                    serializer.writeSerializedObject("timings.dat",jikan);
                    System.out.println(changedFilm.MovieTitle + " has its screentimes changed successfully. See you again");
                    break;
                }              
            }
        }catch(Exception f){
            System.out.println(f.getMessage());
        }
    }
}

