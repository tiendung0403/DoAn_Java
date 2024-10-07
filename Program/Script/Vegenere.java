package Script;

//kế thừa các chức năng của lớp Bangchudon
public class Vegenere extends Bangchudon {

    private String plaintext, ciphertext,key;

    public Vegenere(){
        this.plaintext = "";
        this.key = "";
        this.ciphertext = "";
    }
    //tạo getting và setting cho các khóa
    public void setPlaintext(String p){
        this.plaintext = standardizingKey(p.toCharArray());
    }
    public String getPlaintext(){
        return this.plaintext;
    }
    public void setCiphertext(String c){
        this.ciphertext = standardizingKey(c.toCharArray());
    }
    public String getCiphertext(){
        return this.ciphertext;
    }
    public void setKey(String k){
        this.key = standardizingKey(k.toCharArray());
    }
    public String getKey(){
        return this.key;
    }
    //hàm mã hóa 
    public String encrypt(String plt,String k){
        ciphertext = "";
        int keyLen = k.length();//lấy độ dài của khóa
        int keyIndex = 0;//khởi tạo vị trí ban đầu của kí tự trong khóa
        setPlaintext(plt);
        plt = getPlaintext();
        setKey(k);
        k = getKey();
        //tạo vằng lặp, lặp qua từng kí tự của bản rõ 
        for (char c: plt.toCharArray()) {
            if ( c >= 'A' && c <= 'Z') {
                //thực hiện phép tính chia lấy dư theo khóa 
                //để lấy lần lượt từng kí tự trong khóa và liên tục lặp lại đến hết độ dài của Bản rõ
                char keynew = k.charAt(keyIndex % keyLen);
                keynew -= 'A';//trừ đi A để lấy vị trí trong bảng chữ cái
                ciphertext += (char) ((c - 'A' + keynew) % 26 + 'A');
                keyIndex++;
            }
            else ciphertext += c;//cộng dồn những kí tự không phải chữ cái
        }
        return ciphertext;
    }


    public String decrypt(String cpt, String k){
        plaintext = "";
        int keyLen = k.length();//lấy độ dài của khóa
        int keyIndex = 0;//khởi tạo vị trí ban đầu của kí tự trong khóa
        setCiphertext(cpt);
        cpt = getCiphertext();
        setKey(k);
        k = getKey();
//tạo vằng lặp, lặp qua từng kí tự của bản mã hóa
        for (char c: cpt.toCharArray()) {
            if ( c >= 'A' && c <= 'Z') {
                //thực hiện phép tính chia lấy dư theo khóa 
                //để lấy lần lượt từng kí tự trong khóa và liên tục lặp lại đến hết độ dài của Bản mã hóa
                char keynew = k.charAt(keyIndex % keyLen);
                keynew -= 'A';//trừ đi A để lấy vị trí trong bảng chữ cái
                plaintext += (char)((c - 'A' - keynew + 26) % 26 + 'A');//nếu phép tính ra số âm thì cộng thêm 26 để ra vị trí trong bảng chữ cái 
                keyIndex++;
                
            }
            else plaintext += c;
        }
        return plaintext;

    }
    //hàm tạo mới có độ dài bằng chuỗi đưa vào
    public String newKey(String s, String k){
        String temp = "";
        int keyLen= k.length();
        int keyIndex = 0;
        setCiphertext(s);
        s = getCiphertext();
        setKey(k);
        k = getKey();

        for (char c: s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                //phép tính chia lấy dư để lấy vị trí kí tự trong khóa 
                //và lặp đi lặp lại cho đến khi key có độ dài bằng với chuỗi s
                char keynew = (k.charAt(keyIndex % keyLen));
                temp += keynew;
                keyIndex++;
            }

        
        }
        //trả về khóa mới
        return temp;
    }
}
