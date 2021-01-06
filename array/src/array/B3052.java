package array;

import java.io.*;

class B3052 {
	public void sol() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			boolean arr[] = new boolean[42];
			for(int i = 0; i < 10; i++) {
				arr[Integer.parseInt(br.readLine()) % 42] = true ;
			}
			
			int cnt = 0;
			for(boolean value : arr) {
				if(value) {
					cnt++;
				}
			}
			
			bw.write(Integer.toString(cnt));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
