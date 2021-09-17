package Programmers;

import java.util.*;

public class P43164 { // 3 여행경로

	public static void main(String[] args) {
		
		P43164 p = new P43164();
		
		String[][] tickets = {{"ICN", "SFO"}, {"SFO", "ICN"}, {"ICN", "SFO"}, {"SFO", "QRE"}};
		
		String[] ans = p.solution(tickets);
		
		for(int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
	
	ArrayList<String> ans;
	
    public String[] solution(String[][] tickets) {
    	
    	ans = new ArrayList<>();
    	ans.add("ICN");
        
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(int i = 0; i < tickets.length; i++) {
        	if(map.containsKey(tickets[i][0])) {
        		map.get(tickets[i][0]).add(tickets[i][1]);
        	}else {
        		map.put(tickets[i][0], new ArrayList<String>());
        		map.get(tickets[i][0]).add(tickets[i][1]);
        	}
        }
        
        int sum = 0;
        for(String key : map.keySet()) {
        	ArrayList<String> arrival = map.get(key);
        	sum += arrival.size();
        	Collections.sort(arrival, (o1, o2) -> o1.compareTo(o2));
        }
        
        dfs(map, "ICN", sum, new ArrayList<String>());
        
        String[] answer = new String[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
        	answer[i] = ans.get(i);
        }
        
        return answer;
    }
    
    private void dfs(HashMap<String, ArrayList<String>> map, String next, int num, ArrayList<String> answer) {
    	
    	// 표를 다 쓰고 다른 정답이 없는 경우
    	if(num == 0 && ans.size() == 1) {
    		for(int i = 0; i < answer.size(); i++) {
    			ans.add(answer.get(i));
    		}
    		return;
    	}
    	
    	// 가는 표가 없는 경우
    	if(!map.containsKey(next)) return;
    	
    	ArrayList<String> arrival = map.get(next);
    	
    	if(arrival.size() == 0) return;
    	
    	// 모든 표를 다 써야하기 때문에 확인
    	for(int i = 0; i < arrival.size(); i++) {
        	String nextarrival = arrival.remove(i);
        	answer.add(nextarrival);
        	
        	dfs(map, nextarrival, num-1, answer);
        	
        	answer.remove(answer.size()-1);
        	arrival.add(i, nextarrival);
    	}
    }
}
