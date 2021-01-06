package str;

import java.io.*;

class B1152 { //1152 단어의 개수
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String s[] = br.readLine().trim().split(" ");
			if(s[0].isBlank()) {
				bw.write("0");
			}
			else {
				bw.write(Integer.toString(s.length));
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
