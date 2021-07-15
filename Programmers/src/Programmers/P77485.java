package Programmers;

import java.util.*;

public class P77485 { // 행렬 테두리 회전하기
	
	int[][] arr;

	public static void main(String[] args) {
		P77485 p = new P77485();
		
		int[][] a = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		p.solution(6, 6, a);
	}
	
	public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        arr = new int[rows][columns];
        for(int i = 0; i < rows; i++) {
        	for(int j = 0; j < columns; j++) {
        		arr[i][j] = (j+1) + i*columns;
        	}
        }
        
        for(int i = 0; i < queries.length; i++) {
        	int x1 = queries[i][0]-1;
        	int y1 = queries[i][1]-1;
        	int x2 = queries[i][2]-1;
        	int y2 = queries[i][3]-1;
        	
        	answer[i] = swap(x1, y1, x2, y2);
        }
        
        return answer;
    }
	
	private int swap(int x1, int y1, int x2, int y2) {
		
		Queue<Integer> q = new LinkedList<>();
		int min = 100000;
		
		q.add(arr[x1][y1]);
		if(arr[x1][y1] < min) {
			min = arr[x1][y1];
		}
		
		for(int i = y1+1; i <= y2; i++) {
			q.add(arr[x1][i]);
			if(arr[x1][i] < min) {
				min = arr[x1][i];
			}
			arr[x1][i] = q.poll();
		}
		
		for(int i = x1+1; i <= x2; i++) {
			q.add(arr[i][y2]);
			if(arr[i][y2] < min) {
				min = arr[i][y2];
			}
			arr[i][y2] = q.poll();
		}
		
		for(int i = y2-1; i >= y1; i--) {
			q.add(arr[x2][i]);
			if(arr[x2][i] < min) {
				min = arr[x2][i];
			}
			arr[x2][i] = q.poll();
		}
		
		for(int i = x2-1; i >= x1; i--) {
			q.add(arr[i][y1]);
			if(arr[i][y1] < min) {
				min = arr[i][y1];
			}
			arr[i][y1] = q.poll();
		}
				
		return min;
	}	
}
