package Programmers;

import java.util.*;

public class P68936 { // 2 쿼드압축 후 개수 세기

	public static void main(String[] args) {
		
		P68936 p = new P68936();
		
		int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
		
		int[] ans = p.solution(arr);
		System.out.println(ans[0]);
		System.out.println(ans[1]);
	}

	public int[] solution(int[][] arr) {

        int zero = 0;
        int one = 0;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0,arr.length});
        
        while(!q.isEmpty()) {
        	
        	for(int i = 0; i < q.size(); i++) {
        		int row = q.peek()[0];
        		int col = q.peek()[1];
        		int len = q.peek()[2];
        		q.poll();
        		
        		if(check(arr, len, row, col)) {
        			if(arr[row][col] == 0) {
        				zero++;
        			}else {
        				one++;
        			}
        		}else {
        			if(len != 1) {
        				q.add(new int[] {row,col,len/2});
        				q.add(new int[] {row+len/2,col,len/2});
        				q.add(new int[] {row,col+len/2,len/2});
        				q.add(new int[] {row+len/2,col+len/2,len/2});
        			}else {
        				if(arr[row][col] == 0) {
        					zero++;
        				}else {
        					one++;
        				}
        			}
        		}
        	}
        }
        
        return new int[] {zero, one};
    }
	
	private boolean check(int[][] arr, int len, int row, int col) {
		
		int num = arr[row][col];
		
		for(int i = row; i < row+len; i++) {
			for(int j = col; j < col+len; j++) {
				if(num != arr[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
}
