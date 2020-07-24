package dao;

import java.util.ArrayList;

import dto.MemberDTO;

public interface MemberDAO {
	
	// 넣기
		public  void insert(MemberDTO dto);

		// ID로검색하기
		public MemberDTO select(String mobile);

		
		//전체 데이터 검색
		public ArrayList<MemberDTO> select();

		MemberDTO select(int mobile);
		
		//점수 정보 업데이트
		
//		public void update(UserDTO dto);
//		UPDATE user_tbl SET `score`='32' WHERE  `userID`='ccc';

}
