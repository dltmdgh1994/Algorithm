package str;

import java.io.*;

class B1157 { // 1157 단어 공부
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String s = br.readLine().toUpperCase();
			int alphabet[] = new int[26];
			
			for(int i = 0; i < alphabet.length; i++) {
				alphabet[i] = 0;
			}
			
			int num;
			for(int i = 0; i < s.length(); i++) {
				num = ((int)s.charAt(i)) - 65;
				alphabet[num]++;
			}
			int max = 0; int n = 0;
			for(int i = 0; i < alphabet.length; i++) {
				if(alphabet[i] > max) {
					n = i;
					max = alphabet[i];
				}
				else if(alphabet[i] == max) {
					n = 255;
				}
			}
			
			if(n == 255) {
				bw.write("?");
			}
			else {
				bw.write((char)(n+65));
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
