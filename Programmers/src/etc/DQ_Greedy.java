package etc;

import java.io.*;
import java.util.Arrays;

public class DQ_Greedy {

	BufferedReader br;
	BufferedWriter bw;

	public static void main(String[] args) {
		
		DQ_Greedy p = new DQ_Greedy();
		
		// p.Q1();
		p.Q2();
	}
	
	public void Q1() { // 모험가 길드
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int ans = 0;
			
			int num = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			int[] arr = new int[num];
			for(int i = 0; i < num; i++) {
				arr[i] = Integer.parseInt(s[i]);
			}
			
			Arrays.sort(arr);
			
			int cnt = 0;
			for(int i = 0; i < num; i++) {
				cnt++;
				if(arr[i] == cnt) {
					cnt = 0;
					ans++;
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
	
	public void Q2() { // 곱하기 혹은 더하기
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int ans = 0;
			
			String[] s = br.readLine().split("");
			int[] arr = new int[s.length];
			for(int i = 0; i < s.length; i++) {
				arr[i] = Integer.parseInt(s[i]);
			}
			
			for(int i = 1; i < s.length; i++) {
				int a = arr[i-1];
				int b = arr[i];
				
				if(a+b >= a*b) {
					arr[i] = a+b;
				}else {
					arr[i] = a*b;
				}
			}
			
			bw.write(Integer.toString(arr[s.length-1]));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
