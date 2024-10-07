package Script;


public class Vegenere extends Bangchudon {

    private String plaintext, ciphertext,key;

    public Vegenere(){
        this.plaintext = "";
        this.key = "";
        this.ciphertext = "";
    }

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
    public String encrypt(String plt,String k){
        ciphertext = "";
        int keyLen = k.length();
        int keyIndex = 0;
        setPlaintext(plt);
        plt = getPlaintext();
        setKey(k);
        k = getKey();

        for (char c: plt.toCharArray()) {
            if ( c >= 'A' && c <= 'Z') {
                char keynew = k.charAt(keyIndex % keyLen);
                keynew -= 'A';
                ciphertext += (char) ((c - 'A' + keynew) % 26 + 'A');
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
            if ( c >= 'A' && c <= 'Z') {
                char keynew = k.charAt(keyIndex % keyLen);
                keynew -= 'A';
                plaintext += (char)((c - 'A' - keynew + 26) % 26 + 'A');
                keyIndex++;
                
            }
            else plaintext += c;
        }
        return plaintext;

    }
    public String newKey(String cpt, String k){
        String temp = "";
        int keyLen= k.length();
        int keyIndex = 0;
        setCiphertext(cpt);
        cpt = getCiphertext();
        setKey(k);
        k = getKey();
        for (char c: cpt.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                char keynew = (k.charAt(keyIndex % keyLen));
                temp += keynew;
                keyIndex++;
            }

        
        }
        return temp;
    }
}
