package Programmers;

import java.util.Stack;

public class P12973 { // 짝지어 제거하기
	
	public static void main(String[] args) {
		P12973 p = new P12973();
		
		String s = "baabaa";
		
		System.out.println(p.solution(s));
	}
	
	// 괄호 문제와 같이 스택을 쓰는 문제
	public int solution(String s){
		
		Stack<Character> stack = new Stack<>();
		
		for(char c : s.toCharArray()) {
			if(!stack.isEmpty() && stack.peek() == c) {
				stack.pop();
			}else {
				stack.push(c);
			}
		}
		
		if(stack.isEmpty()) {
			return 1;
		}else {
			return 0;
		}
		
		// String보다 StringBuffer, StringBuilder가 처리속도가 빠르다
//		StringBuffer str = new StringBuffer();
//		str.append(s);
//
//        while(str.length() != 0) {
//        	
//        	boolean flag = false;
//        	for(int i = 0; i < str.length()-1; i++) {
//        		char a = str.charAt(i);
//        		char b = str.charAt(i+1);
//        		
//        		if(a == b) {
//        			str.delete(i, i+2);
//        			flag = true;
//        		}
//        	}
//        	
//        	if(!flag) {
//        		return 0;
//        	}
//        }
//        
//        return 1;
    }
}
