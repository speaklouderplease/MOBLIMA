import java.util.Scanner;
public class LoginUI {
    public static void main(String args[]){
        int a=0;
        String c;
        String b;
        System.out.println("Welcome to Fortran Theatres");
        
        Scanner Aobj = new Scanner(System.in);
        Scanner Cobj = new Scanner(System.in);
        Scanner Bobj = new Scanner(System.in);
        System.out.println("Are you a staff or customer?");
        System.out.println("1. staff");
        System.out.println("2. customer");

        do{
        System.out.println("Please login");
        a = Aobj.nextInt();
        switch(a){
            case 1: //For staff
                CinemaStaff tempstaff = new CinemaStaff("Tom","Hanks");
                System.out.println("username: ");
                b = Bobj.nextLine();
                System.out.println("password: ");
                c = Cobj.nextLine();              
                if(!tempstaff.getUsername().equals(b) || !tempstaff.getPw().equals(c)){
                    System.out.println("Give valid username and password");
                }
                else{
                    System.out.println();
                    System.out.println("please continue!");
                    StaffUI.StaffMain();
                }
                break;
            case 2: //For customer
                System.out.println("hi there");
             }
            }while(a<0&&a>2);
            Aobj.close();
            Cobj.close();
            Bobj.close();
    }
}
