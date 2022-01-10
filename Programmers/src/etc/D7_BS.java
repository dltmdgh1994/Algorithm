package etc;

import java.io.*;

public class D7_BS {
	
	BufferedReader br;
	BufferedWriter bw;

	public static void main(String[] args) {
		
		D7_BS d = new D7_BS();
		
		int[] arr = new int[1000];

		for(int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		
		System.out.println(d.BS_recursion(arr, 0, 0, arr.length-1));
		System.out.println(d.BS_for(arr, 100, 0, arr.length-1));
		
		d.D7_8();
	}
	
	public int BS_recursion(int[] arr, int target, int start, int end) {
		
		int mid;
		
		if(start <= end) {
			mid = (start+end)/2;
			
			if(arr[mid] == target) {
				return mid;
			}else if(arr[mid] < target) {
				return BS_recursion(arr, target, mid+1, end);
			}else {
				return BS_recursion(arr, target, start, mid-1);
			}
		}
		
		return -1; // Å½»ö ½ÇÆÐ
	}
	
	public int BS_for(int[] arr, int target, int start, int end) {
		
		int mid;
		
		while(start <= end) {
			mid = (start+end)/2;
			
			if(arr[mid] == target) {
				return mid;
			}else if(arr[mid] < target) {
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		
		return -1; // Å½»ö ½ÇÆÐ
	}
	
	public void D7_8(){
		int answer = 0;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String s[] = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int len = Integer.parseInt(s[1]);
			
			s = br.readLine().split(" ");
			int[] arr = new int[n];
			int max = 0;
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(s[i]);
				
				if(arr[i] > max) {
					max = arr[i];
				}
			}
			
			int start = 0;
			int end = max;
			int mid;
			
			while(start <= end) {
				mid = (start+end)/2;
				
				int sum = 0;
				for(int i = 0; i < n; i++) {
					int l = arr[i] - mid;
					if(l > 0) sum += l;
				}
				
				if(sum < len) {
					end = mid-1;
				}else {
					answer = mid;
					start = mid+1;
				}
			}
			
			bw.write(Integer.toString(answer));

			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
