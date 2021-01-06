package Bfor;

import java.io.*;

class B10871 {
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String s = br.readLine();
			String[] str = s.split(" "); 
			int num = Integer.parseInt(str[0]);
			int base = Integer.parseInt(str[1]);
			
			String arr = br.readLine();
			String array[] = arr.split(" ");
			
			for(int i = 0; i < num; i++) {
				int a = Integer.parseInt(array[i]);
				if(a < base) {
					bw.write(a + " ");
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
