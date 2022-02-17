package Programmers;

import java.util.*;

public class P42889 { // 1 ½ÇÆÐÀ²
	
	public static void main(String[] args) {
		P42889 p = new P42889();
		
		int[] arr = p.solution(4, new int[] {4,4,4,4,4});
		
		for (int i : arr) {
			System.out.println(i);
		}
	}

    public int[] solution(int N, int[] stages) {
        
        int[] success = new int[N+1];
        for(int i = 0; i < stages.length; i++) {
        	success[stages[i]-1]++;
        }
        
        int num = stages.length;
        double[][] fail = new double[N][2];
        for(int i = 0; i < N; i++) {
        	fail[i][0] = i+1;
        	if(num > 0) {
        		fail[i][1] = (double)success[i]/num;
            	num -= success[i];
        	}else {
        		fail[i][1] = 0;
        	}
        }
        
        Arrays.sort(fail, (o1,o2)->{
        	if(o1[1] == o2[1]) {
        		return Double.compare(o1[0], o2[0]);
        	}else {
        		return -Double.compare(o1[1], o2[1]);
        	}
        });
        
        int[] answer = new int[N];
        for(int i = 0; i < N; i++) {
        	answer[i] = (int)fail[i][0];
        }
        
        return answer;
    }
}
