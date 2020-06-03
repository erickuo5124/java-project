package fight_covid19;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Menu extends JPanel{
    private JButton btn;
    private JLabel label1, label2;
    JTextField textField, textField2;
    
    public void startMenu() {
    	setSize(250, 230);
        setBackground(Color.WHITE);
        
        label1 = new JLabel("請輸入員工識別證號或學號     ");
        label1.setBackground(Color.RED);
        label1.setFont(new Font("Serif", Font.BOLD, 18));
        label1.setBorder(new EmptyBorder(10,0,10,10));
		this.add(label1);
		
		label2 = new JLabel("Enter your Employee ID or Student ID");
        label2.setFont(new Font("Serif", Font.BOLD, 14));
        label2.setBorder(new EmptyBorder(10,0,10,10));
		this.add(label2);
		
        Box b2=Box.createVerticalBox();
        b2.setBorder(new EmptyBorder(0, 10, 0, 10));
		textField = new JTextField("請輸入員工識別證號或學號                  ");
		textField.setBorder(BorderFactory.createEtchedBorder());
		textField.setFont(new Font("Serif", Font.BOLD, 14));
		textField.setForeground(Color.GRAY);
		textField.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (textField.getText().equals("請輸入員工識別證號或學號                  ")) {
		        	textField.setText("");
		        	textField.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (textField.getText().isEmpty()) {
		        	textField.setForeground(Color.GRAY);
		        	textField.setText("請輸入員工識別證號或學號                  ");
		        }
		    }
		});
		b2.add(textField);
		
		textField2 = new JTextField("密碼");
		textField2.setBorder(BorderFactory.createEtchedBorder());
		textField2.setFont(new Font("Serif", Font.BOLD, 14));
		textField2.setForeground(Color.GRAY);
		textField2.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (textField2.getText().equals("密碼")) {
		        	textField2.setText("");
		        	textField2.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (textField2.getText().isEmpty()) {
		        	textField2.setForeground(Color.GRAY);
		        	textField2.setText("密碼");
		        }
		    }
		});
		b2.add(textField2);
		this.add(b2);
		
		Box b1=Box.createHorizontalBox(); 
        b1.setBorder(new EmptyBorder(15, 0, 0, 0));
		b1.setSize(new Dimension(getPreferredSize().width, Integer.MAX_VALUE));
		b1.setBackground(Color.BLACK);
		btn = new JButton("登入");
		btn.setFont(new Font("Serif", Font.BOLD, 14));
		btn.setBackground(Color.decode("#2771ea"));
		btn.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn.setBackground(Color.decode("#9eb9e6"));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn.setBackground(Color.decode("#2771ea"));
		    }
		});
		btn.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e) 
			{ 
				Core.start();
			} 
		});
		b1.add(btn);
		
		JButton btn2 = new JButton("規則");
		btn2.setFont(new Font("Serif", Font.BOLD, 14));
		btn2.setBackground(Color.decode("#ea2750"));
		btn2.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn2.setBackground(Color.decode("#ef8198"));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn2.setBackground(Color.decode("#ea2750"));
		    }
		});
		btn2.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e) 
			{ 
				JOptionPane.showMessageDialog(null,"「知識是光，善良是影，公民責任是教養和承擔。」\r\n" + 
						"面對新型冠狀病毒的來襲，成大也不得不做好準備\r\n" + 
						"收集從書本中得到的知識之光\r\n" + 
						"用口罩來抵禦病毒，並用酒精消滅它們\r\n" + 
						"防疫高手，就是你我"); //呼叫msgbox
			} 
		});
		b1.add(btn2);
		
		this.add(b1);
    }
    
    public void endMenu() {
    	setSize(90, 35);
    	setOpaque(false);
    	setBackground(new Color(255, 255, 255, 0));
    	
    	JButton btn2 = new JButton("重新開始");
		btn2.setFont(new Font("Serif", Font.BOLD, 14));
		btn2.setBackground(Color.decode("#ea2750"));
		btn2.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	btn2.setBackground(Color.decode("#ef8198"));
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btn2.setBackground(Color.decode("#ea2750"));
		    }
		});
		btn2.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e) 
			{ 
				Core.start();
			} 
		});
		this.add(btn2);
    }

    //------------helper------------
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected ImageIcon createImageIcon(String path,
                                        String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
