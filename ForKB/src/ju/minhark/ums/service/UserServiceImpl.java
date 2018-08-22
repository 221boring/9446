package ju.minhark.ums.service;

import java.time.LocalDate;
import java.util.List;
import ju.minhark.ums.dao.UserDao;
import ju.minhark.ums.domain.User;

public class UserServiceImpl implements UserService{
	private UserDao userDao;
	
	public UserServiceImpl(UserDao userDao){
		this.userDao = userDao;
	}
	
	public void writeUsers(User user){
		//io에서 준비된 user를 dao한테 넘겨서 add한다
		userDao.addUser(user);
	};
	
	public void editUser(int userNum, String userName){
		//수정할 번호, 수정할 이름을 넣어주었다
		//수정할 등록일을 만들어서 user통안에 넣어서 dao한테 넘겨준다
		User user = new User();
		user.setUserName(userName);
		user.setReDate(LocalDate.now());
		userDao.editUser(userNum, user);
	};
	
	public void delUser(int userNum){
		//제거할 번호 -> dao한테 넘긴다
		userDao.delUser(userNum);
	};
	
	public List<User> listUsers(){
		return userDao.getUsers();
	}
}
