package Programmers;

import java.util.*;

public class P42628 { // 3 이중우선순위큐

	public static void main(String[] args) {
		
		P42628 p = new P42628();
		
		String[] operations = {"I 7","I 5","I -5","D -1"};
		int[] ans = p.solution(operations);
		
		System.out.println(ans[0]);
		System.out.println(ans[1]);
	}
	
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < operations.length; i++) {
        	String op = operations[i].substring(0,1);
        	int num = Integer.parseInt(operations[i].substring(2));
        	
        	if(op.equals("I")) {
        		minQ.add(num);
        		maxQ.add(num);
        	}else {
        		if(minQ.size() != 0) {
        			if(num == 1) { // 최댓값 제거
            			int max = maxQ.poll();
            			minQ.remove(max);
            		}else { // 최솟값 제거
            			int min = minQ.poll();
            			maxQ.remove(min);
            		}
        		}
        	}
        }
        
        if(minQ.size() != 0) {
        	return new int[] {maxQ.peek(), minQ.peek()};
        }else {
        	return new int[] {0, 0};
        }
    }
}
