import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Data.LoadData;
import Data.LoadMovies;
import Data.LoadRatings;
import Model.Movies;
import Model.Rating;
import Service.MovieOperations;
import Service.RatingsOperations;
import Service.UserOperations;
import ServiceImpl.MovieOperationsImpl;
import ServiceImpl.RatingsOperationsImpl;
import ServiceImpl.UserOperationsImpl;
public class Application {
	
	public static void main(String[] args) {
		

		UserOperations userop = new UserOperationsImpl();
		MovieOperations moviesop = new MovieOperationsImpl();
		RatingsOperations ratingsop = new RatingsOperationsImpl();
		
		LoadMovies.loadMovies(moviesop);
		LoadData.loadUsersData(userop);
		LoadRatings.loadRatings(userop, moviesop, ratingsop);
		
		//System.out.println(moviesop.getAllMovies());
		//System.out.println(userop.getAllUsers());
		ApplicationOperations appOps = new ApplicationOperations(userop, moviesop, ratingsop);
		Scanner sc = new Scanner(System.in);
		 //appOps.printUserWithMostRatings();
	     //appOps.printRatingCountPerUser();
		 //appOps.printMoviesRatedByUser();
		 //appOps.printAverageRatingOfEachMovie();
		 //appOps.printTotalNumberOfRatings();
		 // appOps.printMoviesWithNoRatings();
         //appOps.printUsersWithNoRatings();
         //appOps.printMostRatedMovie();
		int choice;
		do {
			 System.out.println("-----Movie Review System-----");
			 System.out.println("1.Print User with most ratings");
			 System.out.println("2.Print raing count per user");
			 System.out.println("3.Print movies rated by user");
			 System.out.println("4.Print average rating of each movie");
			 System.out.println("5.Print total number of ratings");
			 System.out.println("6.Print movies with no ratings");
			 System.out.println("7.Print users with no ratings");
			 System.out.println("8.Print most rated movie");
			 System.out.println("9.Exit");
			 
			 System.out.println("Enter your choice");
			 choice = sc.nextInt();
			 
			 if(choice == 1) {
				 appOps.printUserWithMostRatings();
			 }else if(choice ==2 ) {
				 appOps.printRatingCountPerUser();
			 }else if(choice == 3) {
				 appOps.printMoviesRatedByUser();
			 }else if(choice == 4) {
				 appOps.printAverageRatingOfEachMovie();
			 }else if(choice == 5) {
				 appOps.printTotalNumberOfRatings();
			 }else if(choice == 6) {
				 appOps.printMoviesWithNoRatings();
			 }else if(choice == 7) {
				 appOps.printUsersWithNoRatings();
			 }else if(choice == 8) {
				 appOps.printMostRatedMovie();
			 }else if(choice == 9) {
			    System.out.println(moviesop.getAllMovies());
			    System.out.println("Please enter movie id from above list to get all ratings of the movie\n");
			    int movieId = sc.nextInt();
			    System.out.println(appOps.getAllRatingsOfMovie(movieId));
			 } 
		
		}while(choice != 10);
		
		
			
			
		
	}
}	
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
         
	


