package nks.DAO;

import nks.beans.User;

public interface UserDAO {
	public User find(String username,String password);
	public int CheckExistance(String username,String password);
}
