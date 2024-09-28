import javax.swing.*;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.*;


public class doanlaptrinhmahoa {

    private static JFrame frame;
    private static JPanel panelContainer;
    private static CardLayout cardLayout;

    public doanlaptrinhmahoa() {
    // Tạo JFrame với tiêu đề
        frame = new JFrame("Đồ án Lập trình Mã hóa cổ điển");
        frame.setSize(800,600); // Đặt kích thước cho cửa sổ
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Thiết lập hành động khi đóng cửa sổ
        frame.setLocationRelativeTo(null); // Đặt cửa sổ ở giữa màn hình
        frame.setVisible(true); // Hiển thị cửa sổ
    }
//cài đặt màn hình chính 
    private static void settingMainScreen(){
        cardLayout.show(panelContainer, "MainScreen");
        frame.setTitle("Đồ án Lập trình Mã hóa cổ điển");
        frame.setSize(800,600);
    }
//tạo màn hình chính 
    private static JPanel mainScreen() {
    //xét lay out kiểu Grid cho màn hình chính 
        JPanel mainPanel = new JPanel(new GridLayout(3,3,5,5));
    //Tạo nút Ceasar
        JButton ceasarButton = new JButton("Ceasar");
        ceasarButton.addActionListener(new ActionListener() {//sự kiện sau khi click vào nut Ceasar
            @Override
            public void actionPerformed(ActionEvent e) {
            // Chuyển sang màn hình Ceasar
                cardLayout.show(panelContainer, "CeasaScreen");
            //set Title với tên Ceasar Cipher
                frame.setTitle("Ceasar Cipher");
                frame.setSize(800,400);
            }
        });
    //tạo nút mới tên bảng chữ đơn
        JButton bangChudonButton = new JButton("Bảng chữ đơn");
        bangChudonButton.addActionListener(new ActionListener() {//tạo sự kiện sau khi click vào nút
            @Override
            public void actionPerformed(ActionEvent e){
                cardLayout.show(panelContainer, "BangchudonScreen");//chhuey sang màn hình mới
                frame.setTitle("Bảng Chữ Đơn");// tên title mới
                frame.setSize(800,400);
                JOptionPane.showMessageDialog(frame, "lưu ý nhập Key Không có Khoảng trắng");//thông báo

            }
        });

    //tạo nút mới tên bảng chữ đơn
        JButton playFairButton = new JButton("PlayFair");

    //tạo nút mới tên bảng chữ đơn
        JButton vegenereButton = new JButton("Vegenere");

    //tạo nút mới tên bảng chữ đơn
        JButton chuyendichdongButton = new JButton("Chuyển dịch dòng");

    //tạo nút mới tên bảng chữ đơn
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {//Tạo sự kiện sau khi click nút Exit
            @Override
            public void actionPerformed(ActionEvent e){
        //đóng cửa sổ và Dừng chương trình 
                System.exit(0);
            }
        });
            
            
    // thêm các nút vào màn hình chính  
        mainPanel.add(ceasarButton);
        mainPanel.add(bangChudonButton);
        mainPanel.add(playFairButton);
        mainPanel.add(vegenereButton);
        mainPanel.add(chuyendichdongButton);
        mainPanel.add(exitButton);
    // trả về kiểu JPanel
        return mainPanel;
    }
//tạo màn hình mới với các chức năng của Ceasar
    private static JPanel ceasarScreen() {
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

    // sét tọa độ hiển thị (x,y,chiều rộng,chiều cao) cho các thành phần 
        plaintext.setBounds(10, 11, 500, 100);
        cipherText.setBounds(10, 200, 500, 100);
        encrytionbutton.setBounds(550,81,90,30);
        decrytionbutton.setBounds(550,268,90,30);
        keyText1.setBounds(550,11,30,30);
        keyText2.setBounds(550,200,30, 30);
        keyE.setBounds(590,11,50,30);
        keyD.setBounds(590,200,50,30);
        exitButton.setBounds(700,140,60,30);
    //Không giới hạn số lượng kí tự khi nhập vào textArea
        cipherText.setDocument(new PlainDocument()); 
        plaintext.setDocument(new PlainDocument()); 

        JScrollPane plainScrollPane = new JScrollPane(plaintext);// Tạo thanh cuộn cho plaintext
        plainScrollPane.setBounds(10, 11, 500, 100);
        JScrollPane cipherScrollPane = new JScrollPane(cipherText);// Tạo thanh cuộn cho cipherText
        cipherScrollPane.setBounds(10, 200, 500, 100);
    
        

    //tạo sự kiện sau khi click vào nút Encrytion
        encrytionbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ceasar a = new Ceasar();
                try {/* 
                    //thực hiện ép kiểu từ chuỗi string của Key sang kiểu int
                    để kiểm tra xem Key có phải là number không 
                    nếu thành công thì tiến hành gán kết quả mã hóa vào biến C 
                    và hiển thị vào Ô cipertext*/
                    Integer.parseInt(keyE.getText());                
                    String C = a.enCrytion(plaintext.getText(),Integer.parseInt(keyE.getText()));
                    cipherText.setText(C);
                } catch (NumberFormatException ex ) {
                    // hiển thị thông báo khi lỗi khi không ép kiểu thanhf công "key không phải dạnh number" 
                    JOptionPane.showMessageDialog(frame, "Nhập sai Key!\n Lưu ý nhập key dạng number");
                }
            }
        });
    //tạo sự kiện sau khi click vào nút Encrytion
        decrytionbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ceasar a = new Ceasar();
                try {/*thực hiện ép kiểu từ chuỗi string của Key sang kiểu int
                    để kiểm tra xem Key có phải là number không 
                    nếu thành công thì tiến hành gán kết quả mã hóa vào biến C 
                    và hiển thị vào Ô cipertext*/
                    Integer.parseInt(keyD.getText());                
                    String p = a.deCrytion(cipherText.getText(),Integer.parseInt(keyD.getText()));
                    plaintext.setText(p);
                } catch (NumberFormatException ex ) {
                    // hiển thị thông báo khi lỗi khi không ép kiểu thanh công "key không phải dạnh number" 
                    JOptionPane.showMessageDialog(frame, "Nhập sai Key!\n Lưu ý nhập key dạng number");
                }
            }
        });
    //taoj sự kiện cho nút exit khi click
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingMainScreen();
            }
        });
    // thêm các thành phần vào panel
        newPanel.add(plaintext); 
        newPanel.add(plainScrollPane);
        newPanel.add(cipherText);
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
// màn hình và chức năng của Bảng chữ đơn 
    public static JPanel bangChuDonScreen(){

        JPanel newPanel = new JPanel(null);
    //Khỏi tạo các thành phần
        JTextArea plaintext = new JTextArea();
        JTextArea cipherText = new JTextArea();
        JButton encrytionbutton = new JButton("Encrytion");
        JButton decrytionbutton = new JButton("Decrytion");
        JButton exitButton = new JButton("Exit");
        JLabel keyText1 = new JLabel("Key");
        JLabel keyText2 = new JLabel("Key"); 
        JTextField keyE = new JTextField();
        JTextField keyD = new JTextField();
    //sét tọa độ hiển thị  (x,y,chiều rộng,chiều cao)
        plaintext.setBounds(10, 11, 500, 100);
        cipherText.setBounds(10, 200, 500, 100);
        encrytionbutton.setBounds(550,81,90,30);
        decrytionbutton.setBounds(550,268,90,30);
        keyText1.setBounds(550,11,30,30);
        keyText2.setBounds(550,200,30, 30);
        keyE.setBounds(590,11,180,30);
        keyD.setBounds(590,200,180,30);
        exitButton.setBounds(700,140,60,30);
    //Không giới hạn số ký tự
        cipherText.setDocument(new PlainDocument()); 
        plaintext.setDocument(new PlainDocument());

        JScrollPane plainScrollPane = new JScrollPane(plaintext);// Tạo thanh cuộn cho plaintext
        plainScrollPane.setBounds(10, 11, 500, 100);
        JScrollPane cipherScrollPane = new JScrollPane(cipherText);// Tạo thanh cuộn cho cipherText
        cipherScrollPane.setBounds(10, 200, 500, 100);
    
        

    //sự kiện sau khi nhấn vào nút Encrytion
        encrytionbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Bangchudon a = new Bangchudon();
                try {/*thực hiện ép kiểu sstring sang int nếu thành công
                    tứ key không phải dạng chuỗi, thực hiện hiển thị thông báo cho người dùng */
                    Integer.parseInt(keyE.getText());                    
                    JOptionPane.showMessageDialog(frame, "Nhập sai Key!\n Lưu ý nhập key dạng String vd: \"nhaplaidi\"");
                
                } catch (NumberFormatException ex ) {
                //nếu key dạng chuỗi thì thực hiện câu lệnh
                    String C = a.enCrytion(plaintext.getText(),keyE.getText());
                    cipherText.setText(C);
                }
            }
        });
    //sự kiện sau khi nhấn vào nút Decrytion
        decrytionbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Bangchudon a = new Bangchudon();
                try {
                //Kiểm tra nếu key được nhập là một số nguyên
                    Integer.parseInt(keyD.getText());
                //hiển thị thông báo Key không đúng định dạng
                    JOptionPane.showMessageDialog(frame, "Nhập sai Key! Vui lòng nhập key dạng chuỗi.");
                } catch (NumberFormatException ex) {
                //Khi key không phải là số thực hiện giải mã
                    String p = a.deCrytion(cipherText.getText(), keyD.getText());
                    plaintext.setText(p); // Đưa kết quả giải mã vào ô plaintext
                }
            }
        });
    //sự kiện quay về màn hình chính sau khi nhấn nut exit
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingMainScreen();
            }
        });
    // thêm các thành phần vào panel
        newPanel.add(plaintext); 
        newPanel.add(plainScrollPane);
        newPanel.add(cipherText);
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
        
    public static void main(String[] args) {
        new doanlaptrinhmahoa();
        cardLayout = new CardLayout();
        panelContainer = new JPanel(cardLayout);
    
        // Tạo các màn hình 
        JPanel mainScreen = mainScreen();
        JPanel ceasarScreen = ceasarScreen();
        JPanel bangChuDonScreen = bangChuDonScreen();
    
        // Thêm các màn hình vào CardLayout
        panelContainer.add(mainScreen, "MainScreen");
        panelContainer.add(ceasarScreen, "CeasaScreen");
        panelContainer.add(bangChuDonScreen,"BangchudonScreen");
    
        // Thiết lập màn hình chính hiển thị đầu tiên
        cardLayout.show(panelContainer, "MainScreen");
    
        frame.add(panelContainer);
        frame.setVisible(true);
    }
}
