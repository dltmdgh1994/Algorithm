package sorting;

import java.io.*;

class B1427 { // 소트인사이드
	BufferedReader br;
	BufferedWriter bw;
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String str = br.readLine();
			int len = str.length();
			Integer[] n = new Integer[len];
			for(int i = 0; i < len; i++) {
				n[i] = Integer.parseInt(str.substring(i,i+1));
			}
			
			sort s = new sort();
			s.mergeSort(n, 0, len-1, 1);
			
			for(int i = 0; i < len; i++) {
				bw.write(Integer.toString(n[i]));
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
