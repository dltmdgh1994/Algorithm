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
		// p.Q5();
		
		int[] food_times = new int[3];
		food_times[0] = 3;
		food_times[1] = 1;
		food_times[2] = 2;
		System.out.println(p.Q6(food_times, 5));
	}
	
	public void Q1() { // 모험가 길드
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));

			
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
	
	public int Q6(int[] food_times, long k) { // 4 무지의 먹방 라이브

		long total_time = 0;
		PriorityQueue<Food> pq = new PriorityQueue<Food>();
		for(int i = 0; i < food_times.length; i++) {
			total_time += food_times[i];
			pq.add(new Food(food_times[i], i));
		}
		
		// 전체 음식을 먹는 시간보다 k가 크거나 같다면 -1 리턴
		if(total_time <= k) return -1;
		
		int now_time = 0;
		int pre_time = 0;
		long sum_time = 0;
		int len = food_times.length;

		// 현재 음식까지의 먹는 시간과 k와 비교
		while(sum_time + ((long)(pq.peek().getFood_time()-pre_time)*len) <= k) {
			now_time = pq.poll().getFood_time();
			sum_time += (long)(now_time-pre_time)*len;
			len--;
			pre_time = now_time;
		}
		
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 0; i < len; i++) {
			arr.add(pq.poll().getIdx());
		}
		
		arr.sort(null);

		int ans = arr.get((int)((k-sum_time)%len));
		
        return ans+1;
	}
}

class Food implements Comparable<Food> {
	
	int food_time;
	int idx;
	
	public Food(int food_time, int idx) {
		this.food_time = food_time;
		this.idx = idx;
	}
	
	public int getFood_time() {
		return food_time;
	}

	public int getIdx() {
		return idx;
	}

	@Override
	public int compareTo(Food food) {
		// TODO Auto-generated method stub
    	if(this.food_time == food.food_time) {
    		return this.idx <= food.idx ? -1 : 1;
    	}
    	else {
    		return this.food_time <= food.food_time ? -1 : 1;
    	}
	}
}
