import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import enums.MovieStatus;

public class MovieRecord {
  /**
   * 
   * Helper class to store data into .txt format
   */
    public static final String SEPARATOR = "|";

    
    /** 
     * @param filename
     * @return ArrayList
     * @throws IOException
     */
    //reading
	public static ArrayList readMovies(String filename) throws IOException {
		// read String from text file
		ArrayList stringArray = (ArrayList)read(filename);
		ArrayList<Movies> alr = new ArrayList<Movies>() ;// to store Movie data

        for (int i = 0 ; i < stringArray.size() ; i++) {
				String st = (String)stringArray.get(i);
				// get individual 'fields' of the string separated by SEPARATOR
				StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter ","

				String  title = star.nextToken().trim();	
				String  direct = star.nextToken().trim();	
        String cast = star.nextToken().trim();
				float rating = Float.parseFloat(star.nextToken().trim());
        String synopsis = star.nextToken().trim();
				String currentstatusString = star.nextToken().trim();
        MovieStatus currentstatus = MovieStatus.valueOf(currentstatusString);
        Movies film = new Movies(title,direct,cast,rating,synopsis,currentstatus);
				// add to Movies list
				alr.add(film) ;
			}
			return alr ;
	}

  
  /** 
   * @param filename
   * @param al
   * @throws IOException
   */
  // saving
public static void saveMovies(String filename, List al) throws IOException {
		List<String> alw = new ArrayList<String>() ;// to store movies data

        for (int i = 0 ; i < al.size() ; i++) {
				Movies films = (Movies)al.get(i);
				StringBuilder st =  new StringBuilder() ;
				st.append(films.MovieTitle.trim());
				st.append(SEPARATOR);
				st.append(films.Director.trim());
				st.append(SEPARATOR);
				st.append(films.Cast.trim());
        st.append(SEPARATOR);
        st.append(films.rating);
        st.append(SEPARATOR);
        st.append(films.getSynopsis().trim());
        st.append(SEPARATOR);
        st.append(films.currentstatus.toString().trim());
				alw.add(st.toString()) ;
			}
			write(filename,alw);
	}

  /** Write fixed content to the given file. */
  public static void write(String fileName, List data) throws IOException  {
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

