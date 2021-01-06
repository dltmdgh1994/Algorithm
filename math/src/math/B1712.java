package math;

import java.io.*;

class B1712 { //1712 손익분기점
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String s[] = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);
			
			if(c-b != 0) {
				int x = a/(c-b);
				x += 1;
				
				if(x < 0) {
					bw.write("-1");
				}else {
					bw.write(Integer.toString(x));
				}
			}else {
				bw.write("-1");
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
