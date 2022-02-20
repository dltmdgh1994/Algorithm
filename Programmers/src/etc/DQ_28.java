package etc;

import java.io.*;

public class DQ_28 { // 고정점 찾기

	BufferedReader br;
	BufferedWriter bw;
	
	public static void main(String[] args) {
		
		DQ_28 dq = new DQ_28();
		
		dq.sol();
	}
	
	public void sol() {
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));

			int n = Integer.parseInt(br.readLine());
			
			String[] s = br.readLine().split(" ");
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(s[i]);
			}
			
			int answer = binarySearch(arr, 0, n-1);
			bw.write(Integer.toString(answer));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private int binarySearch(int[] arr, int start, int end) {
		
		int mid;
		
		while(start <= end) {
			mid = (start+end)/2;
			
			if(mid == arr[mid]) {
				return mid;
			}else if(mid > arr[mid]) {
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		
		return -1;
	}
}
