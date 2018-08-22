package ju.minhark.ums.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ju.minhark.ums.domain.User;

public class UserDaoImpl implements UserDao{
	static int userNum;
	List<User> userList = new ArrayList<>();
	
	//추가
	public void addUser(User user){
		if(userList.size() == 0){
			userNum = 1;
		}
		user.setUserNum(userNum);
		user.setReDate(LocalDate.now());
		//준비물 user를 넣어주면 userList에 추가가 되야한다
		userList.add(user);
		
		userNum++;
	};      
	
	//수정
	public void editUser(int userNum, User user){
		//userNum으로 선택된 userList에 1명이 
		for(User corUser:userList){    //corUser 는 해당유저
			if(corUser.getUserNum() == userNum){
				corUser.setUserName(user.getUserName());
				corUser.setReDate(user.getReDate());
			}
		}
	};    
	
	 //삭제
	public void delUser(int userNum){
		for(User corUser:userList){    //corUser 는 해당유저
			if(corUser.getUserNum() == userNum){
				//userList에서 해당인원을 지운다		
				userList.remove(userNum-1);
			}
		}
	};	
		
	//조회
	public List<User> getUsers( ){
		return userList;
	};                                
}
