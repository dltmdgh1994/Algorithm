package Programmers;

import java.util.*;

public class P12909 { // 2 ¿Ã¹Ù¸¥ °ýÈ£

	public static void main(String[] args) {
		
		P12909 p = new P12909();
		
		System.out.println(p.solution("(())()"));
	}
	
	boolean solution(String s) {

        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	
        	if(c == '(') {
        		stack.push(c);
        	}else {
        		if(!stack.isEmpty()) {
        			stack.pop();
        		}else {
        			return false;
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
