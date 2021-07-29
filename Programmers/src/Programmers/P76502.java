package Programmers;

import java.util.Stack;

public class P76502 { // 괄호 회전하기
	
	public static void main(String[] args) {
		P76502 p = new P76502();

		System.out.println(p.solution("[(])"));
	}
	
	public int solution(String s) {
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++) {
        	
        	if(check(s)) {
        		answer++;
        	}

        	s = s.substring(1) + s.substring(0,1);
        }
        
        return answer;
    }
	
	private boolean check(String s) {
		
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < s.length(); i++) {
			
			char c = s.charAt(i);
			
			if(c == '[' || c == '{' || c == '(') {
				stack.push(c);
			}else {
				if(stack.isEmpty()) {
					// 시작부터 닫힌 괄호가 오면 false 리턴
					return false;
				}else {
					char front = stack.peek();
					
					if(front == '{' && c == '}') {
						stack.pop();
					}else if(front == '[' && c == ']') {
						stack.pop();
					}else if(front == '(' && c == ')') {
						stack.pop();
					}
				}
			}
		}
		
		if(stack.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
}
