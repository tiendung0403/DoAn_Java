package Script;

public class Caesar {
    private int key;
    private String plaintext;
    private String ciphertext;

    public Caesar (){
        this.key = 0;
        this.plaintext = "";
        this.ciphertext = "";
    }

    public void setKey(int k){
            this.key = k;
    }
    public int getKey(){
        return this.key;
    }
//
    public void setPlaintext(String p){
        this.plaintext = p;
    }
    public String getPlaintext(){
        return this.plaintext;
    }
    //
    public void setCiphertext(String c){
        this.ciphertext = c ;
    }
    public String getCiphertext(){
        return this.ciphertext;
    }
    //
    public String encrypt (String plaintext,int key) {
                
        for (char c: plaintext.toCharArray()) {
            if (Character.isLetter(c)) {             
                char n = (c >= 'A' && c <= 'Z') ? 'A' : 'a';
                // nếu biến n nằm trong khoảng của chữ in thì chả về biến n chũ in
                // còn ko đúng thì chả về chữ thường
                ciphertext += (char) ((c - n + key) % 26 + n);// thực hiện phép chia lấy dư 
            }
            else ciphertext += c;
        }

        return ciphertext;
    }
    //giải mã 
    public String decrypt (String ciphertext,int key){
        //tận dụng lại hàm mã hóa truyền vào hàm mã hóa với số key còn lại, 
        //khi đó hàm mã hóa sẽ mã hóa tiếp và quay lại kí tự ban đầu theo chiều kim đồng hồ
        return encrypt (ciphertext, 26 - key);
    }
}

