package BruteForce;

import java.io.*;

class B2231 { // ºÐÇØÇÕ
	BufferedReader br;
	BufferedWriter bw;
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String s = br.readLine();
			int n = Integer.parseInt(s);
			int len = s.length();
			int limit = (int)Math.pow(10, len-1) - 9*len;
			
			if(limit < 1) {
				limit = 1;
			}
			
			int sum; int iLen; int num;
			int min = 0;
			
			for(int i = limit; i < n; i++) {
				iLen = (int)(Math.log10(i)+1);
				sum = i;
				num = i;
				for(int j = iLen; j >= 0; j--) {
					int z = (int)Math.pow(10, j);
					sum += (num / z);
					num = (num % z);
				}
				if(sum == n) {
					min = i;
					break;
				}
			}
			
			bw.write(Integer.toString(min));

			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
