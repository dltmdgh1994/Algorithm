package Programmers;

public class P68645 { // 2 ªÔ∞¢ ¥ﬁ∆ÿ¿Ã

	public static void main(String[] args) {
		P68645 p = new P68645();

		p.solution(6);
	}
	
	public int[] solution(int n) {
        
        int cnt = 0;
        int[][] arr = new int[n][];
        for(int i = 0; i < n; i++) {
        	arr[i] = new int[i+1];
        	cnt += i+1;
        }
        
        int row = 0;
        int col = 0;
        int direction = 0;
        
        for(int i = 1; i <= cnt; i++) {
        	arr[row][col] = i;
        	
        	// øﬁ¬  æ∆∑° πÊ«‚
        	if(row+1 < n && direction == 0) {
        		if(arr[row+1][col] == 0) {
        			row++;
        			continue;
        		}else {
        			direction = 1;
        		}
        	}else if(row+1 >= n && direction == 0) {
        		direction = 1;
        	}
        	
        	// πÿø° ¡Ÿ ø¿∏•¬  πÊ«‚
        	if(col+1 <= row && direction == 1) {
        		if(arr[row][col+1] == 0) {
        			col++;
        			continue;
        		}else {
        			direction = 2;
        		}
        	}else if(col+1 > row && direction == 1) {
        		direction = 2;
        	}
        	
        	// øﬁ¬  ¿ß πÊ«‚
        	if(row-1 >= 0 && col-1 >= 0 && direction == 2) {
        		if(arr[row-1][col-1] == 0) {
        			row--; col--;
        			continue;
        		}else {
        			direction = 0;
        			row++;
        		}
        	}
        }
        
        int[] answer = new int[cnt];
        int k = 0;
        
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < i+1; j++) {
        		answer[k++] = arr[i][j];
        	}
        }
        
        return answer;
    }
}
