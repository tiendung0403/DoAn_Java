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
        if (k>=0 && k<=25) {
            this.key = k;
        }
        else {
            //hiển thị lỗi, ném ngoaij lệ
            throw new IllegalArgumentException("Khóa không hợp lệ");       
         }
    }
    public int getKey(){
        return key;
    }
//
    public void setPlaintext(String p){
        this.plaintext = p;
    }
    public String getPlaintext(){
        return plaintext;
    }
    //
    public void setCiphertext(String c){
        this.ciphertext = c ;
    }
    public String getCiphertext(){
        return ciphertext;
    }
    //
    public String encrypt (String plaintext,int key) {
                
        for (char c: plaintext.toCharArray()) {
            if (Character.isLetter(c)) {             
                char n = (c >= 'A' && c <= 'Z') ? 'A' : 'a';
                ciphertext += (char) ((c - n + key) % 26 + n);
            }
            else ciphertext += c;
        }

        return ciphertext;
    }
    //giải mã 
    public String decrypt (String ciphertext,int key){
        
        return encrypt (ciphertext, 26 - key);
    }
}

