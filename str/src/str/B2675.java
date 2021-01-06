package str;

import java.io.*;

class B2675 { //2675 문자열 반복
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine());
			for(int i = 0; i < num; i++) {
				String s[] = br.readLine().split(" ");
				int n = Integer.parseInt(s[0]);
				String str = "";
				for(int j = 0; j < s[1].length(); j++) {
					for(int k = 0; k < n; k++) {
						str += s[1].substring(j,j+1);
					}
				}
				
				bw.write(str);
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
