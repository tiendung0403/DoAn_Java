package Script;

public class Bangchudon {

    private String plaintext, ciphertext,key;

    public Bangchudon(){
        this.plaintext = "";
        this.key = "";
        this.ciphertext = "";
    }

    public void setPlaintext(String p){
        this.plaintext = p;
    }
    public String getPlaintext(){
        return plaintext;
    }
    public void setCiphertext(String c){
        this.ciphertext = c;
    }
    public String getCiphertext(){
        return ciphertext;
    }
    public void setKey(String k){
        this.key = "";
        for(char c : k.toCharArray()){
            if(( c >= 'a' && c <= 'z' ) || ( c >= 'A' && c <= 'Z' )){
                this.key += c;
            }
        }
    }
    public String getKey(){
        return key;
    }
    public String encrypt (String plaintext,String key){
        ciphertext = "";
        int keyLen = key.length();
        int keyIndex = 0;

        for (char c: plaintext.toCharArray()) {
            if ( (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                char n = (c >= 'A' && c <= 'Z') ? 'A' : 'a';
                char keynew = Character.toUpperCase(key.charAt(keyIndex % keyLen));
                keynew -= 'A';
                ciphertext += (char) ((c - n + keynew) % 26 + n);
                keyIndex++;
            }
            else ciphertext += c;
        }
        return ciphertext;
    }


    public String decrypt (String ciphertext, String key){
        plaintext = "";
        int keyLen = key.length();
        int keyIndex = 0;

        for (char c: ciphertext.toCharArray()) {
            if ( (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                char n = (c >= 'A' && c <= 'Z') ? 'A' : 'a';
                char keynew = Character.toUpperCase(key.charAt(keyIndex % keyLen));
                keynew -= 'A';

                plaintext += (char)((c - n - keynew + 26) % 26 + n);
                keyIndex++;
                
            }
            else plaintext += c;
        }
        return plaintext;

    }
}
