package Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Model.User;
import Service.MovieOperations;
import ServiceImpl.MovieOperationsImpl;
import Model.Cast;
import Model.Crew;
import Model.Movies;


public class LoadMovies {
	
	
	
	public static void loadMovies(MovieOperations moviesop) {
		
		
		BufferedReader reader;

		  try {
		   reader = new BufferedReader(new FileReader("C:\\Users\\Prasanna Reddy\\Downloads\\movielist.csv"));
		   String line = reader.readLine();

		   while (line != null) {
		   
		    String[] movieData = line.split(",");
		    moviesop.addMovie(new Movies(Integer.parseInt(movieData[0]), movieData[1], movieData[2]));	
		    
		    
		    line = reader.readLine();
		   }

		   reader.close();
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		  
		  try {
			   reader = new BufferedReader(new FileReader("C:\\Users\\Prasanna Reddy\\Downloads\\movie_crew.csv"));
			   String line = reader.readLine();

			   while (line != null) {
			    
			    String[] crewData = line.split(",");
			    moviesop.getMoviebyId(Integer.parseInt(crewData[0])).addCrew(new Crew(Integer.parseInt(crewData[0]), crewData[1], crewData[2]));		    
			    line = reader.readLine();
			   }

			   reader.close();
			  } catch (IOException e) {
			   e.printStackTrace();
			  }
		  
		  try {
			   reader = new BufferedReader(new FileReader("C:\\Users\\Prasanna Reddy\\Downloads\\movie_cast.csv"));
			   String line = reader.readLine();

			   while (line != null) {
			    
			    String[] castData = line.split(",");
			    moviesop.getMoviebyId(Integer.parseInt(castData[0])).addCast(new Cast(Integer.parseInt(castData[0]), castData[1], castData[2], castData[3]));
			    
			    line = reader.readLine();
			   }

			   reader.close();
			  } catch (IOException e) {
			   e.printStackTrace();
			  }
		
	}
}




