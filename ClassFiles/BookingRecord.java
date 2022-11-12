import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BookingRecord {
    public static final String SEPARATOR = " | ";

    public static ArrayList readBooking(String filename) throws IOException {
		// read String from text file
		ArrayList stringArray = (ArrayList)read(filename);
		ArrayList booking = new ArrayList<String>() ;// to store booking data

        for (int i = 0 ; i < stringArray.size() ; i++) {
				String st = (String)stringArray.get(i);
				// get individual 'fields' of the string separated by SEPARATOR
				StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","
				String bookinfo = star.nextToken().trim();	// first token	
                			
				// add to booking list
				booking.add(bookinfo) ;
			}
			return booking ;
	}

    public static void saveBooking(String filename, List booklist) throws IOException {
		List<String> alw = new ArrayList<String>() ;// to store booking data

        for (int i = 0 ; i < booklist.size() ; i++) {
				String booking = (String)booklist.get(i);
				StringBuilder st =  new StringBuilder() ;
				st.append(booking);
				alw.add(st.toString()) ;
			}
			write(filename,alw);
	}

    /** Write fixed content to the given file. */
  public static void write(String fileName, List<String> data) throws IOException  {
    PrintWriter out = new PrintWriter(new FileWriter(fileName));

    try {
		for (int i =0; i < data.size() ; i++) {
      		out.println((String)data.get(i));
		}
    }
    finally {
      out.close();
    }
  }

  /** Read the contents of the given file. */
  public static List read(String fileName) throws IOException {
	List<String> data = new ArrayList<String>() ;
    Scanner scanner = new Scanner(new FileInputStream(fileName));
    try {
      while (scanner.hasNextLine()){
        data.add(scanner.nextLine());
      }
    }
    finally{
      scanner.close();
    }
    return data;
  }

}


