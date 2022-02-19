package etc;

import java.io.*;
import java.util.*;

public class DQ_27 { // 정렬된 배열에서 특정 수의 개수 구하기
	
	BufferedReader br;
	BufferedWriter bw;
	
	public static void main(String[] args) {
		
		DQ_27 dq = new DQ_27();
		
		dq.sol();
	}
	
	public void sol() {
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));

			String[] s = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int target = Integer.parseInt(s[1]);
			
			s = br.readLine().split(" ");
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(s[i]);
			}
			
			int start = binarySearch_start(arr, target, 0, n-1);
			if(start == -1) {
				bw.write("-1");
			}else {
				int end = binarySearch_end(arr, target, 0, n-1);
				
				bw.write(Integer.toString(end-start+1));
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	private int binarySearch_start(int[] arr, int target, int start, int end) {
		
		int mid;
		
		while(start <= end) {
			mid = (start+end)/2;
			
			if(mid == 0) {
				if(arr[mid] == target) {
					return mid;
				}else {
					return -1;
				}
			}else if(arr[mid-1] < target && arr[mid] == target){
				return mid;
			}else if(arr[mid] >= target) {
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		
		return -1; // 탐색 실패
	}
	
	private int binarySearch_end(int[] arr, int target, int start, int end) {
		
		int mid;
		
		while(start <= end) {
			mid = (start+end)/2;
			
			if(mid == arr.length-1) {
				if(arr[mid] == target) {
					return mid;
				}else {
					return -1;
				}
			}else if(arr[mid+1] > target && arr[mid] == target){
				return mid;
			}else if(arr[mid] > target) {
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		
		return -1; // 탐색 실패
	}
}
