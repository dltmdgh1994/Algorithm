package Programmers;

import java.util.Arrays;

public class P43238 { // 3 �Ա��ɻ�

	public static void main(String[] args) {
		
		P43238 p = new P43238();
		
		System.out.println(p.solution(6, new int[] {7,10}));
		
	}

	// �Ա��ɻ縦 ��ٸ��� ��� �� n
	// �� �ɻ���� �� ���� �ɻ��ϴµ� �ɸ��� �ð��� ��� �迭 times
	// ��� ����� �ɻ縦 �޴µ� �ɸ��� �ð��� �ּڰ��� return
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
