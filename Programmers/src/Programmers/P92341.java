package Programmers;

import java.util.HashMap;
import java.util.TreeMap;

public class P92341 { // 2 주차 요금 계산

	public static void main(String[] args) {
		
		P92341 p = new P92341();
		
		int[] fees = {180, 5000, 10, 600};
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		
		int[] ans = p.solution(fees, records);
		for(int i : ans) {
			System.out.println(i);
		}
	}
	
    public int[] solution(int[] fees, String[] records) {
    	// 각 차가 주차한 총 시간
        TreeMap<String, Integer> TotalTime = new TreeMap<>();
        // 각 차가 입장한 시간
        HashMap<String, String> enterTime = new HashMap<>();
        
        for(String record : records) {
        	String[] s = record.split(" ");
        	String t = s[0];
        	String n = s[1];
        	String io = s[2];
        	
        	if(io.equals("IN")) {
        		enterTime.put(n, t);
        	}else {
        		String et = enterTime.get(n);
        		if(TotalTime.containsKey(n)) {
        			TotalTime.put(n, TotalTime.get(n)+calTime(et,t));
        		}else {
        			TotalTime.put(n, calTime(et,t));
        		}
        		enterTime.remove(n); // 출차
        	}
        }
        
        // 출차 기록이 없는 경우
        for(String n : enterTime.keySet()) {
        	String et = enterTime.get(n);
    		if(TotalTime.containsKey(n)) {
    			TotalTime.put(n, TotalTime.get(n)+calTime(et,"23:59"));
    		}else {
    			TotalTime.put(n, calTime(et,"23:59"));
    		}
        }
        
        int[] answer = new int[TotalTime.size()];
        int baseT = fees[0];
        int baseF = fees[1];
        int unitT = fees[2];
        int unitF = fees[3];
        
        int idx = 0;
        for(String n : TotalTime.keySet()) {
        	int total = TotalTime.get(n);
        	if(total <= baseT) {
        		answer[idx++] = baseF;
        	}else {
        		int t = total-baseT;
        		if(t%unitT == 0) {
        			answer[idx++] = baseF + (t/unitT)*unitF;
        		}else {
        			answer[idx++] = baseF + ((t/unitT)+1)*unitF;
        		}
        	}
        }

        return answer;
    }
    
    private int calTime(String t1, String t2) {
    	
    	String[] s1 = t1.split(":");
    	String[] s2 = t2.split(":");
    	
    	int h1 = Integer.parseInt(s1[0]);
    	int m1 = Integer.parseInt(s1[1]);
    	int h2 = Integer.parseInt(s2[0]);
    	int m2 = Integer.parseInt(s2[1]);
    	
    	int result = 0;
    	if(m1 > m2) {
    		result += (60-(m1-m2));
    		result += (h2-h1-1)*60;
    	}else {
    		result += (m2-m1);
    		result += (h2-h1)*60;
    	}
    	
    	return result;
    }
}
