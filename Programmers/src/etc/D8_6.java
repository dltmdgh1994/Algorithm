package etc;

import java.io.*;

public class D8_6 { // 개미 전사

	BufferedReader br;
	BufferedWriter bw;

	public static void main(String[] args) {
		
		D8_6 p = new D8_6();
		
		p.sol();
	}
	
	public void sol() {
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine());
			String s[] = br.readLine().split(" ");
			
			int[] food = new int[num];
			for(int i = 0; i < num; i++) {
				food[i] = Integer.parseInt(s[i]);
			}
			
			int[] d = new int[num];
			d[0] = food[0];
			
			if(food[0] >= food[1]) {
				d[1] = food[0];
			}else {
				d[1] = food[1];
			}
			
			for(int i = 2; i < num; i++) {
				if(food[i]+d[i-2] >= d[i-1]) {
					d[i] = food[i]+d[i-2];
				}else {
					d[i] = d[i-1];
				}
			}
				
			bw.write(Integer.toString(d[num-1]));

			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
