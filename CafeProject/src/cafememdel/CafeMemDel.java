package cafememdel;

import java.awt.EventQueue;
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
import java.awt.Color;

public class CafeMemDel extends JFrame {

	private JPanel contentPane;
	private JTextField deltextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CafeMemDel frame = new CafeMemDel();
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
	public CafeMemDel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 417);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uD0C8\uD1F4\uD560 \uD68C\uC6D0\uC758 \uC804\uD654\uBC88\uD638\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
		lblNewLabel.setBounds(76, 95, 384, 28);
		contentPane.add(lblNewLabel);
		
		deltextField = new JTextField();
		deltextField.setText("ex) 010-1234-5678");
		deltextField.setBounds(76, 155, 371, 28);
		contentPane.add(deltextField);
		deltextField.setColumns(10);
		
		JButton btnNewButton = new JButton("\uD68C\uC6D0\uD0C8\uD1F4");
		btnNewButton.setBackground(new Color(176, 224, 230));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//회원탈퇴 눌렀을때 회원정보삭제
				
				try {
					CafeDAO cdao = new CafeDAO();
					String tel = deltextField.getText();
					
					int answer1 = cdao.select_tel(tel); // 번호가 등록되어 있는지 확인하기 위해 select_tel문 호출
					
					if(answer1 == 1) {
						int answer2 = JOptionPane.showConfirmDialog(null, "정말 탈퇴하시겠습니까?", "탈퇴확인", JOptionPane.YES_NO_OPTION);
                        //가운데  //내용							//창이름			 //옵션
						if(answer2 == JOptionPane.YES_OPTION) {
							cdao.delete_mem(tel);
							setVisible(false);
							JOptionPane.showMessageDialog(null, "탈퇴가 성공적으로 되었습니다.", "회원탈퇴", JOptionPane.INFORMATION_MESSAGE);
							new CafeHome().setVisible(true);
						}
					}else {
						JOptionPane.showMessageDialog(null, "등록되지 않은 번호입니다.", "탈퇴실패", JOptionPane.INFORMATION_MESSAGE);
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
		btnNewButton.setBounds(76, 233, 121, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.setBackground(new Color(176, 224, 230));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // 취소버튼클릭
				setVisible(false);
				new CafeHome().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(248, 233, 121, 36);
		contentPane.add(btnNewButton_1);
	}
}

