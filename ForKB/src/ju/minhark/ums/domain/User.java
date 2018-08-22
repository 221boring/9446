package ju.minhark.ums.domain;

import java.time.LocalDate;

public class User {
	private int userNum;       //번호
	private String userName;   //이름
	private LocalDate reDate;  //등록일

	public User(){}
	
	public User(String userName){
		this.userName = userName;
	}
	
	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDate getReDate() {
		return reDate;
	}

	public void setReDate(LocalDate reDate) {
		this.reDate = reDate;
	}

	@Override
	public String toString() {
		return String.format("%d %s %s", userNum, userName, reDate);
	}
}