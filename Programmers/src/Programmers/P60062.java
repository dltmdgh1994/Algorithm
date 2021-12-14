package Programmers;

import java.util.*;

public class P60062 { // 외벽 점검

	public static void main(String[] args) {
		
		P60062 p = new P60062();
		
		int[] weak = {1, 5, 6, 10};
		int[] dist = {1, 2, 3, 4};
		
		p.solution(12, weak, dist);
	}
	
    public int solution(int n, int[] weak, int[] dist) {
        int answer = 0;
        
        boolean[] weakSpot = new boolean[weak.length];
        
        reverseSort(dist);
        for(int i = 0; i < dist.length; i++) {
        	int d = dist[i];
        	int max = 0;
        	int maxIdx = 0;
        	int direct = 0;
        	
        	for(int j = 0; j < weak.length; i++) {

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
        					if(!weakSpot[k] || w+d-n >= weak[k]) {
        						cnt++;
        					}else {
        						break;
        					}
        				}
        			}else {
        				for(int k = j; k < weak.length; k++) {
        					if(!weakSpot[k] || w+d-n >= weak[k]) {
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
        			
        			if(w-d < 0) {
        				for(int k = 0; k <= j; k++) {
        					if(!weakSpot[k]) {
        						cnt++;
        					}else {
        						break;
        					}
        				}
        				for(int k = weak.length-1; k > j; k--) {
        					if(!weakSpot[k] || n-(d-w) <= weak[k]) {
        						cnt++;
        					}else {
        						break;
        					}
        				}
        			}else {
        				for(int k = j; k >= 0; k--) {
        					if(!weakSpot[k] || w-d <= weak[k]) {
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
        	
        	if(direct == 0) {
        		int w = weak[maxIdx];
        		
        		if(w+d >= n) {
        			
        		}else {
        			
        		}
        		
        	}else {
        		int w = weak[maxIdx];
        		
        		if(w-d < 0) {
        			
        		}else {
        			
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
