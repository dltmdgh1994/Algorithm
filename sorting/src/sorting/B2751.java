package sorting;

import java.io.*;

class B2751 { // 수 정렬하기 2
	BufferedReader br;
	BufferedWriter bw;
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			
			Integer arr[] = new Integer[n];
			for(int i = 0; i < n; i++) {
				arr[i] =  Integer.parseInt(br.readLine());
			}
			
			sort s = new sort();
			s.mergeSort(arr, 0, n-1, 0);
			
			for(int i = 0; i < n; i++) {
				bw.write(Integer.toString(arr[i]));
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
