# MOBLIMA
SC2002 Object-Oriented Programming & Design

MOBLIMA is an application to computerize the processes of making online booking and
purchase of movie tickets, listing of movies and sale reporting. It will be used by the movie-
goers and cinema staff.
### Functional Requirements:
##### Admin:
- Login
- Create/Update/Remove movies
- Create/Update/Remove cinema showtimes and the movies to be shown
- Configure system settings
##### Movie-Goer
- Search/List movie
- View movie details – including reviews and ratings
- Check seat availability and selection of seat/s.
- Book and purchase ticket
- View booking history
- List the Top 5 ranking by ticket sales OR by overall reviewers’ ratings

##### Special scenarios
- configuring a holiday date and the ticket price is shown correctly when
booking is done on that date
- booking on a different day of the week or holiday and type of cinema (eg
suite to demonstrate the differences in prices
- configuring “End of Showing” date and the movie should not be listed for
booking
- booking only allowed for “Preview” and “Now Showing” status.

### Data Persistence
- In-built text parser helper functions reads from and writes to a text file that stores the relevant information about the movie.
These are contained within the MovieRecord class. No external database nor JSON/XML used.
- Simpler to write but difficult to extend movie attributes.
<details>
<summary> Snippet of function to parse from text file and creating the movie object </summary>
```java
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
```
</details>

[Google Docs Report]
(https://docs.google.com/document/d/1mFtcWWyKjnIt-P3WChLilIud6iN8iO1GSYjNRmzgCBA/edit?usp=sharing)
