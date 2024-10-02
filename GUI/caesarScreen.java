

import java.awt.Component;

import javax.swing.JButton;
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
	    
	    // Lấy các thành phần trong Panel
	    JTextArea plaintext = (JTextArea) ((JScrollPane) Panel.getComponent(0)).getViewport().getView();
	    JTextArea cipherText = (JTextArea) ((JScrollPane) Panel.getComponent(1)).getViewport().getView();
	    
		JButton encrytionbutton = (JButton) Panel.getComponent(2);
		JButton decrytionbutton = (JButton) Panel.getComponent(3);
		JTextField keyE = (JTextField) Panel.getComponent(7);
		JTextField keyD = (JTextField) Panel.getComponent(8);

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
