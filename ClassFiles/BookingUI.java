import java.io.IOException;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import enums.AgeGroup;
import enums.CinemaType;
import enums.Days;


public class BookingUI {
	private ArrayList<Integer> ScreenTimes;
	static final int arrange = 6;
	public String[][] seats;
    
	BookingUI(){
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


	public static void BookingMain() {
		AgeGroup age;
		CinemaType type;
		Days theDay = Days.MONDAY;
		Booking screening1 = new Booking();	
		
		int choice,watchtime,row,column=0;
		String screening = "Screening.txt";
		String buff;
		double price;
		try{
		ArrayList<String> bookRecord = BookingRecord.readBooking(screening);
		Date current = new Date();
		boolean datedone = false;
		boolean seatok = false;
		SimpleDateFormat quickformat = new SimpleDateFormat("EEEE, MMMM d, yyyy");
		Calendar callater = Calendar.getInstance();
		Calendar pickedcal = (Calendar)callater.clone();
		System.out.println("Here the avaliable dates for booking");
		for(int i=1;i<7;i++){		
			callater.add(Calendar.HOUR,24);
			System.out.println(i + ". " + quickformat.format(callater.getTime()));
			screening1.ScreenTimes = (ArrayList<Integer>)serializer.readSerializedObject("timings.dat");
        	for(int t:screening1.ScreenTimes){
            	System.out.print(t+":00"+" /");
        }
			System.out.println();
			
		}
		Scanner picker = new Scanner(System.in);
		Scanner watchobj = new Scanner(System.in);
		Scanner rowobj = new Scanner(System.in);
		Scanner colobj = new Scanner(System.in);
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
		System.out.println("Select a time based on the list of screentimes");		
		datedone =false;
		do{
		System.out.println("System will proceed only upon entry of valid screentime");
		watchtime = watchobj.nextInt();
		for(int o:screening1.ScreenTimes){
			if(watchtime==o){
				System.out.println(watchtime+":00" +" was selected");
				datedone = true;
				break;
			}
		}
		}while(!datedone);
		pickedcal.set(Calendar.HOUR_OF_DAY,watchtime);
		pickedcal.set(Calendar.MINUTE,0);
		pickedcal.set(Calendar.SECOND,0);
		
	 	System.out.println("Your booking is on " + pickedcal.getTime());
	 	System.out.println("The booking was made on " + current.toString());
	 	if(pickedcal.get(Calendar.DAY_OF_WEEK)==1 || pickedcal.get(Calendar.DAY_OF_WEEK)==7 || pickedcal.get(Calendar.DAY_OF_WEEK)==6){
 			theDay=Days.SATURDAY;
	 	}
		System.out.println("Is the ticket for child or a senior? Verification will be done in-person. Y=1;N=0");
		choice = picker.nextInt();
		if(choice==1){age=AgeGroup.CHILD;}
		else{age=AgeGroup.ADULT;}
		System.out.println("regular cinema or platinum? 1 for regular,0 for platinum");
		choice=picker.nextInt();
		if(choice==1){type=CinemaType.REGULAR;}
		else{type=CinemaType.PLATINUM;}
		System.out.println("Please choose a seat. Input the row and then column of the seat you want");
		screening1.showSeats();	
		do{
		row=rowobj.nextInt();
		column=colobj.nextInt();	
		if(screening1.checkSeatTaken(row-1,column-1)==0){
			screening1.bookSeat(row-1,column-1);
			seatok = true;
		}
		else{
			System.out.println("seat is taken, please choose another seat");
		}
		}while(!seatok);
		price = Pricing.getPrice(theDay,age,type);
		System.out.println("Total price is "+price);
	 	buff = pickedcal.getTime().toString();
	 	buff = buff.replaceAll("\\s","")+price;
	 	bookRecord.add(buff);
	 	BookingRecord.saveBooking(screening,bookRecord);
		
	 	picker.close();
		watchobj.close();
		rowobj.close();
		colobj.close();
	 	}catch(IOException e){
	 	System.out.println(e.getMessage());
	 	}
	}
}