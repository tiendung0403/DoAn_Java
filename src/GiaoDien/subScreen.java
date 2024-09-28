package GiaoDien;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.PlainDocument;

public class subScreen {
	
	protected JPanel Screen() {
		JPanel newPanel = new JPanel(null);
		
		//khởi tạo các thành phần
      JTextArea plaintext = new JTextArea();
      JTextArea cipherText = new JTextArea();
      JButton encrytionbutton = new JButton("Encrytion");
      JButton decrytionbutton = new JButton("Decrytion");
      JButton exitButton = new JButton("Exit");
      JLabel keyText1 = new JLabel("Key");
      JLabel keyText2 = new JLabel("Key"); 
      JTextField keyE = new JTextField();
      JTextField keyD = new JTextField();
		
         //sét tọa độ hiển thị (x,y,chiều rộng,chiều cao) cho các thành phần 
        plaintext.setBounds(10, 11, 500, 100);
        cipherText.setBounds(10, 200, 500, 100);
        encrytionbutton.setBounds(550,81,90,30);
        decrytionbutton.setBounds(550,268,90,30);
        exitButton.setBounds(700,140,60,30);
        keyText1.setBounds(550,11,30,30);
        keyText2.setBounds(550,200,30, 30);
        keyE.setBounds(590,11,180,30);
        keyD.setBounds(590,200,180,30);
        
        
      //Không giới hạn số lượng kí tự khi nhập vào textArea
        cipherText.setDocument(new PlainDocument()); 
        plaintext.setLineWrap(true); // Cho phép tự động xuống hàng
        plaintext.setWrapStyleWord(true); // Tự động xuống từ hoàn chỉnh, không cắt từ
        
        plaintext.setDocument(new PlainDocument()); 
        plaintext.setLineWrap(true); // Cho phép tự động xuống hàng
        plaintext.setWrapStyleWord(true); // Tự động xuống từ hoàn chỉnh, không cắt từ
        
        JScrollPane plainScrollPane = new JScrollPane(plaintext);// Tạo thanh cuộn cho plaintext
        plainScrollPane.setBounds(10, 11, 500, 100);
        JScrollPane cipherScrollPane = new JScrollPane(cipherText);// Tạo thanh cuộn cho cipherText
        cipherScrollPane.setBounds(10, 200, 500, 100);
        
        
        
        // thêm các thành phần vào panel
        newPanel.add(plainScrollPane);
        newPanel.add(cipherScrollPane);
        newPanel.add(keyText1);
        newPanel.add(keyText2);
        newPanel.add(encrytionbutton);
        newPanel.add(decrytionbutton);
        newPanel.add(keyE);
        newPanel.add(keyD);
        newPanel.add(exitButton);
        
        
        return newPanel;
	}
	
	
}
