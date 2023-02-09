package cafelogin;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cafeDAO.CafeDAO;
import cafeHome.CafeHome;
import cafeVO.CafeMemVO;
import cafemenu.CafeMenu;
import java.awt.Color;

public class CafeLogin extends JFrame { // 로그인 화면

	private JPanel contentPane;
	private JTextField textMemtel;
	CafeMemVO cmvo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CafeLogin frame = new CafeLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} 
		});
	}

	/**
	 * Create the frame.
	 */
	public CafeLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 489);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMemTel = new JLabel("\uC804\uD654\uBC88\uD638");
		lblMemTel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblMemTel.setBounds(53, 96, 77, 41);
		contentPane.add(lblMemTel);
		
		textMemtel = new JTextField();
		textMemtel.setText("ex) 010-1234-5678");
		textMemtel.setBounds(142, 103, 262, 31);
		contentPane.add(textMemtel);
		textMemtel.setColumns(10);
		
		JButton btnLogin = new JButton("\uB85C\uADF8\uC778\uD558\uAE30");
		btnLogin.setBackground(new Color(176, 224, 230));
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // 로그인버튼 클릭
				// textMemtel 에 입력된 값을
				// select_tel() 메소드를 이용해 DB CafeMem 테이블에서 찾기
				// 값이 있으면, 로그인 성공 // 없으면, 로그인 실패
				// 로그인 성공하면 메뉴선택화면으로 이동
				// 실패하면 경고창 뜨게하고 처음화면으로 이동
				CafeDAO cdao;
				try {
					cmvo = new CafeMemVO();
					cdao = new CafeDAO();
					
					int answer = cdao.select_tel(textMemtel.getText());
					
					if(answer != 0) { // 로그인 성공
						setVisible(false);
						new CafeMenu(cmvo).setVisible(true);
					}else{ // 로그인 실패
						JOptionPane.showMessageDialog(null, "없는 전화번호입니다.", "로그인실패", JOptionPane.WARNING_MESSAGE);
					}
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		btnLogin.setBounds(417, 103, 103, 31);
		contentPane.add(btnLogin);
		
		JButton btnLoginCancel = new JButton("\uCDE8\uC18C");
		btnLoginCancel.setBackground(new Color(176, 224, 230));
		btnLoginCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new CafeHome().setVisible(true);				
			}
		});
		btnLoginCancel.setBounds(532, 103, 77, 31);
		contentPane.add(btnLoginCancel);
	}
}
