package Service;
import java.util.ArrayList;
import Model.User;

public interface UserOperations {
	
	public boolean addUser(User user);
	public User getUserbyId(int id);
	public ArrayList<User> getAllUsers ();
	public boolean deletebyId(int id);

}
