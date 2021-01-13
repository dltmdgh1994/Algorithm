package Recursion;

import java.io.*;

class B10872 { // ÆÑÅä¸®¾ó
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine());
			int ans = fac(num);
			
			bw.write(Integer.toString(ans));
			bw.newLine();
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private int fac(int num) {
		if(num <= 1) {
			return 1;
		}else {
			return num*fac(num-1);
		}
	}
}
