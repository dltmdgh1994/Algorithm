package sorting;

import java.io.*;

class B10989 { // 수 정렬하기 3
	BufferedReader br;
	BufferedWriter bw;
	public void sol() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			
			int arr[] = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] =  Integer.parseInt(br.readLine());
			}
			
			sort s = new sort();
			int arr2[] = s.countingSort(arr);
			
			for(int i = 0; i < n; i++) {
				bw.write(Integer.toString(arr2[i]));
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
