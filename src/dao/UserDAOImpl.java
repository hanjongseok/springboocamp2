package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DB;
import dto.UserDTO;

public class UserDAOImpl implements UserDAO {

	@Override
	public void insert(UserDTO dto) {
		// DB연결
		// 쿼리 만들고
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DB.conn();
			String sql = "INSERT INTO join_tbl (userID, userPW, Email, mobile) VALUES(?,?, ?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getUserID());
			pstmt.setString(2, dto.getUserPW());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getEmail());
			pstmt.setInt(5, dto.getMobile());

			int count = pstmt.executeUpdate();
			if (count == 0) {
				System.out.println("데이터 입력 실패");
			} else {
				System.out.println("데이터 입력 성공");
			}

		} catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// 쿼리 실행
	}

	@Override
	public UserDTO select(int mobile) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 전달 변수(dto 담을 그릇)
		UserDTO dto = null;
		try {
			conn = DB.conn();
			String sql = "SELECT *FROM join_tbl WHERE mobile = ?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mobile);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new UserDTO();
				pstmt.setString(1, dto.getUserID());
				pstmt.setString(2, dto.getUserPW());
				pstmt.setString(3, dto.getName());
				pstmt.setString(4, dto.getEmail());
				pstmt.setInt(5, dto.getMobile());
			} else {
				System.out.println("없는 사용자");
			}

		} catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	@Override
	public ArrayList<UserDTO> select() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 전달 변수(dto 담을 그릇)
		ArrayList<UserDTO> list = new ArrayList<UserDTO>();
		try {
			conn = DB.conn();
			String sql = "SELECT *FROM join_tbl;";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				UserDTO dto = new UserDTO();
				pstmt.setString(1, dto.getUserID());
				pstmt.setString(2, dto.getUserPW());
				pstmt.setString(3, dto.getName());
				pstmt.setString(4, dto.getEmail());
				pstmt.setInt(5, dto.getMobile());
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public UserDTO select(String mobile) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public void update(UserDTO dto) {
//		// TODO Auto-generated method stub
//
//	}

}
