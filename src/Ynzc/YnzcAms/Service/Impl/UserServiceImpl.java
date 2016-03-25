package Ynzc.YnzcAms.Service.Impl;

import java.util.List;

import Ynzc.YnzcAms.Dao.UserDao;
import Ynzc.YnzcAms.Model.Page;
import Ynzc.YnzcAms.Model.User;
import Ynzc.YnzcAms.Model.UserViewData;
import Ynzc.YnzcAms.Service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}

	public boolean delUser(User user) {
		// TODO Auto-generated method stub
		return userDao.delUser(user);
	}

	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.findUserById(id);
	}

	public List<User> getAllUser(Page page, String conditions) {
		// TODO Auto-generated method stub
		return userDao.getAllUser(page, conditions);
	}

	public List<UserViewData> getAllUserView(Page page, String conditions,
			int unitid) {
		// TODO Auto-generated method stub
		return userDao.getAllUserView(page, conditions, unitid);
	}

	public List<User> getAllUserList() {
		return userDao.getAllUserList();
	}

	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.getUserByUsername(username);
	}

	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}
	
	public UserViewData getUserViewById(int userId){
		return this.userDao.getUserViewById(userId);
	}

}
