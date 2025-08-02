package Service;

import Model.Movies;
import Model.Rating;
import Model.User;
import java.util.List;

public interface RatingsOperations {
	
	public boolean addRatings(Rating rating);
	public List<Rating> getRatingbyUser(User user);
	public List<Rating> getRatingsForMovie(Movies movie);
	public double getAverageRating (Movies movie);
	public Rating getRatingByUserAndMovie(User user, Movies movie);
	public List<Rating> getAllRatings();
	
	
	

}
