package Script;
public class Bangchudon {

    public String enCrytion(String plaintext,String key){
        String ciphertext = "";
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


    public String deCrytion(String ciphertext, String key){
        String plaintext = "";
        int keyLen = key.length();
        int keyIndex = 0;

        for (char c: ciphertext.toCharArray()) {
            if ( (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                char n = (c >= 'A' && c <= 'Z') ? 'A' : 'a';
                char keynew = Character.toUpperCase(key.charAt(keyIndex % keyLen)) ;
                keynew -= 'A';

                plaintext += (char)((c - n - keynew + 26) % 26 + n);
                keyIndex++;
                
            }
            else plaintext += c;
        }
        return plaintext;

    }
}
