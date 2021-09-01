package Programmers;

import java.util.*;

public class P17678 { // 3 셔틀버스

	public static void main(String[] args) {
		
		P17678 p = new P17678();
		
		String[] timetable = {"09:00", "09:00", "09:00", "09:00"};
		
		System.out.println(p.solution(2, 1, 2, timetable));
	}

	// 셔틀 운행 횟수 n, 셔틀 운행 간격 t, 한 셔틀에 탈 수 있는 최대 크루 수 m
	// 크루가 대기열에 도착하는 시각을 모은 배열 timetable
	public String solution(int n, int t, int m, String[] timetable) {
	    String answer = "";
	    
	    int limit = 540+(n-1)*t;
	    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
	    
	    for(int i = 0; i < n; i++) {
	    	map.put(i*t+540, new ArrayList<Integer>());
	    }
	    
	    int[] tt = new int[timetable.length];
	    for(int i = 0; i < timetable.length; i++) {
	    	String[] s = timetable[i].split(":");
	    	
	    	tt[i] = 60*Integer.parseInt(s[0]) + Integer.parseInt(s[1]);
	    }
	    
	    Arrays.sort(tt);
	    
	    int k = 540;   
	    for(int i = 0; i < tt.length; i++) {
	    	ArrayList<Integer> arr = map.get(k);
	    	
	    	// 제일 먼저 도착한 사람이 버스 끊기고 도착
	    	if(tt[i] > limit) break;
	    	
	    	// 크루가 시간 내 도착하면 버스 탑승
	    	if(k >= tt[i]) {
	    		arr.add(tt[i]);
	    	}else { // 크루가 시간 밖이라 다음 버스
	    		k += t;
	    		i--;
	    	}
	    	
	    	if(arr.size() == m) k += t; // 버스가 꽉 차서 다음 버스
	    	
	    	if(k > limit) break; // 버스 끊김
	    }    
	    
	    int ans = 0; 
	    ArrayList<Integer> arr = map.get((n-1)*t+540);
	    
	    if(arr.size() == m) { // 만석이면 마지막에 탑승한 사람보다 1분 먼저
	    	ans = arr.get(arr.size()-1)-1;
	    }else { // 아니면 마지막 버스 탑승
	    	ans = (n-1)*t+540;
	    }
	    
	    // 이 경우 탑승 자리가 1이면 마지막 버스가 아니라 첫 버스에 탄다.
//	    boolean flag = false;
//	    for(int i = n-1; i >= 0; i--) {
//	    	ArrayList<Integer> arr = map.get(i*t+540);
//	    	
//	    	if(arr.size() != m) {
//	    		ans = i*t+540;
//	    		flag = true;
//	    	}else {
//	    		for(int j = arr.size()-1; j > 0; j--) {
//	    			int front = arr.get(j-1);
//	    			int back = arr.get(j);
//	    			
//	    			if(front != back) {
//	    				ans = front;
//	    				flag = true;
//	    				break;
//	    			}
//	    		}
//	    	}
//	    	
//	    	if(flag) break;
//	    }
//	    
//	    if(!flag) {
//	    	ArrayList<Integer> arr = map.get(540);
//	    	ans = arr.get(0)-1;
//	    }
	    
	    int hour = ans/60;
	    int minute = ans%60;
	    
	    if(hour < 10) {
	    	answer += "0"+Integer.toString(hour)+":";
	    }else {
	    	answer += Integer.toString(hour)+":";
	    }
	    
	    if(minute < 10) {
	    	answer += "0"+Integer.toString(minute);
	    }else {
	    	answer += Integer.toString(minute);
	    }
	    
	    return answer;
	}
}
