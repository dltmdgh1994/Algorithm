package Programmers;

public class P92344 { // 3 파괴되지 않은 건물
	
	public static void main(String[] args) {
		
		P92344 p = new P92344();
		
		int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
		int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
		
		System.out.println(p.solution(board, skill));
	}

    public int solution(int[][] board, int[][] skill) {
    	
    	// 누적합 사용 => skill 한 원소를 O(1)만에 처리
    	// https://tech.kakao.com/2022/01/14/2022-kakao-recruitment-round-1/
    	int[][] cumSum = new int[board.length+1][board[0].length+1];
    	
    	for(int[] s : skill) {
    		if(s[0] == 1) { // 공격
    			cumSum[s[1]][s[2]] -= s[5];
    			cumSum[s[1]][s[4]+1] += s[5];
    			cumSum[s[3]+1][s[4]+1] -= s[5];
    			cumSum[s[3]+1][s[2]] += s[5];
    		}else { // 회복
    			cumSum[s[1]][s[2]] += s[5];
    			cumSum[s[1]][s[4]+1] -= s[5];
    			cumSum[s[3]+1][s[4]+1] += s[5];
    			cumSum[s[3]+1][s[2]] -= s[5];
    		}
    	}
    	
    	for(int i = 0; i < cumSum.length; i++) {
    		for(int j = 1; j < cumSum[0].length; j++) {
    			cumSum[i][j] += cumSum[i][j-1];
    		}
    	}
    	
    	for(int i = 0; i < cumSum[0].length; i++) {
    		for(int j = 1; j < cumSum.length; j++) {
    			cumSum[j][i] += cumSum[j-1][i];
    		}
    	}
    	
    	int answer = 0;
    	for(int i = 0; i < board.length; i++) {
    		for(int j = 0; j < board[0].length; j++) {
    			board[i][j] += cumSum[i][j];
    			
    			if(board[i][j] > 0) answer++;
    		}
    	}
        
        return answer;
    }
}

