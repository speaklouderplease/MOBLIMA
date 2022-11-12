import java.util.Scanner;
  
  
public class MovieGoerUI{
  public static void MovieGoerMain(){
    Scanner sc = new Scanner(System.in);
    int choice;
    System.out.println("Welcome to Moblima");
    do{
    System.out.println("1.Search/List Movies");
    System.out.println("2.View Movie details");
    System.out.println("3.Check Seat availability");
    System.out.println("4.Book and purchase ticket");
    System.out.println("5.View booking history");
    System.out.println("6.List top 5 movies");
    System.out.println("7.Exit");                   
    choice = sc.nextInt();
      switch(choice){
        case 1:
          
        case 2:
          System.out.println("Enter name of movie:");
          String movieTitle = sc.nextLine();
          
        case 3:
          
        case 4:
          
        case 5:
          
        case 6:
          
        case 7:
          System.out.println("See you again.");
            
          
          }while (choice != 7)
