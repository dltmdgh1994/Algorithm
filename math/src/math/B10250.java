package math;

import java.io.*;

class B10250 { //10250 ACM хёез
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine());
			String s[]; int width; int height; int n;
			int a; int b;
			for(int i = 0; i < num; i++) {
				s = br.readLine().split(" ");
				height = Integer.parseInt(s[0]);
				width = Integer.parseInt(s[1]);
				n = Integer.parseInt(s[2]);
				
				a = n%height;
				if(n%height == 0) {
					a = height;
				}
				
				b = n/height;
				if(n%height != 0) {
					b++;
				}
				
				if(b<10) {
					bw.write(Integer.toString(a)+"0"+Integer.toString(b));
				}else {
					bw.write(Integer.toString(a)+Integer.toString(b));
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
