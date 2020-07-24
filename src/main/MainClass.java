package main;

import java.util.Scanner;

import dao.MemberDAO;
import dao.MemberDAOImpl;
import dto.MemberDTO;
import utill.MyUtill;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("회원가입");
		MemberDTO dto = new MemberDTO();
		Scanner sc = new Scanner(System.in);

		System.out.print("이메일");
		String email = sc.next();
		System.out.print("패스워드");
		String pw = sc.next();
		System.out.print("이름");
		String name = sc.next();
		System.out.print("전화번호");
		String tel = sc.next();
		System.out.println("");

		
		//전화 번호 하이튼 기능 사용
		String myTel = MyUtill.makePhoneNumber(tel);
		System.out.println(myTel);
		if(myTel == null) {
			System.out.println("다시입력");
		}
		
		
		dto.setEmail(email);
		dto.setUserPW(pw);
		dto.setName(name);
		dto.setMobile(tel);
		
		//이메일을 가지고 id를 셋팅
		String[] emailArr =  email.split("@");
		dto.setUserID(emailArr[0]);
		if(emailArr[1] == null) {
			System.out.println("다시입력");
		}
		
		MemberDAO dao = new MemberDAOImpl();
		dao.insert(dto);

	}

}
