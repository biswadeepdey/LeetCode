package code.exercise;
import java.util.*;

public class InFlightMovieClass {
	public static int[] InFlightMovie(int duration, int[] movieLengths)
	{
		int lastHigh = Integer.MAX_VALUE;
		int[] lastCombo = new int[2];
		
		for(int i = 0; i < movieLengths.length - 1; i++)
		{
			for(int j = i + 1; j < movieLengths.length; j++)
			{
				// we have a valid pair
				if(movieLengths[i] + movieLengths[j] <= duration)
				{
					int currDiff = duration - (movieLengths[i] + movieLengths[j]);
 
					if(currDiff < lastHigh)
					{
						lastHigh = currDiff;
						lastCombo[0] = movieLengths[i];
						lastCombo[1] = movieLengths[j];
					}
					//check the last constraint of pair with longest movie
					else if(currDiff == lastHigh)
					{
						if(Integer.max(movieLengths[i], movieLengths[j]) > Integer.max(lastCombo[0], lastCombo[1]))
						{
							lastCombo[0] = movieLengths[i];
							lastCombo[1] = movieLengths[j];
						}
					}
				}
			}
		}
		
		return lastCombo;
	}
}
