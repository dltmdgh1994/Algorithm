package Programmers;

public class P72414 { // 3 광고 삽입

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
        
        long[] cumTime = new long[360000];
        
        for(int i = 0; i < logs.length; i++) {
        	String[] tmp = logs[i].split("-");
        	
        	int st = timeToSec(tmp[0]);
        	int et = timeToSec(tmp[1]);
        	
        	cumTime[st]++;
        	cumTime[et]--; // 시청이 끝났으므로 뒤에 누적 시간에 추가되는 거 빼줌
        }
        
        // 0 0 1 0 0 -1 0 0
        // 0 0 1 1 1 0 0 0
        int ptSec = timeToSec(play_time);
        int adSec = timeToSec(adv_time);
        for(int i = 1; i <= ptSec; i++) {
        	cumTime[i] += cumTime[i-1];
        }
        
        long sum = 0;
        for(int i = 0; i < adSec; i++) {
        	sum += cumTime[i];
        }
        
        long max = sum;
        int idx = 0;
        
        // 중복을 최대한 줄여야 시간 초과 방지
        for(int i = 1; i < ptSec-adSec+1; i++) {	
        	
        	// 앞에꺼 제거, 뒤에꺼 추가
        	sum -= cumTime[i-1];
        	sum += cumTime[i+adSec-1];
        	
        	if(sum > max) {
    			max = sum;
    			idx = i;
    		}
        }
        
        answer = secToTime(idx);
        
        return answer;
    }
	
	private int timeToSec(String t1) {
		String[] tmp1 = t1.split(":");
		
		int h1 = Integer.parseInt(tmp1[0]);
		int m1 = Integer.parseInt(tmp1[1]);
		int s1 = Integer.parseInt(tmp1[2]);
		
		return h1*3600 + m1*60 + s1;
	}
	
	private String secToTime(int t1) {
		String answer = "";
		
		int h1 = t1/3600;
		t1 %= 3600;
		
		int m1 = t1/60;
		t1 %= 60;
		
		if(h1 < 10) {
			answer += ("0" + Integer.toString(h1) + ":");
		}else {
			answer += Integer.toString(h1) + ":";
		}
		
		if(m1 < 10) {
			answer += ("0" + Integer.toString(m1) + ":");
		}else {
			answer += Integer.toString(m1) + ":";
		}
		
		if(t1 < 10) {
			answer += ("0" + Integer.toString(t1));
		}else {
			answer += Integer.toString(t1);
		}
		
		return answer;
	}
}
