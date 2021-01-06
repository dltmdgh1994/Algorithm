package Bfor;

import java.io.*;

class B11021 {
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			int num = Integer.parseInt(br.readLine());
			
			for(int i = 1; i <= num; i++) {
				String s = br.readLine();
				String[] str = s.split(" "); 
				int a = Integer.parseInt(str[0]);
				int b = Integer.parseInt(str[1]);

				bw.write("Case #"+Integer.toString(i)+": " +Integer.toString(a+b));
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
