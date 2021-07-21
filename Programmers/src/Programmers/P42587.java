package Programmers;

import java.util.*;

public class P42587 { // «¡∏∞≈Õ
	
	public static void main(String[] args) {
		P42587 p = new P42587();
		
		int[] a = {1, 1, 9, 1, 1, 1};
		p.solution(a, 0);
	}
	
	public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < priorities.length; i++) {
        	q.add(i);
        }
        
        while(!q.isEmpty()) {
        	int idx = q.poll();
        	int priority = priorities[idx];
        	
        	System.out.println(idx + " " + priority);
        	
        	boolean flag = false;
        	for(int i = 0; i <priorities.length; i++) {
        		if(priorities[i] > priority) {
        			flag = true;
        			break;
        		}
        	}
        	
        	if(flag) {
        		q.add(idx);
        	}else {
        		answer++;
        		priorities[idx] = 0;
        		
        		if(idx == location) {
        			return answer;
        		}
        	}
        }
        
        return answer;
    }
}
