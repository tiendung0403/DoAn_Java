package giaoDien;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.PlainDocument;

public class subScreen {
	
	// Do các thành phần này là chủ yếu có ở các lớp con nên sẽ tạo ở đây
	// Tạo các thành phần trước ở lớp cha, set tọa độ thì ở lớp con
	protected JLabel plaintextJLabel;
    protected JLabel ciphertextJLabel;
	protected JTextArea plaintext;
    protected JTextArea cipherText;
    protected JButton encrytionbutton;
    protected JButton decrytionbutton;
    protected JButton exitButton;
    protected JLabel keyText1;
    protected JLabel keyText2;
    protected JTextField keyE;
    protected JTextField keyD;
    
	
	private JFrame frame;
    
	private doanlaptrinhmahoa mainClass;

    // Constructor nhận tham chiếu của lớp chính
    public subScreen(doanlaptrinhmahoa mainClass) {
        this.mainClass = mainClass;
    }
	
	
	protected JPanel Screen() {
		JPanel newPanel = new JPanel(null);
		
		// Khởi tạo các thành phần
		plaintextJLabel = new JLabel("Plaintext");
        ciphertextJLabel = new JLabel("Ciphertext");
        plaintext = new JTextArea();
        cipherText = new JTextArea();
        encrytionbutton = new JButton("Encrytion");
        decrytionbutton = new JButton("Decrytion");
        exitButton = new JButton("Exit");
        keyText1 = new JLabel("Key");
        keyText2 = new JLabel("Key"); 
        keyE = new JTextField();
        keyD = new JTextField();
        
        
        // Plaintext và Ciphertext sẽ luôn có mặt nên set tọa độ và kích thước ở đây
        //Không giới hạn số lượng kí tự khi nhập vào textArea
        cipherText.setDocument(new PlainDocument()); 
        plaintext.setLineWrap(true); // Cho phép tự động xuống hàng
        plaintext.setWrapStyleWord(true); // Tự động xuống từ hoàn chỉnh, không cắt từ
        
        plaintext.setDocument(new PlainDocument()); 
        plaintext.setLineWrap(true); // Cho phép tự động xuống hàng
        plaintext.setWrapStyleWord(true); // Tự động xuống từ hoàn chỉnh, không cắt từ
        
        JScrollPane plainScrollPane = new JScrollPane(plaintext);// Tạo thanh cuộn cho plaintext
        JScrollPane cipherScrollPane = new JScrollPane(cipherText);// Tạo thanh cuộn cho cipherText
        
        
        
        // set tọa độ plaintext và ciphertext
        plaintextJLabel.setBounds(10, 22, 100, 20);
	    ciphertextJLabel.setBounds(10, 182, 100, 20);
	    plainScrollPane.setBounds(10, 40, 400, 100);
	    cipherScrollPane.setBounds(10, 200, 400, 100);
	    
	    
        
        // thêm các thành phần vào panel
        newPanel.add(plainScrollPane);
        newPanel.add(cipherScrollPane);
        newPanel.add(encrytionbutton);
        newPanel.add(decrytionbutton);
        newPanel.add(exitButton);
        newPanel.add(keyText1);
        newPanel.add(keyText2);
        newPanel.add(keyE);
        newPanel.add(keyD);
        newPanel.add(plaintextJLabel);
        newPanel.add(ciphertextJLabel);
        
        // Nút exit trở màn hình chính cho tất cả các class kế thừa
	    exitButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	plaintext.setText(null);
	        	cipherText.setText(null);
	        	keyE.setText(null);
	        	keyD.setText(null);
	        	
	        	mainClass.settingMainScreen(); // Quay về màn hình chính
	        }
	    });
        
        
        return newPanel;
	}
	
	protected String removeInvisibleChars(String input) {
        return input.replaceAll("[\\p{C}]+", ""); // Loại bỏ các kí tự không thể nhìn thấy được
    }
	
	// Kiểm tra lỗi ở các thành phần giao diện, ở Key, Plaintext, Ciphertext
	protected boolean showErrorWhenInputWrong(String str, String name) {
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
