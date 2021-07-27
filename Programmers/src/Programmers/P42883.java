package Programmers;

public class P42883 { // 큰 수 만들기

	public static void main(String[] args) {
		P42883 p = new P42883();

		System.out.println(p.solution("1000", 1));
	}
	
	public String solution(String number, int k) {
		
		// String보다 StringBuilder로 처리하는게 빠르다.
		StringBuilder answer = new StringBuilder(number);
        
        boolean decent = false;
        boolean flag = false;
        int len = answer.length();
        
        for(int j = 0; j < k; j++) {
        	flag = false;

        	// 앞뒤를 비교해서 증가하면 앞 부분을 삭제
        	if(!decent) {
        		for(int i = 0; i < len-1; i++) {
                	int front = answer.charAt(i);
                	int back = answer.charAt(i+1);
                	
                	if(front < back) {
                		flag = true;
                		answer.deleteCharAt(i);
                		len--;
                		break;
                	}
                }
        	}
        	
        	if(!flag) {
        		decent = true;
        	}
        	
        	// 모두 감소한다면 맨 뒤를 삭제
        	if(decent) {
        		answer.deleteCharAt(len-1);
        		len--;
        	}
        }
        
        return answer.toString();
    }
}

// 스택을 사용한 멋진 풀이
//import java.util.Stack;
//class Solution {
//    public String solution(String number, int k) {
//        char[] result = new char[number.length() - k];
//        Stack<Character> stack = new Stack<>();
//
//        for (int i=0; i<number.length(); i++) {
//            char c = number.charAt(i);
//            // 애초에 계속 감소한다면 뒤에꺼는 스택에 안 넣어도 된다.
//            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
//                stack.pop();
//            }
//            stack.push(c);
//        }
//        for (int i=0; i<result.length; i++) {
//            result[i] = stack.get(i);
//        }
//        return new String(result);
//    }
//}
