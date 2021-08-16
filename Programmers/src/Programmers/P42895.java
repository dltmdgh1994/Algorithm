package Programmers;

import java.util.*;

public class P42895 { // 3 N으로 표현

	public static void main(String[] args) {
		
		P42895 p = new P42895();
		
		System.out.println(p.solution(8, 53));
	}

	public int solution(int N, int number) {
        int answer = 0;
        
        ArrayList<HashSet<Integer>> sets = new ArrayList<>();
        
        for(int i = 0; i < 8; i++) {
        	HashSet<Integer> set = new HashSet<>();
        	
        	// NNN 넣기
        	String s = "";
        	for(int j = 0; j <= i; j++) {
        		s+= Integer.toString(N);
        	}
        	set.add(Integer.parseInt(s));
        	
//        	N을 n번 사용해서 만들 수 있는 수 :
//        	N을 n번 연달아서 사용할 수 있는 수 U
//        	N을 1번 사용했을 때 SET 과 n-1번 사용했을 때 SET을 사칙연산한 수들의 집합 U
//        	N을 2번 사용했을 때 SET 과 n-2번 사용했을 때 SET을 사칙연산한 수들의 집합 U
//        	... U
//        	N을 n-1번 사용했을 때 SET 과 1번 사용했을 때 SET을 사칙연산한 수들의 집합
        	for(int j = 0; j < i; j++) {
        		HashSet<Integer> set1 = sets.get(j);
        		HashSet<Integer> set2 = sets.get(i-j-1);
        		
        		for(int element1 : set1) {
        			for(int element2 : set2) {
        				
        				set.add(element1+element2);
        				set.add(element1-element2);
        				set.add(element1*element2);
        				if(element2 != 0) {
        					set.add(element1/element2);
        				}
        			}
        		}
        	}
        	
        	sets.add(set);
        }
        
        for(int i = 0; i < sets.size(); i++) {
        	HashSet<Integer> set = sets.get(i);
        	
        	if(set.contains(number)) {
        		answer = i+1;
        		break;
        	}
        }
        
        if(answer != 0) {
        	return answer;
        }else {
        	return -1;
        }
        
//        String s = Integer.toString(N);
//        String[] formula = {s};
//        calc(formula, s, 2);
//        
//        if(num[number-1] == 0) {
//        	answer = -1;
//        }else {
//        	answer = num[number-1];
//        }
    }
	
//	private void calc(String[] formula, String s, int n) {
//		
//		if(n == 9) {
//			return;
//		}
//		
//		String[] temp = new String[formula.length*5];
//		int k = 0;
//		
//		for(int i = 0; i < formula.length; i++) {
//			temp[k++] = (formula[i]+"+"+s);
//		}
//		
//		for(int i = 0; i < formula.length; i++) {
//			temp[k++] = (formula[i]+"-"+s);
//		}
//
//		for(int i = 0; i < formula.length; i++) {
//			temp[k++] = (formula[i]+"*"+s);
//		}
//
//		for(int i = 0; i < formula.length; i++) {
//			temp[k++] = (formula[i]+"/"+s);
//		}
//		
//		for(int i = 0; i < formula.length; i++) {
//			temp[k++] = (formula[i]+s);
//		}
//		
//		for(int i = 0; i < temp.length; i++) {
//			formulaToInt(temp[i], n);
//		}
//		
//		calc(temp, s, n+1);
//	}
//	
//	private void formulaToInt(String formula, int n) {
//		
//		String[] number = formula.split("[-+/*]");
//		String[] cal = formula.split("[0-9]+");
//		
//		if(number.length == 1) {
//			
//			int result = Integer.parseInt(number[0]);
//			
//			if(result > 0 && result <= 32000) {
//				
//				if(num[result-1] == 0) {
//					num[result-1] = n;
//				}else if(num[result-1] > n) {
//					num[result-1] = n;
//				}
//			}
//			
//			return;
//		}
//		
//		boolean[] visited = new boolean[cal.length];
//		
//		permutation(number, cal, visited, 0, n, 0);
//	}
//	
//	private void permutation(String[] number, String[] cal, boolean[] visited, int depth, int n, int result) {
//		
//		if(depth == cal.length-1) {
//			
//			if(result > 0 && result <= 32000) {
//				
//				if(num[result-1] == 0) {
//					num[result-1] = n;
//				}else if(num[result-1] > n) {
//					num[result-1] = n;
//				}
//			}
//			
//			return;
//		}
//		
//		for(int i = 1; i < cal.length; i++) {
//			if (visited[i] != true) {
//				
//				if(depth == 0) {
//					result = Integer.parseInt(number[i-1]);
//				}
//				
//	            visited[i] = true;
//	            
//	            if(cal[i].equals("+")) {
//	            	result += Integer.parseInt(number[i]);
//	            }else if(cal[i].equals("-")) {
//	            	result -= Integer.parseInt(number[i]);
//	            }else if(cal[i].equals("*")) {
//	            	result *= Integer.parseInt(number[i]);
//	            }else {
//	            	
//	            	if(Integer.parseInt(number[i]) != 0) {
//	            		result /= Integer.parseInt(number[i]);
//	            	}else {
//	            		return;
//	            	}
//	            }
//	            
//	            permutation(number, cal, visited, depth+1, n, result);
//	            
//	            visited[i] = false;
//	        }
//		}
//	}
}

//import java.util.*;
//
//class Solution {
//    public String solution(String input) {
//        String answer = "";
//        
//        String[] s = input.split("\n");
//        
//        String[] first = s[0].split(" ");
//        int day = Integer.parseInt(first[0]);
//        int num = Integer.parseInt(first[1]);
//        answer += (s[0]+"\n");
//        
//        int dayCnt = 0;
//        int numCnt = 0;
//        boolean show = true;
//        
//        for(int i = 1; i < s.length; i++){
//            String command = s[i];
//            
//            if(command.equals("SHOW")){
//                if(show){
//                    answer += "1\n";
//                    numCnt++;
//                }else{
//                    answer += "0\n";
//                }
//                
//            }else if(command.equals("NEGATIVE")){
//                answer += "0\n";
//                show = false;
//                dayCnt += day;
//                numCnt = 0;
//                
//            }else if(command.equals("NEXT")){
//                answer += "-\n";
//                
//                if(show && numCnt == 0){
//                    dayCnt = 0;
//                }else if(!show && dayCnt != 0){
//                    dayCnt--;
//                }else if(!show && dayCnt == 0){
//                    show = true;
//                }
//                
//            }else if(command.equals("EXIT")){
//                answer += "BYE";
//                break;
//            }else{
//                answer += "ERROR\n";
//            }
//            
//            if(numCnt == num){
//                show = false;
//                dayCnt += day;
//                numCnt = 0;
//            }
//        }
//        
//        return answer;
//    }
//}
