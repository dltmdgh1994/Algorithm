package Programmers;

import java.util.*;

public class P49994 { // 2 방문 길이
	
	public static void main(String[] args) {
		
		P49994 p = new P49994();
	
		System.out.println(p.solution("RRRRRRRRR"));
		System.out.println(p.solution("LULLLLLLU"));
	}
	
	public int solution(String dirs) {
        int answer = 0;
        
        HashSet<String> set = new HashSet<>();
        int row = 5; // 0 ~ 10
        int col = 5;
        
        for(int i = 0; i < dirs.length(); i++) {
        	
        	char c = dirs.charAt(i);
        	
        	if(c == 'U' && row < 10) {
        		row += 1;
        		
        		String s = Integer.toString(row) + Integer.toString(col) + c;
        		if(!set.contains(s)) {
        			// 경로이기 때문에 오는 길, 가는 길 모두 처리
        			set.add(s);
        			
        			set.add(Integer.toString(row-1) + Integer.toString(col) + "D");
        			
        			answer++;
        		}
        	}else if(c == 'D' && row > 0) {
        		row -= 1;
        		
        		String s = Integer.toString(row) + Integer.toString(col) + c;
        		if(!set.contains(s)) {
        			set.add(s);
        			
        			set.add(Integer.toString(row+1) + Integer.toString(col) + "U");
        			
        			answer++;
        		}
        	}else if(c == 'L' && col > 0) {
        		col -= 1;
        		
        		String s = Integer.toString(row) + Integer.toString(col) + c;
        		if(!set.contains(s)) {
        			set.add(s);
        			
        			set.add(Integer.toString(row) + Integer.toString(col+1) + "R");
        			
        			answer++;
        		}
        	}else if(c == 'R' && col < 10){
        		col += 1;
        		
        		String s = Integer.toString(row) + Integer.toString(col) + c;
        		if(!set.contains(s)) {
        			set.add(s);
        			
        			set.add(Integer.toString(row) + Integer.toString(col-1) + "L");
        			
        			answer++;
        		}
        	}
        	
//        	System.out.println(c + " row : " + row + " col : " + col + " " + answer);
        	
        }
        
        return answer;
    }
}
