package giaoDien;
import javax.swing.*;
import java.awt.event.*;
import Script.Vegenere;

public class vegenereScreen extends subScreen {
	private  JFrame frame;
	
	public vegenereScreen(doanlaptrinhmahoa mainClass) {
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
	    
		
        
        // Thêm các thành phần
		JTextField keyNew = new JTextField();
		keyNew.setBounds(590,45,180,30);
		JLabel keygeneration = new JLabel("Key generation");
		keygeneration.setBounds(490,45,90,30);
		keyNew.setEditable(false);
		
		Panel.add(keyNew);
		Panel.add(keygeneration);
		
		

	    //tạo sự kiện sau khi click vào nút Encrytion
        encrytionbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
			    Vegenere a = new Vegenere();
				try {/* 
					//thực hiện ép kiểu từ chuỗi string của Key sang kiểu int
					để kiểm tra xem Key có phải là number không 
					nếu thành công thì hiển thị lỗi và bắt người dùng nhập lại*/					   
					Integer.parseInt(keyE.getText());
   					JOptionPane.showMessageDialog(frame, "Nhập sai Key!\n Lưu ý nhập key dạng chuỗi");
					keyE.setText(null);

				}catch (NumberFormatException ex ) {
					   ///
					playfairScreen x = new playfairScreen(null);
					String strKeyTextField = x.removeInvisibleChars(keyE.getText());
				
				    if (x.showErrorWhenInputWrong(strKeyTextField, "Key")) {
						    cipherText.setText(a.encrypt(plaintext.getText(),strKeyTextField));
							keyNew.setText(a.newKey(plaintext.getText(),strKeyTextField));
					    }
				    }
		        }
        });
	    
	    
    //tạo sự kiện sau khi click vào nút Encrytion
        decrytionbutton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
			Vegenere a = new Vegenere();
			try {/* 
				//thực hiện ép kiểu từ chuỗi string của Key sang kiểu int
				để kiểm tra xem Key có phải là number không 
				nếu thành công thì hiển thị lỗi và bắt người dùng nhập lại*/					   
				Integer.parseInt(keyD.getText());
				JOptionPane.showMessageDialog(frame, "Nhập sai Key!\n Lưu ý nhập key dạng chuỗi");
				keyD.setText(null);

			}catch (NumberFormatException ex ) {
				   ///
				playfairScreen x = new playfairScreen(null);
				String strKeyTextField = x.removeInvisibleChars(keyD.getText());
			
				if (x.showErrorWhenInputWrong(strKeyTextField, "Key")) {
						plaintext.setText(a.decrypt(cipherText.getText(),strKeyTextField));
						keyNew.setText(a.newKey(cipherText.getText(),strKeyTextField));
					}
				}
			}
});
    
	    return Panel;
	}

	
	
}

