package Programmers;

import java.util.Arrays;

public class P43238 { // 3 입국심사

	public static void main(String[] args) {
		
		P43238 p = new P43238();
		
		System.out.println(p.solution(6, new int[] {7,10}));
		
	}

	// 입국심사를 기다리는 사람 수 n
	// 각 심사관이 한 명을 심사하는데 걸리는 시간이 담긴 배열 times
	// 모든 사람이 심사를 받는데 걸리는 시간의 최솟값을 return
	public long solution(int n, int[] times) {
		
		Arrays.sort(times);
		
        long time = (times[times.length-1]/2) * times.length;
        
        while(true) {
        	long maxNum = getMaxNum(time, times);
        	
        	if(maxNum == n) {
        		break;
        	}else if(maxNum > n) {
        		time--;
        	}else {
        		time++;
        	}
        }
        
        return time;
    }
	
	private long getMaxNum(long time, int[] times) {
		long maxNum = 0;
		
		for(int i = 0; i < times.length; i++) {
			maxNum += (time/times[i]);
		}
		
		return maxNum;
	}
}
