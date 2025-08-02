package ServiceImpl;

import java.util.ArrayList;

import Model.Movies;
import Service.MovieOperations;

public class MovieOperationsImpl implements MovieOperations{
	
	private ArrayList<Movies> movies = new ArrayList<>();

	@Override
	public boolean addMovie(Movies movie) {
		for(Movies m:movies) {
			if(m.getId()==movie.getId()) {
				return false;
			}
		}
		movies.add(movie);
		return true;
		
	}

	@Override
	public Movies getMoviebyId(int id) {
		for(Movies m:movies) {
			if(m.getId()==id) {
				return m;
			}
		}
		return null;
	}

	@Override
	public ArrayList<Movies> getAllMovies() {
		
		return movies;
	}

	@Override
	public boolean deleteMovie(int id) {
		Movies temp=null;
		boolean flag=false;
		for(Movies m:movies) {
			if(m.getId()==id) {
				temp=m;
				flag=true;
			}
		}
		if(flag) {
			movies.remove(temp);
			return true;
		}
		return false;
		
   }
	
	
	

}
