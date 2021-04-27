package Programmers;

public class P12899 { // 124 나라의 숫자
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(12));
	}
}

class Solution {
    public String solution(int n) {
        String answer = "";
        
        int num = 1;
        
        while(n > num*3) {
        	num *= 3;
        	n -= num;
        }
        
        while(num > 0) {
        	double q = (double)n/(double)num;
        	
        	if(n%num == 0) {
        		n = num;
        	}else {
        		n %= num;
        	}
        	
        	num /= 3;
        	
        	if(q > 2) {
        		answer += "4";
        	}else if(q > 1) {
        		answer += "2";
        	}else {
        		answer += "1";
        	}
        }
        
        return answer;
    }
}