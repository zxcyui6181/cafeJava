package cafeHome;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cafeMemtelUpdate.CafeMemTelUpdate;
import cafejoin.CafeJoin;
import cafelogin.CafeLogin;
import cafememdel.CafeMemDel;
import cafemenu.CafeMenu2;
import java.awt.Color;

public class CafeHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CafeHome frame = new CafeHome();
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
	public CafeHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 444);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMem = new JButton("\uD68C\uC6D0");
		btnMem.setBackground(new Color(176, 224, 230));
		btnMem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new CafeLogin().setVisible(true);
			}
		});
		btnMem.setFont(new Font("���� ���", Font.BOLD, 14));
		btnMem.setBounds(98, 207, 157, 47);
		contentPane.add(btnMem);
		
		JButton btnNonMem = new JButton("\uBE44\uD68C\uC6D0");
		btnNonMem.setBackground(new Color(176, 224, 230));
		btnNonMem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { 
				setVisible(false);
				new CafeMenu2().setVisible(true);
			}
		});
		btnNonMem.setFont(new Font("���� ���", Font.BOLD, 14));
		btnNonMem.setBounds(323, 207, 163, 47);
		contentPane.add(btnNonMem);
		
		JButton btnNewButton = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnNewButton.setBackground(new Color(176, 224, 230));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new CafeJoin().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("���� ���", Font.BOLD, 14));
		btnNewButton.setBounds(372, 339, 114, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\uC5B4\uC11C\uC624\uC138\uC694. \uD37C\uC2A4\uD2B8\uD074\uB798\uC2A4\uCE74\uD398\uC785\uB2C8\uB2E4. ");
		lblNewLabel.setFont(new Font("���� ���", Font.BOLD, 20));
		lblNewLabel.setBounds(125, 53, 361, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uD68C\uC6D0\uC740 5%\uD560\uC778\uB429\uB2C8\uB2E4. \uD68C\uC6D0\uAC00\uC785\uD558\uC2DC\uACA0\uC2B5\uB2C8\uAE4C?");
		lblNewLabel_1.setFont(new Font("���� ���", Font.BOLD, 12));
		lblNewLabel_1.setBounds(102, 339, 258, 23);
		contentPane.add(lblNewLabel_1);
		
		JButton btnUpdate = new JButton("\uD68C\uC6D0\uC815\uBCF4 \uC218\uC815");
		btnUpdate.setBackground(new Color(176, 224, 230));
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new CafeMemTelUpdate().setVisible(true);
			}
		});
		btnUpdate.setBounds(176, 374, 114, 23);
		contentPane.add(btnUpdate);
		
		JButton btnWithdrawal = new JButton("\uD68C\uC6D0 \uD0C8\uD1F4");
		btnWithdrawal.setBackground(new Color(176, 224, 230));
		btnWithdrawal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { 
				setVisible(false);
				new CafeMemDel().setVisible(true);
			}
		});
		btnWithdrawal.setBounds(312, 374, 103, 23);
		contentPane.add(btnWithdrawal);
	}
}
