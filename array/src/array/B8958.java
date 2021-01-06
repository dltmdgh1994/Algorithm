package array;

import java.io.*;

class B8958 {
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(br.readLine());
			
			int cnt = 0; int score;
			for(int i = 0; i < num; i++) {
				String str = br.readLine();
				score = 0; cnt = 0;
				for(int j = 0; j < str.length(); j++) {
					if(str.substring(j,j+1).equals("O")) {
						cnt++;
						score += cnt;
					}else {
						cnt = 0;
					}
				}
				bw.write(Integer.toString(score));
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
