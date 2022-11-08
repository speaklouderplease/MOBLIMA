//import java.io.IOException;
//import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
/**
 * @version 1.0
 * @author Justin
 * Display the screentimes.
 */
public class Screening {
    static void showScreenings(){
        SimpleDateFormat quickformat = new SimpleDateFormat("EEEE, MMMM d, yyyy");
        Calendar showtimes = Calendar.getInstance();
        System.out.println("Here the current screening dates");
		for(int i=1;i<7;i++){			
			System.out.println(i + ". " + quickformat.format(showtimes.getTime()));
            System.out.println("Showtimes: 10am, 1pm, 3pm, 5pm, 7pm, 9pm, 11pm");
            System.out.println();
			showtimes.add(Calendar.HOUR,24);
		}
    }
}
