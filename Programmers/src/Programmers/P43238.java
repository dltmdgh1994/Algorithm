package Programmers;

import java.util.Arrays;

public class P43238 { // 3 �Ա��ɻ�

	public static void main(String[] args) {
		
		P43238 p = new P43238();
		
		System.out.println(p.solution(1, new int[] {3,10}));
		
	}

	// �Ա��ɻ縦 ��ٸ��� ��� �� n
	// �� �ɻ���� �� ���� �ɻ��ϴµ� �ɸ��� �ð��� ��� �迭 times
	// ��� ����� �ɻ縦 �޴µ� �ɸ��� �ð��� �ּڰ��� return
	public long solution(long n, int[] times) {
		
		long answer = 0;
		
		Arrays.sort(times);
		
		long max = n*times[times.length-1];
		long min = 1;
		
        long time = 0;
        
        // �ɻ�� ������ ��⿭�� ���� ��� 
        // times[(int)(n-1)]�� ������ �ִ�
        if(n<=times.length) {
        	answer=times[(int)(n-1)];
        }else {
        	answer=max;
        }
        
        // �̺� Ž��
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
