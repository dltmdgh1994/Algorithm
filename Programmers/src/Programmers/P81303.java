package Programmers;

import java.util.*;

public class P81303 { // 3 표 편집
	
	public static void main(String[] args) {
		
		P81303 p = new P81303();
		
		String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
		
		System.out.println(p.solution(8, 2, cmd));
	}
	

	// 처음 표의 행 개수를 나타내는 정수 n, 처음에 선택된 행의 위치를 나타내는 정수 k
	// 수행한 명령어들이 담긴 문자열 배열 cmd
	//	"U X": 현재 선택된 행에서 X칸 위에 있는 행을 선택합니다.
	//	"D X": 현재 선택된 행에서 X칸 아래에 있는 행을 선택합니다.
	//	"C" : 현재 선택된 행을 삭제한 후, 바로 아래 행을 선택합니다. 
	//        단, 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택합니다.
	//	"Z" : 가장 최근에 삭제된 행을 원래대로 복구합니다. 
	//        단, 현재 선택된 행은 바뀌지 않습니다.
	public String solution(int n, int k, String[] cmd) {
        
        Stack<Integer> stack = new Stack<>();
        int len = n;
        
        for(int i = 0; i < cmd.length; i++) {
        	
        	String s = cmd[i];
        	char c = s.charAt(0);
        	
        	if(c == 'U') {
        		int tmp = Integer.parseInt(s.substring(2));
        		
        		if(k >= tmp) {
        			k -= tmp;
        		}else {
        			k = 0;
        		}
        	}else if(c == 'D') {
        		int tmp = Integer.parseInt(s.substring(2));
        		
        		if(k >= len - tmp) {
        			k = len-1;
        		}else {
        			k += tmp;
        		}
        	}else if(c == 'C') {
        		stack.push(k);
        		
        		if(k == len-1) {
        			k--; len--;
        		}else {
        			len--;
        		}
        	}else {
        		int tmp = stack.pop();
        		
        		if(tmp <= k) {
        			k++; len++;
        		}else {
        			len++;
        		}
        	}
        }
        
        // ArrayList로 'X'를 Add하니 시간초과
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++) {
        	sb.append('O');
        }
        
        while(!stack.isEmpty()) {
        	int temp = stack.pop();
        	sb.insert(temp, 'X');
        }
        
        return sb.toString();
    }
}
