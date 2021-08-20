package Programmers;

import java.util.Arrays;

public class P43238 { // 3 입국심사

	public static void main(String[] args) {
		
		P43238 p = new P43238();
		
		System.out.println(p.solution(1, new int[] {3,10}));
		
	}

	// 입국심사를 기다리는 사람 수 n
	// 각 심사관이 한 명을 심사하는데 걸리는 시간이 담긴 배열 times
	// 모든 사람이 심사를 받는데 걸리는 시간의 최솟값을 return
	public long solution(long n, int[] times) {
		
		long answer = 0;
		
		Arrays.sort(times);
		
		long max = n*times[times.length-1];
		long min = 1;
		
        long time = 0;
        
        // 심사관 수보다 대기열이 적은 경우 
        // times[(int)(n-1)]이 가능한 최댓값
        if(n<=times.length) {
        	answer=times[(int)(n-1)];
        }else {
        	answer=max;
        }
        
        // 이분 탐색
        while(min <= max) {
        	
        	time = (max+min)/2;
        	long num = getNum(time, times, n);
        	
        	if(num >= n) {
        		max = time-1;
        		answer = answer>time?time:answer;
        	}else{
        		min = time+1;
        	}
        	
//        	System.out.println(min + " " + time + " " + max);
        }
        
        return answer;
    }
	
	private long getNum(long time, int[] times, long n) {
		long num = 0;
		
		for(int i = 0; i < times.length; i++) {
			num += (time/times[i]);
		}
		
		return num;
	}
}
