package Script;

import java.util.Random;

public class Bangchudon {

    private String plaintext, ciphertext,key;

    public Bangchudon(){
        this.plaintext = "";
        this.key = "";
        this.ciphertext = "";
    }

    public void setPlaintext(String p){
        this.plaintext = p.toUpperCase();
    }
    public String getPlaintext(){
        return this.plaintext;
    }
    public void setCiphertext(String c){
        this.ciphertext = c.toUpperCase();
    }
    public String getCiphertext(){
        return this.ciphertext;
    }
    public void setKey(String k){
        this.key = standardizingKey(k.toCharArray());
        
    }
    //hàm chuẩn hóa chuỗi loại bỏ các kí tự không phải chữ cái và chả về chuối IN hoa
    public String standardizingKey(char[] k){
        String temp = new String();
        for(char c : k){
            if((c>='a'&& c<='z') || (c>='A' && c<='Z')){
                temp += c;
            }
        }
        return temp.toUpperCase();
    }
    public String getKey(){
        return this.key;
    }

    public String encrypt (String plt,String k){
        ciphertext = "";
        setPlaintext(plt);
        plt = getPlaintext();
        setKey(k);
        k= getKey();
        //
        //tọa vòng lặp với Plaintext nếu c nằm trong khoảng điều kiện thif lấy biến c - A ĐỂ RA 
        //vị trí của bảng mã từ 0 -> 25
        //sau đó lấy vị trí vừa tính để lấy khóa thay thế tại key thêm vào ciphertext
        //

        for (char c: plt.toCharArray()) {
            if ( c >= 'A' && c <= 'Z') {
                int i = (int)( c - 'A');
                ciphertext += k.charAt(i);
            }
            else ciphertext += c;
        }
        return ciphertext;
    }


    public String decrypt (String cpt, String k){
        plaintext = "";
        setCiphertext(cpt);
        cpt = getCiphertext();
        setKey(k);
        k= getKey();

        //khỏi tạo vòng lặp for với biến char, số vòng theo độ dài của ciphertext
        for(char c : cpt.toCharArray()){
            //sét điều kiện cho biến c
            if(c >= 'A' && c <= 'Z'){
                //tạo vòng for với key chạy 26 lần để tìm khóa == biến c
                for ( int i = 0; i < 26 ; i++ ){
                    if(c == k.charAt(i)){// nếu đúng thì lấy vị trí của khóa cộng với "A" để ra bản rõ 
                        plaintext += (char) (i +'A');
                    }
                }
            }
            else plaintext += c;
        }
        return plaintext;
       
    } 
    //hàm hoán đổi vị trí 
    public void swap(char[] c,int a,int b){
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }
    // hàm tạo Bảng mã sau đó đảo các kí tự tại các vị trí bất kì để ra key random với 26 kí tự
    public String randomKey(){
            Random rdk = new Random();
            char[] c = new char[26];

            for(int i = 0 ; i <26 ; i++){
                c[i] = (char) (i + 'A');
            }
            for(int i = 0 ; i <26 ; i++){
                swap(c, i, rdk.nextInt(26));
            }
            return new String(c);
    }
    
}
