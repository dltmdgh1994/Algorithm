package Programmers;

import java.util.ArrayList;

public class P67257 { // 수식 최대화
	
	public static void main(String[] args) {
		P67257 p = new P67257();
		
		System.out.println(p.solution("100-200*300-500+20"));
	}

	public long solution(String expression) {
        
        String[][] priority = {{"+","-","*"}, {"+","*","-"}, {"-","+","*"},
        					{"-","*","+"}, {"*","+","-"}, {"*","-","+"}};
        
        ArrayList<Long> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();
        
        String s = "";
        for(int i = 0; i < expression.length(); i++) {
        	String str = expression.substring(i,i+1);
        	
        	if(str.equals("+") || str.equals("-") || str.equals("*")) {
        		arr1.add(Long.parseLong(s));
        		arr2.add(str);
        		s = "";
        	}else {
        		s += str;
        	}
        }
        arr1.add(Long.parseLong(s));
        
        long max = 0;
        for(int i = 0; i < 6; i++) {
        	
        	// 그냥 대입하면 얕은 복사
        	ArrayList<Long> temp1 = new ArrayList<>();
    		ArrayList<String> temp2 = new ArrayList<>();
        	
        	for(long a : arr1) {
        		temp1.add(a);
        	}
    		
    		for(String a : arr2) {
    			temp2.add(a);
    		}
    		
        	for(int j = 0; j < 3; j++) {
        		String cal = priority[i][j];
        	
        		long ans = 0;
    			for(int k = 0; k < temp2.size(); k++) {
    				if(temp2.get(k).equals(cal) && cal.equals("+")) {
        				ans = temp1.get(k) + temp1.get(k+1);
        				temp1.set(k, ans);
        				temp1.remove(k+1);
        				temp2.remove(k);
        				k--;
        			}else if(temp2.get(k).equals(cal) && cal.equals("-")) {
        				ans = temp1.get(k) - temp1.get(k+1);
        				temp1.set(k, ans);
        				temp1.remove(k+1);
        				temp2.remove(k);
        				k--;
        			}else if(temp2.get(k).equals(cal) && cal.equals("*")) {
        				ans = temp1.get(k) * temp1.get(k+1);
        				temp1.set(k, ans);
        				temp1.remove(k+1);
        				temp2.remove(k);
        				k--;
        			}
    			}
        	}
        	
        	long val = (long)Math.abs((double)temp1.get(0));
        	if(val > max) {
        		max = val;
        	}
        }
        
        return max;
    }
}
