package Programmers;

import java.util.*;

public class P60060 { // 가사 검색
	
	public static void main(String[] args) {
		
		P60060 p = new P60060();
		
		String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
		
		int[] ans = p.solution(words, queries);
		for(int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
	
    public int[] solution(String[] words, String[] queries) {
        int qLength = queries.length;
        int[] answer = new int[qLength];
        int cnt = 0;
        
        HashMap<String,Integer> map = new HashMap<>();

        for(int i = 0; i < qLength; i++){
        	
        	if(map.containsKey(queries[i])) {
        		cnt = map.get(queries[i]);
        	}else {
        		cnt = countWords(queries[i],words);
        	}
            
            answer[i] = cnt;
        }
        
        return answer;
    }

    private int countWords(String query, String[] words){
        int cnt = 0;
        int qLen = query.length();
        
        char[] q = query.toCharArray();
        int start = 0;
    	int end = q.length-1;
    	int idx = 0;
    	
    	if(q[0] == '?') {
    		idx = findStart(start, end, q);
    	}else {
    		idx = findEnd(start, end, q);
    	}
    	
    	if(idx == -1) return words.length;
        
        for(int i = 0; i < words.length; i++){
        	
            if(words[i].length() == qLen){
            	char[] w = words[i].toCharArray();
            	
                if(check(w,q,idx)){
                    cnt++;
                }
            }
        }
        
        return cnt;
    }

    private boolean check(char[] w, char[] q, int idx){
    	
    	if(q[0] == '?') {
    		for(int i = idx; i < q.length; i++) {
    			if(w[i] != q[i]) return false;
    		}
    		
    		return true;
    	}else {
    		for(int i = idx; i >= 0; i--) {
    			if(w[i] != q[i]) return false;
    		}
	
    		return true;
    	}
    }
    
    // ? 아닌 첫글자 찾기
    private int findStart(int start, int end, char[] q) {
    	
    	int mid;
    	
    	while(start <= end) {
    		mid = (start+end)/2;
    		
    		if(mid == 0) {
    			if(q[mid] == '?') {
    				return mid+1;
    			}else {
    				return -1;
    			}
    		}else if(q[mid] != '?' && q[mid-1] == '?') {
    			return mid;
    		}else if(q[mid] != '?') {
    			end = mid-1;
    		}else {
    			start = mid+1;
    		}
    	}
    	
    	return -1;
    }
    
	// ? 아닌 끝글자 찾기
    private int findEnd(int start, int end, char[] q) {
    	
    	int mid;
    	
    	while(start <= end) {
    		mid = (start+end)/2;
    		
    		if(mid == q.length-1) {
    			if(q[mid] == '?') {
    				return mid-1;
    			}else {
    				return -1;
    			}
    		}else if(q[mid] != '?' && q[mid+1] == '?') {
    			return mid;
    		}else if(q[mid] != '?') {
    			start = mid+1;
    		}else {
    			end = mid-1;
    		}
    	}
    	
    	return -1;
    }
}
