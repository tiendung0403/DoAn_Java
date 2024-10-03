package giaoDien;


import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Script.Caesar;
public class caesarScreen extends subScreen {
	
	private  JFrame frame;

	public caesarScreen(doanlaptrinhmahoa mainClass) {
        super(mainClass); // Truyền lớp chính vào lớp cha
    }
	
	
	@Override
	protected JPanel Screen() {
	    JPanel Panel = super.Screen();

	    //set tọa độ hiển thị (x,y,chiều rộng,chiều cao) cho các thành phần 

        encrytionbutton.setBounds(550,81,90,30);
        decrytionbutton.setBounds(550,268,90,30);
        exitButton.setBounds(700,140,60,30);
        keyText1.setBounds(550,11,30,30);
        keyText2.setBounds(550,200,30, 30);
        keyE.setBounds(590,11,180,30);
        keyD.setBounds(590,200,180,30);
		
        
        
	    //tạo sự kiện sau khi click vào nút Encrytion
        encrytionbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Caesar a = new Caesar();
                try {/* 
                 //thực hiện ép kiểu từ chuỗi string của Key sang kiểu int
                 để kiểm tra xem Key có phải là number không 
                 nếu thành công thì tiến hành gán kết quả mã hóa vào biến c 
                 và hiển thị vào Ô cipertext*/
                    Integer.parseInt(keyE.getText());                
                    String c = a.encrypt(plaintext.getText(),Integer.parseInt(keyE.getText()));
                    cipherText.setText(c);
                }catch (NumberFormatException ex ) {
                 // hiển thị thông báo khi lỗi khi không ép kiểu thanhf công "key không phải dạnh number" 
                    JOptionPane.showMessageDialog(frame, "Nhập sai Key!\n Lưu ý nhập key dạng number");
                }
            }
        });
	    
	    
    //tạo sự kiện sau khi click vào nút Encrytion
        decrytionbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Caesar a = new Caesar();
                try {/*thực hiện ép kiểu từ chuỗi string của Key sang kiểu int
               để kiểm tra xem Key có phải là number không 
               nếu thành công thì tiến hành gán kết quả mã hóa vào biến p 
               và hiển thị vào Ô cipertext*/
                    Integer.parseInt(keyD.getText());                
                    String p = a.decrypt(cipherText.getText(),Integer.parseInt(keyD.getText()));
                    plaintext.setText(p);
                }catch (NumberFormatException ex ) {
               // hiển thị thông báo khi lỗi khi không ép kiểu thanh công "key không phải dạnh number" 
                    JOptionPane.showMessageDialog(frame, "Nhập sai Key!\n Lưu ý nhập key dạng number");
                }
            }
        });
		
	    return Panel;
	}

	
	
}
