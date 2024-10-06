package giaoDien;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import Script.ChuyenDichDong;

public class ChuyenDichDongScreen extends subScreen {

	
	public ChuyenDichDongScreen(doanlaptrinhmahoa mainClass) {
		super(mainClass);
	}
	
	@Override
	protected JPanel Screen() {
		JPanel Panel = super.Screen();
		
        // Thêm các thành phần mới
        JButton startBtn = new JButton("Start");
        
        // Tạo lựa chọn mã hóa hoặc giải mã
        // Tạo mảng các lựa chọn cho JComboBox
        String[] options = { "Encryption", "Decryption" };
        
        // Tạo JComboBox từ mảng các lựa chọn
        JComboBox<String> choice = new JComboBox<>(options);
        
        
        
        //set tọa độ hiển thị (x,y,chiều rộng,chiều cao) cho các thành phần 
		
	    // Key
        keyText1.setText("Key");
        keyText1.setBounds(450,100,30,30);
       
        // key Textfield
        keyE.setBounds(500,100,220,30);
	    
        // Exit Button
        exitButton.setBounds(700,230,80,30);
        
        
        startBtn.setBounds(500, 150, 100, 30);
        choice.setBounds(610,150,100,30);
        
        
        // Thêm các thành phần mới vào
        Panel.add(startBtn);
        Panel.add(choice);
        
        
        
        startBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Tạo biến và loại bỏ các kí tự không thể nhìn thấy
				String strPlaintext = removeInvisibleChars(plaintext.getText());
				String strCipherText = removeInvisibleChars(cipherText.getText());
				String strKeyTextField = removeInvisibleChars(keyE.getText());
				
				if (showErrorWhenInputWrong(strKeyTextField, "Key")) { // Kiểm tra Key ko có kí tự đặc biệt
					
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
	
}
