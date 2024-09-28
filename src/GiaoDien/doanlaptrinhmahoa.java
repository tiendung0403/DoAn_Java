package GiaoDien;

import GiaoDien.*;

import javax.swing.*;
import javax.swing.text.PlainDocument;

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
    	// Chuyển sang màn hình Ceasar
        cardLayout.show(panelContainer, screen);
    //set Title với tên Ceasar Cipher
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
        
    //Tạo nút Ceasar
        JButton ceasarButton = new JButton("Ceasar");
        ceasarButton.addActionListener(new ActionListener() {//sự kiện sau khi click vào nut Ceasar
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen("CeasarScreen", "Ceasar Cipher", false, "");
            }
        });
        
        
    //tạo nút mới tên bảng chữ đơn
        JButton bangChudonButton = new JButton("Bảng chữ đơn");
        bangChudonButton.addActionListener(new ActionListener() {//tạo sự kiện sau khi click vào nút
            @Override
            public void actionPerformed(ActionEvent e){
                changeScreen("BangchudonScreen", "Bảng Chữ Đơn", true, "lưu ý nhập Key Không có Khoảng trắng");
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
    private JPanel ceasar() {
    	JPanel cS = new ceasarScreen(this).Screen();
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
        JPanel ceasarScreen = ceasar();
        JPanel bangChuDonScreen = bangChuDonScr();
    
        // Thêm các màn hình vào CardLayout
        panelContainer.add(mainScreen, "MainScreen");
        panelContainer.add(ceasarScreen, "CeasarScreen");
        panelContainer.add(bangChuDonScreen,"BangchudonScreen");
    
        // Thiết lập màn hình chính hiển thị đầu tiên
        cardLayout.show(panelContainer, "MainScreen");
    
        frame.add(panelContainer);
        frame.setVisible(true);
        
        
    }
    

}
