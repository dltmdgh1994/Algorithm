package str;

import java.io.*;

class B2908 { //2908 »ó¼ö
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String s[] = br.readLine().split(" ");
			s[0] = reverseString(s[0]);
			s[1] = reverseString(s[1]);
			
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			
			if(a > b) {
				bw.write(Integer.toString(a));
			}else {
				bw.write(Integer.toString(b));
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public static String reverseString(String s) {
	    return ( new StringBuffer(s) ).reverse().toString();
	}
}
