package Script;


public class PlayFair {
	private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private char[] alphabetArr;
	private char[][] array2d = new char[5][5];
	
	
	private String key = "";
	private String plainText = "";
	
	
	
	public PlayFair() {
		add_Alphabet_into_Arr();
	}
	
	public PlayFair(String key, String plainText) {
		// Cả key và plainText đều không có kí tự đặc biệt và số
		if (!checkString(key) && !checkString(plainText)) {
			add_Alphabet_into_Arr();
			chuanHoaPlainText();
			this.key = key.toUpperCase();
			this.plainText = plainText.toUpperCase();
		}
		else {
			
			// Bắt người dùng nhập lại, xử lí ở giao diện
			
		}
		
	}
	
	
	public void setKey(String key) {
		this.key = key.toUpperCase();
	}
	public String getKey() {
		return this.key;
	}
	
	
	public void setPlainText(String plainText) {
		this.plainText = plainText.toUpperCase();
		chuanHoaPlainText();
	}
	public String getPlainText() {
		return this.plainText;
	}
	
	
	// Hàm boolean kiểm tra chuỗi có số hoặc các kí tự khác
	// Có kí tự đặc biệt hoặc số => true
	// Chuỗi chữ thông thường => false
	public boolean checkString(String s) {
		//boolean check = false;
		
		for (int i = 0; i < s.length(); i++) {
			if (!(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || s.charAt(i) == ' ') {
				return true;
			}
		}
		return false;
	}
	
	private void add_Alphabet_into_Arr() {
		alphabetArr = new char[26];
		
		for (int i = 0; i < 26; i++) {
			alphabetArr[i] = alphabet.charAt(i); 
		}
	}
	
	
	private boolean kiemTraLap(char[] arr, char x, int n) {
		
//		if (x == ' ') {
//			return false;
//		}
		for (int i = 0; i < n; i++) {
			if (arr[i] == x) {
				return false;
			}
		}
		return true;
	}
	private String chuanHoaKey(String temp) {
		
		String answer = "";
		int n = temp.length();
		char[] tempArr = new char[n];
		int indexArr = 0;
		boolean checkIJ = false;
		
		for (int i = 0; i < n; i++) {
			char c = temp.charAt(i);

			if (c != ' ') {
				if (kiemTraLap(tempArr, c, i)) {
					if ((c == 'I' || c == 'J') && checkIJ) {
						continue;
					}
					tempArr[indexArr] = c;
					answer += tempArr[indexArr++];
				}
				
				if (c == 'I' || c == 'J') {
					checkIJ = true;
					alphabetArr['I' - 65] = '0';
					alphabetArr['J' - 65] = '0';
				}
			}
		}
		
		return answer;
	}

	
	private int[] spacePositionSave;
	private void chuanHoaPlainText() {
		String rT = "";
		String temp = this.plainText;
		int[] save = new int[temp.length()];
		int index = 0;
		
		boolean checkI = false;
		boolean checkJ = false;
		
		for (int i = 0; i < temp.length(); i++) {
			if (temp.charAt(i) != ' ') {
				
				if (temp.charAt(i) == 'I') {
					checkI = true;
				}
				else if(temp.charAt(i) == 'J') {
					checkJ = true;
				}
				
				if (temp.charAt(i) == 'I' || temp.charAt(i) == 'J') {
					if (checkI) {
						rT += 'I';
					}
					else if (checkJ) {
						rT += 'J';
					}
				}
				else {
					rT += temp.charAt(i);
				}
				
			}
			else {
				save[index++] = i;
			}
		}
		
		spacePositionSave = new int[index];
		for (int i = 0; i < spacePositionSave.length; i++) {
			spacePositionSave[i] = save[i]; 
		}
		
		this.plainText = rT;
	}
	
	public void addKey_into_Arr2d(String key) {
		int indexKey = 0;
		int indexAlphabet = 0;
		
		String tempKey = chuanHoaKey(key).toUpperCase();
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				
				// Nhập key vào trước
				if (indexKey < tempKey.length()) {
					
					char temp = tempKey.charAt(indexKey++); 
					
					alphabetArr[temp - 65] = '0';
					
					array2d[i][j] = temp;
					
				}
				// Nhập những chữ cái còn lại mà key không có
				else {
					
					while (true) {
						
						if (alphabetArr[indexAlphabet++] != '0') {
							break;
						}
						
						
					}
					array2d[i][j] = alphabetArr[indexAlphabet-1]; 
				}
			}
		}
		
	}
	
	
	public void xuat2d() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(array2d[i][j] + " ");
			}
			System.out.println();
		}
	}

//	private char[] maHoaString = new char[plainText.length() * 2];
//	private int indexMaHoa = 0;
	private char[] maHoa() {
		int index = 0;
		int indexMaHoa = 0;
		char a, b;
		int n = plainText.length();
		char[] maHoaString = new char[plainText.length() * 2];
		
		while (true) {
			
			a = plainText.charAt(index);
			
			if (n == 1) {
				b = 'X';
			}
			else if (index + 1 < n) {
				b = plainText.charAt(++index);
				
				if (a == b) {
					b = 'X';
				}
				else {
					index++;
				}
			}
			else {
				b = 'X';
				index++;
			}
			
			int[] posA = findPosition(a);
	        int[] posB = findPosition(b);
				
			if (posA[0] == posB[0]) {
				// Cùng hàng
				maHoaString[indexMaHoa++] = array2d[posA[0]][(posA[1] + 1) % 5];
				maHoaString[indexMaHoa++] = array2d[posB[0]][(posB[1] + 1) % 5];
			}
			else if (posA[1] == posB[1]) {
				// Cùng cột
				maHoaString[indexMaHoa++] = array2d[(posA[0] + 1) % 5][posA[1]];
				maHoaString[indexMaHoa++] = array2d[(posB[0] + 1) % 5][posB[1]];
			}
			else {
				// Bình thường (khác hàng, khác cột)
				maHoaString[indexMaHoa++] = array2d[posA[0]][posB[1]];
				maHoaString[indexMaHoa++] = array2d[posB[0]][posA[1]];
			}
			if (index >= n) {
				break;
			}
		}
		return maHoaString;
	}

	private int[] findPosition(char c) {
	    // Tìm vị trí của ký tự trong array2d
	    for (int i = 0; i < 5; i++) {
	        for (int j = 0; j < 5; j++) {
	            if (array2d[i][j] == c) {
	                return new int[] { i, j };
	            }
	        }
	    }
	    return null; // Trường hợp không tìm thấy
	}

	private boolean checkSavePosition(int[] arrSave,int index) {
		
		for (int i = 0; i < arrSave.length; i++) {
			if (arrSave[i] == index) {
				return true;
			}
		}
		
		return false;
	}
	
	public String batDauMaHoa() {
		String cipherText = "";
		addKey_into_Arr2d(this.key);
		xuat2d();
		char[] maHoaString = new char[plainText.length() * 2];
		maHoaString = maHoa();
		
		for (int i = 0; i < plainText.length() * 2; i++) {
			
			cipherText += maHoaString[i];
		}
		
		return cipherText;
	}
}
