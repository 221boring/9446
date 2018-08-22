package ju.minhark.ums.service;

import java.util.List;

import ju.minhark.ums.domain.User;

public interface UserService {
	
	void writeUsers(User user);
	void editUser(int userNum,  String userName);
	void delUser(int userNum);
	
	List<User> listUsers();
}