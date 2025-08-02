import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Model.Movies;
import Model.Rating;
import Model.User;
import Service.MovieOperations;
import Service.RatingsOperations;
import Service.UserOperations;

public class ApplicationOperations {

	private UserOperations userop;
	private MovieOperations moviesop;
	private RatingsOperations ratingsop;

	public ApplicationOperations() {
	}

	public ApplicationOperations(UserOperations userOp, MovieOperations movieOp, RatingsOperations ratingsOp) {
		this.userop = userOp;
		this.moviesop = movieOp;
		this.ratingsop = ratingsOp;
	}

	public void printRatingCountPerUser() {

		List<User> users = userop.getAllUsers();

		System.out.println("Rating count per user:");
		userop.getAllUsers().stream()
				.forEach(user -> System.out.println(user.getName() + " gave " + user.getRating().size() + " ratings"));

	}

	public void printUserWithMostRatings() {
		List<User> users = userop.getAllUsers();

		int max = users.stream().map(user -> user.getRating().size()).max(Integer::compareTo).orElse(0);

		for (User user : users) {
			if (user.getRating().size() == max) {
				System.out.println("User with most ratings: " + user.getName() + " (" + max + " ratings)");
			}
		}
	}

	public void printMoviesRatedByUser() {

		List<User> users = userop.getAllUsers();
		List<Rating> ratings = ratingsop.getAllRatings();
		List<Movies> movies = moviesop.getAllMovies();

		for (User u : users) {

			System.out.println("Movies rated by" + u.getName() + ":");
			boolean rated = false;

			for (Rating r : ratings) {
				if (r.getUserId().getId() == u.getId()) {
					rated = true;
					for (Movies m : movies) {
						if (m.getId() == r.getMovieId().getId()) {
							System.out.println("- " + m.getName() + ": " + r.getRating() + " stars");
							break;
						}
					}
				}
			}
			if (!rated) {
				System.out.println("No movies rated");
			}
		}
	}

	public void printAverageRatingOfEachMovie() {
		List<Movies> movies = moviesop.getAllMovies();
		for (Movies movie : movies) {
			double avg = ratingsop.getAverageRating(movie);
			System.out.println(movie.getName() + "- Average Rating " + avg);
		}
	}

	public void printTotalNumberOfRatings() {
		List<Rating> ratings = ratingsop.getAllRatings();

		System.out.println("Total no of ratings are :" + ratings.size());

	}

	public void printMoviesWithNoRatings() {
		List<Movies> movies = moviesop.getAllMovies();
		List<Rating> ratings = ratingsop.getAllRatings();

		Set<Integer> ratedMovies = new HashSet();
		for (Rating r : ratings) {
			ratedMovies.add(r.getMovieId().getId());

		}

		System.out.println("Movies with no ratings :");
		boolean found = false;
		for (Movies m : movies) {
			if (!ratedMovies.contains(m.getId())) {
				System.out.println("-" + m.getName());
				found = true;
			}
		}

		if (!found) {
			System.out.println("All movies have atleast one rating");
		}

	}

	public void printUsersWithNoRatings() {

		List<User> users = userop.getAllUsers();
		List<Rating> ratings = ratingsop.getAllRatings();
		Set<Integer> ratedUsers = new HashSet();

		for (Rating r : ratings) {
			ratedUsers.add(r.getUserId().getId());
		}

		System.out.println("Users with no ratings");
		boolean found = false;
		for (User u : users) {
			if (!ratedUsers.contains(u.getId())) {
				System.out.println("-" + u.getName());
				found = true;
			}
		}

		if (!found) {
			System.out.println("All users have given atleast one rating ");
		}

	}

	public void printMostRatedMovie() {
		List<Movies> movies = moviesop.getAllMovies();
		List<Rating> ratings = ratingsop.getAllRatings();

		Map<Integer, Integer> ratingCount = new HashMap();
		for (Rating r : ratings) {
			int movieId = r.getMovieId().getId();
			if (ratingCount.containsKey(movieId)) {
				int count = ratingCount.get(movieId);
				ratingCount.put(movieId, count + 1);
			} else {
				ratingCount.put(movieId, 1);
			}
		}
		int maxCount = Integer.MIN_VALUE;
		int mostRatedMovieId = -1;
		for (Map.Entry<Integer, Integer> entry : ratingCount.entrySet()) {
			if (entry.getValue() > maxCount) {
				maxCount = entry.getValue();
				mostRatedMovieId = entry.getKey();
			}
		}

		if (mostRatedMovieId != -1) {
			for (Movies m : movies) {
				if (m.getId() == mostRatedMovieId) {
					System.out.println("Most rated movie is " + m.getName() + "->" + maxCount + "ratings");
					return;
				}
			}
		} else {
			System.out.println("No ratings available");
		}

	}

	public List<Rating> getAllRatingsOfMovie(int movieId) {
		
		List<Movies> movies = moviesop.getAllMovies();
		List<Rating> ratings = ratingsop.getAllRatings();
		List<Rating> ratingslist = new ArrayList();
        
		for(Movies m : movies) {
			if(m.getId() == movieId) {
				for(Rating r: ratings) {
					if(r.getMovieId().getId() == movieId) {
						ratingslist.add(r);
					}
					
				}
			}
		}
		return ratingslist;
		
		
	}
		
	}


