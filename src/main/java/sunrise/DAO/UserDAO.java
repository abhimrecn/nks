package sunrise.DAO;

import sunrise.beans.User;

public interface UserDAO {
	public User find(String username,String password);
	public int CheckExistance(String username,String password);
}
