package Programmers;

import java.util.*;

public class P17678 { // 3 ��Ʋ����

	public static void main(String[] args) {
		
		P17678 p = new P17678();
		
		String[] timetable = {"09:00", "09:00", "09:00", "09:00"};
		
		System.out.println(p.solution(2, 1, 2, timetable));
	}

	// ��Ʋ ���� Ƚ�� n, ��Ʋ ���� ���� t, �� ��Ʋ�� Ż �� �ִ� �ִ� ũ�� �� m
	// ũ�簡 ��⿭�� �����ϴ� �ð��� ���� �迭 timetable
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
	    	
	    	// ���� ���� ������ ����� ���� ����� ����
	    	if(tt[i] > limit) break;
	    	
	    	// ũ�簡 �ð� �� �����ϸ� ���� ž��
	    	if(k >= tt[i]) {
	    		arr.add(tt[i]);
	    	}else { // ũ�簡 �ð� ���̶� ���� ����
	    		k += t;
	    		i--;
	    	}
	    	
	    	if(arr.size() == m) k += t; // ������ �� ���� ���� ����
	    	
	    	if(k > limit) break; // ���� ����
	    }    
	    
	    int ans = 0; 
	    ArrayList<Integer> arr = map.get((n-1)*t+540);
	    
	    if(arr.size() == m) { // �����̸� �������� ž���� ������� 1�� ����
	    	ans = arr.get(arr.size()-1)-1;
	    }else { // �ƴϸ� ������ ���� ž��
	    	ans = (n-1)*t+540;
	    }
	    
	    // �� ��� ž�� �ڸ��� 1�̸� ������ ������ �ƴ϶� ù ������ ź��.
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
