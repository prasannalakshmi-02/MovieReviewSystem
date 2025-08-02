package Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Model.Movies;
import Model.Rating;
import Model.User;
import Service.MovieOperations;
import Service.RatingsOperations;
import Service.UserOperations;

public class LoadRatings {
	
	
	public static void loadRatings(UserOperations userop, MovieOperations movieop, RatingsOperations ratingsop) {
		
		BufferedReader reader;
		{

		  try {
		   reader = new BufferedReader(new FileReader("C:\\Users\\Prasanna Reddy\\Downloads\\user_ratings.csv"));
		   String line = reader.readLine();

		   while (line != null) {
		    
		    String[] userData = line.split(",");
		    User user = userop.getUserbyId(Integer.parseInt(userData[0]));
		    Movies movie = movieop.getMoviebyId(Integer.parseInt(userData[1]));
		    Rating r = new Rating(user, movie, Integer.parseInt(userData[2]));
		    ratingsop.addRatings(r);
		    user.addRating(r);
		    line = reader.readLine();
		   }

		   reader.close();
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
	   }
		
	}
}
