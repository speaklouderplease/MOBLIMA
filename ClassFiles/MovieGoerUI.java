//import java.util.Scanner;
import java.util.ArrayList;
import java.util.Objects;
import java.io.IOException;
import java.util.*;

/**
 * @author Ang Teck Yee
 * Provide the menu for the customer to use the system after logging in.
 */
public class MovieGoerUI{
  public static void MovieGoerMain(){
    MovieGoer customer = new MovieGoer("Jack","34","cgui345",34,"62781245","JackTheman@hotmail.com");
    Scanner sc = new Scanner(System.in);
    int choice=0;
    System.out.println("Welcome to Moblima "+ customer.getUsername());
    do{
    System.out.println("Pick a option from below");
    System.out.println("1.Search/List Movies");
    System.out.println("2.View Movie details");
    System.out.println("3.Check Seat availability");
    System.out.println("4.Add a rating");
    System.out.println("5.Book and purchase ticket");  
    System.out.println("6.View booking history");
    System.out.println("7.List top 5 movies");
    System.out.println("8.Exit");                   
    choice = sc.nextInt();
      switch(choice){
        case 1:
            String filename = "MoviesCatalogue.txt";
            try{
                ArrayList filmlist = MovieRecord.readMovies(filename);
            for (int i = 0 ; i < filmlist.size() ; i++){
              Movies c = (Movies)filmlist.get(i);
              c.MovieInfo();
              }
              }catch(Exception d){System.out.println(d.getMessage());}             
              break;

        case 2:         
            System.out.println("Enter name of movie:");
            Scanner sc1 = new Scanner(System.in);
            String movieTitle = sc1.nextLine();  
            try{
            Movies xyz = new Movies();
            ArrayList filmlist = MovieRecord.readMovies("MoviesCatalogue.txt");
            for (int i = 0 ; i < filmlist.size() ; i++) {
                xyz = (Movies)filmlist.get(i);
                if(xyz.MovieTitle.equalsIgnoreCase(movieTitle)){
                    break;
                }
                else{xyz=null;}
            }
            if(!Objects.isNull(xyz)){
                xyz.MovieInfo();
                xyz.getScreenTime();
            }
            else{
                System.out.println("No such movie exists");
            }     
            }catch(IOException d){System.out.println(d.getMessage());}            
            break;

        case 3:         
            System.out.println("Enter name of movie:");
            Scanner sc2 = new Scanner(System.in);
            String movieTitles = sc2.nextLine();  
            try{
            Movies xyz = new Movies();
            ArrayList filmlist = MovieRecord.readMovies("MoviesCatalogue.txt");
            for (int i = 0 ; i < filmlist.size() ; i++) {
                xyz = (Movies)filmlist.get(i);
                if(xyz.MovieTitle.equalsIgnoreCase(movieTitles)){
                    break;
                }
                else{xyz=null;}
            }
            if(!Objects.isNull(xyz)){
                Booking layout = new Booking();
                layout.showSeats();
            }
            else{
                System.out.println("No such movie exists");
            }     
            }catch(IOException d){System.out.println(d.getMessage());}           
            break;

        case 5:
              System.out.println("You've chosen to make a booking.");
              System.out.println();
              BookingUI.BookingMain();    
              System.out.println("Details will be sent to "+customer.getemailAddress());
              System.out.println();   
              break;

        case 4:
            Scanner sc3 = new Scanner(System.in);
            Scanner sc4 = new Scanner(System.in);
            System.out.println("Enter the movie name and the rating you want to give");
            String name = sc3.nextLine();
            float hyouka = sc4.nextFloat();

            try{
            Movies xyz = new Movies();
            ArrayList filmlist = MovieRecord.readMovies("MoviesCatalogue.txt");
            for (int i = 0 ; i < filmlist.size() ; i++) {
                xyz = (Movies)filmlist.get(i);
                if(xyz.MovieTitle.equalsIgnoreCase(name)){
                    break;
                }
                else{xyz=null;}
            }
            if(!Objects.isNull(xyz)){
                xyz.setRating(hyouka);
                xyz.MovieInfo();
            }
            else{
                System.out.println("No such movie exists");
            }     
            }catch(IOException d){System.out.println(d.getMessage());}
            break;

        case 6:
            try{
            ArrayList<String> gunio = BookingRecord.readBooking("Screening.txt");
            for(String record:gunio){
              System.out.println(record);
            }
            }catch(IOException p){System.out.println(p.getMessage());}
            break;

        case 7:
            try{
            ArrayList<Movies> eigalist = MovieRecord.readMovies("MoviesCatalogue.txt");
            System.out.println("Here the movies by rating");
            Sorting.insertionSort(eigalist);
            for(Movies s:eigalist){
              System.out.println(s.MovieTitle);
            }
            }catch(IOException b){System.out.println(b.getMessage());}
            break;

        case 8:
            System.out.println("See you again.");
            break;

        default:
            System.out.println("Please input a valid option.");
            break;
    }     
    }while (choice != 8);
    sc.close();
    }
} 
