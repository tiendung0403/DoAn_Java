package giaoDien;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Script.Bangchudon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bangChuDonScreen extends subScreen {
	private  JFrame frame;
	
	public bangChuDonScreen(doanlaptrinhmahoa mainClass) {
        super(mainClass); // Truyền lớp chính vào lớp cha
    }
	
	
	@Override
	protected JPanel Screen() {
	    JPanel Panel = super.Screen();
	    
	  //set tọa độ hiển thị (x,y,chiều rộng,chiều cao) cho các thành phần 
        plaintext.setBounds(10, 11, 400, 100);
        cipherText.setBounds(10, 200, 400, 100);
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
			    Bangchudon a = new Bangchudon();
			    try {/*thực hiện ép kiểu sstring sang int nếu thành công
				tứ key không phải dạng chuỗi, thực hiện hiển thị thông báo loi*/
				    Integer.parseInt(keyE.getText());                    
				    JOptionPane.showMessageDialog(frame, "Nhập sai Key!\n Lưu ý nhập key dạng String vd: \"nhaplaidi\"");
			
			    } catch (NumberFormatException ex ) {
			//nếu key dạng chuỗi thì thực hiện câu lệnh
				    String C = a.encrypt(plaintext.getText(),keyE.getText());
				    cipherText.setText(C);
			    }
            }
        });
	    
	    
    //tạo sự kiện sau khi click vào nút Encrytion
        decrytionbutton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
			Bangchudon a = new Bangchudon();
			try {
			//Kiểm tra nếu key được nhập là một số nguyên
				Integer.parseInt(keyD.getText());
			//hiển thị thông báo Key không đúng
				JOptionPane.showMessageDialog(frame, "Nhập sai Key! Vui lòng nhập key dạng chuỗi.");
			} catch (NumberFormatException ex) {
			//Khi key không phải là số thực hiện giải mã
				String p = a.decrypt(cipherText.getText(), keyD.getText());
				plaintext.setText(p); // xóa kết quả cũ và Đưa kết quả mới giải mã vào ô plaintext
			}
        }
    });
    
	    return Panel;
	}

	
	
}
