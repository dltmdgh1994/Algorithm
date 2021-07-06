package Programmers;

import java.util.*;

public class P72411 { // 메뉴 리뉴얼
	
	ArrayList<String> arr;
	
	public static void main(String[] args) {
		P72411 p = new P72411();
		
		String[] orders = new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = new int[] {2,3,4};
		
		String[] ans = p.solution(orders, course);
		for(int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
		
	}
	
	// 테스트 케이스 중 하나만 시간초과 => 최대와 최소 사이 모든 조합을 다 뽑아서 걸러서 그런듯
	// 주문한 단품 메뉴 조합에서 가능한 조합을 미리 뽑아 돌려야 시간 초과 안뜬다.
	public String[] solution(String[] orders, int[] course) {
        
        int maxChar = 0;
        int minChar = 100;
        int maxLen = 0;
        String[] order = new String[orders.length];
        
        for(int i = 0; i < orders.length; i++) {
        	int len = orders[i].length();
        	
//            int ch1 = findMaxChar(orders[i]);
//            int ch2 = findMinChar(orders[i]);
//            if(ch1 > maxChar){
//                maxChar = ch1;
//            }
//            
//            if(ch2 < minChar){
//            	minChar = ch2;
//            }
            
            if(len > maxLen){
                maxLen = len;
            }
            
            // orders는 정렬되어 있지 않으므로 정렬해준다.
            char[] StringtoChar = orders[i].toCharArray();
            Arrays.sort(StringtoChar);
            order[i] = new String(StringtoChar);
        }
        
        arr = new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();
        
        for(int i = 0; i < course.length; i++){
        	
        	if(course[i] > maxLen){
                break;
            }
        	
        	for(String o : order) {
        		int oLen = o.length();
        		String[] str = new String[oLen];
                boolean[] visited = new boolean[oLen];
                for(int j = 0; j < oLen; j++) {
                	str[j] = o.substring(j,j+1);
                }
                
            	comb(str, visited, 0, oLen, course[i]);
        	}
        	
        	int max = 1;

        	ArrayList<String> arr2 = new ArrayList<>();
            for(int j = 0; j < arr.size(); j++) {
            	int cnt = 0;
            	
            	for(String o : order){
            		
                    if(check(o, arr.get(j))) {
                    	cnt++;
                    }
                }
            	
            	if(cnt > max) {
                	arr2.clear();
                	max = cnt;
                	arr2.add(arr.get(j));
                }else if(cnt == max && cnt != 1) {
                	arr2.add(arr.get(j));
                }
            }
            
            for(int j = 0; j < arr2.size(); j++) {
            	ans.add(arr2.get(j));
            }
            
            arr2.clear();
        	arr.clear();
        }
        
        ans.sort(null);
        
        String[] answer = new String[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
        	answer[i] = ans.get(i);
        }
        
        return answer;
    }
    
    private void comb(String[] str, boolean[] visited, int start, int n, int r) {
		if(r == 0) {
			String ans = "";
	        for(int i = 0; i < n; i++) {
	        	if(visited[i]) {
	        		ans += str[i];
	        	}
	        }
	        
	        if(!arr.contains(ans)) {
	        	arr.add(ans);
	        }
	        
	        return;
	    } 

	    for(int i=start; i<n; i++) {
	        visited[i] = true;
	        comb(str, visited, i + 1, n, r - 1);
	        visited[i] = false;
	    }
	}
    
    private boolean check(String order, String target) {
    	
    	for(int i = 0; i < target.length(); i++) {
    		if(!order.contains(target.substring(i,i+1))) {
    			return false;
    		}
    	}
    	
    	return true;
    }
    
//    private int findMaxChar(String order) {
//    	int max = 64;
//    	
//    	for(int i = 0; i < order.length(); i++) {
//    		int ch = (int)order.charAt(i);
//    		
//    		if(ch > max) {
//    			max = ch;
//    		}
//    	}
//    	
//    	return max;
//    }
//    
//    private int findMinChar(String order) {
//    	int min = 100;
//    	
//    	for(int i = 0; i < order.length(); i++) {
//    		int ch = (int)order.charAt(i);
//    		
//    		if(ch < min) {
//    			min = ch;
//    		}
//    	}
//    	
//    	return min;
//    }
}
