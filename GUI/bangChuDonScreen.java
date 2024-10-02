import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Script.Bangchudon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bangChuDonScreen extends subScreen {
	private  JPanel Panel;
	
	public bangChuDonScreen(doanlaptrinhmahoa mainClass) {
        super(mainClass); // Truyền lớp chính vào lớp cha
    }
	
	
	@Override
	protected JPanel Screen() {
	    this.Panel = super.Screen();
	    
	    // Lấy các thành phần trong Panel
	    JTextArea plaintext = (JTextArea) ((JScrollPane) Panel.getComponent(0)).getViewport().getView();
	    JTextArea cipherText = (JTextArea) ((JScrollPane) Panel.getComponent(1)).getViewport().getView();
	    
		JButton encrybutton = (JButton) Panel.getComponent(2);
		JButton decrybutton = (JButton) Panel.getComponent(3);
		JTextField keyE = (JTextField) Panel.getComponent(7);
		JTextField keyD = (JTextField) Panel.getComponent(8);
		JLabel keyText1 = (JLabel) Panel.getComponent(5);
        JLabel keyText2 = (JLabel) Panel.getComponent(6); 

		JButton randomkeybt = new JButton("Random Key");
		JTextField text = new JTextField("ABCDEFGHIJKLNMOPQRSTUVWXYZ");
        
		keyText1.setBounds(520,11,30,30);
        keyText2.setBounds(520,200,30, 30);
		encrybutton.setBounds(450, 81, 90, 30);
		randomkeybt.setBounds(550, 81, 120, 30);
		keyE.setBounds(560,11,220,30);
		keyD.setBounds(560,200,220,30);
		text.setBounds(560,45,220,30);
		Panel.add(text);
		Panel.add(randomkeybt);

	    //tạo sự kiện sau khi click vào nút Encrytion
		
        encrybutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
			    Bangchudon a = new Bangchudon();
				cipherText.setText(a.encrypt(plaintext.getText(),keyE.getText()));
			}
        });
	    
	    
    //tạo sự kiện sau khi click vào nút Encrytion
        decrybutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
			    Bangchudon a = new Bangchudon();

				plaintext.setText(a.decrypt(cipherText.getText(), keyD.getText())); // xóa kết quả cũ và Đưa kết quả mới giải mã vào ô plaintext
            }
        });

		randomkeybt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				Bangchudon a = new Bangchudon();
				String s = a.randomKey();
				keyE.setText(s);
				keyD.setText(s);
			}
		});
    
	    return Panel;
	}

	
	
}
