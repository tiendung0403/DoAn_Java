import javax.swing.*;
import java.awt.event.*;
import Script.Vegenere;

public class vegenereScreen extends subScreen {
	private  JFrame frame;
	
	public vegenereScreen(doanlaptrinhmahoa mainClass) {
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
		JTextField keyNew = new JTextField();

		keyNew.setBounds(590,45,180,30);
		JLabel keygeneration = new JLabel("Key generation");
		keygeneration.setBounds(490,45,90,30);
		Panel.add(keyNew);
		Panel.add(keygeneration);

	    //tạo sự kiện sau khi click vào nút Encrytion
        encrytionbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
			    Vegenere a = new Vegenere();
			    try {/*thực hiện ép kiểu sstring sang int nếu thành công
				tứ key không phải dạng chuỗi, thực hiện hiển thị thông báo loi*/
				    Integer.parseInt(keyE.getText());                    
				    JOptionPane.showMessageDialog(frame, "Nhập sai Key!\n Lưu ý nhập key dạng String vd: \"nhaplaidi\"");
			
			    } catch (NumberFormatException ex ) {
			//nếu key dạng chuỗi thì thực hiện câu lệnh
				    String C = a.encrypt(plaintext.getText(),keyE.getText());
				    cipherText.setText(C);
					keyNew.setText(a.newKey(plaintext.getText(),keyE.getText()));
			    }
            }
        });
	    
	    
    //tạo sự kiện sau khi click vào nút Encrytion
        decrytionbutton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
			Vegenere a = new Vegenere();
			try {
			//Kiểm tra nếu key được nhập là một số nguyên
			    Integer.parseInt(keyD.getText());
				JOptionPane.showMessageDialog(frame, "Nhập sai Key! Vui lòng nhập key dạng chuỗi kí tự.");
			//hiển thị thông báo Key không đúng
			} catch (NumberFormatException ex) {
			//Khi key không phải là số thực hiện giải mã
				String p = a.decrypt(cipherText.getText(), keyD.getText());
				plaintext.setText(p); // xóa kết quả cũ và Đưa kết quả mới giải mã vào ô plaintext
				keyNew.setText(a.newKey(cipherText.getText(),keyD.getText()));

			}
        }
    });
    
	    return Panel;
	}

	
	
}

