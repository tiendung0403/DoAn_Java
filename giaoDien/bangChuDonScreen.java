
package giaoDien;


import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Script.Bangchudon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bangChuDonScreen extends subScreen {
	private  JPanel Panel;
	
	public bangChuDonScreen(doanlaptrinhmahoa mainClass) {
        super(mainClass); // Truyền lớp chính vào lớp cha
    }
	
	
	@Override
	protected JPanel Screen() {
	    this.Panel = super.Screen();
	    


		JButton randomkeybt = new JButton("Random Key");
		JTextField text = new JTextField("ABCDEFGHIJKLNMOPQRSTUVWXYZ");

		keyText1.setBounds(520,11,30,30);
        keyText2.setBounds(520,200,30, 30);
		encrytionbutton.setBounds(450, 81, 90, 30);
		decrytionbutton.setBounds(550,268,90,30);
		keyE.setBounds(560,11,220,30);
		keyD.setBounds(560,200,220,30);

		randomkeybt.setBounds(550, 81, 120, 30);
		text.setBounds(560,45,220,30);
		Panel.add(text);
		Panel.add(randomkeybt);
	  //set tọa độ hiển thị (x,y,chiều rộng,chiều cao) cho các thành phần 
        exitButton.setBounds(700,140,60,30);

        
        
	    //tạo sự kiện sau khi click vào nút Encrytion
		
        encrytionbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
			    Bangchudon a = new Bangchudon();
				cipherText.setText(a.encrypt(plaintext.getText(),keyE.getText()));
			}
        });
	    
	    
    //tạo sự kiện sau khi click vào nút Encrytion
        decrytionbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
			    Bangchudon a = new Bangchudon();

				plaintext.setText(a.decrypt(cipherText.getText(), keyD.getText())); // xóa kết quả cũ và Đưa kết quả mới giải mã vào ô plaintext
            }
        });

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
