package Programmers;

public class P12905 { // 2 가장 큰 정사각형 찾기
	
	public static void main(String[] args) {
		
		P12905 p = new P12905();
		
		int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
		int ans = p.solution(board);
		System.out.println(ans);
	}
	
	public int solution(int [][]board) {
		
		int answer = 1;
	    
	    boolean f = false;
	    for(int i = 0; i < board.length; i++) {
	    	for(int j = 0; j < board[0].length; j++) {
	    		if(board[i][j] == 1) {
	    			f = true;
	    			break;
	    		}
	    	}
	    	
	    	if(f) break;
	    }
	    
	    if(!f) return 0;
	    
	    for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if(board[i][j] == 0) continue;
                // 위 , 좌 , 좌측 대각선 값을 찾아 그중 최소값 + 1 로 업데이트
                board[i][j] = Math.min(Math.min(board[i - 1][j], board[i][j - 1]), board[i - 1][j - 1]) + 1;
                answer = Math.max(answer, board[i][j]);
            }
        }

        return answer * answer;
	}

//  시간 초과
//	public int solution(int [][]board) {
//	
//	    int row = board.length;
//	    int col = board[0].length;
//	    int maxLen = 0;
//	    
//	    if(row >= col) {
//	    	maxLen = col;
//	    }else {
//	    	maxLen = row;
//	    }
//	    
//	    for(int i = maxLen; i > 0; i--) {
//	    	for(int j = 0; j < row-i+1; j++) {
//	    		for(int k = 0; k < col-i+1; k++ ) {
//	    			if(check(board, j, k, i)) {
//	    				return i*i;
//	    			}
//	    		}
//	    	}
//	    } 
//	
//	    return 0;
//	}
//	
//	private boolean check(int [][]board, int row, int col, int len) {
//		
//		for(int i = row; i < row+len; i++) {
//			for(int j = col; j < col+len; j++) {
//				if(board[i][j] == 0) {
//					return false;
//				}
//			}
//		}
//		
//		return true;
//	}
}
