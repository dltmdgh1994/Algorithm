package Programmers;

import java.util.*;

public class P72414 { // 3 ±¤°í »ðÀÔ

	public static void main(String[] args) {
		
		P72414 p = new P72414();
		
		String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
		
		System.out.println(p.solution("02:03:55", "00:14:15", logs));
	}
	
	public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        
        if(play_time.equals(adv_time)) {
        	return "00:00:00";
        }
        
        long max = 0;
        
        ArrayList<String[]> log = new ArrayList<>();
        for(int i = 0; i < logs.length; i++) {
        	String[] tmp = logs[i].split("-");
        	
        	log.add(tmp);
        }
        
        Collections.sort(log, (o1, o2) -> compareToTime(timeToSec(o1[0]), timeToSec(o2[0])));
        
        for(int i = 0; i < logs.length; i++) {
        	int stTime = timeToSec(log.get(i)[0]);
        	int adEndTime = stTime + timeToSec(adv_time);
        	long sum = 0;
        	
        	for(int j = i; j < logs.length; j++) {
        		int st = timeToSec(log.get(j)[0]);
        		int et = timeToSec(log.get(j)[1]);
        		
        		if(st >= stTime && st < adEndTime) {
        			if(et >= adEndTime) {
        				sum += (adEndTime - st);
        			}else {
        				sum += (et - st);
        			}
        		}else if(st >= adEndTime) break;
        	}
        	
        	if(sum > max) {
        		max = sum;
        		answer = log.get(i)[0];
        	}
        }
        
        
        return answer;
    }
	
	private int timeToSec(String t1) {
		String[] tmp1 = t1.split(":");
		
		int h1 = Integer.parseInt(tmp1[0]);
		int m1 = Integer.parseInt(tmp1[1]);
		int s1 = Integer.parseInt(tmp1[2]);
		
		return h1*3600 + m1*60 + s1;
	}
	
	private int compareToTime(int t1, int t2) {
		if(t1 > t2) {
			return 1;
		}else if(t1 == t2) {
			return 0;
		}else {
			return -1;
		}
	}
}
