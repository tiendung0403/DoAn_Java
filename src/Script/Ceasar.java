package Script;
public class Ceasar {
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
    public String deCrytion(String ciphertext,int key){
        return enCrytion(ciphertext, 26 - key);
    }
}

