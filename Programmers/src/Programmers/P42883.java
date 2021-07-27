package Programmers;

public class P42883 { // ū �� �����

	public static void main(String[] args) {
		P42883 p = new P42883();

		System.out.println(p.solution("1000", 1));
	}
	
	public String solution(String number, int k) {
		
		// String���� StringBuilder�� ó���ϴ°� ������.
		StringBuilder answer = new StringBuilder(number);
        
        boolean decent = false;
        boolean flag = false;
        int len = answer.length();
        
        for(int j = 0; j < k; j++) {
        	flag = false;

        	// �յڸ� ���ؼ� �����ϸ� �� �κ��� ����
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
        	
        	// ��� �����Ѵٸ� �� �ڸ� ����
        	if(decent) {
        		answer.deleteCharAt(len-1);
        		len--;
        	}
        }
        
        return answer.toString();
    }
}

// ������ ����� ���� Ǯ��
//import java.util.Stack;
//class Solution {
//    public String solution(String number, int k) {
//        char[] result = new char[number.length() - k];
//        Stack<Character> stack = new Stack<>();
//
//        for (int i=0; i<number.length(); i++) {
//            char c = number.charAt(i);
//            // ���ʿ� ��� �����Ѵٸ� �ڿ����� ���ÿ� �� �־ �ȴ�.
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
