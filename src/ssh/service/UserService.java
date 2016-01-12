package ssh.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ssh.dao.UserDao;
import ssh.model.User;


@Service
public class UserService {
	@Resource
	private UserDao userDao = new UserDao();
	public List<User> queryAllUser(){
		return userDao.queryAllUser();
		
	}
	public void add(User user){
		userDao.add(user);
	}
}
