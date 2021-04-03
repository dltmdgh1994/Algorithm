package Greedy;

import java.io.*;

class B11047 { // µ¿Àü 0
	BufferedReader br;
	BufferedWriter bw;
	
	
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] str = br.readLine().split(" ");
			int size = Integer.parseInt(str[0]);
			int num = Integer.parseInt(str[1]);
			
			int[] unit = new int[size];
			for(int i = 0; i < size; i++) {
				unit[i] = Integer.parseInt(br.readLine());
			}
			
			int cnt = 0;
			for(int i = size-1; i>=0; i--) {
				int m = unit[i];
				if(m <= num) {
					cnt += (num/m);
					num %= m;
				}
			}
			
			bw.write(Integer.toString(cnt));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
