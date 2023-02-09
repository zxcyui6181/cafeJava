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
		
		// ȸ������ �Է� �޼ҵ�
		public int insert_mem(CafeMemVO cmvo) {
			// ȸ������ â
			// ȸ������ ��ư
			// CafeJoin ���� ȸ������ ��ư�� ��������
			// cafemem ���̺� memname, memtel �Է��ϰ�
			// �޴����� ȭ������ �Ѿ��
			// memname, memtel �� �ϳ��� ���� �Է����� �ʾ����� ���â �߰��ϱ�
			// memtel �̹� �ִ� ���, ���â���� �̹� ��ϵ��� �˷���
			
			String sql = "insert into cafemem"
					+ " values(?,?)";
			int cnt = 0;
			
			try {
			
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, cmvo.getMemname());
				pstmt.setString(2, cmvo.getMemtel());
				cnt = pstmt.executeUpdate(); // executeUpdate() : ó���� row�� ������ ��ȯ
				
//				if(cnt == 0) { // cnt�� 0�̸� ���� �Է��� �ȵȰ�
//					return cnt;
//				}else {
//					return cnt; 
//				}
				
			} catch (SQLException e) {
				System.out.println("insert error");
			}
			return cnt;
			
		} // insert_mem-end
				
		
		// select��
		public int select_tel(String tel) throws SQLException {
			String sql = "select memtel"
					+ " from cafemem"
					+ " where memtel = ?";
			int cnt=0;
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  tel);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // ��ȯ���� �ִٸ� cnt ������ 1 ��ȯ
				cnt++;
			}
			
			return cnt;
			
			
		} // select-end
		
		// update��
		public int update_tel(String tel1, String tel2) {
			                  // ������ȣ    , �����ȣ
			String sql = "update cafemem"
					+ " set memtel = ?"
					+ " where memtel = ?";
			int cnt=0;
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, tel2); // �����ȣ
				pstmt.setString(2, tel1); // ������ȣ
				cnt = pstmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println("update error");
				return cnt;
			}
			return cnt;	
		} // update-end
		
		// delete��
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
