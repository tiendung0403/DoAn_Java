import javax.swing.*;


import java.awt.*;
import java.awt.event.*;


public class doanlaptrinhmahoa {

    private  JFrame frame;
    private  JPanel panelContainer;
    private  CardLayout cardLayout;

    public doanlaptrinhmahoa() {
    // Tạo JFrame với tiêu đề
        frame = new JFrame("Đồ án Lập trình Mã hóa cổ điển");
        frame.setSize(800,600); // Đặt kích thước cho cửa sổ
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Thiết lập hành động khi đóng cửa sổ
        frame.setLocationRelativeTo(null); // Đặt cửa sổ ở giữa màn hình
        frame.setVisible(true); // Hiển thị cửa sổ
    }
    
//cài đặt màn hình chính 
    protected void settingMainScreen(){
        cardLayout.show(panelContainer, "MainScreen");
        frame.setTitle("Đồ án Lập trình Mã hóa cổ điển");
        frame.setSize(800,600);
    }
    
    //												Đặt tựa đề	  Có note không ?   Note (nếu có)
    private void changeScreen(String screen, String title, Boolean haveNote, String note) {
    	// Chuyển sang màn hình Caesar
        cardLayout.show(panelContainer, screen);
    //set Title với tên Caesar Cipher
        frame.setTitle(title);
        frame.setSize(800,400);
        
        if (haveNote == true) {
        	JOptionPane.showMessageDialog(frame, note);
        }
    }
    
//tạo màn hình chính 
    private JPanel mainScreen() {
    //xét lay out kiểu Grid cho màn hình chính 
        JPanel mainPanel = new JPanel(new GridLayout(3,3,5,5));
        
    //Tạo nút Caesar
        JButton ceasarButton = new JButton("Caesar");
        ceasarButton.addActionListener(new ActionListener() {//sự kiện sau khi click vào nut Caesar
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen("CaesarScreen", "Caesar Cipher", true, "Nhập key từ 0 đến 25 oke!!!!!");
            }
        });
        
        
    //tạo nút mới tên bảng chữ đơn
        JButton bangChudonButton = new JButton("Bảng chữ đơn");
        bangChudonButton.addActionListener(new ActionListener() {//tạo sự kiện sau khi click vào nút
            @Override
            public void actionPerformed(ActionEvent e){
                changeScreen("BangchudonScreen", "Bảng Chữ Đơn", false, "");
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

    
    
    
    //tạo màn hình mới với các chức năng của Caesar
    private JPanel caesar() {
    	JPanel cS = new caesarScreen(this).Screen();
    	return cS;
    }
    
    
// màn hình và chức năng của Bảng chữ đơn 
    public JPanel bangChuDonScr(){
    	JPanel bCDC = new bangChuDonScreen(this).Screen();
    	return bCDC;
    }
        
    
    
    public void start() {
    	cardLayout = new CardLayout();
        panelContainer = new JPanel(cardLayout);
    
        // Tạo các màn hình 
        JPanel mainScreen = mainScreen();
        JPanel caesarScreen = caesar();
        JPanel bangChuDonScreen = bangChuDonScr();
    
        // Thêm các màn hình vào CardLayout
        panelContainer.add(mainScreen, "MainScreen");
        panelContainer.add(caesarScreen, "CaesarScreen");
        panelContainer.add(bangChuDonScreen,"BangchudonScreen");
    
        // Thiết lập màn hình chính hiển thị đầu tiên
        cardLayout.show(panelContainer, "MainScreen");
    
        frame.add(panelContainer);
        frame.setVisible(true);
    }
}
