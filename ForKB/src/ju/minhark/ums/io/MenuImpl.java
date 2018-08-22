package ju.minhark.ums.io;

import ju.minhark.ums.domain.Code;
import ju.minhark.ums.io.Console;

public class MenuImpl implements Menu {
	String[] menuitem;
	UserIo userIo;
	
	public MenuImpl(String[] menuItem, UserIo userIo) {
		this.menuitem = menuItem;
		this.userIo = userIo;
	}

	public void play() {
	
		while(true){
			
			String menu = "";
			for ( int i = 0 ; i < menuitem.length; i++){
			menu += (i+1 + "." + menuitem[i]+" ");
			}
			menu += ("0. 종료");
			
			Console.info(menu);
			
			String menuChoice = null;
			menuChoice = Console.inString("▶");
			
			if (menuChoice.equals(Code.USER_READ)) userIo.userList();
			else if (menuChoice.equals(Code.USER_ADD)) userIo.userAdd();
			else if ( menuChoice.equals(Code.USER_EDIT))userIo.userEdit();
			else if (menuChoice.equals(Code.USER_DEL))userIo.userDel();
			else if (menuChoice.equals(Code.Close)) break;
			else Console.info("ERROR: 존재하는 메뉴 번호를 입력하세요.");
		}
	}
}