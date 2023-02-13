import java.util.Scanner;
public class LoginUI {
    /**
     * @author Justin Seah
     * @param args
     * The first screen to appear when MOBLIMA is launch is here. From here customer and staff can log in to perform their respective function.
     */
    public static void main(String args[]){
        String a;
        String c;
        String b;
        System.out.println("Welcome to Fortran Theatres");
        
        Scanner Aobj = new Scanner(System.in);
        Scanner Bobj = new Scanner(System.in);
        System.out.println("Are you a staff or customer? Input the letters");
        System.out.println("a. staff");
        System.out.println("b. customer");
        System.out.println("c. Logout");

        do{
        System.out.println("Please login");
        //a=0;
        if(!Aobj.hasNextInt()){
            a = Aobj.nextLine();
        }
        else{a=Aobj.nextLine();}
        switch(a){
            case "a": //For staff
                CinemaStaff tempstaff = new CinemaStaff("Tom","Hanks");
                System.out.println("username: ");
                b = Bobj.nextLine();
                System.out.println("password: ");
                c = Bobj.nextLine();              
                if(!tempstaff.getUsername().equals(b) || !tempstaff.getPw().equals(c)){
                    System.out.println("Give valid username and password");
                }
                else{
                    System.out.println();
                    System.out.println("please continue!");
                    StaffUI.StaffMain();
                }
                break;
            case "b": //For customer
                MovieGoer customer = new MovieGoer("Jack","34","cgui345",34,"62781245","JackTheman@hotmail.com");
                System.out.println("username: ");
                b = Bobj.nextLine();
                System.out.println("password: ");
                c = Bobj.nextLine();
                //System.out.println(customer.getUsername());
                //System.out.println(customer.getPw());
                if(!customer.getUsername().equals(b) || !customer.getPw().equals(c)){
                    System.out.println("Give valid username and password");
                }
                else{
                    System.out.println();
                    System.out.println("please continue!");
                    MovieGoerUI.MovieGoerMain();
                }
                break;
             }
             a="c";
            //Aobj.nextLine();
            }while(a.equals("a")||a.equals("b"));
        System.out.println("Sucessfully logged out, goodbye!");
        Aobj.close();
        Bobj.close();
    }
}
