package Model;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
	
	private int id;
	private String name;
	private String gender;
	private int age;
	private List<Rating> ratings;
	
	public User() {
		
	}
	
	public User(int id, String name, String gender, int age) {
		
		  this.id = id;
		  this.name = name;
		  this.gender = gender;
		  this.age = age;
		  ratings = new ArrayList();
		
	}
	
	public void addRating(Rating rating) {
		ratings.add(rating);
	}

	
	public User(int id, String name, String gender, int age, List<Rating> ratings) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.ratings = ratings;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setRating(List<Rating> ratings) {
		this.ratings = ratings;
	}
	
	public List<Rating> getRating() {
		return ratings;
		
	}
	

	
	public int hashCode() {
		return Objects.hash(id);
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id;
	}
	
	public String toString() {
		return "[ id = " + id + ", name = " + name + ", gender = " + gender + ", age = " + age + ", rating = " + ratings + "]\n";
	
	}

}
