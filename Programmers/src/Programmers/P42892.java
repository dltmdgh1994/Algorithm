package Programmers;

import java.util.*;

public class P42892 { // 3 길 찾기 게임

	public static void main(String[] args) {
		
		P42892 p = new P42892();
		
		p.solution(null);
	}
	
	public int[][] solution(int[][] nodeinfo) {
        int[][] answer = {{0,0},{1,1},{2,1}};
        
        
        
        Arrays.sort(nodeinfo, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[1] > o2[1]) {
					return -1;
				}else if(o1[1] < o2[1]) {
					return 1;
				}else {
					if(o1[0] < o2[0]) {
						return -1;
					}else if(o1[0] > o2[0]) {
						return 1;
					}else {
						return 0;
					}
				}
			}
        	
		});
        
        for(int i = 0; i < answer.length; i++) {
        	for(int j = 0; j < answer[0].length; j++) {
        		System.out.print(answer[i][j] + " ");
        	}
        	System.out.println();
        }
        
        return answer;
    }
}

class Node {
    int value;
    int[] xy;
    Node leftChild;
    Node rightChild;
    Node parent;

    public Node(int value, int[] xy) {
        this.value = value;
        this.xy = xy;
        this.leftChild = null;
        this.rightChild = null;
        this.parent = null;
    }
}

class Tree{
	Node rootNode = null;
	
	public void insertNode(Node node) {
		
		if(this.rootNode == null) {
			this.rootNode = node;
		}else {
			
		}
	}
}
