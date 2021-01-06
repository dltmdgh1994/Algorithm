package Bwhile;

import java.io.*;

class B10951 {
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String s;
			String str[];
			int a, b;

			do {
				s = br.readLine();
				
				if(s != null) {
					str = s.split(" ");
					a = Integer.parseInt(str[0]);
					b = Integer.parseInt(str[1]);
					bw.write(Integer.toString(a+b));
					bw.newLine();
				}
			}while(s != null);
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
