package math;

import java.io.*;

class B1193 { //1193 분수찾기
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine()); 
			int a = 2; int b = 1;
			while(b < num) {
				b += a;
				a++;
			}
			
			int gab = b - num; int top; int bot;
			if(a%2 == 0) {
				top = 1; bot = a-1;
				for(int i = 0; i < gab; i++) {
					top++; bot--;
				}
			}else {
				top = a-1; bot = 1;
				for(int i = 0; i < gab; i++) {
					top--; bot++;
				}
			}
			
			bw.write(Integer.toString(top)+"/"+Integer.toString(bot));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
