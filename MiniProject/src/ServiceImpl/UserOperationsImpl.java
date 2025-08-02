package ServiceImpl;
import java.util.ArrayList;
import Model.User;
import Service.UserOperations;

public class UserOperationsImpl implements UserOperations {

	private ArrayList<User> users = new ArrayList<>();
	
	@Override
	public boolean addUser(User user) {

		for(User u : users) {
			if(u.getId() == user.getId()) {
				return false;
			}
		}
		users.add(user);
		return true;
		
	}
	

	@Override
	public User getUserbyId(int id) {
		
		for(User u : users) {
			if(u.getId() == id) {
				return u;
			}
		}	
			
		return null;
	}
	
	
	public ArrayList<User> getAllUsers(){
		return users;
	}	
	
	public boolean deletebyId(int id) {
		User temp = null;
		boolean flag = false;
		for(User u : users) {
			if(u.getId() == id) {
				temp = u;
				flag = true;
			}
		}
		
		if(flag) {
			users.remove(temp);
			return true;
		}
		
		return false;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
