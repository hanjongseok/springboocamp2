package main;

import java.util.Scanner;

import dao.UserDAO;
import dao.UserDAOImpl;
import dto.UserDTO;

public class MainClass {

	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);

		
		
		
		
		
		System.out.println("");
		System.out.println("가입내역이 있는지 확인합니다 전화 번호를 입력해주세요");
		int mobile = sc.nextInt();
		
		UserDAO userDAO = new UserDAOImpl();
		UserDTO dto = UserDAO.select(Mobile);
		if(dto == null) {
			//dto가 null이기 때문에 new로 공간을 만들어줘야함
			dto = new UserDTO();
			System.out.println("아이디가 없습니다 가입해주세요");
			System.out.println("===================================");
			System.out.println("회원가입");
			System.out.println("아이디를 입력해주세요");
			String userID = sc.next();// id입력받기
			System.out.println("패스워드를 입력해주세요");
			String userPW = sc.next();
			System.out.println("email을 입력해주세요");
			String email = sc.next();
			System.out.println("-없이 입력해주세요");
			int mobile = sc.nextInt();
			
			String userName = sc.next();
			UserDTO dto =  userDAO.select(userID);
			//id 와 이름을 dto에 셋팅
			
			dto.setUserID(userID);
			dto.setUserPW(userPW);
			dto.setEmail(email);
			dto.setMobile(mobile);
			System.out.println("당신이 입력한 ID는 " + userID + "입니다");
			System.out.println("당신이 입력한 PW는 "+userPW+"입니다");
			System.out.println("당신이 입력한 Email은 "+email+"입니다");
			System.out.println("당신이 입력한 전화 번호는 "+mobile+"입니다");

			
			
			
			//DB에 insert 한다
			userDAO.insert(dto);
		}	
				
//		}else {
//			System.out.println("아이디가 있습니다");
//		}
		
		//유저 정보출력
		System.out.println("당신의 정보");
		System.out.println("점수: "+dto.getNum());
		System.out.println("아이디: "+dto.getUserID());
		System.out.println("이름: "+dto.getUserPW());
		System.out.println("점수: "+dto.getEmail());
		System.out.println("점수: "+dto.getMobile());
//		System.out.println("점수: "+dto.getDate());


	}

}
