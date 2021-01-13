package Recursion;

import java.io.*;

class B10870 {
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine());
			int ans = pivo(num);
			
			bw.write(Integer.toString(ans));
			bw.newLine();
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private int pivo(int num) {
		return 1;
	}
}
