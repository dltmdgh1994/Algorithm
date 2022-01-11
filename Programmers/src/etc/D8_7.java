package etc;

import java.io.*;

public class D8_7 { // ¹Ù´Ú °ø»ç
	
	BufferedReader br;
	BufferedWriter bw;

	public static void main(String[] args) {
		
		D8_7 p = new D8_7();
		
		p.sol();
	}
	
	public void sol() {
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine());

			int[] d = new int[100];
			d[0] = 1;
			d[1] = 3;
			
			for(int i = 2; i < 100; i++) {
				d[i] = (d[i-2]*2 + d[i-1])%796796;
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
