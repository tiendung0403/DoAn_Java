package Script;

public class Vegenere {

    private String plaintext, ciphertext,key;

    public Vegenere(){
        this.plaintext = "";
        this.key = "";
        this.ciphertext = "";
    }

    public void setPlaintext(String p){
        this.plaintext = p;
    }
    public String getPlaintext(){
        return this.plaintext;
    }
    public void setCiphertext(String c){
        this.ciphertext = c;
    }
    public String getCiphertext(){
        return this.ciphertext;
    }
    public void setKey(String k){
        this.key = k;
    }
    public String getKey(){
        return this.key;
    }
    public String encrypt(String plt,String k){
        ciphertext = "";
        int keyLen = k.length();
        int keyIndex = 0;
        setPlaintext(plt);
        plt = getPlaintext();
        setKey(k);
        k = getKey();

        for (char c: plt.toCharArray()) {
            if ( (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                char n = (c >= 'A' && c <= 'Z') ? 'A' : 'a';
                char keynew = Character.toUpperCase(k.charAt(keyIndex % keyLen));
                keynew -= 'A';
                ciphertext += (char) ((c - n + keynew) % 26 + n);
                keyIndex++;
            }
            else ciphertext += c;
        }
        return ciphertext;
    }


    public String decrypt(String cpt, String k){
        plaintext = "";
        int keyLen = k.length();
        int keyIndex = 0;
        setCiphertext(cpt);
        cpt = getCiphertext();
        setKey(k);
        k = getKey();

        for (char c: cpt.toCharArray()) {
            if ( (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                char n = (c >= 'A' && c <= 'Z') ? 'A' : 'a';
                char keynew = Character.toUpperCase(k.charAt(keyIndex % keyLen));
                keynew -= 'A';

                plaintext += (char)((c - n - keynew + 26) % 26 + n);
                keyIndex++;
                
            }
            else plaintext += c;
        }
        return plaintext;

    }
    public String newKey(String cpt, String k){
        String temp = "";
        int keyLen=k.length();
        int keyIndex = 0;
        for (char c: cpt.toCharArray()) {
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                char keynew = (k.charAt(keyIndex % keyLen));
                temp += keynew;
                keyIndex++;
            }

        
        }
        return temp;
    }
}
