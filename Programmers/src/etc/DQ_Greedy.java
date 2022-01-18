package etc;

import java.io.*;
import java.util.*;

public class DQ_Greedy {

	BufferedReader br;
	BufferedWriter bw;

	public static void main(String[] args) {
		
		DQ_Greedy p = new DQ_Greedy();
		
		// p.Q1();
		// p.Q2();
		// p.Q3();
		// p.Q4();
		p.Q5();
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
	
	public void Q3() { // 문자열 뒤집기
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int cnt0 = 0;
			int cnt1 = 0;
			
			String s = br.readLine();
			int curN = Integer.parseInt(s.substring(0,1));
			if(curN == 0) {
				cnt0++;
			}else {
				cnt1++;
			}
			
			for(int i = 1; i < s.length(); i++) {
				if(s.charAt(i-1) != s.charAt(i)) {
					curN = Integer.parseInt(s.substring(i,i+1));
					if(curN == 0) {
						cnt0++;
					}else {
						cnt1++;
					}
				}
			}
			
			if(cnt0 >= cnt1) {
				bw.write(Integer.toString(cnt1));
			}else {
				bw.write(Integer.toString(cnt0));
			}
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public void Q4() { // 만들 수 없는 금액
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(s[i]);
			}
			
			Arrays.sort(arr);
			
			int num = 1;
			for(int i : arr) {
				if(num < i) break;
				num += i;
			}
			
			bw.write(Integer.toString(num));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public void Q5() { // 볼링공 고르기
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] s = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int w = Integer.parseInt(s[1]);
			
			int[] weight = new int[w];
			s = br.readLine().split(" ");
			for(int i = 0; i < n; i++) {
				weight[Integer.parseInt(s[i])-1]++;
			}
			
			int ans = 0;
			for(int i : weight) {
				n -= i;
				ans += n*i;
			}
			
			bw.write(Integer.toString(ans));
			
			br.close();
			bw.close();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
