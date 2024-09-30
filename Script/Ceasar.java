package Script;

public class Ceasar {
    private int key;
    private String plaintext;
    private String ciphertext;

    public Ceasar (){
        this.key = 0;
        this.plaintext = "";
        this.ciphertext = "";
    }
    public void setKey(int k){
        if (k>=0 && k<=25) {
            this.key = k;
        }
        else {
            System.err.println("key khong dung");
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
    public String enCrytion(String plaintext,int key) {
        String ciphertext = "";
        
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
    public String deCrytion(String ciphertext,int key){
        
        return enCrytion(ciphertext, 26 - key);
    }
}

