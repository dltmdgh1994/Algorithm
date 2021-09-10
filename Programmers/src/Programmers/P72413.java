package Programmers;

public class P72413 { // 3 �ս� �ý� ���

	public static void main(String[] args) {
		
		P72413 p = new P72413();

		int[][] fares = {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};
		
		System.out.println(p.solution(7, 3, 4, 1, fares));
	}
	
	// ������ ���� n, ��������� ��Ÿ���� s, A�� ���������� ��Ÿ���� a, 
	// B�� ���������� ��Ÿ���� b, ���� ������ ���� �ýÿ���� ��Ÿ���� fares
	public int solution(int n, int s, int a, int b, int[][] fares) {
        
		int[][] roads = new int[n][n];
        
        for(int i = 0; i < fares.length; i++) {
        	roads[fares[i][0]-1][fares[i][1]-1] = fares[i][2];
        	roads[fares[i][1]-1][fares[i][0]-1] = fares[i][2];
        }
        
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		if(roads[i][j] == 0 && i != j) {
        			roads[i][j] = 10000000;
        		}
        	}
        }
        
        // �÷��̵� �ͼ� �˰������� ��� �������� �ٸ� ��� �������� ���� �ִܰŸ� ���
        for(int k = 0; k < n; k++) {
        	for(int i = 0; i < n; i++) {
            	for(int j = 0; j < n; j++) {
            		if(roads[i][k] + roads[k][j] < roads[i][j]) {
            			roads[i][j] = roads[i][k] + roads[k][j];
            		}
            	}
            }
        }
        
        // ���� ���� �ý� Ÿ�� �Ÿ�
        int min = roads[s-1][a-1] + roads[s-1][b-1];
        
        // ��� �� �������� �ս����� ��, ���� ���� ������ ������ Ȯ��
        for(int i = 0; i < n; i++) {
      	
      	    int tmp = roads[s-1][i] + roads[i][a-1] + roads[i][b-1];
      	
      	    if(tmp < min)  min = tmp;
        }
        
        return min;
    }
}
