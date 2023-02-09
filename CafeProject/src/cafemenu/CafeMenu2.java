package cafemenu;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cafeHome.CafeHome;
import cafeVO.CafeMemVO;


public class CafeMenu2 {
    int count = 0;
    String show = "";
    int sum = 0;
    public CafeMenu2() {
 
        // �����δ�
        // ������ ������
        JFrame frame = new JFrame("���� ī�� �Ǹű�");
        frame.setBounds(0, 0, 625, 1000);
        frame.setBackground(Color.black);
 
        // ��Ʈ
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
        Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 22);
 
        // ����
        Panel pNorth = new Panel();
        pNorth.setBackground(new Color(200, 205, 215));
        pNorth.setLayout(null);
        pNorth.setSize(0, 500);
        pNorth.setFont(font);
 

        
        // �迭 ���� �κ� 
        String gj[] = {"����","���"};
        String str[] = {"ice","hot"};
        String menu[] = { "�Ƹ޸�ī��", "ī���", "��ü��", "�ٹ�Ŀ��", "ī���ī", "�ٴҶ��", "�����ƶ�", "�������" };
        int price[] = { 2000, 2500, 3000, 2500, 4000, 3500, 3500, 2500 };
        JButton bt[] = new JButton[menu.length];
        TextField suja[] = new TextField[menu.length];
        Button minus[] = new Button[menu.length];
        Button plus[] = new Button[menu.length]; 
        JButton ok[] = new JButton[menu.length];
        Label l[] = new Label[menu.length];
        ImageIcon icon[] = new ImageIcon[menu.length];
        Image img[] = new Image[menu.length];
        Image chimg[] = new Image[menu.length];
        ImageIcon chicon[] = new ImageIcon[menu.length];
        Label m[] = new Label[menu.length];
        
        
        
        
        JComboBox strcom1 = new JComboBox(str);
        JComboBox strcom2 = new JComboBox(str);
        JComboBox strcom3 = new JComboBox(str);
        JComboBox strcom4 = new JComboBox(str);
        JComboBox strcom5 = new JComboBox(str);
        JComboBox strcom6 = new JComboBox(str);
        JComboBox strcom7 = new JComboBox(str);
        JComboBox strcom8 = new JComboBox(str);
        
        // ��ư ���� �κ�
        for (int i = 0; i < menu.length; i++) {
 
            //  ��ư i���� �̸��� �޴� i�����̸�
            bt[i] = new JButton(menu[i]);
            if (i < 4) {
                bt[i].setBounds(25 + i * 150, 50, 100, 100);
            } else {
                bt[i].setBounds(25 + (i - 4) * 150, 300, 100, 100);
            }
              
            
         // ��ư �� �޴��̸�
            m[i] = new Label(menu[i]);
            m[i].setBounds(bt[i].getX() + 15, bt[i].getY() - 30, 100, 20);
            
            
         // ��ư�� �̹��� �ֱ�
            icon[i] = new ImageIcon("images/"+i+".jpg");//�������� �����ͼ� i��°�� ����

            img[i] = icon[i].getImage(); //�������� �̹�����
            img[i] = img[i].getScaledInstance(110, 110, Image.SCALE_SMOOTH);//�̹����� ������ ����
            chicon[i] = new ImageIcon(img[i]);//������ �̹����� �ٽ� ����������
            bt[i].setIcon(chicon[i]);//��ư�� �̹��� ����
            
           
 
            // ���� txt ��ư
            suja[i] = new TextField("0");
            suja[i].setBackground(Color.white);
            suja[i].setEditable(false);//�ؽ�Ʈ �Է� ���ϰ���
            suja[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 130, 40, 20);
 
            // "-" ��ư
            minus[i] = new Button("-");
            minus[i].setBounds(bt[i].getX(), suja[i].getY(), 20, 20);//bt[i]�� suja[i]�� x,y���� ������
            minus[i].setEnabled(false);//�ߺ�Ŭ������,��Ȱ��ȭ
 
            // "+" ��ư
            plus[i] = new Button("+");
            plus[i].setBounds(bt[i].getX() + (100 - 20), suja[i].getY(), 20, 20);
            plus[i].setEnabled(false);
 
            // ����
            l[i] = new Label(price[i] + "��");
            l[i].setBounds(bt[i].getX() + 20, suja[i].getY() - 25, 100, 20);
 
            // Ȯ�� ��ư
            ok[i] = new JButton("Ȯ��");
            ok[i].setBounds(bt[i].getX(), suja[i].getY() + 30, 100, 20);
            ok[i].setEnabled(false);
            
            //hot.ice
 
            pNorth.add(bt[i]);
            pNorth.add(suja[i]);
            pNorth.add(minus[i]);
            pNorth.add(plus[i]); 
            pNorth.add(l[i]);
            pNorth.add(ok[i]);
            pNorth.add(m[i]);

            
        }
        strcom1.setBounds(bt[0].getX(), suja[0].getY() + 50, 100, 20);
        strcom2.setBounds(bt[1].getX(), suja[1].getY() + 50, 100, 20);
        strcom3.setBounds(bt[2].getX(), suja[2].getY() + 50, 100, 20);
        strcom4.setBounds(bt[3].getX(), suja[3].getY() + 50, 100, 20);
        strcom5.setBounds(bt[4].getX(), suja[4].getY() + 50, 100, 20);
        strcom6.setBounds(bt[5].getX(), suja[5].getY() + 50, 100, 20);
        strcom7.setBounds(bt[6].getX(), suja[6].getY() + 50, 100, 20);
        strcom8.setBounds(bt[7].getX(), suja[7].getY() + 50, 100, 20);
        strcom1.setEnabled(false);
        strcom2.setEnabled(false);
        strcom3.setEnabled(false);
        strcom4.setEnabled(false);
        strcom5.setEnabled(false);
        strcom6.setEnabled(false);
        strcom7.setEnabled(false);
        strcom8.setEnabled(false);
        pNorth.add(strcom1);
        pNorth.add(strcom2);
        pNorth.add(strcom3);
        pNorth.add(strcom4);
        pNorth.add(strcom5);
        pNorth.add(strcom6);
        pNorth.add(strcom7);
        pNorth.add(strcom8);
        
        
        
        
 
        // �߾�
        TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        
        ta.setText("   ��ǰ��\t\t�ܰ�\t\t\t����\t\t\t�հ�\n\n");
        ta.setBackground(Color.white);
        
        ta.setEditable(false);
        ta.setFont(font1);
        
 
        // ����
        Panel pSouth = new Panel();
        pSouth.setFont(font);
        pSouth.setBackground(new Color(200, 205, 215));
 
        Button bt1 = new Button("�ֹ�");
        Button bt2 = new Button("�ʱ�ȭ");
        Button bt3 = new Button("�ݱ�");
        Button bt4 = new Button("ó������");
       
        pSouth.add(bt1);
        pSouth.add(bt2);
        pSouth.add(bt3);
        pSouth.add(bt4); 

 
        // �ֹ���ư
        bt1.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
            	
              int var =  JOptionPane.showOptionDialog(null, ta.getText() + "���� :"+sum+"��\n�ֹ������� �½��ϱ�?","�ֹ�Ȯ��"
                		,0,1,null,gj,gj[1]);//nul= ȭ����������
              if(var==0) {
            	  JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.\n�����մϴ�.", "�ֹ�����", JOptionPane.INFORMATION_MESSAGE);
            	  frame.setVisible(false);
            	  new CafeHome().setVisible(true);
              }
              			
     
                
                for (int i = 0; i < menu.length; i++) {
                    bt[i].setEnabled(true);
                    minus[i].setEnabled(false);
                    plus[i].setEnabled(false);
                    suja[i].setText("0");
                    if(i==0) strcom1.setEnabled(false);
                    if(i==1) strcom2.setEnabled(false);
                    if(i==2) strcom3.setEnabled(false);
                    if(i==3) strcom4.setEnabled(false);
                    if(i==4) strcom5.setEnabled(false);
                    if(i==5) strcom6.setEnabled(false);
                    if(i==6) strcom7.setEnabled(false); 
                    if(i==7) strcom8.setEnabled(false);
                    sum=0;
 
                }
            }
        });
  
        // �ʱ�ȭ ��ư
        bt2.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                for (int i = 0; i < menu.length; i++) {
                	ta.setText("   ��ǰ��\t\t�ܰ�\t\t\t����\t\t\t�հ�\n\n");
                    bt[i].setEnabled(true);
                    minus[i].setEnabled(false);
                    plus[i].setEnabled(false);
                    suja[i].setText("0");
                    if(i==0) strcom1.setEnabled(false); 
                    if(i==1) strcom2.setEnabled(false);
                    if(i==2) strcom3.setEnabled(false);
                    if(i==3) strcom4.setEnabled(false);
                    if(i==4) strcom5.setEnabled(false);
                    if(i==5) strcom6.setEnabled(false);
                    if(i==6) strcom7.setEnabled(false);
                    if(i==7) strcom8.setEnabled(false);           
                    sum=0;
                    
                } 
            }
        });
 
 
        //bt3 �ݱ��ư
        
        bt3.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
       
        bt4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
			frame.setVisible(false);
			
			new CafeHome().setVisible(true); 
			}
		});
 
 
        // ������Ʈ
        frame.getContentPane().add(pNorth, BorderLayout.NORTH);
        frame.getContentPane().add(ta, BorderLayout.CENTER);
        frame.getContentPane().add(pSouth, BorderLayout.SOUTH);
        frame.setVisible(true);
 
        // �̺�Ʈ��
        for (int i = 0; i < menu.length; i++) {
            int j = i;
            
 
            // Ŀ�� ��ư �̺�Ʈ
            bt[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    minus[j].setEnabled(true);
                    plus[j].setEnabled(true);
                    bt[j].setEnabled(false);
                    ok[j].setEnabled(false);
                    if(j==0) strcom1.setEnabled(true);
                    if(j==1) strcom2.setEnabled(true);
                    if(j==2) strcom3.setEnabled(true);
                    if(j==3) strcom4.setEnabled(true);
                    if(j==4) strcom5.setEnabled(true);
                    if(j==5) strcom6.setEnabled(true);
                    if(j==6) strcom7.setEnabled(true);
                    if(j==7) strcom8.setEnabled(true);
                    count = 0;
                }
            });
 
            // "-" ��ư �̺�Ʈ
            minus[i].addActionListener(new ActionListener() {
 
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (count > 0) {
                        count = count - 1;
                        suja[j].setText(count + "");
                        ok[j].setEnabled(true);
                    } else {
                        minus[j].setEnabled(false);
                    }
                }
            });
            
            // "+" ��ư �̺�Ʈ
            plus[i].addActionListener(new ActionListener() {
 
                @Override
                public void actionPerformed(ActionEvent e) {
                    count = count + 1;
                    suja[j].setText(count + "");
                    ok[j].setEnabled(true);
                    if (count > 0) {
                        minus[j].setEnabled(true);
                    }
                }
            });
            
            //Ȯ�� ��ư �̺�Ʈ
            ok[i].addActionListener(new ActionListener() {
 
                @Override  
                public void actionPerformed(ActionEvent e) {
                    show = bt[j].getActionCommand();//��ư�� �̸��� ������
                   
                    if(e.getSource()==ok[0]) ta.append("   " + show + (String)strcom1.getSelectedItem()  
                    		+ "\t" + price[j] + "        " + count + "         " + price[j] * count
                            + "��" + "\n"); 
                    if(e.getSource()==ok[1]) ta.append("   " + show + (String)strcom2.getSelectedItem()  
            		+ "\t" + price[j] + "        " + count + "         " + price[j] * count
                    + "��" + "\n");
                    if(e.getSource()==ok[2]) ta.append("   " + show + (String)strcom3.getSelectedItem()  
            		+ "\t" + price[j] + "        " + count + "         " + price[j] * count
                    + "��" + "\n");
                    if(e.getSource()==ok[3]) ta.append("   " + show + (String)strcom4.getSelectedItem()  
            		+ "\t" + price[j] + "        " + count + "         " + price[j] * count
                    + "��" + "\n");
                    if(e.getSource()==ok[4]) ta.append("   " + show + (String)strcom5.getSelectedItem()  
            		+ "\t" + price[j] + "        " + count + "         " + price[j] * count
                    + "��" + "\n");
                    if(e.getSource()==ok[5]) ta.append("   " + show + (String)strcom6.getSelectedItem()  
            		+ "\t" + price[j] + "        " + count + "         " + price[j] * count
                    + "��" + "\n");
                    if(e.getSource()==ok[6]) ta.append("   " + show + (String)strcom7.getSelectedItem()  
            		+ "\t" + price[j] + "        " + count + "         " + price[j] * count
                    + "��" + "\n");
                    if(e.getSource()==ok[7]) ta.append("   " + show + (String)strcom8.getSelectedItem()  
            		+ "\t" + price[j] + "        " + count + "         " + price[j] * count
                    + "��" + "\n");
                    
                    sum+=price[j] * count; 
                     
                    
//                    ta.append("   " + show + (String)strcom1.getSelectedItem()  
//            		+ "       " + price[j] + "        " + count + "         " + price[j] * count
//                    + "��" + "\n");
//                    ok[j].setEnabled(false);
                    
                    
                }
                
            });
 
        }
 
        // ����
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    } 
 
    // ����
    public static void main(String[] args) {
        new CafeMenu(null);
    }

	public void setVisible(boolean b) {

		
	}
 
}
