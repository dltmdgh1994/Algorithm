package str;

import java.io.*;

class B11654 { //11654 �ƽ�Ű �ڵ�
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String s = br.readLine();
			int a = (int)s.charAt(0);
			
			bw.write(Integer.toString(a));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
