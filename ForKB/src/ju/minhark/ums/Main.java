package ju.minhark.ums;

import ju.minhark.ums.dao.UserDao;
import ju.minhark.ums.dao.UserDaoImpl;
import ju.minhark.ums.io.Console;
import ju.minhark.ums.io.Menu;
import ju.minhark.ums.io.MenuImpl;
import ju.minhark.ums.io.UserIo;
import ju.minhark.ums.io.UserIoImpl;
import ju.minhark.ums.service.UserService;
import ju.minhark.ums.service.UserServiceImpl;

public class Main {
	public static void main(String[] args){
		String[] menuItem = {"목록", "등록", "수정", "탈퇴"};
		
		UserDao userDao = new UserDaoImpl(); 
		UserService userService = new UserServiceImpl(userDao);
		UserIo userIo = new UserIoImpl(userService);
		Menu menu = new MenuImpl(menuItem, userIo);
		
		Console.info("UMS를 시작합니다.");
		menu.play();
		Console.info("UMS를 종료합니다.");
	}
}
