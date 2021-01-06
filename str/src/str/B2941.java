package str;

import java.io.*;

class B2941 { //2941 크로아티아 알파벳
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String s = br.readLine();
			int cnt = checkString(s);
			
			bw.write(Integer.toString(cnt));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public int checkString(String s) {
		int cnt = 0; String str = "";
		for(int i = 0; i < s.length(); i++) {
			str += s.substring(i,i+1);
			if(str.length() == 1) {
				if((str.equals("c") || str.equals("d") || str.equals("l") || str.equals("n") || str.equals("s") || str.equals("z")) && i != s.length()-1) {
					//아무것도 안해
				}else {
					cnt++; str = "";
				}
			}else if(str.length() == 2) {
				if(str.equals("c=") || str.equals("c-") || str.equals("d-") || str.equals("lj") || str.equals("nj") || str.equals("s=") || str.equals("z=")) {
					cnt++; str = "";
				}else if(str.equals("dz") && i != s.length()-1) {
					//아무것도 안해
				}else {
					cnt ++; str = ""; i--;
				}
			}else {
				if(str.equals("dz=")) {
					cnt++; str = "";
				}else {
					cnt += 2; str = ""; i--;
				}
			}
		}
		
		return cnt;
	}
}
