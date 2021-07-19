package Programmers;

public class P81302 { // �Ÿ��α� Ȯ���ϱ�
	
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) {
		P81302 p = new P81302();
		
	}
	
	// P : ���, O : �� ���̺�, X : ĭ����
	// 1 : �Ÿ��α�o, 0: �Ÿ��α� x
	public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i = 0; i < places.length; i++) {
        	
        	int[][] map = new int[5][5];
        	for(int j = 0; j < 5; j++) {
        		String[] s = places[i][j].split("");
        		for(int k = 0; k < 5; k++) {
        			if(s[k].equals("P")) {
        				map[j][k] = 1; // ���
        			}else if(s[k].equals("O")) {
        				map[j][k] = 0; // ��
        			}else {
        				map[j][k] = 2; // ĭ����
        			}
        		}
        	}
        	
        	answer[i] = check(map);
        }
        
        return answer;
    }
	
	private int check(int[][] map) {
		
		for(int j = 0; j < 5; j++) {
    		for(int k = 0; k < 5; k++) {
    			int n = map[j][k];
    			
    			// ���� �ڸ��� ����� ���
    			if(n == 1) {
    				for(int l = 0; l < 4; l++) {
        				int nx = j + dx[l];
        				int ny = k + dy[l];
        				
        				if(nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
        					// �Ѹ��̶� ������ �Ÿ��α� x
        					if(map[nx][ny] == 1) {
        						return 0;
        					}
        				}
        			}
    			}else if(n == 0) { // ���� �ڸ��� �� �ڸ�
    				int cnt = 0;
    				
    				for(int l = 0; l < 4; l++) {
        				int nx = j + dx[l];
        				int ny = k + dy[l];
        				
        				if(nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
        					if(map[nx][ny] == 1) {
        						cnt++;
        					}
        				}
        			}
    				// ��ó�� 2�� �̻� ������ �Ÿ��α� x
    				if(cnt >= 2) {
    					return 0;
    				}
    			}
    		}
    	}
		
		return 1;
	}
}
