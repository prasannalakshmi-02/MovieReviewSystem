package ServiceImpl;
import java.util.ArrayList;
import java.util.List;

import Model.Movies;
import Model.Rating;
import Model.User;
import Service.RatingsOperations;

public class RatingsOperationsImpl implements RatingsOperations {
	
	private ArrayList<Rating> ratings=new ArrayList<>();
	
	public RatingsOperationsImpl() {
		this.ratings=new ArrayList<>();
	}

	@Override
	public boolean addRatings(Rating rating) {
		
		for(Rating r:ratings) {
			if(r.equals(rating)) {
				return false;
			}
			
		}
		
		ratings.add(rating);
		return true;
	}

	@Override
	public List<Rating> getRatingbyUser(User user) {
		 List<Rating> userRatings = new ArrayList<>();
	        for (Rating r : ratings) {
	            if (r.getUserId().getId() == user.getId()) {
	                userRatings.add(r);
	            }
	        }
	        return userRatings;
	}
	

	@Override
	public List<Rating> getRatingsForMovie(Movies movie) {
		List<Rating> movieRatings = new ArrayList<>();
        for (Rating r : ratings) {
            if (r.getMovieId().getId() == movie.getId()) {
                movieRatings.add(r);
            }
        }
        return movieRatings;
	}

	@Override
	public double getAverageRating(Movies movie) {
		  List<Rating> movieRatings = getRatingsForMovie(movie);
        if (movieRatings.isEmpty()) return 0.0;

        int total = 0;
        for (Rating r : movieRatings) {
            total += r.getRating();
        }
        return (double) total / movieRatings.size();
	
	
	}

	@Override
	public Rating getRatingByUserAndMovie(User user, Movies movie) {
		
		for (Rating r : ratings) {
            if (r.getUserId().getId() == user.getId() && r.getMovieId().getId() == movie.getId()) {
                return r;
            }
        }
        return null;
	}

	@Override
	public List<Rating> getAllRatings() {
		  return new ArrayList<>(ratings);
	
	}
	
	

	
	
	
	
	

}
