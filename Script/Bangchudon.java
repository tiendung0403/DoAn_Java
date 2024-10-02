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


        for (char c: plt.toCharArray()) {
            if ( c >= 'A' && c <= 'Z') {
                int i = (int)( c - 'A');
                ciphertext += k.charAt(i);
            }
            else ciphertext += c;
        }
        return ciphertext.toUpperCase();
    }


    public String decrypt (String cpt, String k){
        plaintext = "";
        for(char c : cpt.toCharArray()){
            if(c >= 'A' && c <= 'Z'){
                for ( int i = 0; i < 26 ; i++ ){
                    if(c == k.charAt(i)){
                        plaintext +=(char) (i +'A');
                    }
                }
            }
            else plaintext += c;
        }
        return plaintext;
       
    } 
    public void swap(char[] c,int a,int b){
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }
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
