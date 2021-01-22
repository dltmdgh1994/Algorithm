package bruteForce;

import java.io.*;

class B1436 { // ¿µÈ­°¨µ¶ ¼ò
	BufferedReader br;
	BufferedWriter bw;
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			
			int cnt = 0;
			int num = 666;
			while(true) {
				if(Integer.toString(num).contains("666")) {
					cnt++;
				}
				if(cnt == n) {
					break;
				}
				num++;
			}
			
			bw.write(Integer.toString(num));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
