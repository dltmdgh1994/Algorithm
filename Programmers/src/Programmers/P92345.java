package Programmers;

public class P92345 { // 3 ������� ����

	public static void main(String[] args) {
		
		P92345 p = new P92345();
		
		int[][] board = {{1,1,1},{1,0,1},{1,1,1}};
		
		System.out.println(p.solution(board, new int[] {1,0}, new int[] {1,2}));
	}
	
    public int solution(int[][] board, int[] aloc, int[] bloc) {
    	
        return dfs(board, aloc[0], aloc[1], bloc[0], bloc[1], 0).cnt;
    }
    
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    
    private WinCnt dfs(int[][] board, int x1, int y1, int x2, int y2, int depth) {
    	
    	boolean win = false;
    	int minCnt = 5*5;
    	int maxCnt = depth;
    	
    	if(board[x1][y1] == 1) {
    		for(int i = 0; i < 4; i++) {
    			int nx = x1 + dx[i];
    			int ny = y1 + dy[i];
    			
    			if(nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length) {
    				if(board[nx][ny] == 1) {
    					board[x1][y1] = 0;
    					
    					WinCnt tmp = dfs(board, x2, y2, nx, ny, depth+1);
    					
    					// ������ ���а� ���� ������ �ݴ�
    					// �̱�� ���̽��� �ϳ��� �ִٸ� win�� true��
    					if(!win) win = !tmp.win;
    					
    					// ��밡 �̱�� �ִ� ���, ���� �ּ� ���
    					if(tmp.win) maxCnt = Math.max(maxCnt, tmp.cnt);
    					else minCnt = Math.min(minCnt, tmp.cnt);
    					
    					board[x1][y1] = 1;
    				}
    			}
    		}
    	}
    	
    	return new WinCnt(win, win ? minCnt : maxCnt);
    }
}

class WinCnt{
	boolean win;
	int cnt;
	
	public WinCnt(boolean win, int cnt) {
		this.win = win;
		this.cnt = cnt;
	}
}
