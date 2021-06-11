package Programmers;
import java.util.*;

class P1835 {
	
	public static void main(String[] args) {
		P1835 p = new P1835();
		String[] s = {"N~F=0", "R~T>2"};
		System.out.println(p.solution(2, s));
	}
	
	
	static String[] d;
    static HashMap<Character,Integer> map ;
    static boolean[] visited;
    static int[] ch;
    static int answer;
    
    // 모든 경우의 수를 만든 후(순열) 조건 체크! => 코드가 간결해진다.
    public int solution(int n, String[] data) {
        d = data;
        map = new HashMap<>();
        visited = new boolean[8];
        ch = new int[8];
        answer = 0;
        map.put('A',0);
        map.put('C',1);
        map.put('F',2);
        map.put('J',3);
        map.put('M',4);
        map.put('N',5);
        map.put('R',6);
        map.put('T',7);
        dfs(0);
        return answer;
    }
    
    public static void dfs(int idx){
        if(idx == 8){
            // 조건 만족하면 answer++
            if(check()) answer++;
        }
        else{
        	// 중복 없는 순열 만들기
            for(int i=0;i<8;i++){
                if(!visited[i]){
                    visited[i] = true;
                    ch[idx] = i;
                    dfs(idx + 1);
                    visited[i] = false;
                }
            }
        }
    }
    
    public static boolean check(){
        int a,b,res;
        char op;
        for(String s : d){
            a = ch[map.get(s.charAt(0))];
            b = ch[map.get(s.charAt(2))];
            op = s.charAt(3);
            // 두 사람 간 간격이 n이면 거리는 n+1
            res = s.charAt(4)-'0' + 1;
            
            if(op == '='){ if(Math.abs(a-b)!=res) return false;}
            else if(op == '>'){ if(Math.abs(a-b) <= res) return false;}
            else {if(Math.abs(a-b) >= res) return false;}
        }
        return true;
    }
	
	// 예제만 맞고 틀림 왠지 모름
    // 조건 먼저 확인하고 가지치기하는 backtracking 쓰려고 했음.
//	String[] problem1;
//	int limit;
//	int answer;
//	
//	public int solution(int n, String[] data) {
//        answer = 0;
//        
//        problem1 = data;
//        limit = n;
//        
//        String[] arr = {"0", "0", "0", "0", "0", "0", "0", "0"};
//        // {A, C, F, J, M, N, R, T}
//        boolean[] isVisited = {false, false, false, false, false, false, false, false};
//        
//        backtracking(arr, isVisited, 0);
//        
//        
//        return answer;
//    }
//	
//	private void backtracking(String[] arr, boolean[] isVisited, int r) {
//		
//		if(r == limit) {
//			int cnt = 0;
//			for(int i = 0; i < 8; i++) {
//				System.out.print(arr[i]);
//				if(arr[i].equals("0")) {
//					cnt += 1;
//				}
//			}
//			System.out.println();
//			
//			int result = 1;
//			for(int i = cnt; i > 0; i--) {
//				result *= i;
//			}
//			
//			answer += result;
//			System.out.println(answer);
//			
//    		return;
//    	}
//		
//		String s = problem1[r];
//    	String a1 = s.substring(0,1);
//    	String a2 = s.substring(2,3);
//    	String condition = s.substring(3,4);
//    	int len = Integer.parseInt(s.substring(4,5));
//    	
//    	boolean c1 = isVisited[check(a1)];
//    	boolean c2 = isVisited[check(a2)];
//    	
//    	if(c1 && c2) {
//    		int x1 = 0; int x2 = 0;
//    		for(int i = 0; i < 8; i++) {
//    			if(arr[i].equals(a1)) {
//    				x1 = i;
//    				break;
//    			}
//    		}
//    		for(int i = 0; i < 8; i++) {
//    			if(arr[i].equals(a2)) {
//    				x2 = i;
//    				break;
//    			}
//    		}
//    		
//    		if(condition.equals("=")) {
//    			if(Math.abs(x1 - x2) == len+1) {
//    				backtracking(arr, isVisited, r+1);
//    			}else {
//    				return;
//    			}
//    		}else if(condition.equals(">")) {
//    			if(Math.abs(x1 - x2) > len+1) {
//    				backtracking(arr, isVisited, r+1);
//    			}else {
//    				return;
//    			}
//    		}else {
//    			if(Math.abs(x1 - x2) < len+1) {
//    				backtracking(arr, isVisited, r+1);
//    			}else {
//    				return;
//    			}
//    		}
//    		
//    	}else if(!c1 && !c2) {
//    		if(condition.equals("=")) {
//    			for(int i = 0; i < 8-(len+1); i++) {
//    				if(arr[i] == "0" && arr[i+(len+1)] == "0") {
//        				arr[i] = a1; arr[i+(len+1)] = a2;
//        				isVisited[check(a1)] = true; isVisited[check(a2)] = true;
//        				backtracking(arr, isVisited, r+1);
//        				
//        				arr[i] = a2; arr[i+(len+1)] = a1;
//        				backtracking(arr, isVisited, r+1);
//        				
//        				arr[i] = "0"; arr[i+(len+1)] = "0";
//        				isVisited[check(a1)] = false; isVisited[check(a2)] = false;
//        			}
//    	    	}
//    		}else if(condition.equals(">")) {
//    			for(int i = 0; i < 8-(len+2); i++) {
//    	    		for(int j = i+(len+2); j < 8; j++) {
//    	    			if(arr[i] == "0" && arr[j] == "0") {
//    	    				arr[i] = a1; arr[j] = a2;
//            				isVisited[check(a1)] = true; isVisited[check(a2)] = true;
//            				backtracking(arr, isVisited, r+1);
//            				
//            				arr[j] = a1; arr[i] = a2;
//            				backtracking(arr, isVisited, r+1);
//            				
//            				arr[i] = "0"; arr[j] = "0";
//            				isVisited[check(a1)] = false; isVisited[check(a2)] = false;
//    	    			}
//    	    		}
//    	    	}
//    		}else {
//    			for(int i = 0; i < 8-(len); i++) {
//    	    		for(int j = i+1; j < i+(len+1); j++) {
//    	    			if(arr[i] == "0" && arr[j] == "0") {
//    	    				arr[i] = a1; arr[j] = a2;
//            				isVisited[check(a1)] = true; isVisited[check(a2)] = true;
//            				backtracking(arr, isVisited, r+1);
//            				
//            				arr[j] = a1; arr[i] = a2;
//            				backtracking(arr, isVisited, r+1);
//            				
//            				arr[i] = "0"; arr[j] = "0";
//            				isVisited[check(a1)] = false; isVisited[check(a2)] = false;
//    	    			}
//    	    		}
//    	    	}
//    		}
//    	}else if(c1 && !c2) {
//    		if(condition.equals("=")) {
//    			for(int i = 0; i < 8; i++) {
//    				if(arr[i].equals(a1)) {
//    					if(i-(len+1) >= 0) {
//    						if(arr[i-(len+1)] == "0") {
//    							arr[i-(len+1)] = a2;
//    							isVisited[check(a2)] = true;
//                				backtracking(arr, isVisited, r+1);
//                				arr[i-(len+1)] = "0";
//    							isVisited[check(a2)] = false;
//    						}
//    					}
//    					
//    					if(i+(len+1) <= 7) {
//    						if(arr[i+(len+1)] == "0") {
//    							arr[i+(len+1)] = a2;
//    							isVisited[check(a2)] = true;
//                				backtracking(arr, isVisited, r+1);
//                				arr[i+(len+1)] = "0";
//    							isVisited[check(a2)] = false;
//    						}
//    					}
//    					break;
//    				}
//    			}
//    		}else if(condition.equals(">")) {
//    			for(int i = 0; i < 8; i++) {
//    				if(arr[i].equals(a1)) {
//    					for(int j = 0; j < 8; j++) {
//    						if(Math.abs(i - j) > len+1) {
//    							arr[j] = a2;
//    							isVisited[check(a2)] = true;
//                				backtracking(arr, isVisited, r+1);
//                				arr[j] = "0";
//    							isVisited[check(a2)] = false;
//    						}
//    					}
//    				}
//    			}
//    		}else {
//    			for(int i = 0; i < 8; i++) {
//    				if(arr[i].equals(a1)) {
//    					for(int j = 0; j < 8; j++) {
//    						if(Math.abs(i - j) < len+1 && Math.abs(i - j) != 0) {
//    							arr[j] = a2;
//    							isVisited[check(a2)] = true;
//                				backtracking(arr, isVisited, r+1);
//                				arr[j] = "0";
//    							isVisited[check(a2)] = false;
//    						}
//    					}
//    				}
//    			}
//    		}
//    	}else {
//    		if(condition.equals("=")) {
//    			for(int i = 0; i < 8; i++) {
//    				if(arr[i].equals(a2)) {
//    					if(i-(len+1) >= 0) {
//    						if(arr[i-(len+1)] == "0") {
//    							arr[i-(len+1)] = a1;
//    							isVisited[check(a1)] = true;
//                				backtracking(arr, isVisited, r+1);
//                				arr[i-(len+1)] = "0";
//    							isVisited[check(a1)] = false;
//    						}
//    					}
//    					
//    					if(i+(len+1) <= 7) {
//    						if(arr[i+(len+1)] == "0") {
//    							arr[i+(len+1)] = a1;
//    							isVisited[check(a1)] = true;
//                				backtracking(arr, isVisited, r+1);
//                				arr[i+(len+1)] = "0";
//    							isVisited[check(a1)] = false;
//    						}
//    					}
//    					break;
//    				}
//    			}
//    		}else if(condition.equals(">")) {
//    			for(int i = 0; i < 8; i++) {
//    				if(arr[i].equals(a2)) {
//    					for(int j = 0; j < 8; j++) {
//    						if(Math.abs(i - j) > len+1) {
//    							arr[j] = a1;
//    							isVisited[check(a1)] = true;
//                				backtracking(arr, isVisited, r+1);
//                				arr[j] = "0";
//    							isVisited[check(a1)] = false;
//    						}
//    					}
//    				}
//    			}
//    		}else {
//    			for(int i = 0; i < 8; i++) {
//    				if(arr[i].equals(a2)) {
//    					for(int j = 0; j < 8; j++) {
//    						if(Math.abs(i - j) < len+1 && Math.abs(i - j) != 0) {
//    							arr[j] = a1;
//    							isVisited[check(a1)] = true;
//                				backtracking(arr, isVisited, r+1);
//                				arr[j] = "0";
//    							isVisited[check(a1)] = false;
//    						}
//    					}
//    				}
//    			}
//    		}
//    	}
//	}
//	
//	// {A, C, F, J, M, N, R, T}
//	private int check(String s) {
//		if(s.equals("A")) {
//			return 0;
//		}else if(s.equals("C")) {
//			return 1;
//		}else if(s.equals("F")) {
//			return 2;
//		}else if(s.equals("J")) {
//			return 3;
//		}else if(s.equals("M")) {
//			return 4;
//		}else if(s.equals("N")) {
//			return 5;
//		}else if(s.equals("R")) {
//			return 6;
//		}else {
//			return 7;
//		}
//	}
}
