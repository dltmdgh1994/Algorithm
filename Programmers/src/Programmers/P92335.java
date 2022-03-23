package Programmers;

import java.util.HashSet;

public class P92335 { // 2 k진수에서 소수 개수 구하기

	public static void main(String[] args) {
		
		P92335 p = new P92335();
		
		System.out.println(p.solution(437674, 3));
	}
	
    public int solution(int n, int k) {
        
        String converted = Integer.toString(n, k);
        
        String temp = "";
        int answer = 0;
        for(char c : converted.toCharArray()) {
        	if(c != '0') {
        		temp += c;
        	}else {
        		if(!temp.equals("")) {
        			long num = Long.parseLong(temp);
        			if(isPrime(num)) {
        				System.out.println(num);
        				answer++;
        			}
        		}
        		temp = "";
        	}
        }
        
		if(!temp.equals("")) {
			long num = Long.parseLong(temp);
			if(isPrime(num)) {
				System.out.println(num);
				answer++;
			}
		}
        
        return answer;
    }
    
    private boolean isPrime(long n) {
    	if(n == 1) return false;
    	
    	for(long i = 2; i < Math.sqrt(n); i++) {
    		if(n % i == 0) return false;
    	}
    	
    	return true;
    }
}
