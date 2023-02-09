package cafeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cafeDBConn.CafeDBConn;
import cafeVO.CafeMemVO;

public class CafeDAO {

		private Connection con;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		public CafeDAO() throws ClassNotFoundException, SQLException {
			con = new CafeDBConn().getConnection();
		}
		
		// 회원가입 입력 메소드
		public int insert_mem(CafeMemVO cmvo) {
			// 회원가입 창
			// 회원가입 버튼
			// CafeJoin 에서 회원가입 버튼이 눌러지면
			// cafemem 테이블에 memname, memtel 입력하고
			// 메뉴선택 화면으로 넘어가기
			// memname, memtel 중 하나라도 값을 입력하지 않았을시 경고창 뜨게하기
			// memtel 이미 있는 경우, 경고창으로 이미 등록됨을 알려줌
			
			String sql = "insert into cafemem"
					+ " values(?,?)";
			int cnt = 0;
			
			try {
			
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, cmvo.getMemname());
				pstmt.setString(2, cmvo.getMemtel());
				cnt = pstmt.executeUpdate(); // executeUpdate() : 처리된 row의 개수를 반환
				
//				if(cnt == 0) { // cnt가 0이면 값이 입력이 안된거
//					return cnt;
//				}else {
//					return cnt; 
//				}
				
			} catch (SQLException e) {
				System.out.println("insert error");
			}
			return cnt;
			
		} // insert_mem-end
				
		
		// select문
		public int select_tel(String tel) throws SQLException {
			String sql = "select memtel"
					+ " from cafemem"
					+ " where memtel = ?";
			int cnt=0;
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  tel);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 반환값이 있다면 cnt 증가로 1 반환
				cnt++;
			}
			
			return cnt;
			
			
		} // select-end
		
		// update문
		public int update_tel(String tel1, String tel2) {
			                  // 기존번호    , 변경번호
			String sql = "update cafemem"
					+ " set memtel = ?"
					+ " where memtel = ?";
			int cnt=0;
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, tel2); // 변경번호
				pstmt.setString(2, tel1); // 기존번호
				cnt = pstmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println("update error");
				return cnt;
			}
			return cnt;	
		} // update-end
		
		// delete문
		public void delete_mem(String tel) {
            String sql = "delete from cafemem where memtel=?";       
            
            try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,tel);
				pstmt.executeUpdate();
	            
			} catch (SQLException e) {
				System.out.println("delete error");
			}
   
                      
		} // delete-end
		
		
		

		
}
