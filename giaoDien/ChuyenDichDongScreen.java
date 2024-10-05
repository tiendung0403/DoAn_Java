package giaoDien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.PlainDocument;

import Script.ChuyenDichDong;
import Script.PlayFair;

public class ChuyenDichDongScreen extends subScreen {

	private JFrame frame;
	
	public ChuyenDichDongScreen(doanlaptrinhmahoa mainClass) {
		super(mainClass);
		frame = new JFrame();
	}
	
	@Override
	protected JPanel Screen() {
		JPanel Panel = super.Screen();
		
//set tọa độ hiển thị (x,y,chiều rộng,chiều cao) cho các thành phần 
	    
	    
	    // Key
        keyText1.setText("Key");
        keyText1.setBounds(450,100,30,30);
       
        // key Textfield
        keyE.setBounds(500,100,220,30);
	    
        // Exit Button
        exitButton.setBounds(700,230,80,30);
		
		
		
        // Thêm các thành phần mới
        JButton startBtn = new JButton("Start");
        
        // Tạo lựa chọn mã hóa hoặc giải mã
        // Tạo mảng các lựa chọn cho JComboBox
        String[] options = { "Encryption", "Decryption" };
        
        // Tạo JComboBox từ mảng các lựa chọn
        JComboBox<String> choice = new JComboBox<>(options);
        
        
        startBtn.setBounds(500, 150, 100, 30);
        choice.setBounds(610,150,100,30);
        
        
        // Thêm các thành phần mới vào
        Panel.add(startBtn);
        Panel.add(choice);
        
        
        
startBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String strPlaintext = removeInvisibleChars(plaintext.getText());
				String strCipherText = removeInvisibleChars(cipherText.getText());
				String strKeyTextField = removeInvisibleChars(keyE.getText());
				
				if (showErrorWhenInputWrong(strKeyTextField, "Key")) { // Key ko có số và kí tự đặc biệt
					
					if ("Encryption".equals((String) choice.getSelectedItem())) {
						
						if (showErrorWhenInputWrong(strPlaintext, "plaintext")) {
							
							ChuyenDichDong encryptCDD = new ChuyenDichDong(strKeyTextField, strPlaintext);
							cipherText.setText(removeInvisibleChars(encryptCDD.batDauMaHoa()));
							
						}
					}
					else if ("Decryption".equals((String) choice.getSelectedItem())) {
						
						if (showErrorWhenInputWrong(strCipherText, "ciphertext")) {
							
							ChuyenDichDong decryptCDD = new ChuyenDichDong(strKeyTextField, strCipherText);
							plaintext.setText(removeInvisibleChars(decryptCDD.batDauGiaiMa()));
						}
					}
				}
				
			}
		});
        
		return Panel;
	}
	
	
	private String removeInvisibleChars(String input) {
        return input.replaceAll("[\\p{C}]+", ""); // Loại bỏ các kí tự không thể nhìn thấy được
    }
	
	private boolean showErrorWhenInputWrong(String str, String name) {
		boolean check = true;
		if (str.trim().isEmpty()) {
    		JOptionPane.showMessageDialog(frame, "Bạn chưa nhập gì ở " + name);
    		check = false;
    	}
    	else if (str.matches(".*[^a-zA-Z0-9 ]+.*")) {
			JOptionPane.showMessageDialog(frame, "Không được kí tự đặc biệt ở " + name);
			check = false;
		}
		
		
		return check;
	}
}
