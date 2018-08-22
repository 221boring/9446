package ju.minhark.ums.dao;

import java.util.List;
import ju.minhark.ums.domain.User;

public interface UserDao {
	//write
	public void addUser(User user);                    //추가
	public void editUser(int userNum, User user);   //수정
	public void delUser(int userNum);	               //삭제
	
	//read
	List<User> getUsers();                               //조회
}
