package giaoDien;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.PlainDocument;

public class subScreen {
	
	protected JTextArea plaintext;
    protected JTextArea cipherText;
    protected JButton encrytionbutton;
    protected JButton decrytionbutton;
    protected JButton exitButton;
    protected JLabel keyText1;
    protected JLabel keyText2;
    protected JTextField keyE;
    protected JTextField keyD;
	
	
	
	private doanlaptrinhmahoa mainClass;

    // Constructor nhận tham chiếu của lớp chính
    public subScreen(doanlaptrinhmahoa mainClass) {
        this.mainClass = mainClass;
    }
	
	
	protected JPanel Screen() {
		JPanel newPanel = new JPanel(null);
		
		//khởi tạo các thành phần
        plaintext = new JTextArea();
        cipherText = new JTextArea();
        encrytionbutton = new JButton("Encrytion");
        decrytionbutton = new JButton("Decrytion");
        exitButton = new JButton("Exit");
        keyText1 = new JLabel("Key");
        keyText2 = new JLabel("Key"); 
        keyE = new JTextField();
        keyD = new JTextField();
		
        
        
        
      //Không giới hạn số lượng kí tự khi nhập vào textArea
        cipherText.setDocument(new PlainDocument()); 
        plaintext.setLineWrap(true); // Cho phép tự động xuống hàng
        plaintext.setWrapStyleWord(true); // Tự động xuống từ hoàn chỉnh, không cắt từ
        
        plaintext.setDocument(new PlainDocument()); 
        plaintext.setLineWrap(true); // Cho phép tự động xuống hàng
        plaintext.setWrapStyleWord(true); // Tự động xuống từ hoàn chỉnh, không cắt từ
        
        JScrollPane plainScrollPane = new JScrollPane(plaintext);// Tạo thanh cuộn cho plaintext
        plainScrollPane.setBounds(10, 11, 400, 100);
        JScrollPane cipherScrollPane = new JScrollPane(cipherText);// Tạo thanh cuộn cho cipherText
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
        
        // Nút exit trở màn hình chính cho tất cả các class kế thừa
	    exitButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	
	        	mainClass.settingMainScreen(); // Quay về màn hình chính
	        }
	    });
        
        
        return newPanel;
	}
	
	
}
