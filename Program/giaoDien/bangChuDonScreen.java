
package giaoDien;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Script.Bangchudon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bangChuDonScreen extends subScreen {
	private  JPanel Panel;
	private JFrame frame;

	
	public bangChuDonScreen(doanlaptrinhmahoa mainClass) {
        super(mainClass); // Truyền lớp chính vào lớp cha
    }
	
	
	@Override
	protected JPanel Screen() {
	    this.Panel = super.Screen();
	    

		//tạo nút random key
		JButton randomkeybt = new JButton("Random Key");
		// tạo text hiện sẵn bảng mã 
		JTextField text = new JTextField("ABCDEFGHIJKLNMOPQRSTUVWXYZ");
		text.setEditable(false);

		//set tọa độ hiển thị (x,y,chiều rộng,chiều cao) cho các thành phần 

		keyText1.setBounds(520,11,30,30);
        keyText2.setBounds(520,200,30, 30);
		encrytionbutton.setBounds(450, 81, 90, 30);
		decrytionbutton.setBounds(550,268,90,30);
		keyE.setBounds(560,11,220,30);
		keyD.setBounds(560,200,220,30);

		randomkeybt.setBounds(550, 81, 120, 30);
		text.setBounds(560,45,220,30);        
		exitButton.setBounds(700,140,60,30);

		//thêm hai nút vừa tạo vào Panel
		Panel.add(text);
		Panel.add(randomkeybt);

        
	    //tạo sự kiện sau khi click vào nút Encrytion
		
        encrytionbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
			    Bangchudon a = new Bangchudon();
			    
				try {/* 
					//thực hiện ép kiểu từ chuỗi string của Key sang kiểu int
					để kiểm tra xem Key có phải là number không 
					nếu thành công thì hiển thị lỗi và bắt người dùng nhập lại*/					   
					Integer.parseInt(keyE.getText());
   					JOptionPane.showMessageDialog(frame, "Nhập sai Key!\n Lưu ý nhập key dạng chuỗi và đủ 26 kí tự");
					keyE.setText(null);

				}catch (NumberFormatException ex ) {
					   ///
					   /// lấy độ dài key gán vào biến i và kiểm tra key có thỏa điều 
					   //kiện không nếu thỏa thì thực hiện còn không thì làm mới ô key và hiện thông báo
					playfairScreen x = new playfairScreen(null);
					String strKeyTextField = x.removeInvisibleChars(keyE.getText());
				
				    if (x.showErrorWhenInputWrong(strKeyTextField, "Key")) {
					    int n = keyE.getText().length();
					    if(n == 26){                
						    cipherText.setText(a.encrypt(plaintext.getText(),keyE.getText()));
					    }else {
						    JOptionPane.showMessageDialog(frame, "Nhập sai Key!\n nhập key có độ dài 26 kí tự");
						    keyE.setText(null);
					    }
				    }
		        }
	        }
	    });
	    
	    
    //tạo sự kiện sau khi click vào nút Encrytion
        decrytionbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
			    Bangchudon a = new Bangchudon();
				try {/* 
					//thực hiện ép kiểu từ chuỗi string của Key sang kiểu int
					để kiểm tra xem Key có phải là number không 
					nếu thành công thì hiển thị lỗi và bắt người dùng nhập lại*/					   
					Integer.parseInt(keyD.getText());
   					JOptionPane.showMessageDialog(frame, "Nhập sai Key!\n Lưu ý nhập key dạng chuỗi và đủ 26 kí tự");
					keyD.setText(null);

				}catch (NumberFormatException ex ) {
					   /// lấy độ dài key gán vào biến i và kiểm tra key có thỏa điều 
					   //kiện không nếu thỏa thì thực hiện còn không thì làm mới ô key và hiện thông báo
					    String strKeyTextField = removeInvisibleChars(keyD.getText());
				   
					    if (showErrorWhenInputWrong(strKeyTextField, "Key")) {
						    int n = keyD.getText().length();
						    if(n == 26){                
							    plaintext.setText(a.decrypt(cipherText.getText(),keyD.getText()));
						    }else {
							    JOptionPane.showMessageDialog(frame, "Nhập sai Key!\n nhập key có độ dài 26 kí tự");
							    keyD.setText(null);
						    }
					    }
				    }
				}
			});
		//sau khi nhấn nút random, hiển thị kết quả keyrandom vào hai ô text keye và keyd
		randomkeybt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				Bangchudon a = new Bangchudon();
				String s = a.randomKey();
				keyE.setText(s);
				keyD.setText(s);
			}
		});
    
	    return Panel;
	}

	
	
}
