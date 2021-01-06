package Bwhile;

import java.io.*;

class B10952 {
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String s;
			String str[];
			int a = 1; int b = 1;
			
			while(a != 0 && b != 0) {
				s = br.readLine();
				str = s.split(" ");
				a = Integer.parseInt(str[0]);
				b = Integer.parseInt(str[1]);
				
				if(a != 0 && b != 0) {
					bw.write(Integer.toString(a+b));
					bw.newLine();
				}
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
