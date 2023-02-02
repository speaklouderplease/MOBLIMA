package TestFiles;

import java.io.IOException;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @param string
 * Allows user to choose the screentime. Generates a string detailing details of the date and time chosen by the movie-goer. Contains additional code to read and write to a .txt 
 * file if necessary. The .txt file must be created before and has to be contained inside the package.
 */
public class Bookingtest {
    
	/** 
	 * @return String
	 */
	static String movieBooking(){
        int choice = 0;
        String buff = "\0";
        //String screening = "record.txt";
		// // try{
		// // ArrayList<String> bookRecord = BookingRecord.readBooking(screening);
		// for(int i=0;i<bookRecord.size();i++){
		// 	String test = bookRecord.get(i);
		// 	System.out.println(test);
		// }
		Date current = new Date();
		boolean datedone = false;
		boolean timedone = false;
		SimpleDateFormat quickformat = new SimpleDateFormat("EEEE, MMMM d, yyyy");
		Calendar callater = Calendar.getInstance();
		Calendar pickedcal = (Calendar)callater.clone();
		System.out.println("Here the avaliable dates for booking");
		for(int i=1;i<7;i++){			
			System.out.println(i + ". " + quickformat.format(callater.getTime()));
			System.out.println("Showtimes: 10am, 1pm, 3pm, 5pm, 7pm, 9pm, 11pm");
			System.out.println();
			callater.add(Calendar.HOUR,24);
		}
		Scanner picker = new Scanner(System.in);
		do{
		System.out.println("Pick a date using 1 to 6");
		choice = picker.nextInt();
		switch(choice){
			case 1:
				pickedcal.add(Calendar.HOUR,24);
				datedone = true;
				break;
			case 2:
				pickedcal.add(Calendar.HOUR,24*2);
				datedone = true;
				break;
			case 3:
				pickedcal.add(Calendar.HOUR,24*3);
				datedone = true;
				break;
			case 4:
				pickedcal.add(Calendar.HOUR,24*4);
				datedone = true;
				break;
			case 5:
				pickedcal.add(Calendar.HOUR,24*5);
				datedone = true;
				break;
			case 6:
				pickedcal.add(Calendar.HOUR,24*6);
				datedone = true;
				break;
			default:
				System.out.println("Please choose a valid date from the list");
				break;
		}
		}while(!datedone);
		System.out.println("Your booking is on " + quickformat.format(pickedcal.getTime()));
		do{
		System.out.println("Showtimes: 10am, 1pm, 3pm, 5pm, 7pm, 9pm, 11pm");
		System.out.println("Pick a preferred time");
		choice = picker.nextInt();		
		switch(choice){
			case 10:
				pickedcal.set(Calendar.HOUR_OF_DAY,11);
				pickedcal.set(Calendar.MINUTE,0);
				pickedcal.set(Calendar.SECOND,0);
				timedone = true;
				break;
			case 1:
				pickedcal.set(Calendar.HOUR_OF_DAY,13);
				pickedcal.set(Calendar.MINUTE,0);
				pickedcal.set(Calendar.SECOND,0);
				timedone = true;
				break;
			case 3:
				pickedcal.set(Calendar.HOUR_OF_DAY,15);
				pickedcal.set(Calendar.MINUTE,0);
				pickedcal.set(Calendar.SECOND,0);
				timedone = true;
				break;
			case 5:
				pickedcal.set(Calendar.HOUR_OF_DAY,17);
				pickedcal.set(Calendar.MINUTE,0);
				pickedcal.set(Calendar.SECOND,0);
				timedone = true;
				break;
			case 7:
				pickedcal.set(Calendar.HOUR_OF_DAY,19);
				pickedcal.set(Calendar.MINUTE,0);
				pickedcal.set(Calendar.SECOND,0);
				timedone = true;
				break;
			case 9:
				pickedcal.set(Calendar.HOUR_OF_DAY,21);
				pickedcal.set(Calendar.MINUTE,0);
				pickedcal.set(Calendar.SECOND,0);
				timedone = true;
				break;
			case 11:
				pickedcal.set(Calendar.HOUR_OF_DAY,23);
				pickedcal.set(Calendar.MINUTE,0);
				pickedcal.set(Calendar.SECOND,0);
				timedone = true;
				break;
			default:
				System.out.println("Give a valid screening time");
				break;
		}
		}while(!timedone);
		System.out.println("Your booking is on " + pickedcal.getTime());
		System.out.println("The booking was made on " + current.toString());
		buff = pickedcal.getTime().toString();
		buff = buff.replaceAll("\\s","");
        picker.close();
		//bookRecord.add(buff);
		//BookingRecord.saveBooking(screening,bookRecord);
		//}catch(IOException e){
		//System.out.println(e.getMessage());
		//}
        return buff;
    }
}
