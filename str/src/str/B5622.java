package str;

import java.io.*;

class B5622 {  //5622  ´ÙÀÌ¾ó
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
					
			String s = br.readLine();
			int sum = 0;
			for(int i = 0; i < s.length(); i++) {
				sum += engToNum(s.substring(i,i+1));
			}
			
			bw.write(Integer.toString(sum));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public int engToNum(String s) {
		int n = (int)s.charAt(0);
		int num = 0;
		
		if(n>= 65 && n <= 67) {
			num = 3;
		}else if(n >= 68 && n <= 70) {
			num = 4;
		}else if(n >= 71 && n <= 73) {
			num = 5;
		}else if(n >= 74 && n <= 76) {
			num = 6;
		}else if(n >= 77 && n <= 79) {
			num = 7;
		}else if(n >= 80 && n <= 83) {
			num = 8;
		}else if(n >= 84 && n <= 86) {
			num = 9;
		}else if(n >= 87 && n <= 90) {
			num = 10;
		}
		return num;
	}
}
