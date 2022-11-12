import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class Booking {
    public ArrayList<Integer> ScreenTimes;
	static final int arrange = 6;
	public String[][] seats;

    /**
     * Constructor for a instance of a booking; generates a cinema setting with seats
     */
	Booking(){
		seats = new String[arrange][arrange];
		int[] other = {4,3,4,5,1,0};
		for(int a=0;a<arrange;a++){
			for(int b=0;b<arrange;b++){
				seats[a][b] = "[0]";
			}
		}
		for(int i=0;i<arrange;i++){
			for(int j=0;j<arrange;j++){
				if(i==other[j])
					seats[i][j]="[X]";
			}
		}
	}

	/**
	 * 
	 * @param myFilm
	 * prints the screenings
	 */
	static void showTimings(Movies myFilm){
		myFilm.getScreenTime();
	}

	/**
	 * shows the avaliable dates.
	 */
	static void showScreendates(){
		SimpleDateFormat quickformat = new SimpleDateFormat("EEEE, MMMM d, yyyy");
		Calendar callater = Calendar.getInstance();
		System.out.println("Here the avaliable dates for booking");
		for(int i=1;i<7;i++){			
			System.out.println(i + ". " + quickformat.format(callater.getTime()));
			System.out.println();
			callater.add(Calendar.HOUR,24);
		}
	}

	
	/**
	 * Prints the seats which are represented by a 2d string array
	 */
	public void showSeats(){
		System.out.println("Avaliable seats, shown by '0' ");
		System.out.print("  ");
		for (int i = 1; i <= arrange; i++) {
			System.out.print(i + "  ");
		}
		System.out.println();
		for(int i=0;i<arrange;i++){
			for(int j=0;j<arrange;j++){
				System.out.print(seats[i][j]);
			}
		System.out.println();
		}
		System.out.println();
	}

	
	/** 
	 * @param row
	 * @param column
	 * Makes the booking and shows the new booking
	 */
	public void bookSeat(int row,int column){
		seats[row][column]="[B]";
		System.out.println("Booking made");
		showSeats();
	}

	public void book2Seat(int row1,int col1,int row2,int col2){
		seats[row1][col1]="[B]";
		seats[row2][col2]="[B]";
		showSeats();
	}
	
	public int checkSeatTaken(int row,int column){
		if(seats[row][column].equals("[X]")){return 1;}
		return 0;
	}
}
