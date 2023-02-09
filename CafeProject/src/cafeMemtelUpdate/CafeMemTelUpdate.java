package cafeMemtelUpdate;

import java.awt.EventQueue;
import java.awt.Font;
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

public class CafeMemTelUpdate extends JFrame {

	private JPanel contentPane;
	private JTextField textMemtel1;
	private JTextField textMemtel2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CafeMemTelUpdate frame = new CafeMemTelUpdate();
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
	public CafeMemTelUpdate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 413);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMemtel1 = new JLabel("\uAE30\uC874\uC804\uD654\uBC88\uD638");
		lblMemtel1.setBounds(69, 92, 93, 27);
		contentPane.add(lblMemtel1);
		
		JLabel lblMemtel2 = new JLabel("\uBCC0\uACBD\uB41C\uC804\uD654\uBC88\uD638");
		lblMemtel2.setBounds(58, 129, 85, 21);
		contentPane.add(lblMemtel2);
		
		textMemtel1 = new JTextField();
		textMemtel1.setForeground(new Color(0, 0, 0));
		textMemtel1.setText("ex)010-1234-5678");
		textMemtel1.setBounds(155, 94, 211, 24);
		contentPane.add(textMemtel1);
		textMemtel1.setColumns(10);
		
		textMemtel2 = new JTextField();
		textMemtel2.setBounds(155, 129, 211, 21);
		contentPane.add(textMemtel2);
		textMemtel2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\uD68C\uC6D0\uC815\uBCF4\uC218\uC815");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel_2.setBounds(188, 10, 211, 46);
		contentPane.add(lblNewLabel_2);
		
		JButton btnUpateCheck = new JButton("\uC218\uC815");
		btnUpateCheck.setBackground(new Color(176, 224, 230));
		btnUpateCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // 수정버튼 클릭 // CafeHome으로 이동
				// update_tel
				CafeDAO cdao;
				try {
					cdao = new CafeDAO();
					int answer = cdao.update_tel(textMemtel1.getText(), textMemtel2.getText());
                    								// 기존변호                변경번호    
					if(answer == 0) {
						JOptionPane.showMessageDialog(null, "전화번호를 다시 입력하세요.", "수정실패", JOptionPane.INFORMATION_MESSAGE);
					}else {
						setVisible(false);
						JOptionPane.showMessageDialog(null, "수정이 완료되었습니다.", "수정완료", JOptionPane.INFORMATION_MESSAGE);
						new CafeHome().setVisible(true);
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
		btnUpateCheck.setBounds(328, 310, 93, 40);
		contentPane.add(btnUpateCheck);
		
		JButton btnUpdateCancel = new JButton("\uCDE8\uC18C");
		btnUpdateCancel.setBackground(new Color(176, 224, 230));
		btnUpdateCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // 최소버튼 클릭 // CafeHome으로 이동
				setVisible(false);
				new CafeHome().setVisible(true);
			}
		});
		btnUpdateCancel.setBounds(440, 310, 93, 40);
		contentPane.add(btnUpdateCancel);
	}
}
