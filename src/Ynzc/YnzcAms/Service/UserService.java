package Ynzc.YnzcAms.Service;

import java.util.List;

import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Model.UserViewData;

public interface UserService {
	//UserService
	public User getUserByUsername(String username);
	public List<User> getAllUser(Page page,String conditions);
	public User findUserById(int id);
	public boolean addUser(User user);
	public boolean delUser(User user);
	public boolean updateUser(User user);
	public List<User> getAllUserList();
	public List<UserViewData> getAllUserView(Page page,String conditions,int unitid);
	public UserViewData getUserViewById(int userId);
	
}
