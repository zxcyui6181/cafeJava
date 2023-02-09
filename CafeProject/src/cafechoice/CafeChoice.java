package cafechoice;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cafeVO.CafeMemVO;

import javax.swing.JButton;

public class CafeChoice extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CafeChoice frame = new CafeChoice(null);
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
	public CafeChoice(CafeMemVO cmvo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(12, 10, 146, 107);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(170, 10, 146, 107);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(334, 10, 146, 107);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(492, 10, 146, 107);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(12, 139, 146, 107);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setBounds(170, 139, 146, 107);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.setBounds(334, 139, 146, 107);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("New button");
		btnNewButton_7.setBounds(494, 139, 146, 107);
		contentPane.add(btnNewButton_7);
	}

}
