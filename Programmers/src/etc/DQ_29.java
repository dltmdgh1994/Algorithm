package etc;

import java.io.*;
import java.util.Arrays;

public class DQ_29 { // 공유기 설치

	BufferedReader br;
	BufferedWriter bw;
	
	public static void main(String[] args) {
		
		DQ_29 dq = new DQ_29();
		
		dq.sol();
	}
	
	// 적정 간격을 이분탐색법으로 찾음
	public void sol() {
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));

			String[] s = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int c = Integer.parseInt(s[1]);
			
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(arr);
			
			int start = 1; // 최소 간격
			int end = arr[n-1]-arr[0]; // 최대 간격
			int mid = 0;
			
			while(start <= end) {
				
				mid = (start+end)/2; // 설정한 간격
				int val = arr[0];
				int cnt = 1;
				for(int i = 1; i < n; i++) {
					if(arr[i] >= val+mid) {
						val = arr[i];
						cnt++;
					}
				}
				
				if(cnt >= c) {
					start = mid+1;
				}else {
					end = mid-1;
				}
			}
			
			bw.write(Integer.toString(mid));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
