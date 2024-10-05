package giaoDien;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Script.PlayFair;

public class playfairScreen extends subScreen {

	private  JFrame frame;
	
	
	public playfairScreen(doanlaptrinhmahoa mainClass) {
		super(mainClass); // Truyền lớp chính vào lớp cha
		frame = new JFrame();
	}

	@Override
	protected JPanel Screen() {
	    JPanel Panel = super.Screen();

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
        
        
        // Thêm các thành phần mới
        
        
        // Button generate
        JButton generateBtn = new JButton("Generate Key");
        JButton startBtn = new JButton("Start");
        
        // Tạo lựa chọn mã hóa hoặc giải mã
        // Tạo mảng các lựa chọn cho JComboBox
        String[] options = { "Encryption", "Decryption" };
        
        // Tạo JComboBox từ mảng các lựa chọn
        JComboBox<String> choice = new JComboBox<>(options);
        
        
        
        generateBtn.setBounds(630, 85, 130, 25);
        startBtn.setBounds(500, 150, 100, 30);
        choice.setBounds(610,150,100,30);
        
        
        // Thêm các thành phần mới vào
        Panel.add(generateBtn);
        Panel.add(startBtn);
        Panel.add(choice);
        

        generateBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String strKeyTextField = removeInvisibleChars(keyE.getText());
				
				if (showErrorWhenInputWrong(strKeyTextField, "Key")) {
					PlayFair pF = new PlayFair();
					pF.setKey(strKeyTextField);
					
					keyD.setText(pF.xuatArr());
				}
				
				
				
			}
		});
        

        startBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String strPlaintext = removeInvisibleChars(plaintext.getText());
				String strCipherText = removeInvisibleChars(cipherText.getText());
				String strKeyTextField = removeInvisibleChars(keyE.getText());
				
				if (showErrorWhenInputWrong(strKeyTextField, "Key")) { // Key ko có số và kí tự đặc biệt
					
					if ("Encryption".equals((String) choice.getSelectedItem())) {
						
						if (showErrorWhenInputWrong(strPlaintext, "plaintext")) {
							
							PlayFair EncryptpF = new PlayFair(strKeyTextField, strPlaintext);
							cipherText.setText(removeInvisibleChars(EncryptpF.batDauMaHoa()));
							
						}
							
						
						
					}
					else if ("Decryption".equals((String) choice.getSelectedItem())) {
						
						if (showErrorWhenInputWrong(strCipherText, "ciphertext")) {
							
							PlayFair DecryptpF = new PlayFair(strKeyTextField, strCipherText);
							plaintext.setText(removeInvisibleChars(DecryptpF.batDauGiaiMa()));
							
							
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
    	else if (str.matches(".*[^a-zA-Z ]+.*")) {
			JOptionPane.showMessageDialog(frame, "Không được nhập số hoặc kí tự đặc biệt ở " + name);
			check = false;
		}
		
		
		return check;
	}
}
