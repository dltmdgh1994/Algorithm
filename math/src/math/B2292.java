package math;

import java.io.*;

class B2292 { // 2292 ¹úÁý
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine()); 
			int a =1; int b = 1;
			while(a < num) {
				a += (b*6);
				b++;
			}
			
			bw.write(Integer.toString(b));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
