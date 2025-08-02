package Data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import Model.Movies;
import Model.User;
import Service.UserOperations;
import ServiceImpl.UserOperationsImpl;

public class LoadData {
	
	public static void loadUsersData(UserOperations userop) {
		
		BufferedReader reader;

		  try {
		   reader = new BufferedReader(new FileReader("C:\\Users\\Prasanna Reddy\\Downloads\\users.csv"));
		   String line = reader.readLine();

		   while (line != null) {
		   
		    String[] userData = line.split(",");
		    userop.addUser(new User(Integer.parseInt(userData[0]), userData[1], userData[2], Integer.parseInt(userData[3])));		    
		    line = reader.readLine();
		   }

		   reader.close();
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
	}
}



