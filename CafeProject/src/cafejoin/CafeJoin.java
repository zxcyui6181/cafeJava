package cafejoin;

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
import cafelogin.CafeLogin;
import java.awt.Color;

public class CafeJoin extends JFrame {

	private JPanel contentPane;
	private JTextField textName; // 입력이름
	private JTextField textTel; // 입력전화번호
	CafeMemVO cmvo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try { 
					CafeJoin frame = new CafeJoin();
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
	public CafeJoin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 753, 435); 
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJoin = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lblJoin.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblJoin.setBounds(309, 42, 141, 53);
		contentPane.add(lblJoin);
		
		JLabel lblName = new JLabel("\uC774\uB984");
		lblName.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblName.setBounds(94, 122, 81, 27);
		contentPane.add(lblName);
		
		JLabel lblTel = new JLabel("\uC804\uD654\uBC88\uD638");
		lblTel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblTel.setBounds(94, 182, 87, 27);
		contentPane.add(lblTel);
		
		textName = new JTextField();
		textName.setBounds(187, 122, 234, 27);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textTel = new JTextField();
		textTel.setText("ex) 010-1234-5678");
		textTel.setBounds(187, 185, 239, 24);
		contentPane.add(textTel);
		textTel.setColumns(10);
		
		JButton btnJoinCheck = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnJoinCheck.setBackground(new Color(176, 224, 230));
		btnJoinCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 회원가입 버튼을 누르면
				// 입력받은 이름과 전화번호를 CafeMemVO의 setter 메소드를 통해 저장하고
				// 메뉴선택 화면으로 이동
				//cmvo = new CafeMemVO(textName.getText(), textTel.getText());
				cmvo = new CafeMemVO();
				CafeDAO cdao;
				
				try {
					cdao = new CafeDAO();
					cmvo.setMemname(textName.getText());
					cmvo.setMemtel(textTel.getText());
					
					int answer1 = cdao.insert_mem(cmvo);  
					int answer2 = cdao.select_tel(cmvo.getMemtel());
					// memtel이 이미 등록되어 있는지를 파악하기 위해서 호출
					
					
					if(answer1 == 0){
						if(answer2 == 1) { // answer1이면 이미 전화번호가 등록되어 있음
							// 이미 등록된 값을 알려주는 경고창 뜨게하기
							JOptionPane.showMessageDialog(null, "이미 등록되어 있습니다.", "회원가입 오류", JOptionPane.WARNING_MESSAGE);
						}else {	
							JOptionPane.showMessageDialog(null, "값을 다시 입력하세요.", "회원가입 오류", JOptionPane.WARNING_MESSAGE);
						}
					}else {
						setVisible(false);
						JOptionPane.showMessageDialog(null, "회원가입 되셨습니다.", "회원가입 성공", JOptionPane.INFORMATION_MESSAGE);
						new CafeLogin().setVisible(true);
					}
					
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}							

			}
		});
		btnJoinCheck.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnJoinCheck.setBounds(149, 295, 120, 39);
		contentPane.add(btnJoinCheck);
		
		JButton btnCancel = new JButton("\uCDE8\uC18C");
		btnCancel.setBackground(new Color(176, 224, 230));
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new CafeHome().setVisible(true);
			}
		});
		btnCancel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancel.setBounds(319, 295, 141, 39);
		contentPane.add(btnCancel);
	}
}
