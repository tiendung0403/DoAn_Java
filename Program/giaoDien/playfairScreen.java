package giaoDien;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import Script.PlayFair;

public class playfairScreen extends subScreen {

	
	
	public playfairScreen(doanlaptrinhmahoa mainClass) {
		super(mainClass); // Truyền lớp chính vào lớp cha
	}

	@Override
	protected JPanel Screen() {
	    JPanel Panel = super.Screen();

        // Thêm các thành phần mới
        
        
        // Button generate
        JButton generateBtn = new JButton("Generate Key");
        JButton startBtn = new JButton("Start");
        
        // Tạo lựa chọn mã hóa hoặc giải mã
        // Tạo mảng các lựa chọn cho JComboBox
        String[] options = { "Encryption", "Decryption" };
        
        // Tạo JComboBox từ mảng các lựa chọn
        JComboBox<String> choice = new JComboBox<>(options);
        
        
        //set tọa độ hiển thị (x,y,chiều rộng,chiều cao) cho các thành phần 
	    
	    // Key & Key generation
        keyText1.setText("Key");
        keyText1.setBounds(450,11,30,30);
        keyText2.setText("Key generation");
        keyText2.setBounds(450,50,85,30);
       
        
        keyE.setBounds(540,11,220,30); // key Textfield
        keyD.setBounds(540,50,220,30); // key generation Textfield
	    //keyD.setEnabled(false); // Không cho chỉnh sửa ở key generation
	    keyD.setEditable(false);
	    
        exitButton.setBounds(700,230,80,30);
        
        
        generateBtn.setBounds(630, 85, 130, 25);
        startBtn.setBounds(500, 150, 100, 30);
        choice.setBounds(610,150,100,30);
        
        
        // Thêm các thành phần mới vào
        Panel.add(generateBtn);
        Panel.add(startBtn);
        Panel.add(choice);
        

        // Kiểm tra key và xuất ra key generation
        generateBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String strKeyTextField = removeInvisibleChars(keyE.getText()); // Loại bỏ các kí tự đặc biệt không thể nhìn thấy
				
				if (showErrorWhenInputWrong(strKeyTextField, "Key")) { // Kiểm tra người dùng nhập key, tránh nhập số và kí tự đặc biệt
					PlayFair pF = new PlayFair();
					pF.setKey(strKeyTextField);
					
					keyD.setText(pF.xuatArr());
				}
			}
		});
        

        startBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Tạo biến và lưu các giá trị được loại bỏ các kí tự đặc biệt không nhìn thấy được
				String strPlaintext = removeInvisibleChars(plaintext.getText());
				String strCipherText = removeInvisibleChars(cipherText.getText());
				String strKeyTextField = removeInvisibleChars(keyE.getText());
				
				if (showErrorWhenInputWrong(strKeyTextField, "Key")) { // Key ko có số và kí tự đặc biệt
					
					if ("Encryption".equals((String) choice.getSelectedItem())) { // Nếu combobox chọn Encryption
						
						if (showErrorWhenInputWrong(strPlaintext, "plaintext")) { // Plaintext không có số và kí tự đặc biệt
							
							PlayFair EncryptpF = new PlayFair(strKeyTextField, strPlaintext);
							cipherText.setText(removeInvisibleChars(EncryptpF.batDauMaHoa()));
							
						}
					}
					else if ("Decryption".equals((String) choice.getSelectedItem())) { // Nếu combobox chọn Decryption
						
						if (showErrorWhenInputWrong(strCipherText, "ciphertext")) { // Ciphertext không có số và kí tự đặc biệt
							
							PlayFair DecryptpF = new PlayFair(strKeyTextField, strCipherText);
							plaintext.setText(removeInvisibleChars(DecryptpF.batDauGiaiMa()));
						}
					}
				}
				
			}
		});
        

	    return Panel;
	}
	
}
