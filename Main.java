import GUI.doanlaptrinhmahoa;
import Script.PlayFair;

public class Main {
	public static void main(String[] args) {
		
//        doanlaptrinhmahoa a = new doanlaptrinhmahoa();
//        a.start();
        
        
		PlayFair a = new PlayFair();
		
		String pT = "Attack at dawn";
		String k = "Gravity Falls";
		
		a.setPlainText(pT);
		a.setKey(k);

		
		System.out.println("Attack at dawn -> " + a.batDauMaHoa());
    }
}

