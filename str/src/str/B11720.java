package str;

import java.io.*;

class B11720 {  //11720 숫자의 합
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine());
			String s = br.readLine();
			int sum = 0;
			for(int i = 0; i < num; i++) {
				sum += Integer.parseInt(s.substring(i,i+1));
			}
			
			bw.write(Integer.toString(sum));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
