package dao;

import java.util.ArrayList;

import dto.UserDTO;

public interface UserDAO {
	
	// 넣기
		public void insert(UserDTO dto);

		// ID로검색하기
		public UserDTO select(String mobile);

		
		//전체 데이터 검색
		public ArrayList<UserDTO> select();

		UserDTO select(int mobile);
		
		//점수 정보 업데이트
		
//		public void update(UserDTO dto);
//		UPDATE user_tbl SET `score`='32' WHERE  `userID`='ccc';

}
