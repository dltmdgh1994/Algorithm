package Recursion;

import java.io.*;

class B10870 { //피보나치
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine());
					
			bw.write(Integer.toString(fibo(num)));
			bw.newLine();
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private int fibo(int num) {
		if(num == 0) {
			return 0;
		}else if(num == 1) {
			return 1;
		}else {
			return fibo(num-1) + fibo(num-2);
		}
	}
}
