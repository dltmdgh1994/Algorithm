package etc;

import java.io.*;

public class D8_5 { // 1로 만들기

	BufferedReader br;
	BufferedWriter bw;

	public static void main(String[] args) {
		
		D8_5 p = new D8_5();
		
		p.sol();
	}
	
	public void sol() {
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine());
			
			int[] d = new int[30001];
			d[0] = 0;
			d[1] = 0;
			
			for(int i = 2; i < 30001; i++) {
				d[i] = d[i-1]+1;
				
				if(i%2 == 0) {
					if(d[i] > d[i/2]+1) {
						d[i] = d[i/2]+1;
					}
				}
				
				if(i%3 == 0) {
					if(d[i] > d[i/3]+1) {
						d[i] = d[i/3]+1;
					}
				}
				
				if(i%5 == 0) {
					if(d[i] > d[i/5]+1) {
						d[i] = d[i/5]+1;
					}
				}
			}
			
			bw.write(Integer.toString(d[num]));

			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
