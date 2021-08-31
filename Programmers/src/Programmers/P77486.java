package Programmers;

import java.util.*;

public class P77486 { // 3 다단계 칫솔 판매

	public static void main(String[] args) {
		
		P77486 p = new P77486();
		
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"young", "john", "tod", "emily", "mary"};
		int[] amount = {12, 4, 2, 5, 10};
		
		int[] answer = p.solution(enroll, referral, seller, amount);
		
		for(int i = 0; i < answer.length; i++) {
	    	System.out.println(answer[i]);
	    }
	}

	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
	    int[] answer = new int[enroll.length];
	    
	    HashMap<String, Integer> map = new HashMap<>();
	    
	    for(int i = 0; i < enroll.length; i++) {
	    	map.put(enroll[i], i);
	    }
	    
	    for(int i = 0; i < seller.length; i++) {
	    	
	    	amount[i] *= 100;
	    	int idx = map.get(seller[i]);
	    	int m1 = (int)Math.floor((double)amount[i]*0.1);
	    	
	    	answer[idx] += (amount[i] - m1);
	    	
	    	if(m1 == 0) continue;
	    	
	    	while(!referral[idx].equals("-")) {
	    		
	    		idx = map.get(referral[idx]);
	    		int m2 = (int)Math.floor((double)m1*0.1);
	    		
	    		answer[idx] += (m1 - m2);
	    		
	    		m1 = m2;
	    		
	    		if(m1 == 0) break;
	    	}
	    }
	    
	    return answer;
	}
}
