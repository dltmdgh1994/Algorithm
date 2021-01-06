package math;

import java.io.*;

class B2839 { //2839 ¼³ÅÁ ¹è´Þ
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine());
			int a = num / 5; int b; int c; int min = 10000;
			for(int i = a; i >=0; i--) {
				b = num - (5*i);
				if(b%3 == 0) {
					if((i+(b/3))<min) {
						min = (i+(b/3));
					}
				}
			}
			
			if(min == 10000) {
				bw.write("-1");
			}else {
				bw.write(Integer.toString(min));
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
