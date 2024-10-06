package Script;

public class PlayFair {
	private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	//private char[] alphabetArr = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	private char[] alphabetArr = new char[26];
	private char[][] array2d = new char[5][5];
	
	
	private String key = "";
	private String plainText = "";
	
	private char kiTuThayThe = 'X';
	
	
	public PlayFair() {
		add_Alphabet_into_Arr();
	}
	
	public PlayFair(String key, String plainText) {
		this.key = key.toUpperCase(); // Cho key lên chữ hoa
		this.plainText = plainText.toUpperCase(); // Cho plaintext lên chữ hoa
		this.plainText = chuanHoaPlainText(this.plainText); // Để xét duyệt I và J
		add_Alphabet_into_Arr(); // Cho bảng chữ alphabet vào mảng
		addKeyIntoArr2d(key); // nếu có key thì cho key vào mảng 2d
	}
	
	
	public void setKey(String key) {
		this.key = key.toUpperCase();
		addKeyIntoArr2d(this.key);
	}
	public String getKey() {
		return this.key;
	}
	
	
	public void setPlainText(String plainText) {
		this.plainText = plainText.toUpperCase();
		this.plainText = chuanHoaPlainText(this.plainText);
	}
	public String getPlainText() {
		return this.plainText;
	}
	
	
	// Truyền 26 chữ cái vào mảng để dễ dàng so với key
	private void add_Alphabet_into_Arr() {
		alphabetArr = new char[26];
		
		for (int i = 0; i < 26; i++) {
			alphabetArr[i] = alphabet.charAt(i); 
		}
	}
	
	
	// Kiểm tra các kí tự lặp đi lặp lại
	private boolean kiemTraLap(char[] arr, char x, int n) {

		for (int i = 0; i < n; i++) {
			if (arr[i] == x) {
				return false;
			}
		}
		return true;
	}
	// Có 2 nhiệm vụ
	// 1 là làm gọn lại key, vd: ABCAA QW -> ABCQW để dễ dàng đưa vào arr2d hơn
	// 2 là để xử lí I và J
	private String chuanHoaKey(String temp) {
		
		String answer = "";
		int n = temp.length();
		char[] tempArr = new char[n];
		int indexArr = 0;
		boolean checkIJ = false;
		
		// Chỉ xét trường hợp có I hoặc J hoặc cả 2 trong key gốc
		for (int i = 0; i < n; i++) {
			char c = temp.charAt(i);

			if (c != ' ') { // Bỏ khoảng cách
				if (kiemTraLap(tempArr, c, i)) {
					if ((c == 'I' || c == 'J') && checkIJ) {
						continue;
					}
					tempArr[indexArr] = c;
					answer += tempArr[indexArr++];
				}
				
				if (c == 'I' || c == 'J') { // Nếu I hoặc J xuất hiện lần đầu trong mảng thì cả 2 sẽ bị vô hiệu hóa trong mảng alphabet vì key chỉ cần 1
					checkIJ = true;
					alphabetArr['I' - 65] = '0';
					alphabetArr['J' - 65] = '0';
				}
			}
		}
		
		if (checkIJ == false) { // Nếu key gốc ko có I và J 
			alphabetArr['J' - 65] = '0'; // thì sẽ lấy I và bỏ J
		}
		
		return answer;
	}

	
	private int[] spacePositionSave; // Lưu khoảng cách space giữa các từ
	
	// Biến đổi I và J tùy vào cái nào đến trước và đồng thời lưu các khoảng cách space
	// VD: IJ JI AEW -> IIIIAEW
	private String chuanHoaPlainText(String plaintext) { 
		String rT = "";
		String temp = plaintext;
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
		
		return rT;
	}
	
	// Cho key vào arr2d
	private void addKeyIntoArr2d(String key) {
		int indexKey = 0;
		int indexAlphabet = 0;
		
		String tempKey = chuanHoaKey(key); // Chuẩn hóa key trc khi cho vào mảng 2d
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				
				// Nhập key vào trước
				if (indexKey < tempKey.length()) {
					
					char temp = tempKey.charAt(indexKey++); 
					array2d[i][j] = temp;
					alphabetArr[temp - 65] = '0';
				}
				// Nhập những chữ cái còn lại mà key không có
				else {
					
					while (true) {
						
						if (alphabetArr[indexAlphabet++] != '0') {
							break;
						}
					}
					array2d[i][j] = alphabetArr[indexAlphabet-1]; // Trừ 1 do I và J là 1
				}
			}
		}
		
	}
	// hàm thêm kiểm tra mảng
	public String xuatArr() {
		String str = "";
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				str += array2d[i][j];
			}
		}
		return str;
	}

	
	private int[] findPosition(char c) {// Tìm vị trí kí tự c trong arr2d và trả về vị trí theo tọa độ x,y
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
	
	private char[] maHoa() {
		int index = 0;
		int indexMaHoa = 0;
		char a, b;
		int n = plainText.length();
		char[] maHoaString = new char[plainText.length() * 2];
		
		while (true) {
			
			a = plainText.charAt(index);
			
			// Nếu chỉ có 1 kí tự thì sẽ add thêm kí tự thay thế để mã hóa
			if (n == 1) {
				b = kiTuThayThe;
				index++;
			}
			else if (index + 1 < n) {
				b = plainText.charAt(++index);
				
				if (a == b) { // Nếu 2 chữ kề nhau trùng thì thêm 1 kí tự thay thế để mã hóa, VD: AA -> AZAZ
					b = kiTuThayThe;
				}
				else {
					index++;
				}
			}
			else {
				b = kiTuThayThe;
				index++;
			}
			
			// Tìm vị trí
			int[] posA = findPosition(a);
	        int[] posB = findPosition(b);
				
			if (posA[0] == posB[0]) {
				// Cùng hàng, di chuyển sang phải
				maHoaString[indexMaHoa++] = array2d[posA[0]][(posA[1] + 1) % 5];
				maHoaString[indexMaHoa++] = array2d[posB[0]][(posB[1] + 1) % 5];
			}
			else if (posA[1] == posB[1]) {
				// Cùng cột, di chuyển xuống
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


	private char[] giaiMa() {
	    int index = 0;
	    int indexGiaMa = 0;
	    char a, b;
	    int n = plainText.length();
	    char[] giaMaString = new char[plainText.length() * 2];

	    while (index < n) {
	        a = plainText.charAt(index);

	        if (n == 1) {
	            b = kiTuThayThe; // Khi chỉ còn một ký tự, thay thế bằng ký tự thay thế.
	            index++;
	        } else if (index + 1 < n) {
	            b = plainText.charAt(++index);

	            if (a == b) {
	                b = kiTuThayThe; // Nếu hai ký tự giống nhau, thêm kí tự thay thế vào giữa, VD: AA -> AZAZ
	            } else {
	                index++; // index + 1 vì cả 2 kí tự khác nhau, ko cần thêm kí tự đặc biệt
	            }
	        } else {
	            b = kiTuThayThe; // Khi chỉ còn một ký tự cuối cùng, thay thế nó.
	            index++;
	        }

	        int[] posA = findPosition(a);
	        int[] posB = findPosition(b);

	        if (posA[0] == posB[0]) {
	            // Cùng hàng, giải mã di chuyển sang trái.
	            giaMaString[indexGiaMa++] = array2d[posA[0]][(posA[1] + 4) % 5];
	            giaMaString[indexGiaMa++] = array2d[posB[0]][(posB[1] + 4) % 5];
	        } else if (posA[1] == posB[1]) {
	            // Cùng cột, giải mã di chuyển lên trên.
	            giaMaString[indexGiaMa++] = array2d[(posA[0] + 4) % 5][posA[1]];
	            giaMaString[indexGiaMa++] = array2d[(posB[0] + 4) % 5][posB[1]];
	        } else {
	            // Bình thường (khác hàng, khác cột), thay đổi theo chiều đối xứng.
	            giaMaString[indexGiaMa++] = array2d[posA[0]][posB[1]];
	            giaMaString[indexGiaMa++] = array2d[posB[0]][posA[1]];
	        }

	        if (index >= n) {
	            break;
	        }
	    }
	    return giaMaString;
	}





	
	public String batDauMaHoa() {
		String cipherText = "";
		char[] maHoaString = new char[plainText.length() * 2];
		maHoaString = maHoa();
		
		for (int i = 0; i < plainText.length() * 2; i++) {
			
			cipherText += maHoaString[i];
		}
		
		return cipherText;
	}
	
	
	public String batDauGiaiMa() {
		String plaintext = "";
		char[] giaiMaString = new char[plainText.length() * 2];
		giaiMaString = giaiMa();

		
		for (int i = 0; i < plainText.length() * 2; i++) {
			
			plaintext += giaiMaString[i];
		}
		
		return plaintext;
	}
}
