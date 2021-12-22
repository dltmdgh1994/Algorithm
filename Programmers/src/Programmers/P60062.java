package Programmers;

import java.util.*;

public class P60062 { // 3 외벽 점검

	public static void main(String[] args) {
		
		P60062 p = new P60062();
		
		int[] weak = {1, 5, 6, 10};
		int[] dist = {1, 2, 3, 4};
		
		int ans = p.solution(12, weak, dist);
		
		System.out.println(ans);
	}
	
    public int solution(int n, int[] weak, int[] dist) {
        int answer = 0;
        
        Queue<Wall> q = new LinkedList<>();
        boolean[] weakSpot = new boolean[weak.length];
        q.add(new Wall(weakSpot, 0));
        
        reverseSort(dist);
        for(int i = 0; i < dist.length; i++) {
        	int d = dist[i];
        	int max = 0;
        	int maxIdx = 0;
        	int direct = 0;
        	
        	while(true) {
        		Wall wall = q.peek();
        		
        		if(wall.getCnt() <= answer) break;
        		
        		weakSpot = wall.getWeakSpot();
        	}
        	
        	Wall wall1 = q.poll();
        	weakSpot = wall1.getWeakSpot();
        	
        	for(int j = 0; j < weak.length; j++) {

        		if(!weakSpot[j]) {
        			int w = weak[j];
        			int cnt = 0;
        			
        			if(w+d >= n) {
        				for(int k = j; k < weak.length; k++) {
        					if(!weakSpot[k]) {
        						cnt++;
        					}else {
        						break;
        					}
        				}
        				for(int k = 0; k < j; k++) {
        					if(!weakSpot[k] && w+d-n >= weak[k]) {
        						cnt++;
        					}else {
        						break;
        					}
        				}
        			}else {
        				for(int k = j; k < weak.length; k++) {
        					if(!weakSpot[k] && w+d >= weak[k]) {
        						cnt++;
        					}else {
        						break;
        					}
        				}
        			}
        			
        			if(cnt > max) {
        				max = cnt;
        				maxIdx = j;
        				direct = 0;
        			}
        			
        			cnt = 0;
        			 
        			if(w-d < 0) {
        				for(int k = 0; k <= j; k++) {
        					if(!weakSpot[k]) {
        						cnt++;
        					}else {
        						break;
        					}
        				}
        				for(int k = weak.length-1; k > j; k--) {
        					if(!weakSpot[k] && n-(d-w) <= weak[k]) {
        						cnt++;
        					}else {
        						break;
        					}
        				}
        			}else {
        				for(int k = j; k >= 0; k--) {
        					if(!weakSpot[k] && w-d <= weak[k]) {
        						cnt++;
        					}else {
        						break;
        					}
        				}
        			}
        			
        			if(cnt > max) {
        				max = cnt;
        				maxIdx = j;
        				direct = 1;
        			}
        		}
        	}
        	
        	System.out.println(maxIdx + " " + direct + " " + max);
        	
        	if(direct == 0) {
        		int w = weak[maxIdx];
        		
        		if(w+d >= n) {
        			for(int j = maxIdx; j < weak.length; j++) {
        				if(!weakSpot[j]) {
        					weakSpot[j] = true;
        				}
        			}
        			for(int j = 0; j < maxIdx; j++) {
        				if(!weakSpot[j] && w+d-n >= weak[j]) {
        					weakSpot[j] = true;
        				}
        			}
        		}else {
        			for(int j = maxIdx; j < weak.length; j++) {
        				if(!weakSpot[j] && w+d >= weak[j]) {
        					weakSpot[j] = true;
        				}else {
        					break;
        				}
        			}
        		}
        		
        	}else {
        		int w = weak[maxIdx];
        		
        		if(w-d < 0) {
        			for(int j = maxIdx; j >= 0; j--) {
        				if(!weakSpot[j]) {
        					weakSpot[j] = true;
        				}
        			}
        			for(int j = weak.length-1; j > maxIdx; j--) {
        				if(!weakSpot[j] && n-(d-w) <= weak[j]) {
        					weakSpot[j] = true;
        				}
        			}
        		}else {
        			for(int j = maxIdx; j >= 0; j--) {
        				if(!weakSpot[j] && w-d <= weak[j]) {
        					weakSpot[j] = true;
        				}else {
        					break;
        				}
        			}
        		}
        	}
        	
        	answer++;
        	
        	if(checkComplete(weakSpot)) break;
        }
        
        return answer;
    }
    
    // 내림차순 정렬
    private void reverseSort(int[] arr) {
        Arrays.sort(arr);
        
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }
    
    private boolean checkComplete(boolean[] weakSpot) {
    	
    	for(int i = 0; i < weakSpot.length; i++) {
    		if(!weakSpot[i]) return false;
    	}
    	return true;
    }
}

class Wall{
	boolean[] weakSpot;
	int cnt;
	
	public Wall(boolean[] weakSpot, int cnt) {
		super();
		this.weakSpot = weakSpot;
		this.cnt = cnt;
	}

	public boolean[] getWeakSpot() {
		return weakSpot;
	}

	public void setWeakSpot(boolean[] weakSpot) {
		this.weakSpot = weakSpot;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	public boolean checkComplete() {
    	
    	for(int i = 0; i < weakSpot.length; i++) {
    		if(!weakSpot[i]) return false;
    	}
    	return true;
    }
}
