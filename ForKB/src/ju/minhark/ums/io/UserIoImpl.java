package ju.minhark.ums.io;

import java.util.List;                          
import ju.minhark.ums.io.Console;
import ju.minhark.ums.domain.User;              
import ju.minhark.ums.service.UserService;      

public class UserIoImpl implements UserIo{
	private UserService userService;
	//writeUserRecord
	//listUserRecord
	
	public UserIoImpl(UserService userService){
		this.userService = userService;
	}
	
	//--------------------------------------------------------------
	@Override
	public void userList(){            //조회
		List<User> userlist = userService.listUsers();
		
		if(userlist.size() == 0) Console.info("사용자가 없습니다.");         //목록 없다
		else for(User user : userlist) Console.info(user);               //목록이 있다
		
	}
	
	@Override
	public void userAdd(){             //추가	
		String userName = Console.inString("등록할 사용자 이름을 입력하세요. \n ▶");
		User user = new User(userName);
		if(userName.charAt(0) == '0'){
			Console.info("사용자 등록 취소.");
		}else{
			user.setUserName(userName);
			userService.writeUsers(user);
			Console.info("사용자 등록 성공");
		}
	}
	@Override
	public void userEdit(){            //수정
		
		User user = new User();
		List<User> users = userService.listUsers();
		
		boolean userExist = false;     
		boolean editClose = false;      
		
		if(users.size() == 0) Console.info("사용자가 없습니다.");
		else {
			do {
				int userNum = Console.inNum("수정할 사용자 번호를 입력하세요. \n▶");
				
				if(userNum == 0) editClose = true;
			
				for(User corUser : users) { 
					if(userNum == corUser.getUserNum()) {
						userExist = true;
						break;
					}
				}
				
				if(userExist && !editClose) { 
					String userName = Console.inString("수정할 이름을 입력하세요. \n▶");
					userService.editUser(userNum, userName);
					Console.info("사용자 정보 수정 성공.");
					editClose = true;
				} else if(!userExist && !editClose) Console.info("ERROR: 존재하지 않는 사용자.");
				else Console.info("사용자 정보 수정 취소.");
			
			} while(!editClose);
		}
	}
	
	@Override
	public void userDel(){                     //삭제
		List<User> users = userService.listUsers();
		
		boolean delClose = false;
		boolean userExist = false;
		
		if(users.size() == 0)Console.info("사용자가 없습니다."); 
		else {
			do {
				int userNum = Console.inNum("탈퇴할 사용자 번호를 입력하세요. \n▶");
			
				if(userNum == 0) delClose = true;
			
				for(User corUser : users) {
					if(userNum == corUser.getUserNum()) {
						userExist = true;
						break;
					}
				}
			
				if(userExist && !delClose) {
					userService.delUser(userNum);
					Console.info("사용자 탈퇴 성공.");
					delClose = true;
				} else if(!userExist && !delClose)Console.info("ERROR: 존재하지 않는 사용자."); 
				else Console.info("사용자 탈퇴 취소");
			
			} while(!delClose);
		}
	}
}

