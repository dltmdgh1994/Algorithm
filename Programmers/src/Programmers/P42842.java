package Programmers;

public class P42842 { // Ä«Æê

	public static void main(String[] args) {
		P42842 p = new P42842();

		int[] ans = p.solution(10, 2);
		
		for(int i = 0; i < 2; i++) {
			System.out.println(ans[i]);
		}
	}
	
	public int[] solution(int brown, int yellow) {
        
        int all = brown + yellow;
        int row = 3;
        int col = 3;
        
        while(true) {
        	int check = row*2 + (col-2)*2;
        	
        	if(check < brown) {
        		row++;
        	}else if(check > brown) {
        		col++;
        		row = col;
        	}else {
        		if(row*col == all) {
        			break;
        		}else {
        			row++;
        		}
        	}
        }
        
        return new int[] {row, col};
    }
}
