package Service;
import java.util.ArrayList;
import Model.Movies;

public interface MovieOperations {
	
	public boolean addMovie(Movies movie);
	public Movies getMoviebyId(int id);
	public ArrayList<Movies> getAllMovies();
	public boolean deleteMovie(int id);
	

}
