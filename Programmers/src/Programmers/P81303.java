package Programmers;

import java.util.*;

public class P81303 { // 3 ǥ ����
	
	public static void main(String[] args) {
		
		P81303 p = new P81303();
		
		String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
		
		System.out.println(p.solution(8, 2, cmd));
	}
	

	// ó�� ǥ�� �� ������ ��Ÿ���� ���� n, ó���� ���õ� ���� ��ġ�� ��Ÿ���� ���� k
	// ������ ��ɾ���� ��� ���ڿ� �迭 cmd
	//	"U X": ���� ���õ� �࿡�� Xĭ ���� �ִ� ���� �����մϴ�.
	//	"D X": ���� ���õ� �࿡�� Xĭ �Ʒ��� �ִ� ���� �����մϴ�.
	//	"C" : ���� ���õ� ���� ������ ��, �ٷ� �Ʒ� ���� �����մϴ�. 
	//        ��, ������ ���� ���� ������ ���� ��� �ٷ� �� ���� �����մϴ�.
	//	"Z" : ���� �ֱٿ� ������ ���� ������� �����մϴ�. 
	//        ��, ���� ���õ� ���� �ٲ��� �ʽ��ϴ�.
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
        
        // ArrayList�� 'X'�� Add�ϴ� �ð��ʰ�
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
