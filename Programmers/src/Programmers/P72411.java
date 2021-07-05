package Programmers;

import java.util.*;

public class P72411 { // �޴� ������
	
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
	
	// �׽�Ʈ ���̽� �� �ϳ��� �ð��ʰ� => �ִ�� �ּ� ���� ��� ������ �� �̾Ƽ� �ɷ��� �׷���
	// �ֹ��� ��ǰ �޴� ���տ��� ������ ������ �̸� �̾� ������ �ð� �ʰ� �ȶ��! 
	public String[] solution(String[] orders, int[] course) {
        
        int maxChar = 0;
        int minChar = 100;
        int maxLen = 0;
        for(String order : orders){
        	int len = order.length();
        	
        	// order�� ���ĵǾ� ���� �����Ƿ� �ִ� �ƽ�Ű�ڵ尪�� ã�´�.
            int ch1 = findMaxChar(order);
            int ch2 = findMinChar(order);
            if(ch1 > maxChar){
                maxChar = ch1;
            }
            
            if(ch2 < minChar){
            	minChar = ch2;
            }
            
            if(len > maxLen){
                maxLen = len;
            }
        }
        
        arr = new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();
        
        String[] str = new String[maxChar-minChar+1];
        boolean[] visited = new boolean[maxChar-minChar+1];
        for(int i = 0; i < maxChar-minChar+1; i++) {
        	str[i] = Character.toString((char)i+minChar);
        }
        
        for(int i = 0; i < course.length; i++){
        	
        	if(course[i] > maxLen){
                break;
            }
            
        	comb(str, visited, 0, maxChar-minChar+1, course[i]);
        	
        	int max = 1;

        	ArrayList<String> arr2 = new ArrayList<>();
            for(int j = 0; j < arr.size(); j++) {
            	int cnt = 0;
            	
            	for(String order : orders){
            		
                    if(check(order, arr.get(j))) {
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
	        arr.add(ans);
	        
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
    
    private int findMaxChar(String order) {
    	int max = 64;
    	
    	for(int i = 0; i < order.length(); i++) {
    		int ch = (int)order.charAt(i);
    		
    		if(ch > max) {
    			max = ch;
    		}
    	}
    	
    	return max;
    }
    
    private int findMinChar(String order) {
    	int min = 100;
    	
    	for(int i = 0; i < order.length(); i++) {
    		int ch = (int)order.charAt(i);
    		
    		if(ch < min) {
    			min = ch;
    		}
    	}
    	
    	return min;
    }
}
