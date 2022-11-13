import java.util.ArrayList;
import java.util.Collections;
public class Sorting implements Comparable<Sorting>{

    public static void insertionSort (Comparable<Sorting>[] list)
	{
		for (int index = 1; index < list.length; index++)
		{
			Comparable key = list[index];
			int position = index;
			// Shift larger values to the right
			while (position > 0 && key.compareTo(list[position-1]) < 0)
			{
				list[position] = list[position-1];
				position--;
			}
				list[position] = key;
		}
	}
/**
 * 
 * @param list
 * @see Movies.java
 * Does insertion sort algorithm on a ArrayList of movies. This implements the compareTo method and the details are in Movies.java
 */
    public static void insertionSort (ArrayList<Movies> list)
	{
		for (int index = 1; index < list.size(); index++)
		{
			Movies key = list.get(index);
			int position = index;
			// Shift smaller values to the right
			while (position > 0 && key.compareTo(list.get(position-1)) > 0)
			{
				Collections.swap(list,position,position-1);
				position--;
			}
				list.set(position,key);
		}
	}

    @Override
	public int compareTo(Sorting list){
			if(this.compareTo(list) != 0){
				return this.compareTo(list);
		}
		else{
			return 0;
		}
	}
}
