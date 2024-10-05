package Script;

public class ChuyenDichDong {
	
	private String key = "";
	private String plaintext = "";
	
	private int collum;
	private int row;
	
	private char[][] arr2dDecrypt;
	private char[][] arr2dEncrypt;
	
	
	private int[] sttEncrypt;
	private int[] sttDecrypt;
	
	
	private char kiTuThayThe = 'X';
	
	public ChuyenDichDong() {
		
	}
	public ChuyenDichDong(String key, String plaintext) {
		this.key = chuanHoaChuoi(key.toUpperCase());
		this.plaintext = chuanHoaChuoi(plaintext.toUpperCase());
	}
	
	public void setKey(String key) {
		this.key = chuanHoaChuoi(key.toUpperCase());
	}
	public String getKey() {
		return this.key;
	}
	
	public void setPlaintext(String plaintext) {
		this.plaintext = chuanHoaChuoi(plaintext.toUpperCase());
	}
	public String getPlaintext() {
		return this.plaintext;
	}
	
	
	private String chuanHoaChuoi(String str) { // xóa khoảng trống
		String temp = "";
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				temp += str.charAt(i);
			}
		}
		return temp;
	}
	
	
	
	private char[][] createArr2d() { // tạo mảng 2d
		double cot = this.key.length();
		double hang = Math.ceil(this.plaintext.length() / cot);
		
		
		collum = (int)cot;
		row = (int)hang;
		return new char[row][collum];
		
	}
	
	private int[] charArrToCharInt(String str) {
		int n = str.length();
		int[] arrInt = new int[n];
		
		for (int i = 0; i < n; i++) {
			arrInt[i] =  ((int)str.charAt(i) - 65);
		}
		
		return arrInt;
	}
	private int[] laystt() {
		int n = this.key.length();
		int indexsttEncrypt = 0;
		
		int[] tempsttEncrypt = new int[n];
		int[] temp = charArrToCharInt(this.key);
		
		for (int i = 0; i < n; i++) {
			int min = 99;
			int savePos = -1;
			
			// Kiếm min và vị trí
			for (int j = 0; j < n; j++) { 
				if (min >= temp[j]) {
					min = temp[j];
					savePos = j;
				}
			}
			tempsttEncrypt[indexsttEncrypt++] = savePos; 
			temp[savePos] = 91; // 91 là vì A (65) -> Z (90), 91 không thể ở trong bảng chữ cái hoa
								// 0 (48) - > 9 (57), 91 không thể ở trong bảng số
		}
		
		return tempsttEncrypt;
	}
	
	
	private void addPlaintextIntoArr2dEncrypt() {
		int indexPlaintext = 0;
		int n = plaintext.length();
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < collum; j++) {
				if (indexPlaintext < n) {
					arr2dEncrypt[i][j] = this.plaintext.charAt(indexPlaintext++);
				}
				else {
					arr2dEncrypt[i][j] = kiTuThayThe; 
				}
			}
		}
	}
	
	private String maHoa() {
		sttEncrypt = laystt();
		String maHoaString = "";
		for (int i = 0; i < collum; i++) {
			int pos = sttEncrypt[i];
			for (int j = 0; j < row; j++) {
				maHoaString += arr2dEncrypt[j][pos];
			}
			
		}
		return maHoaString;
	}
	
	private void addPlaintextIntoArr2dDecrypt() {
		String ciphertext = plaintext;
		int indexCiphertext = 0;
		sttDecrypt = laystt();
		
		for (int i = 0; i < collum; i++) {
			int pos = sttDecrypt[i];
			for (int j = 0; j < row; j++) {
				if (indexCiphertext < ciphertext.length()) {
					arr2dDecrypt[j][pos] = ciphertext.charAt(indexCiphertext++);
				}
				else {
					arr2dDecrypt[j][pos] = kiTuThayThe;
				}
			}
		}
	}
	
	private String giaiMa() {
		String temp = "";
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < collum; j++) {
				temp += arr2dDecrypt[i][j];
			}
		}
		
		return temp;
	}
	
	public void xuatArr() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < collum; j++) {
				System.out.print(arr2dEncrypt[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public String batDauMaHoa() {
		arr2dEncrypt = createArr2d();
		addPlaintextIntoArr2dEncrypt();
		return maHoa();
	}
	
	public String batDauGiaiMa() {
		arr2dDecrypt = createArr2d();
		addPlaintextIntoArr2dDecrypt();
		return giaiMa();
	}
	
	
}
