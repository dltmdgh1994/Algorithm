package Programmers;

import java.util.*;

public class P60061 { // 3 기둥과 보 설치
	
	public static void main(String[] args) {
		
		P60061 p = new P60061();
		
		int[][] build_frame = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},
				{5,1,0,1},{4,2,1,1},{3,2,1,1}};
		
		int[][] ans = p.solution(5, build_frame);
		for(int i = 0; i < ans.length; i++) {
			System.out.println(ans[i][0] + " " + ans[i][1] + " " + ans[i][2]);
		}
	}
	
	// build_frame의 원소는 [x, y, a, b]형태
	// a => 기둥 : 0, 보 : 1
	// b => 삭제 : 0, 설치 : 1
    public int[][] solution(int n, int[][] build_frame) {
    	
    	ArrayList<Structure> arr = new ArrayList<>();
        
        for(int i = 0; i < build_frame.length; i++) {
        	Structure structure = new Structure(build_frame[i][0], build_frame[i][1], build_frame[i][2]);
        	int op = build_frame[i][3];
        	
        	if(op == 1) { // 설치
        		arr.add(structure);
        		if(!check(arr)) {
        			arr.remove(structure);
        		}
        	}else if(op == 0) { // 삭제
        		arr.remove(structure);
        		if(!check(arr)) {
        			arr.add(structure);
        		}
        	}
        }
        
        arr.sort(null);
        int[][] answer = new int[arr.size()][3];
        for(int i = 0; i < arr.size(); i++) {
        	answer[i][0] = arr.get(i).getX();
        	answer[i][1] = arr.get(i).getY();
        	answer[i][2] = arr.get(i).getS();
        }
        
        return answer;
    }
    
    private boolean check(ArrayList<Structure> arr) {
    	
    	for(Structure structure : arr) {
    		int x = structure.getX();
    		int y = structure.getY();
    		int s = structure.getS();
    		
    		if(s == 0) { // 기둥
    			if(y == 0 || arr.contains(new Structure(x-1, y, 1)) 
    					|| arr.contains(new Structure(x, y, 1))
    					|| arr.contains(new Structure(x, y-1, 0))) {
    				continue;
    			}
    			return false;
    		}else { // 보
    			if(arr.contains(new Structure(x, y-1, 0)) ||
    					arr.contains(new Structure(x+1, y-1, 0)) ||
    					(arr.contains(new Structure(x-1, y, 1)) &&
    					arr.contains(new Structure(x+1, y, 1)))) {
    				continue;
    			}
    			return false;
    		}
    	}
    	
    	return true;
    }
}

class Structure implements Comparable<Structure>{
	int x;
	int y;
	int s;
	
	public Structure(int x, int y, int s) {
		this.x = x;
		this.y = y;
		this.s = s;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getS() {
		return s;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + s;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Structure structure = (Structure) obj;
		if(structure.x == this.x && structure.y == this.y
				&& structure.s == this.s) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public int compareTo(Structure o) {
		// TODO Auto-generated method stub
		if(this.x < o.getX()) {
			return -1;
		}else if(this.x > o.getX()) {
			return 1;
		}else {
			if(this.y < o.getY()) {
				return -1;
			}else if(this.y > o.getY()) {
				return 1;
			}else {
				if(this.s < o.getS()) {
					return -1;
				}else if(this.s > o.getS()) {
					return 1;
				}else {
					return 0;
				}
			}
		}
	}
}
