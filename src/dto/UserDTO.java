package dto;

public class UserDTO {
	
	private int num;
	private String userID;
	private String userPW;
	private String name;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	private String email;
	private int mobile;
//	private 
	
	
	public int getNum() {
		return num;
	}
	
	
	public void setNum(int num) {
		this.num = num;
	}
	
	
	public String getUserID() {
		return userID;
	}
	
	
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	
	public String getUserPW() {
		return userPW;
	}
	
	
	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public int getMobile() {
		return mobile;
	}
	
	
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

}
