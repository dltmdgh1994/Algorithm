package Bfor;

import java.io.*;

class B2439 {
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			int num = Integer.parseInt(br.readLine());
			
			for(int i = 1; i <= num; i++) {
				for(int j = 0; j < num-i; j++) {
					bw.write(" ");
				}
				for(int n = 0; n < i; n++) {
					bw.write("*");
				}
				bw.newLine();
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
