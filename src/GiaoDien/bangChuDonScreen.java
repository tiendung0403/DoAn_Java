package GiaoDien;

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

public class bangChuDonScreen extends subScreen {
	private  JFrame frame;
	private doanlaptrinhmahoa mainClass;

    public bangChuDonScreen(doanlaptrinhmahoa mainClass) {
        this.mainClass = mainClass;
    }
	
	
	@Override
	protected JPanel Screen() {
	    JPanel Panel = super.Screen();
	    
	    // Lấy các thành phần trong Panel
	    JTextArea plaintext = (JTextArea) ((JScrollPane) Panel.getComponent(0)).getViewport().getView();
	    JTextArea cipherText = (JTextArea) ((JScrollPane) Panel.getComponent(1)).getViewport().getView();
	    
	    JButton encrytionbutton = null;
	    JButton decrytionbutton = null;
	    JButton exitButton = null;
	    JLabel keyText1 = null;
	    JLabel keyText2 = null;
	    JTextField keyE = null;
	    JTextField keyD = null;

	    // Lặp qua các thành phần và kiểm tra loại
	    for (Component component : Panel.getComponents()) {
	        if (component instanceof JButton) {
	            if (encrytionbutton == null) {
	                encrytionbutton = (JButton) component;
	            } else if (decrytionbutton == null) {
	                decrytionbutton = (JButton) component;
	            } else if (exitButton == null) {
	                exitButton = (JButton) component;
	            }
	        } else if (component instanceof JLabel) {
	            if (keyText1 == null) {
	                keyText1 = (JLabel) component;
	            } else if (keyText2 == null) {
	                keyText2 = (JLabel) component;
	            }
	        } else if (component instanceof JTextField) {
	            if (keyE == null) {
	                keyE = (JTextField) component;
	            } else if (keyD == null) {
	                keyD = (JTextField) component;
	            }
	        }
	    }

	    // Ghi đè tọa độ hiển thị (x,y,chiều rộng,chiều cao) cho các thành phần 
	      plaintext.setBounds(10, 11, 500, 100);
	      cipherText.setBounds(10, 200, 500, 100);
	      encrytionbutton.setBounds(550,81,90,30);
	      decrytionbutton.setBounds(550,268,90,30);
	      keyText1.setBounds(550,11,30,30);
	      keyText2.setBounds(550,200,30, 30);
	      keyE.setBounds(590,11,180,30);
	      keyD.setBounds(590,200,180,30);
	      exitButton.setBounds(700,140,60,30);
	    
	    
	    
	    //tạo sự kiện sau khi click vào nút Encrytion
      encrytionbutton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
//              Ceasar a = new Ceasar();
//              try {/* 
//                  //thực hiện ép kiểu từ chuỗi string của Key sang kiểu int
//                  để kiểm tra xem Key có phải là number không 
//                  nếu thành công thì tiến hành gán kết quả mã hóa vào biến C 
//                  và hiển thị vào Ô cipertext*/
//                  Integer.parseInt(keyE.getText());                
//                  String C = a.enCrytion(plaintext.getText(),Integer.parseInt(keyE.getText()));
//                  cipherText.setText(C);
//              } catch (NumberFormatException ex ) {
//                  // hiển thị thông báo khi lỗi khi không ép kiểu thanhf công "key không phải dạnh number" 
//                  JOptionPane.showMessageDialog(frame, "Nhập sai Key!\n Lưu ý nhập key dạng number");
//              }
        	  JOptionPane.showMessageDialog(frame, "Bạn nhấn nút Encrypt");
          }
      });
	    
	    
    //tạo sự kiện sau khi click vào nút Encrytion
    decrytionbutton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
//            Ceasar a = new Ceasar();
//            try {/*thực hiện ép kiểu từ chuỗi string của Key sang kiểu int
//                để kiểm tra xem Key có phải là number không 
//                nếu thành công thì tiến hành gán kết quả mã hóa vào biến C 
//                và hiển thị vào Ô cipertext*/
//                Integer.parseInt(keyD.getText());                
//                String p = a.deCrytion(cipherText.getText(),Integer.parseInt(keyD.getText()));
//                plaintext.setText(p);
//            } catch (NumberFormatException ex ) {
//                // hiển thị thông báo khi lỗi khi không ép kiểu thanh công "key không phải dạnh number" 
//                JOptionPane.showMessageDialog(frame, "Nhập sai Key!\n Lưu ý nhập key dạng number");
//            }
        	JOptionPane.showMessageDialog(frame, "Bạn nhấn nút Decrypt");
        }
    });
	    
	    
	    
	 // Thêm sự kiện cho nút Exit
	    exitButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	
	        	mainClass.settingMainScreen(); // Quay về màn hình chính
	        }
	    });
	    
	    
	    return Panel;
	}

	
	
}
