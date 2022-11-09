import java.util.Calendar;
import java.text.SimpleDateFormat;

public class MovieScreening {
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
	 * Prints the seats
	 */
	static void showSeats(){
		System.out.print("  ");
		for (int i = 1; i <= 6; i++) {
			System.out.print(i + " ");
		}
		System.out.println();

		for(int i=1;i<7;i++){
				System.out.print(i + " ");
			for(int j=0;j<6;j++){
				System.out.print("[]");
			}
			System.out.println();
		}
		System.out.println();
	}
}
