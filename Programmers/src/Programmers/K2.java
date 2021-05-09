package Programmers;

public class K2 {
	String[][] room;
	boolean[][] isVisit;
    int n = 5;
    
    int dx[] = {0,0,1,-1};
    int dy[] = {1,-1,0,0};
    
    public static void main(String[] args) {
    	K2 p = new K2();
    	String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
    	p.solution(places);
	}
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i = 0; i < 5; i++){
            room = new String[5][5];
            isVisit = new boolean[5][5];
            for(int j = 0; j < 5; j++){
                for(int k = 0; k < 5; k++){
                    room[j][k] = places[i][j].substring(k,k+1);
                    isVisit[j][k] = false;
                }
            }
            
            boolean flag = true;
            for(int j = 0; j < 5; j++){
                for(int k = 0; k < 5; k++){
                	isVisit[j][k] = true;
                    if(room[j][k].equals("P") && !checkDistance(j, k)){
                        flag = false;
                        break;
                    }
                }
                if(!flag){
                    break;
                }
            }
            
            if(flag){
                answer[i] = 1;
            }else{
                answer[i] = 0;
            }
        }
        
        return answer;
    }
    
    private boolean checkDistance(int row, int col){
    	
        for(int i=0; i<4; i++){
            int nx = row + dx[i];
            int ny = col + dy[i];

            if(nx >=0 && ny >=0 && nx < 5 && ny < 5){
                if(room[nx][ny].equals("P") && !isVisit[nx][ny]){

                    return false;
                }else if(room[nx][ny].equals("O")){
                    for(int j=0; j<4; j++){
                        int nx2 = nx + dx[j];
                        int ny2 = ny + dy[j];
                        
                        if(nx2 >=0 && ny2 >=0 && nx2 < 5 && ny2 < 5){
                            if(room[nx2][ny2].equals("P") && !isVisit[nx2][ny2]){

                                return false;
                            }
                        }
                    }
                }
            }
        }
        
        return true;
    }
}
