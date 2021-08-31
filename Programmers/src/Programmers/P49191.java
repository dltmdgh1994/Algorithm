package Programmers;

public class P49191 { // 3 ����

	public static void main(String[] args) {
		
		P49191 p = new P49191();
		
		int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		
		System.out.println(p.solution(5, results));
	}

	public int solution(int n, int[][] results) {
	    int answer = 0;
	    
	    int[][] player = new int[n][n];
 
	    for(int i = 0; i < results.length; i++) {
	    	player[results[i][0]-1][results[i][1]-1] = 1;
	    	player[results[i][1]-1][results[i][0]-1] = -1;
	    }
	    
	    // ���ͽ�Ʈ��(Dijkstra) �˰���
	    // �ϳ��� �������� �ٸ� ��� ���������� �ִ� ��θ� ���� �� ���
	    
	    // �÷��̵� �ͼ�(Floyd Warshall) �˰���
	    // ��� �������� ��� ���������� �ִ� ��θ� ���� �� ���
	    
	    // k = ���İ��� ���
	    for(int k = 0; k < n; k++) {
	    	// i = ���۳��
	    	for(int i = 0; i < n; i++) {
	    		// j = �������
	    		for(int j = 0; j < n; j++) {
	    			if(player[i][j] == 0) {
	    				if(player[i][k] == 1 && player[k][j] == 1) {
	    					player[i][j] = 1;
	    					player[j][i] = -1;
	    				}else if(player[i][k] == -1 && player[k][j] == -1) {
	    					player[i][j] = -1;
	    					player[j][i] = 1;
	    				}
	    			}
	    		}
	    	}
	    }
	    
	    for(int i = 0; i < n; i++) {
	    	int cnt = 0;
	    	
	    	for(int j = 0; j < n; j++) {
	    		if(player[i][j] != 0) cnt++;
	    	}
	    	
	    	if(cnt == n-1) answer++;
	    }
	    
	    return answer;
	}
}
