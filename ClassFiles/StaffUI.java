import java.util.Scanner;
import enums.MovieStatus;
public class StaffUI {
    public static void main(String args[]){
        int choice =0;
        CinemaStaff staffone = new CinemaStaff("Tom","Hanks");
        Scanner picker = new Scanner(System.in);
        do{
        System.out.println("Welcome " + staffone.getFirstName());
        System.out.println("What will be the agenda for today?");
        System.out.println("1. add a new film");
        System.out.println("2. remove a film from listing");
        System.out.println("3. add a new screening");
        System.out.println("4. remove a screening");
        System.out.println("5. change the status of a film");
        System.out.println("6. change the synopsis of a film");
        System.out.println("7. logout");		
		choice = picker.nextInt();
		switch(choice){
			case 1:
                Scanner a1 = new Scanner(System.in);
                Scanner b1 = new Scanner(System.in);
                Scanner c1 = new Scanner(System.in);
                Scanner d1 = new Scanner(System.in);
                Scanner s = new Scanner(System.in);
                String a,b,c,d;
                int S;
				System.out.println("Enter the following");
                System.out.println("title, director, cast, synopsis");
                a = a1.nextLine();
                b = b1.nextLine();
                c = c1.nextLine();
                d = d1.nextLine();
                System.out.println("what is the status?");
                System.out.println("1.preview. 2.coming soon 3.now showing");
                S = s.nextInt();
                switch(S){
                    case 1:
                        staffone.addMovie(a,b,c,0f,d,MovieStatus.PREVIEW);
                        break;
                    case 2:
                        staffone.addMovie(a,b,c,0f,d,MovieStatus.COMINGSOON);
                        break;
                    case 3:
                        staffone.addMovie(a,b,c,0f,d,MovieStatus.NOWSHOWING);
                        break;
                }
                System.out.println("Movie added!");
				break;
			case 2:
                String g1;
                Scanner g= new Scanner(System.in);
                System.out.println("current list");
                staffone.viewMovies();
                System.out.println("Which movie to remove? Please enter the title");
                g1 = g.nextLine();
                staffone.removeMovie(g1);
				break;
			case 3:
                String mov;
                Scanner movobj = new Scanner(System.in);
				int q1;
                Scanner q = new Scanner(System.in);
                System.out.println("Give the movie name and then the time to add (in 24HR time)");
                mov = movobj.nextLine();
                q1 = q.nextInt();
                staffone.updateScreenings(mov, q1);
                System.out.println("new details");
                staffone.checkMovie(mov);
				break;
			case 4:
                String MOV;
                Scanner MOVobj = new Scanner(System.in);
                int Q1;
                Scanner Q = new Scanner(System.in);
                System.out.println("Give the movie name");
                MOV = MOVobj.nextLine();
                staffone.checkMovie(MOV);
                System.out.println("The timing to remove: ");
                Q1 = Q.nextInt();
                staffone.updateScreenings(MOV, Q1);
                System.out.println("new details");
                staffone.checkMovie(MOV);
				break;
			case 5:
                String eiga;
                int v=0;
                Scanner vobj = new Scanner(System.in);
                Scanner eigaobj = new Scanner(System.in);
                System.out.println("Give the movie name");
                eiga = eigaobj.nextLine();
                System.out.println("what is the status?");
                System.out.println("1.preview. 2.coming soon 3.now showing");
                v = vobj.nextInt();
                switch(v){
                    case 1:
                        staffone.updateStatus(eiga, MovieStatus.PREVIEW);;
                        break;
                    case 2:
                        staffone.updateStatus(eiga,MovieStatus.COMINGSOON);
                        break;
                    case 3:
                        staffone.updateStatus(eiga,MovieStatus.NOWSHOWING);
                        break;
                }
                staffone.checkMovie(eiga);
				break;
			case 6:
				String summary,dianying;
                Scanner sum = new Scanner(System.in);
                Scanner dian = new Scanner(System.in);
                System.out.println("Give the movie name");
                dianying = dian.nextLine();
                System.out.println("Give the synopsis");
                summary = sum.nextLine();
                staffone.updateSynopsis(dianying,summary);
                staffone.checkMovie(dianying);
				break;
            case 7:
                System.out.println("See you again");
                break;
			default:
				System.out.println("Please choose a valid task from the list");
				break;
		}
		}while(choice!=7);
    }
}
